import java.awt.event.*;
import javax.swing.JFrame;

/**
 * Classe <code>EndScreenListener</code>
 * Permet de gérer le menu de fin du jeu
 * @author Yvan
 * @version 1.0
 */
public class EndScreenListener implements ActionListener{
    private JFrame gameF;
    private JFrame endF;

    /**
     * Permet d'initiliser les actions du menu de fin, initilisée par la classe EndScreen
     * @param g fenêtre du jeu
     * @param f fenêtre du menu de fin
     * @see EndScreen
     */
    public EndScreenListener(JFrame g, JFrame f){
        this.gameF = g;
        this.endF = f;
    }

    /**
     * Clic sur un des boutons
     */
    public void actionPerformed(ActionEvent e){
        String txtBouton = e.getActionCommand();

        if(txtBouton.equals("Menu Principal")){
            /* Actions pour lancer une nouvelle partie */
            this.endF.dispose();
            this.gameF.dispose();
            new Menu();
        } else if (txtBouton.equals("Quitter")){
            /* Actions pour quitter le jeu */
            this.gameF.dispose();
            this.endF.dispose();
        }

    }
}
