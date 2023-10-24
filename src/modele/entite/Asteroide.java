package deskastre.modele.entite;

import deskastre.Constantes;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.Polygon;
import java.awt.Dimension;

/**
 * Entite Asteroide pouvant être recolté
 * @autor : Maximeuuu
 */
public class Asteroide extends Entite implements IDeplacable, IInteraction, IDestructible
{
	private double velociteX;
	private double velociteY;
	private Polygon masque;
	private int pvActuel;
	private int pvMax;

	public Asteroide( Point position, Dimension dimension, String image )
	{
		super( position, dimension, image );

		this.velociteX = -1.0;
		this.velociteY = 0;
		this.masque = OutilsImage.getPolygoneSimplifie( OutilsImage.getMasqueImage( super.getImage() ), 1.0 );
		this.pvMax = 1;
		this.pvActuel = this.pvMax;
	}

	public void arreter(){ this.velociteX=0; this.velociteY=0; }
	public void avancer()
	{
		/*super.x -= 0.5;
		super.y -= 1.5;*/
		super.x += (this.velociteX*Constantes.TEMPS/10.0); //remplacer TEMPS par PAS_X et PAS_Y
		super.y += (this.velociteY*Constantes.TEMPS/10.0);
	}
	public void setVelocite( double vx, double vy ){ this.velociteX = vx; this.velociteY = vy; }

	public boolean estSelectionne( Point p )
	{
		Point p2 = new Point( p );
		p2.translate( (int)(-super.getX()), (int)(-super.getY()) ); //les masques sont places en (0,0) donc on se met a l'origine du repere de la fenetre
		return masque.contains( p2 );
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
