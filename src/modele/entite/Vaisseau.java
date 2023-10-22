package deskastre.modele.entite;

import java.awt.Polygon;
import java.awt.Point;
import java.awt.Dimension;

public class Vaisseau extends Entite implements IAttaque, IDeplacable, IInteraction
{
	int degat;
	int velociteX;
	int velociteY;
	Polygon masque;

	Entite bouclier;

	public Vaisseau(  Point position, Dimension dimension, String image, int degat )
	{
		super( position, dimension, image );

		this.degat = degat;
		this.velociteX = 0;
		this.velociteY = 0;
		this.masque = OutilsImage.getMasqueImage( super.getImage(), super.getLocation() );
	}

	public int getPuissanceAttaque(){ return this.degat; }
	public void setPuissanceAttaque( int degat ){ this.degat = degat; }

	public int getVelociteX(){ return this.velociteX; }
	public int getVelociteY(){ return this.velociteY; }
	public void arreter(){ this.velociteX=0; this.velociteY=0; }
	public void deplacer( int x, int y ){ super.x = x; super.y = y; }

	public boolean estSelectionne( Point p ){ return masque.contains( p ); }
}
