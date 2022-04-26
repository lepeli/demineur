import java.awt.*; 
import javax.swing.*;

/**
 * Case
 * Permet de gérer l'apparence et la logique basique d'une case avec des actions comme reveler, définir que la case est une bombe ect.
 */

public class Case {
    private boolean isBomb;
    private boolean revealed = false;
    private boolean is;
    
    /**
     * Initialisation de la classe Case (on doit pouvoir faire des choses dedans mais je n'ai pas d'idée de quoi faire dedans)
     */
    public Case(){

    }

    /**
     *  Permet de transformer la case en bombe et ne pas pouvoir faire l'inverse
     */
    public void setBomb(){
        this.isBomb = true;
    }

    public void reveal(){
        this.revealed = true;
        if(this.isBomb){
            /* Implémenter la logique pour les bombes */
            /* Afficher une bombe */ 
        } else {
            /* Afficher la valeur de la case voire déclencher le reveal des cases alentours */
        }
    }

}
