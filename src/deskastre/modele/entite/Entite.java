package deskastre.modele.entite;

import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Point;

/**
 * Objet simple du jeu
 * @autor : Maximeuuu
 */
public class Entite extends AbstractEntite
{
	public static final int NORTH = 0;
	public static final int SOUTH = 180;
	public static final int EAST  = 90;
	public static final int WEST  = 270;

	private ImageIcon image;
	private int direction; //angle en degres -> probablement à supprimer

	public Entite( Point centre, ImageIcon image )
	{
		super( centre, new Dimension( image.getIconWidth(), image.getIconHeight() ) );

		this.image = image;
		this.direction = Entite.NORTH;
	}

	//public void setImage( String image ){ this.image = new ImageIcon(VariablesUtilisateur.REP_IMAGE+image); }
	public void setImage( ImageIcon image )
	{
		super.setDimension( new Dimension( image.getIconWidth(), image.getIconHeight() ) );
		this.image = image;
	}
	public void setDirection( int direction ){ this.direction = direction%360; }

	public ImageIcon getImage(){ return this.image; }
	public int getDirection(){ return this.direction; }
}
