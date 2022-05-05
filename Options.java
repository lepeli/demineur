import javax.swing.*;
import java.awt.*;

/**
 * Classe <code>Options</code>
 * permet de récupérer les options pour la partie
 * @author Yvan
 * @version 1.0
*/
public class Options extends JFrame {
    private JLabel hauteurErr;
    private JLabel largeurErr;
    private JLabel bombesErr;

    protected JTextField hauteur;
    protected JTextField largeur;
    protected JTextField bombes;

    protected int l;
    protected int h;
    protected int b;


    /**
     * Initialisation de la classe Options
     */
    public Options(){
        this.setSize(600,500);
        this.setTitle("Démineur - Options");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.hauteurErr = new JLabel("");
        this.largeurErr = new JLabel("");
        this.bombesErr = new JLabel("");

        this.hauteurErr.setForeground(Color.RED);
        this.largeurErr.setForeground(Color.RED);
        this.bombesErr.setForeground(Color.RED);

        GridLayout fenMgr = new GridLayout(5,1);
        this.setLayout(fenMgr);

        Dimension txtDim = new Dimension(100, 30);

        JLabel titre = new JLabel("Options de la partie");
        titre.setHorizontalAlignment(JLabel.CENTER);
        this.add(titre);

        JPanel hauteurPanel = new JPanel();
        this.hauteur = new JTextField();
        JLabel hauteurLb = new JLabel("Hauteur:");
        this.hauteur.setPreferredSize(txtDim);
        hauteurPanel.add(hauteurLb);
        hauteurPanel.add(this.hauteur);
        hauteurPanel.add(this.hauteurErr);
        this.add(hauteurPanel);

        JPanel largeurPanel = new JPanel();
        this.largeur = new JTextField();
        JLabel largeurLb = new JLabel("Largeur:");
        this.largeur.setPreferredSize(txtDim);
        largeurPanel.add(largeurLb);
        largeurPanel.add(this.largeur);
        largeurPanel.add(this.largeurErr);

        this.add(largeurPanel);

        JPanel bombesPanel = new JPanel();
        this.bombes = new JTextField();
        JLabel bombesLb = new JLabel("Bombes:");
        this.bombes.setPreferredSize(txtDim);
        bombesPanel.add(bombesLb);
        bombesPanel.add(this.bombes);
        bombesPanel.add(this.bombesErr);
        this.add(bombesPanel);

        JButton confirmer = new JButton("Confirmer");
        JPanel bouton = new JPanel();
        confirmer.addActionListener(new MenuListener(this));
        bouton.add(confirmer);
        this.add(bouton);


        this.setVisible(true);

    }

    /**
     * Permet de vérifier les champs s'ils sont correctes ou non.
     * Si non correcte affichera une erreur
     */
    public boolean verifyFields(){
        boolean valid = true;
        /* Largeur */
        try {
            this.l = Integer.parseInt(largeur.getText());
            if (4 > this.l || this.l >= 31){
                valid = false;
                this.largeurErr.setText("La largeur doit être comprise entre 4 et 30");
            } else {
                this.hauteurErr.setText("");
            }
        
        } catch (NumberFormatException e){
            this.largeurErr.setText("Ce n'est pas un nombre !!!");
            valid = false;
        } 
        /* Hauteur */
        try {
            this.h = Integer.parseInt(hauteur.getText());
            if (4 > this.h || this.h >= 31){
                valid = false;
                this.hauteurErr.setText("La hauteur doit être comprise entre 4 et 30");
            } else {
                this.hauteurErr.setText("");
            }
        
        } catch (NumberFormatException e){
            this.hauteurErr.setText("Ce n'est pas un nombre !!!");
            valid = false;
        }
        /* Bombes */
        try {
            this.b = Integer.parseInt(bombes.getText());
            if (1 > this.b || this.b >= this.l * this.h){
                valid = false;
                this.bombesErr.setText("Le nombre de bombes ne doit pas dépasser le nombres de cases !");
            } else {
                this.bombesErr.setText("");
            }
        
        } catch (NumberFormatException e){
            this.bombesErr.setText("Ce n'est pas un nombre !!!");
            valid = false;
        }

        return valid;
    }

}
