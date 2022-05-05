import javax.swing.*;
import java.awt.*;

/**
 * Classe Menu, permet de gérer la partie graphique du menu
 * @author Yvan
 * @version 1.0
 */
public class Menu extends JFrame{

    /**
     * Initialisation de la classe Menu
     */
    public Menu(){
        
        /* Configuration de la fenêtre */
        GridLayout fenMgr = new GridLayout(4,1);

        this.setTitle("Demineur - Menu");
        this.setSize(300,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(fenMgr);

        JLabel txt = new JLabel("Menu principal");
        txt.setHorizontalAlignment(JLabel.CENTER);
        this.add(txt);


        /* Ajout des boutons */
        JPanel btnJouer = new JPanel();
        JButton jouer  = new JButton("Nouvelle partie");
        jouer.addActionListener(new MenuListener(this));
        btnJouer.add(jouer);
        this.add(btnJouer);

        JPanel btnCharger = new JPanel();
        JButton charger = new JButton("Charger une partie");
        btnCharger.add(charger);
        charger.addActionListener(new MenuListener(this));
        this.add(btnCharger);

        JPanel quitterBtn = new JPanel();
        JButton quitter = new JButton("Quitter");
        quitterBtn.add(quitter);
        quitter.addActionListener(new MenuListener(this));
        this.add(quitterBtn);
        
        /* Ajout des boutons sur la fenêtre */
        this.setVisible(true);
    }

}