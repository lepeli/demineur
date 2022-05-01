import java.awt.*; 
import javax.swing.*;

/**
 * Case
 * Permet de gérer l'apparence et la logique basique d'une case avec des actions comme reveler, définir que la case est une bombe ect.
 * @author Yvan
 * @version 1.0
 */
public class Case extends JComponent{
    protected boolean isBomb = false; /* Permet de savoir si la case est une bombe ou pas */
    private boolean revealed = false;
    /**
     * state est utilisé pour savoir à quel état la case est:
     *  - 0: non révélée ()
     *  - 1: suspectée (*)
     *  - 2: doute (?)
     */
    private int state = 0;
    
    /**
     * Nombres de bombes aux alentours (utilisé pour les cases qui affichent le nbr de bombes alentours)
     */
    protected int nbBombesAlentours = 0;

    /**
     * Initialisation de la classe Case
     */
    public Case(){
        super();
        this.setPreferredSize(new Dimension(50,50));
        this.setMaximumSize(new Dimension(50, 50));
        this.setSize(50,50);
    }

    /**
     * Création graphique de la case
     * @param pinceau utilisé pour créer un autre pinceau
     */
    @Override
    protected void paintComponent(Graphics pinceau){
        Graphics secondPinceau = pinceau.create();
        secondPinceau.setColor(Color.BLUE);
        secondPinceau.fillRect(0, 0, 50, 50);
        if(!this.isBomb){
            secondPinceau.setColor(Color.GREEN);
            secondPinceau.fillRect(0, 0, 50, 50);
            secondPinceau.setColor(Color.WHITE);
            secondPinceau.drawString("" + this.nbBombesAlentours, 25, 25); 
        }
    }

    /**
     *  Permet de transformer la case en bombe et ne pas pouvoir faire l'inverse, utilisé par la classe Grille
     * @see GameGrid
     */
    public void setBomb(){
        this.isBomb = true;
        this.repaint(); /* On force le composant à se redessiner*/ 
    }

    /**
     * Permet à la classe Grille de gérer le compte des bombes alentours d'une case
     * Permet aussi d'éviter de devoir faire des calculs supplémentaires lorsque l'on clique sur une case
     * @see GameGrid
     */
    public void incrementerNbBombesAlentours(){
        this.nbBombesAlentours += 1;
    }
    /**
     * Méthode utilisée pour marquer la case en suspecte.
     * Appellée par l'action listener des cases 
     * @see ActionCase
     */
    public void doSuspect(){
        this.state = 1;
    }
    /**
     * Méthode utilisée pour dire que l'on a un doute sur le contenu de la case
     * Appellée par l'action listener des cases 
     * @see ActionCase 
     */
    public void doDoubt(){
        this.state = 2;
    }
    /**
     * Utilisé par la gestion des actions sur les cases, permet de révéler la case
     * @see ActionCase (nom temporaire)
     */
    public void reveal(){
        this.revealed = true;
        if(this.isBomb){
            /* Implémenter la logique pour les bombes */
            this.repaint();
        } else {
            /* Afficher la valeur de la case voire déclencher le reveal des cases alentours */
        }
    }

}
