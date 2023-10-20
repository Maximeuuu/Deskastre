boolean 	contains​(int x, int y) 	
Gives the UI delegate an opportunity to define the precise shape of this component for the sake of mouse processing.


import javax.swing.*;
import javax.swing.OverlayLayout;

public class SuperposerPanels {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Exemple de superposition de panneaux");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            // Création des panneaux
            JPanel panel1 = new JPanel();
            panel1.setBackground(java.awt.Color.RED);
            panel1.add(new JLabel("Panneau 1"));

            JPanel panel2 = new JPanel();
            panel2.setBackground(java.awt.Color.BLUE);
            panel2.add(new JLabel("Panneau 2"));

            // Utilisation d'OverlayLayout pour superposer les panneaux
            frame.setLayout(new OverlayLayout(frame.getContentPane()));
            frame.add(panel1);
            frame.add(panel2);

            frame.setVisible(true);
        });
    }
}


import java.awt.geom.RoundRectangle2D;
this.setShape(new RoundRectangle2D.Double(0, 0, 500, 600, 80, 80));

