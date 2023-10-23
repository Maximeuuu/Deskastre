package deskastre.modele.entite;

import java.awt.Polygon;
import java.awt.Point;
import java.awt.Dimension;

public class Asteroide extends Entite implements IDeplacable, IInteraction, IDestructible
{
	int velociteX;
	int velociteY;
	Polygon masque;
	int pvActuel;
	int pvMax;

	public Asteroide( Point position, Dimension dimension, String image )
	{
		super( position, dimension, image );

		this.velociteX = 0;
		this.velociteY = 0;
		this.masque = OutilsImage.getMasqueImage( super.getImage() );
		this.pvMax = 1;
		this.pvActuel = this.pvMax;
	}

	public int getVelociteX(){ return this.velociteX; }
	public int getVelociteY(){ return this.velociteY; }
	public void arreter(){ this.velociteX=0; this.velociteY=0; }
	public void deplacer( int x, int y ){ super.x = x; super.y = y; }

	public boolean estSelectionne( Point p )
	{
		p.translate( (int)(-super.getX()), (int)(-super.getY()) );
		return masque.contains( p );
	}
	
	public boolean perdrePv()
	{
		if( this.pvActuel <= 0 )
		{
			return false;
		}
		else
		{
			this.pvActuel--;
			return true;
		}
	}
	public boolean gagnerPv()
	{
		if( this.pvActuel >= this.pvMax )
		{
			return false;
		}
		else
		{
			this.pvActuel++;
			return true;
		}
	}

	public boolean estDetruit(){ return (this.pvActuel <= 0); }

	public void detruire(){ this.pvActuel = 0; }
	public void reconstruire(){ this.pvActuel = pvMax; }
}
