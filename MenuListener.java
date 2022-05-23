import java.awt.event.*;

/**
 * La clase <code>MenuListener</code> permet de récupérer les actions effectuées dans le menu.
 * @version 1.0 
 * @author Yvan
 * @see Menu
 */
public class MenuListener implements ActionListener{
    private Menu menu;
    private Options oF;
    private Game game;

    /**
     * Initialisation de la classe MenuListener pour pouvoir sauvegarder et quitter une partie en cours
     * @param g la fenêtre qui gère l'affichage du jeu
     * @see Game
     */
    public MenuListener(Game g){
        this.game = g;
    }
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
     * @param m fenêtre parent (le menu)
     * @see Menu
     */
    public MenuListener(Menu m){
        this.menu = m;
    }

    /**
     * Méthode appellée lors d'une action effectuée sur le menu. 
     * Il est possible de savoir sur quel bouton a été effectuée une action.
     * @see Menu
     * @see Options
     * @see Game
     */
    public void actionPerformed(ActionEvent event){
        String buttonName = event.getActionCommand();
        if(buttonName.equals("Nouvelle partie")){
            this.menu.dispose();
            new Options();
        } else if(buttonName.equals("Charger une partie")){
            Save sauv = new Save();
            this.menu.dispose();
            sauv.loadSave();
        } else if(buttonName.equals("Quitter")){
            this.menu.dispose();
        } else if(buttonName.equals("Confirmer")){
            if(this.oF.verifyFields()){
                this.oF.dispose();
                Game game = new Game(this.oF.l, this.oF.h, this.oF.b);
                game.generateGrid();
            }
        } else if(buttonName.equals("Sauvegarder et quitter")){
            if(!this.game.grille.ended){
                this.game.dispose();
                this.game.saveGame();
            }
        }

    }
}