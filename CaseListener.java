import java.awt.event.*;

/**
 * Classe <code>CaseListener</code>
 * Gère les clics faits sur une case.
 * @author Yvan
 * @version 1.0
 * @see Case
 */
public class CaseListener implements MouseListener{

    private Case c;

    /**
     * Initialisation de la classe CaseListener
     * @param c Objet Case pour faire des appels sur la case correspondante
     */
    public CaseListener(Case c){
        this.c = c;
    }

    /**
     * Clic détecté sur une des cases
     */
    public void mouseClicked(MouseEvent evenement){

        if(evenement.getButton() == MouseEvent.BUTTON1){
            /* Il y a eu un clic gauche */
            this.c.leftClick();
        }
        else if(evenement.getButton() == MouseEvent.BUTTON3){
            /* Il y a eu un clic droit */
            this.c.rightClick();
        }

    }

    /*
        Les actions ci-dessous ne sont pas implémentées dans le jeu
    */
    public void mouseEntered(MouseEvent evenement){
        // debut du survol
    }          

    public void mouseExited(MouseEvent evenement){
        // fin du survol
    }           
    public void mousePressed(MouseEvent evenement){
        // un bouton appuyé
    }         
    public void mouseReleased(MouseEvent evenement){
        // un bouton relâché
    }       

}
