import javax.swing.*;
import java.awt.*;

/**
 * Classe <code>Game</code>
 * Elle permet d'appeler la grille en lui envoyant les paramètres reçus depuis l'écran d'options
 * @author Yvan
 * @version 1.0
 */
public class Game extends JFrame{
    protected int hauteur;
    protected int largeur;
    protected int nbBombes;

    /**
     * Initialisation de la classe Game
     */
    public Game(int l, int h, int b){
        /* 
            Valeurs de tests
        */
        this.largeur  = l;
        this.hauteur = h;
        this.nbBombes = b;

        /* Paramètres de la fenêtre */
        this.setSize(800,800);
        this.setVisible(true);
        // this.setResizable(false);
        this.setTitle("Démineur - Partie en cours");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GridLayout fenMgr = new GridLayout(3,1);
        // this.setLayout(fenMgr);

        /* Initialisation de la grille */
        GameGrid grille = new GameGrid(this.hauteur, this.largeur, this.nbBombes, this);

        this.add(grille);
    }

}
