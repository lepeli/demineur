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
    File fichierSauv;
    /**
     * Flux en lecture du fichier
     */
    FileInputStream fluxEntree;

    /**
     * Flux en écriture du fichier
     */
    FileOutputStream fluxSortie;
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
        return true;
    }

    /**
     * Méthode pour lancer la sauvegarde d'une partie
     * @return la sauvegarde a bien été effectuée ou non
     */
    public boolean saveGame(){
        return true;
    }

}