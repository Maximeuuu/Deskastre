package deskastre.modele.entite;

import deskastre.Constantes;

import java.awt.Polygon;
import java.awt.Point;
import java.awt.Dimension;

public class Asteroide extends Entite implements IDeplacable, IInteraction, IDestructible
{
	double velociteX;
	double velociteY;
	Polygon masque;
	int pvActuel;
	int pvMax;

	public Asteroide( Point position, Dimension dimension, String image )
	{
		super( position, dimension, image );

		this.velociteX = -1.0;
		this.velociteY = 0;
		this.masque = OutilsImage.getMasqueImage( super.getImage(), (int)(super.getX()), (int)(super.getY()) );
		this.pvMax = 1;
		this.pvActuel = this.pvMax;
	}

	public void arreter(){ this.velociteX=0; this.velociteY=0; }
	public void avancer()
	{
		super.x += (int)(this.velociteX*Constantes.TEMPS/10);
		super.y += (int)(this.velociteY*Constantes.TEMPS/10);
		this.masque.translate( (int)(this.velociteX*Constantes.TEMPS/10), (int)(this.velociteY*Constantes.TEMPS/10) );
	}
	public void setVelocite( double vx, double vy ){ this.velociteX = vx; this.velociteY = vy; }

	public boolean estSelectionne( Point p )
	{
		return this.masque.contains( p );
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
