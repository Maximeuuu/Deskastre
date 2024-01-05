import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickThroughImageExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Click-Through Image Example");
            frame.setUndecorated(true);
            frame.setBackground( new Color(0,0,0,0) );
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            // Création d'un JLayeredPane
            JLayeredPane layeredPane = new JLayeredPane();
            frame.add(layeredPane);

            // Création de composants en arrière-plan
            JPanel backgroundPanel = new JPanel();
            backgroundPanel.setBackground( new Color(0,0,0,0));
            backgroundPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
            layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

            // Création de l'image
            ImageIcon imageIcon = new ImageIcon("../../lib/images/vaisseaux/vaisseau1.png");
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(50, 50, imageIcon.getIconWidth(), imageIcon.getIconHeight());
            layeredPane.add(imageLabel, JLayeredPane.PALETTE_LAYER);

            // Définir la zone de l'image comme transparente pour les clics
            imageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Ne rien faire pour les clics sur l'image
                }
            });

            frame.setVisible(true);
        });
    }
}

