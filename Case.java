import java.awt.*; 
import javax.swing.*;

/**
 * Case
 * Permet de gérer l'apparence et la logique basique d'une case avec des actions comme reveler, définir que la case est une bombe ect.
 */

public class Case {
    private boolean isBomb;
    private boolean revealed = false;
    /**
     * state est utilisé pour savoir à quel état la case est:
     *  - 0: non révélée ()
     *  - 1: suspectée (*)
     *  - 2: pas sûr d'être suspectée (?)
     */
    private int state = 0;

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
