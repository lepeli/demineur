import java.awt.*;
import javax.swing.*;

/**
 * Classe EndScreen.
 * Permet d'afficher l'écran de fin de partie
 * @author Yvan
 * @version 1.0
 */
public class EndScreen extends JFrame {

    private JFrame gameF;

    /**
     * Initialisation de la fenêtre de fin de partie
     * @param title titre donné à la fenêtre + texte écrit
     * @param gameFrame fenêtre du jeu
     */
    public EndScreen(String title, JFrame gameFrame){
        this.gameF = gameFrame;

        GridLayout fenetreMgr = new GridLayout(3,1);
        this.setLayout(fenetreMgr);
        this.setTitle("Démineur - " + title);
        /* Texte */
        JLabel texte = new JLabel(title);
        texte.setHorizontalAlignment(JLabel.CENTER);
        this.add(texte);

        /* Boutons */
        JPanel boutons = new JPanel();
        GridLayout boutonsMgr = new GridLayout(1,2);
        boutons.setLayout(boutonsMgr);
        
        JButton menuPrincipal = new JButton("Menu Principal");
        JButton quitter = new JButton("Quitter");

        menuPrincipal.addActionListener(new EndScreenListener(this.gameF, this));
        quitter.addActionListener(new EndScreenListener(this.gameF, this));

        boutons.add(menuPrincipal);
        boutons.add(quitter);
        this.setSize(300,300);
        this.setResizable(false);
        this.add(boutons);
        this.setVisible(true);

    }

}
