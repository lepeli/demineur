import javax.swing.*;
import java.awt.*;
/**
 * Classe <code>GameGrid</code>
 * @authour Yvan
 * @version 1.0
 */
public class GameGrid extends JPanel{
    protected int hauteur;
    protected int largeur;
    protected int nbBombes;

    /**
     * Permet de stocker les différentes cases.
     * Tableau multidimentionnel
     */
    protected Case tab[][] = null;
    
    /**
     * Initialisation de la classe <code>Grille</code>
     * @param h hauteur de la grille
     * @param l largeur de la grille
     * @param b nombres de bombes
     */
    public GameGrid(int h, int l, int b){
        this.tab = new Case[h][l];
        this.hauteur = h;
        this.largeur = l;
        this.nbBombes = b;

        GridLayout gestionnaire = new GridLayout(l, h);
        this.setLayout(gestionnaire);

        for(int i=0; i < h; i++){
            for(int j = 0; j < l; j++){
                Case caseToAdd = new Case();
                this.tab[i][j] = caseToAdd; 
                this.add(caseToAdd);
            }
        }
        int nb = 0;
        while(0 < nb){
            for(int i=0; i < h; i++){
                for(int j = 0; j < l; j++){
                    Case caseToAdd = new Case();
                    this.tab[i][j] = caseToAdd; 
                    this.add(caseToAdd);
                }
            }
        }

    }
    /**
     * S'occupe de prévenir les cases voisines qu'il y a une nouvelle bombe à côté d'elles.
     * @param x coordonées x de la bombe
     * @param y cordonnées y de la bombe 
     * @see Case
     */
    private void processNeighboorCase(int x, int y){
        /* Insérer les trucs à faire lol */
    }

}
