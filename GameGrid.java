import javax.swing.*;
import java.awt.*;

/**
 * Classe <code>GameGrid</code>
 * @authour Yvan
 * @version 1.0
 */
public class GameGrid extends JPanel{

    private JFrame parent;

    /**
     * Paramètres de la partie
     */
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
     * Créer la fenêtre et vient placer les bombes
     * @param h hauteur de la grille
     * @param l largeur de la grille
     * @param b nombres de bombes
     * @param pF fenêtre parent (jeu)
     * @see Game
     */
    public GameGrid(int h, int l, int b, JFrame pF){
        
        /* Initialisation des variables */
        this.parent = pF;
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
                if(x + _x >= 0 && y + _y >= 0 && x + _x < this.hauteur && y + _y < this.largeur){
                    this.tab[x + _x ][y + _y].incrementerNbBombesAlentours();
                }
            }
        }
    }

    /**
     * Afficher les autres cases vides aux alentours d'une case vide
     * @param x coordonées x de la case
     * @param y cordonnées y de la case 
     * @see Case
     */
    public void revealBlankNeighboor(int x, int y){
        /* Insérer les trucs à faire lol */
        for (int _x = - 1; _x <= 1 ; _x++){
            for(int _y = - 1; _y  <= 1; _y++){
                /* On vérifie que la case calculée ne soit pas en dehors du tableau pour éviter les erreurs outofbond*/
                if(x + _x >= 0 && y + _y >= 0 && x + _x < this.hauteur && y + _y < this.largeur){
                    Case voisinne = this.tab[x + _x ][y + _y];
                    if(!voisinne.isBomb && !voisinne.revealed){
                        voisinne.leftClick();
                    } 
                }
            }
        }
    }

    /**
     * Méthode appellée lorsqu'un bombe a été révélée par un joueur
     * @see Case
     */
    public void gameLost(){
        for(int x=0; x < this.hauteur; x++){ /* hauteur */ 
            for(int y = 0; y < this.largeur; y++){ /* largeur */
                this.tab[x][y].reveal();
            }
        }
        new EndScreen("Perdu !", this.parent);
    }

    /**
     * Vérifie si le joueur a gagné la partie ou pas encore
     * Méthode appellée à chaque fois que le joueur signale une bombe
     * @see Case
     */
    public void checkWin(){
        boolean win = true;
        for(int x=0; x < this.hauteur; x++){ /* hauteur */ 
            for(int y = 0; y < this.largeur; y++){ /* largeur */ 
                if(!this.tab[x][y].isBomb && this.tab[x][y].state != 0){
                    win = false;
                    break;
                } 
                if(this.tab[x][y].isBomb && this.tab[x][y].state != 1){
                    win = false;
                    break;
                }
            }
            if(!win) break;
        }
        if(win){
            new EndScreen("Vous avez gagné !!!", this.parent);
        }
    }

}
