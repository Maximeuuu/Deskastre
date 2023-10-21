package deskastre.modele.entite;

import deskastre.Constantes;
import javax.swing.ImageIcon;

public class Entite extends AbstractEntite
{
	private ImageIcon image;
	private int direction; //angle en degres

	public Entite( String image )
	{
		this.image = new ImageIcon(Constantes.REP_IMAGE+image);
		this.direction = 0;
	}

	public Entite()
	{
		this.direction = 0;
	}

	public void setImage( String image ){ this.image = new ImageIcon(Constantes.REP_IMAGE+image); }
	public void setImage( ImageIcon image ){ this.image = image; }
	public void setDirection( int direction ){ this.direction = direction%360; }

	public ImageIcon getImage(){ return this.image; }
	public int getDirection(){ return this.direction; }
}
