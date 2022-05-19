import java.awt.*;
import javax.swing.*;

/**
 * Case
 * Permet de gérer l'apparence et la logique basique d'une case avec des actions comme reveler, définir que la case est une bombe ect.
 * @author Yvan
 * @version 1.0
 */
public class Case extends JComponent{
    /**
     * Position x de la case
     */
    protected int posx;
    /**
     * Position y de la casze
     */
    protected int posy;
    protected boolean isBomb = false; /* Permet de savoir si la case est une bombe ou pas */
    protected boolean revealed = false;
    protected GameGrid gridController;

    protected Image image;

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
     * @param x cordonnées x de la case 
     * @param y cordonnées y de la case
     * @param g grille pour pouvoir faire des appels plus tard à la grille
     */
    public Case(int x, int y, GameGrid g){
        super();
        this.posx = x;
        this.posy = y;
        this.gridController = g;

        this.image = Toolkit.getDefaultToolkit().getImage("icones/start.png");

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
    }
    /**
     * Permet de changer le state de la case
     * @param state l'entier correspondant au state
     */
    public void setState(int state){
        this.state = state;
    }
    /**
     * Permet de changer le nombres de bombes voisinnes
     * @param neighboors nombres de bombes voisinnes
     */
    public void setNeighboors(int neighboors){
        this.nbBombesAlentours = neighboors;
    }
    /**
     * Permet à la classe Grille de gérer le compte des bombes alentours d'une case lors de la création
     * Permet d'éviter de faire des calculs supplémentaires lorsque l'on clique sur une case
     * @see GameGrid
     */
    public void incrementerNbBombesAlentours(){
        this.nbBombesAlentours += 1;
    }

    /**
     * Méthode utilisée pour changer le state de la case
     * Appellée par l'action listener des cases 
     * @see CaseListener
     */
    public void rightClick(){
        if(!this.revealed){
            this.state++;
            if(this.state == 3){
                this.state = 0;
            }
            this.repaint();
            this.gridController.checkWin();
        }

    }

    /**
     * Méthode utilisée par la gestion des actions sur les cases, permet de révéler la case
     * @see CaseListener
     */
    public void leftClick(){
        if(this.state == 0 && !this.revealed){
            this.reveal();
            if(this.isBomb){
                this.gridController.gameLost();
            } else {
                if(0 == nbBombesAlentours){
                    this.gridController.revealBlankNeighboor(this.posx, this.posy);
                }
            }
        }

    }

    /**
     * Révéler la case.
     * Méthode utilisée par la classe Grille
     * @see GameGrid
     */
    public void reveal(){
        this.revealed = true;
        this.repaint();
        this.gridController.checkWin();
    }

    /**
     * Méthode pour savoir si la case a été révelée ou non utilisée dans le GameGrid
     * @see GameGrid
     * @return true si révélé, sinon false
     */
    public boolean isRevealed(){
        return this.revealed;
    }
    /**
     * Création graphique de la case
     * @param pinceau utilisé pour créer un autre pinceau
     */
    @Override
    protected void paintComponent(Graphics pinceau){
        Graphics secondPinceau = pinceau.create();
        // secondPinceau.setColor(Color.BLUE);

        if(this.revealed){

            if(this.isBomb){
                this.image = Toolkit.getDefaultToolkit().getImage("icones/bombes.png");
            } else if (this.nbBombesAlentours > 0) {
                this.image = Toolkit.getDefaultToolkit().getImage("icones/"+this.nbBombesAlentours+".png");
            } else {
                this.image = Toolkit.getDefaultToolkit().getImage("icones/vide.png");
            }

        } else if (this.state == 1){
            this.image = Toolkit.getDefaultToolkit().getImage("icones/flag.png");
        } else if (this.state == 2){
            this.image = Toolkit.getDefaultToolkit().getImage("icones/doute.png");
        } else {
            this.image = Toolkit.getDefaultToolkit().getImage("icones/start.png");
        }

        secondPinceau.fillRect(0, 0, this.getSize().width, this.getSize().width);
        secondPinceau.drawImage(this.image, 0, 0, this);

    }
}
