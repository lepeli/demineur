import javax.swing.*;
import java.awt.*;

/**
 * Classe <code>GameGrid</code>
 * @author Yvan
 * @version 1.0
 */
public class GameGrid extends JPanel{

    private Game parent;

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
    public GameGrid(int h, int l, int b, Game pF){
        
        /* Initialisation des variables */
        this.parent = pF;
        this.tab = new Case[h][l];
        this.hauteur = h;
        this.largeur = l;
        this.nbBombes = b;

        GridLayout gestionnaire = new GridLayout(h,l);
        this.setLayout(gestionnaire);

        for(int x=0; x < this.hauteur; x++){ /* hauteur */
            for(int y = 0; y < this.largeur; y++){ /* largeur */
                Case caseToAdd = new Case(x,y, this);
                this.tab[x][y] = caseToAdd;
                /* On force la dimension de la case */
                caseToAdd.setSize(30, 30);
                caseToAdd.setPreferredSize(new Dimension(30,30));
                this.add(caseToAdd);
            }
        }

    }

    /**
     * Générer aléatoirement la grille 
     */
    public void generateGrid(){

        /* Placement des bombes aléatoirement */
        int nbToPlace = nbBombes;
        while(0 < nbToPlace){

            for(int x=0; x < this.hauteur; x++){
                for(int y = 0; y < this.largeur; y++){
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

    /*
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
     * Afficher les autres cases aux alentours d'une case (en l'occurence des cases qui ne sont pas des bombes)
     * @param x coordonées x de la case
     * @param y cordonnées y de la case 
     * @see Case
     */
    public void revealNonBombsNeighboors(int x, int y){
        /* Insérer les trucs à faire lol */
        for (int _x = - 1; _x <= 1 ; _x++){
            for(int _y = - 1; _y  <= 1; _y++){
                /* On vérifie que la case calculée ne soit pas en dehors du tableau pour éviter les erreurs outofbond*/
                if(x + _x >= 0 && y + _y >= 0 && x + _x < this.hauteur && y + _y < this.largeur){
                    if(!this.tab[x + _x ][y + _y].isBomb && !this.tab[x + _x ][y + _y].revealed){
                        this.tab[x + _x ][y + _y].leftClick(false);
                    }
                }
            }
        }
    }

    /**
     * Afficher les autres cases aux alentours d'une case
     * @param x coordonées x de la case
     * @param y cordonnées y de la case 
     * @see Case
     */
    public void revealNeighboors(int x, int y){
        /* Insérer les trucs à faire lol */
        for (int _x = - 1; _x <= 1 ; _x++){
            for(int _y = - 1; _y  <= 1; _y++){
                /* On vérifie que la case calculée ne soit pas en dehors du tableau pour éviter les erreurs outofbond*/
                if(x + _x >= 0 && y + _y >= 0 && x + _x < this.hauteur && y + _y < this.largeur){
                    if(!this.tab[x + _x ][y + _y].revealed){
                        this.tab[x + _x ][y + _y].leftClick(false);
                    }
                }
            }
        }
    }

    /**
     * Compte le nombre de drapeaux à côté d'une case
     * @param x coordonées x de la case
     * @param y cordonnées y de la case 
     * @see Case
     */
    public int countFlagsNear(int x, int y){
        /* Insérer les trucs à faire lol */
        int count  = 0; 
        for (int _x = - 1; _x <= 1 ; _x++){
            for(int _y = - 1; _y  <= 1; _y++){
                /* On vérifie que la case calculée ne soit pas en dehors du tableau pour éviter les erreurs outofbond*/
                if(x + _x >= 0 && y + _y >= 0 && x + _x < this.hauteur && y + _y < this.largeur){
                    if(this.tab[x + _x ][y + _y].state != 0){
                        count++;
                    }
                }
            }
        }
        return count;
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
                if(!this.tab[x][y].revealed & !this.tab[x][y].isBomb) win = false;
                if(!this.tab[x][y].isBomb && this.tab[x][y].state != 0) win = false;
                if(this.tab[x][y].isBomb && this.tab[x][y].state != 1) win = false;
                if(!win){
                    break;
                }
            }
            if(!win) break;
        }
        if(win){
            new EndScreen("Vous avez gagné !!!", this.parent);
        }
    }

    /**
     * Méthode pour connaître le nombre de flags sur le plateau
     * @return le nombre de flags sur le plateau
     */
    public int countFlags(){
        int count = 0;
        for(int x=0; x < this.hauteur; x++){ /* hauteur */ 
            for(int y = 0; y < this.largeur; y++){ /* largeur */ 
                if(this.tab[x][y].state == 1) count++;
            }
        }
        return count;
    }

    /**
     * Méthode pour mettre à jour le nombre de flags sur le plateau
     */
    public void updateBombsCount(){
        this.parent.updateFlagCount(this.countFlags());
    }

}
