import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

/**
 * Classe Menu, permet de gérer la partie graphique du menu
 * @author Yvan
 * @version 1.0
 */
public class Menu extends JFrame{

    public Menu(){
        this.setTitle("Demineur - Menu");
        this.setVisible(true);
        this.setSize(300,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton jouer  = new JButton("Nouvelle partie");
        panel.add(jouer);
        JButton charger = new JButton("Charger une partie");
        panel.add(charger);
        JButton quitter = new JButton("Quitter");        
        panel.add(quitter);
        this.add(panel);
    }
    
}