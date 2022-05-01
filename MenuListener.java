import java.awt.event.*;

import javax.swing.JFrame;

/**
 * La clase <code>MenuListener</code> permet de récupérer les actions effectuées dans le menu.
 * @version 1.0 
 * @author Yvan
 */
public class MenuListener implements ActionListener{
    private JFrame parent;

    /**
     * Initialisation de la classe <code>MenuListener</code>
     * La classe vient récupérer dans l'initialisation la fenêtre parent qui correspond au menu pour pouvoir la fermer par la suite
     * @param p fenêtre parent (le menu)
     * @see Menu
     */
    public MenuListener(JFrame p){
        this.parent = p;         
    }
    /**
     * Méthode appellée lors d'une action effectuée sur le menu. 
     * Il est possible de savoir sur quel bouton a été effectuée une action.
     * @todo coder les actions pour les boutons du menu
     * @see Menu
     */
    public void actionPerformed(ActionEvent event){
        String buttonName = event.getActionCommand();
        if(buttonName.equals("Nouvelle partie")){
            this.parent.dispose();
            Game partie = new Game();
        } else if(buttonName.equals("Charger une partie")){
            // On ne fait rien pour l'instant car on n'a pas implémenté la sauvegarde de la partie
        } else if(buttonName.equals("Quitter")){
            this.parent.dispose();
        }

    }
}