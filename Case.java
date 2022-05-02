import java.awt.*; 
import javax.swing.*;

/**
 * Case
 * Permet de gérer l'apparence et la logique basique d'une case avec des actions comme reveler, définir que la case est une bombe ect.
 * @author Yvan
 * @version 1.0
 */
public class Case extends JButton{
    protected int posx;
    protected int posy;
    protected boolean isBomb = false; /* Permet de savoir si la case est une bombe ou pas */
    protected boolean revealed = false;
    protected GameGrid gridController;

    /**
     * state est utilisé pour savoir à quel état la case est:
     *  - 0: non révélée ()
     *  - 1: suspectée (*)
     *  - 2: doute (?)
     */
    protected int state = 0;
    
    /**
     * Nombres de bombes aux alentours (utilisé pour les cases qui affichent le nbr de bombes alentours)
     */
    protected int nbBombesAlentours = 0;

    /**
     * Initialisation de la classe Case
     */
    public Case(int x, int y, GameGrid g){
        super();
        this.posx = x;
        this.posy = y;
        this.gridController = g;

        this.setPreferredSize(new Dimension(50,50));
        this.setMaximumSize(new Dimension(50, 50));
        this.setSize(50,50);
        this.addMouseListener(new CaseListener(this));
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
     * Méthode utilisée pour changer le state de la case
     * Appellée par l'action listener des cases 
     * @see CaseListener
     */
    public void rightClick(){
        this.state++;
        if(this.state == 3){
            this.state = 0;
        }
        this.repaint();
    }

    /**
     * Utilisé par la gestion des actions sur les cases, permet de révéler la case
     * @see ActionCase (nom temporaire)
     */
    public void leftClick(){
        if(this.state == 0){
            this.revealed = true;
            if(this.isBomb){
                /* Implémenter la logique pour les bombes */
                this.gridController.gameLost();
            } else {
                if(0 == nbBombesAlentours){
                    this.gridController.revealBlankNeighboor(this.posx, this.posy);
                }
            }            
        }
        this.repaint();

    }

    /**
     * Révéler la case
     */
    public void reveal(){
        this.revealed = true;
        this.repaint();
    }

    /**
     * Création graphique de la case
     * @param pinceau utilisé pour créer un autre pinceau
     */
    @Override
    protected void paintComponent(Graphics pinceau){
        Graphics secondPinceau = pinceau.create();
        secondPinceau.setColor(Color.BLUE);
        secondPinceau.fillRect(0, 0, this.getSize().width, this.getSize().width);
        if(this.revealed){
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
        } else if(this.state == 1){
            secondPinceau.setColor(Color.WHITE);
            secondPinceau.drawString("F", this.getSize().width / 2, this.getSize().width / 2); 
        } else if(this.state == 2){
            secondPinceau.setColor(Color.WHITE);
            secondPinceau.drawString("?", this.getSize().width / 2, this.getSize().width / 2); 
        }
    }
}
