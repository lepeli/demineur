import java.io.*;

/**
 * Save
 * Permet de gérer la sauvegarde d'une partie et de charger une partie
 * @author Yvan
 * @version 1.0
 */
public class Save { 
    /**
     * Fichier de sauvegarde
     */
    private File fichierSauv;
    /**
     * Flux en lecture du fichier
     */
    private FileInputStream fluxEntree;

    /**
     * Flux en écriture du fichier
     */
    private FileOutputStream fluxSortie;
    /**
     * Initialisation de la classe Save
     */
    public Save(){
        /* Ouverture du fichier sauv.dat */
        this.fichierSauv = new File("sauv.dat");
    }

    /**
     * Méthode pour charger une partie sauvegardée.
     * @return la sauvegarde a bien été chargée ou non
     */
    public boolean loadSave(){
        int hauteur;
        int largeur;
        int bombes;

        try{
            this.fluxEntree = new FileInputStream(this.fichierSauv);
        } catch (FileNotFoundException e){
            System.err.println("Le fichier sauv.dat n'a pas été trouvé !");
            return false;
        }
        try{
            hauteur = this.fluxEntree.read();
            largeur = this.fluxEntree.read();
            bombes = this.fluxEntree.read();
            Game game = new Game(largeur, hauteur, bombes);
            GameGrid grille = game.grille;

            for(int x = 0; x < hauteur; x++){
                for(int y = 0; y < largeur; y++){
                    if(this.fluxEntree.read() == 1){
                        grille.tab[x][y].setBomb();
                    }
                    if(this.fluxEntree.read() == 1){
                        grille.tab[x][y].reveal();
                    }
                    grille.tab[x][y].setState(this.fluxEntree.read());
                    grille.tab[x][y].setNeighboors(this.fluxEntree.read());
                }
            }
            this.fluxEntree.close();
        } catch (IOException e){
            System.err.println("Le fichier sauv.dat n'a pas pu être lu !");
        }
        return true;
    }

    /**
     * Méthode pour lancer la sauvegarde d'une partie
     * @param grille la grille à sauvegarder
     * @return la sauvegarde a bien été effectuée ou non
     */
    public boolean saveGame(GameGrid grille){
        try{
            this.fluxSortie = new FileOutputStream(fichierSauv);
        } catch (FileNotFoundException e){
            System.err.println("Le fichier sauv.dat n'a pas été trouvé ! ");
            return false;
        }

        try{
            this.fluxSortie.write(grille.hauteur);
            this.fluxSortie.write(grille.largeur);
            this.fluxSortie.write(grille.nbBombes);

            for(int x = 0; x <  grille.hauteur; x++){
                for(int y = 0; y < grille.largeur; y++){
                    if(grille.tab[x][y].isBomb){
                        this.fluxSortie.write(1);
                    } else {
                        this.fluxSortie.write(0);
                    }
                    if(grille.tab[x][y].isRevealed()){
                        this.fluxSortie.write(1);
                    } else{
                        this.fluxSortie.write(0);
                    }
                    this.fluxSortie.write(grille.tab[x][y].state);
                    this.fluxSortie.write(grille.tab[x][y].nbBombesAlentours);
                }
            }
            this.fluxSortie.close();
        } catch(IOException e){
            System.err.println("Impossible d'écrire dans le fichier sauv.dat");
            return false;
        }

        return true;
    }

    /**
     * Méthode pour savoir si le fichier de sauvegarde existe ou non.
     * @see Menu utilisé par la classe Menu
     * @return true si le fichier existe, sinon false
     */
    public boolean isAvailable(){
        return fichierSauv.exists();
    }

    /**
     * Méthode pour supprimer la sauvegarde après une victoire
     */
    public void delete(){
        if(this.isAvailable()){
            this.fichierSauv.delete();
        }
    }

}