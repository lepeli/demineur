import java.awt.event.*;
import javax.swing.*;

/**
 * La clase <code>MenuListener</code> permet de récupérer les actions effectuées dans le menu.
 * @version 1.0 
 * @author Yvan
 * @see Menu
 */
public class MenuListener implements ActionListener{
    private JFrame parent;
    private Options oF;

    /**
     * Initialisation de la classe MenuListener pour les options
     * @param p la fenêtre qui fait appel au MenuListener
     * @see Options
     */
    public MenuListener(Options p){
        this.oF = p;
    }

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
            new Options();
        } else if(buttonName.equals("Charger une partie")){
            Save sauv = new Save();
            this.parent.dispose();
            sauv.loadSave();
        } else if(buttonName.equals("Quitter")){
            this.parent.dispose();
        } else if(buttonName.equals("Confirmer")){
            if(this.oF.verifyFields()){
                this.oF.dispose();
                Game game = new Game(this.oF.l, this.oF.h, this.oF.b);
                game.generateGrid();
            }
        }

    }
}