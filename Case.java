import java.awt.*; 
import javax.swing.*;

/**
 * Case
 * Permet de gérer l'apparence et la logique basique d'une case avec des actions comme reveler, définir que la case est une bombe ect.
 * @author Yvan
 * @version 1.0
 */
public class Case extends JComponent{
    protected int posx;
    protected int posy;
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
    public Case(int x, int y){
        super();
        this.posx = x;
        this.posy = y;
        this.setPreferredSize(new Dimension(50,50));
        this.setMaximumSize(new Dimension(50, 50));
        this.setSize(50,50);
        this.addMouseListener(new CaseListener(this));
    }

    /**
     * Création graphique de la case
     * @param pinceau utilisé pour créer un autre pinceau
     */
    @Override
    protected void paintComponent(Graphics pinceau){
        // System.out.println(this.getSize());
        Graphics secondPinceau = pinceau.create();
        secondPinceau.setColor(Color.BLUE);
        secondPinceau.fillRect(0, 0, this.getSize().width, this.getSize().width);
        if(!this.isBomb){
            if(this.nbBombesAlentours > 0){
                secondPinceau.setColor(Color.GREEN);
                secondPinceau.fillRect(0, 0, this.getSize().width, this.getSize().width);
                secondPinceau.setColor(Color.WHITE);
                secondPinceau.drawString("" + this.nbBombesAlentours, this.getSize().width / 2, this.getSize().width / 2); 
            } else {
                secondPinceau.setColor(Color.GRAY);
                secondPinceau.fillRect(0, 0, this.getSize().width, this.getSize().width);
            }
        }
        if(this.isBomb){
            secondPinceau.setColor(Color.RED);
            secondPinceau.fillRect(0, 0, this.getSize().width, this.getSize().width);
            secondPinceau.setColor(Color.WHITE);
            secondPinceau.drawString("X", this.getSize().width / 2, this.getSize().width / 2);
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
        this.repaint();
    }
    /**
     * Méthode utilisée pour marquer la case en suspecte.
     * Appellée par l'action listener des cases 
     * @see ActionCase
     */
    public void doSuspect(){
        this.state = 1;
        this.repaint(); /* On force la case à se redessinner*/
    }
    /**
     * Méthode utilisée pour dire que l'on a un doute sur le contenu de la case
     * Appellée par l'action listener des cases 
     * @see ActionCase 
     */
    public void doDoubt(){
        this.state = 2;
        this.repaint(); /* On force la case à se redessinner*/
    }
    /**
     * Utilisé par la gestion des actions sur les cases, permet de révéler la case
     * @see ActionCase (nom temporaire)
     */

    public void rightClick(){
        this.revealed = true;
        if(this.isBomb){
            /* Implémenter la logique pour les bombes */
            this.repaint();
        } else {
            if(0 < nbBombesAlentours){
                /* On affiche la valeur de la case */
            } else {
                /* On révèle toutes les voisines (de façon récursive) qui ne sont pas des bombes */
            }
        }
    }

}
