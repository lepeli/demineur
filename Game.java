import javax.swing.JFrame;

/**
 * Classe <code>Game</code>
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
    public Game(){
        /* 
            Valeurs de tests
        */
        this.largeur  = 50;
        this.hauteur = 50;
        this.nbBombes = 100;
        /* Paramètres de la fenêtre */
        this.setSize(800,800);
        this.setVisible(true);
        // this.setResizable(false);
        this.setTitle("Démineur - Partie en cours");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Initialisation de la grille */
        GameGrid grille = new GameGrid(this.hauteur, this.largeur, this.nbBombes);

        this.add(grille);
    }
}
