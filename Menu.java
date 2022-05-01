import javax.swing.JPanel;

/**
 * Menu, contrôle le menu 
 */

import java.awt.*;

import javax.swing.*;
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