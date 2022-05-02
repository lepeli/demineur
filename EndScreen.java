import java.awt.*;
import javax.swing.*;

/**
 * Classe EndScreen.
 * Permet d'afficher l'écran de fin de partie
 * @author Yvan
 * @version 1.0
 */
public class EndScreen extends JFrame {
    
    /**
     * Initialisation de la fenêtre de fin de partie
     * @param title titre donné à la fenêtre + texte écrit
     */
    public EndScreen(String title){
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

        boutons.add(menuPrincipal);
        boutons.add(quitter);
        this.setSize(300,300);
        this.setResizable(false);
        this.add(boutons);
        this.setVisible(true);

    }

}
