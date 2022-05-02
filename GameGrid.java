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
        /* Initialisation des variables */
        this.tab = new Case[h][l];
        this.hauteur = h;
        this.largeur = l;
        this.nbBombes = b;

        GridLayout gestionnaire = new GridLayout(h,l);
        this.setLayout(gestionnaire);

        for(int x=0; x < h; x++){ /* hauteur */ 
            for(int y = 0; y < l; y++){ /* largeur */ 
                Case caseToAdd = new Case(x,y, this);
                this.tab[x][y] = caseToAdd; 
                this.add(caseToAdd);
            }
        }

        /* Placement des bombes aléatoirement */
        int nbToPlace = nbBombes;
        while(0 < nbToPlace){

            for(int x=0; x < h; x++){
                for(int y = 0; y < l; y++){
                    if(Math.random() > 0.99){
                        if(!this.tab[x][y].isBomb){
                            this.tab[x][y].setBomb();
                            this.processNeighboorCase(x, y);
                            nbToPlace--;
                        }
                    }
                    if(nbToPlace == 0) break;
                }
                if(nbToPlace == 0) break;

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
        for (int _x = - 1; _x <= 1 ; _x++){
            for(int _y = - 1; _y  <= 1; _y++){
                /* On vérifie que la case calculée ne soit pas en dehors du tableau pour éviter les erreurs outofbond*/
                if(x + _x >= 0 && y + _y >= 0 && x + _x < this.largeur && y + _y < this.hauteur){
                    this.tab[x + _x ][y + _y].incrementerNbBombesAlentours();
                }
            }
        }
    }

    /**
     * 
     * @param x coordonées x de la case
     * @param y cordonnées y de la case 
     * @see Case
     */
    public void revealBlankNeighboor(int x, int y){
        /* Insérer les trucs à faire lol */
        for (int _x = - 1; _x <= 1 ; _x++){
            for(int _y = - 1; _y  <= 1; _y++){
                /* On vérifie que la case calculée ne soit pas en dehors du tableau pour éviter les erreurs outofbond*/
                if(x + _x >= 0 && y + _y >= 0 && x + _x < this.largeur && y + _y < this.hauteur){
                    Case voisinne = this.tab[x + _x ][y + _y];
                    if(!voisinne.isBomb && !voisinne.revealed){
                        voisinne.leftClick();
                    } 
                }
            }
        }
    }

    public void gameLost(){
        for(int x=0; x < this.hauteur; x++){ /* hauteur */ 
            for(int y = 0; y < this.largeur; y++){ /* largeur */ 
                this.tab[x][y].reveal();
            }
        }
        EndScreen deathScreen = new EndScreen("Perdu !");
    }
}
