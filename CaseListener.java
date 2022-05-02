import java.awt.event.*;

public class CaseListener implements MouseListener{
    private Case c;
    public CaseListener(Case c){
        this.c = c;
    }
    public void mouseClicked(MouseEvent evenement){
        System.out.println("Pos Y:" + this.c.posy + " Pos X:" + this.c.posx);

        if(evenement.getButton() == MouseEvent.BUTTON1){
            /* Il y a eu un clic droit*/
            this.c.leftClick();
        }
        else if(evenement.getButton() == MouseEvent.BUTTON3){
            this.c.rightClick();
        }

    }          // un bouton cliqué
    public void mouseEntered(MouseEvent evenement){

    }          // debut du survol
    public void mouseExited(MouseEvent evenement){

    }           // fin du survol
    public void mousePressed(MouseEvent evenement){

    }         // un bouton appuyé
    public void mouseReleased(MouseEvent evenement){

    }       // un bouton relâché
}
