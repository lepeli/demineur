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

    public GameGrid grille;

    /**
     * Initialisation de la partie
     * @param l largeur de la grille
     * @param h hauteur de la grille 
     * @param b nombres de bombes sur la grille
     */
    public Game(int l, int h, int b){
        /* 
            On définit les valeurs dans la classe
        */
        this.largeur  = l;
        this.hauteur = h;
        this.nbBombes = b;

        /* Paramètres de la fenêtre */
        this.setSize(l*30+30,h*30+30);
        // this.setResizable(false);
        this.setTitle("Démineur - Partie en cours");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Initialisation de la grille */
        this.grille = new GameGrid(this.hauteur, this.largeur, this.nbBombes, this);
        this.add(this.grille, BorderLayout.CENTER);

        JButton boutonSave = new JButton("Sauvegarder et quitter");
        boutonSave.addActionListener(new MenuListener(this));
        this.add(boutonSave, BorderLayout.NORTH);
        this.setVisible(true);
    }

    /**
     * Force la grille à se générer
     * @see MenuListener
     */
    public void generateGrid(){
        this.grille.generateGrid();

    }

    /**
     * Lancement de la sauvegarde depuis le bouton sauvegarder
     * @see MenuListener
     */
    public void saveGame(){
        Save save = new Save();
        save.saveGame(this.grille);
    }

}
