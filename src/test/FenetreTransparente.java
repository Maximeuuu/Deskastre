
import javax.swing.*;
import java.awt.Color;


public abstract class FenetreTransparente extends JFrame
{
	private JPanel panel;
	private int largeur;
	private int hauteur;

	//créer une interface / classe au lieu de JPanel ?
	public FenetreTransparente( JPanel panel, int posX, int posY, int largeur, int hauteur ) //abstract par la suite ?
	{
		this.largeur = largeur;
		this.hauteur = hauteur;

		/* Propriétés */
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //créer une dépendance entre toutes les fenetres pour que ça arrête le jeu quand on ferme / demande confirmation
		this.setLocation(posX,posY);
		this.setBackground( new Color(0,0,0,0) );

		/* Dimensions */
		this.setResizable(false);
		this.setSize(largeur, hauteur);

		/*Composants*/
		this.panel = panel;
		this.add( this.panel );

		/* Activation */
		//this.setClosable(false);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
}
