import java.awt.*;
import javax.swing.*;

public class EndScreen extends JFrame {
    
    public EndScreen(String title){
        GridLayout fenetreMgr = new GridLayout(3,1);
        this.setLayout(fenetreMgr);
        /* Texte */
        JLabel texte = new JLabel(title);
        texte.setHorizontalAlignment(JLabel.CENTER);
        this.add(texte);

        /* Boutons */
        JPanel boutons = new JPanel();
        GridLayout boutonsMgr = new GridLayout(1,2);
        boutons.setLayout(boutonsMgr);
        
        JButton menuPrincipal = new JButton("Menu Principal");
        JButton quitter = new JButton("Quitter");

        boutons.add(menuPrincipal);
        boutons.add(quitter);
        this.setSize(300,300);
        this.setResizable(false);
        this.add(boutons);
        this.setVisible(true);

    }

}
