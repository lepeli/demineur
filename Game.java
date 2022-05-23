import javax.swing.*;
import java.awt.*;
/**
 * Classe <code>Game</code>
 * Elle permet d'appeler la grille en lui envoyant les paramètres reçus depuis l'écran d'options
 * @author Yvan
 * @version 1.0
 */
public class Game extends JFrame{
    /**
     * Hauteur de la grille
     */
    protected int hauteur;
    /**
     * Largeur de la grille
     */
    protected int largeur;
    /**
     * Nombre de bombes sur la grille
     */
    protected int nbBombes;
    /**
     * Label pour afficher le nombre de bombes restantes
     */
    protected JLabel nbBombesRestantes;

    /**
     * La grille du jeu
     */
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
        this.setSize(1000,1000);
        this.setTitle("Démineur - Partie en cours");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Initialisation de la grille */
        this.grille = new GameGrid(this.hauteur, this.largeur, this.nbBombes, this);
        
        /* Code qui permet de centrer la grille en vertical */
        JPanel gmPanel = new JPanel();
        gmPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gmPanel.add(this.grille, gbc);
        gmPanel.setBackground(Color.DARK_GRAY);
        /* On force une taille pour la grille, afin qu'elle s'affiche correctement */
        gmPanel.setSize(l*30,h*30);
        this.add(gmPanel, BorderLayout.CENTER);

        /* Top bar */
        JPanel topbar = new JPanel();
        topbar.setLayout(new GridLayout(1,2));
        JButton boutonSave = new JButton("Sauvegarder et quitter");
        boutonSave.addActionListener(new MenuListener(this));

        topbar.add(boutonSave);

        /* Scoreboard */
        this.nbBombesRestantes = new JLabel("Bombes restantes : " + this.nbBombes);
        topbar.add(nbBombesRestantes);

        this.add(topbar, BorderLayout.NORTH);
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

    /**
     * Permet d'afficher le nombre de flag restants
     * @param count le compte de flag restants
     */
    public void updateFlagsCount(int count){
        this.nbBombesRestantes.setText("Bombes restantes : " + (this.nbBombes - count));
    }

}
