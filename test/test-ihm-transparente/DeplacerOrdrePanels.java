import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeplacerOrdrePanels {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Déplacer l'ordre des panneaux");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            // Création de plusieurs panneaux
            JPanel panel1 = new JPanel();
            panel1.setBackground(java.awt.Color.RED);
            panel1.add(new JLabel("Panneau 1"));

            JPanel panel2 = new JPanel();
            panel2.setBackground(java.awt.Color.BLUE);
            panel2.add(new JLabel("Panneau 2"));

            JPanel panel3 = new JPanel();
            panel3.setBackground(java.awt.Color.GREEN);
            panel3.add(new JLabel("Panneau 3"));

            // Ajout des panneaux à la frame
            frame.setLayout(new OverlayLayout(frame.getContentPane()));
            frame.add(panel1);
            frame.add(panel2);
            frame.add(panel3);

            // Création d'un bouton pour déplacer l'ordre
            JButton moveButton = new JButton("Déplacer vers le haut");
            moveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Changer l'ordre des panneaux (déplacer vers le haut)
                    frame.setComponentZOrder(panel1, 1);
                    frame.repaint();
                }
            });

            frame.add(moveButton);
            frame.setVisible(true);
        });
    }
}

