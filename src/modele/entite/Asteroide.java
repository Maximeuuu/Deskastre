package deskastre.modele.entite;

import java.awt.Polygon;
import java.awt.Point;
import java.awt.Dimension;

public class Asteroide extends Entite implements IDeplacable, IInteraction
{
	int velociteX;
	int velociteY;
	Polygon masque;

	public Asteroide( Point position, Dimension dimension, String image )
	{
		super( position, dimension, image );

		this.velociteX = 0;
		this.velociteY = 0;
		this.masque = OutilsImage.getMasqueImage( super.getImage(), super.getLocation() );
	}

	public int getVelociteX(){ return this.velociteX; }
	public int getVelociteY(){ return this.velociteY; }
	public void arreter(){ this.velociteX=0; this.velociteY=0; }
	public void deplacer( int x, int y ){ super.x = x; super.y = y; }

	public boolean estSelectionne( Point p ){ return masque.contains( p ); }
}
