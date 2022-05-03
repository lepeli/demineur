import javax.swing.*;

/**
 * Classe Menu, permet de gérer la partie graphique du menu
 * @author Yvan
 * @version 1.0
 */
public class Menu extends JFrame{

    /**
     * Initialisation de la classe Menu
     */
    public Menu(){
        /* Configuration de la fenêtre */
        this.setTitle("Demineur - Menu");
        this.setSize(300,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Ajout des boutons */
        JPanel panel = new JPanel();
        JButton jouer  = new JButton("Nouvelle partie");
        jouer.addActionListener(new MenuListener(this));
        panel.add(jouer);
        JButton charger = new JButton("Charger une partie");
        charger.addActionListener(new MenuListener(this));
        panel.add(charger);
        
        JButton quitter = new JButton("Quitter");
        quitter.addActionListener(new MenuListener(this));
        panel.add(quitter);
        
        /* Ajout des boutons sur la fenêtre */
        this.add(panel);
        this.setVisible(true);
    }

}