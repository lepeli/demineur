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
        this.largeur  = 5;
        this.hauteur = 3;
        this.nbBombes = 2;
        this.setVisible(true);
        this.setTitle("Démineur - Partie en cours");
        GameGrid grille = new GameGrid(this.hauteur, this.largeur, this.nbBombes);

        this.add(grille);
    }
}
