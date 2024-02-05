package deskastre.modele.entite;

import deskastre.modele.Constantes;
import deskastre.modele.entite.propriete.*;

import java.awt.Point;
import java.awt.Polygon;

import javax.swing.ImageIcon;


/**
 * Entite Asteroide pouvant être récolté
 * @autor : Maximeuuu
 */
public class Asteroide extends Entite implements IDeplacable, IInteraction, IDestructible
{
	//private Proprietes proprietes; -> ensemble de règles que doit respecter l'entite
	private Polygon masque;
	private double velociteX;
	private double velociteY;
	private int pvActuel;
	private int pvMax;
	private int loot;

	public Asteroide( Point position, ImageIcon image, Polygon masque )
	{
		this( position, image, masque, -1.0, 0.0, 1, 0 );
	}

	public Asteroide( Point position, ImageIcon image, Polygon masque, double velociteX, double velociteY, int pvMax, int loot )
	{
		super( position, image );
		this.masque = masque;

		this.velociteX = velociteX;
		this.velociteY = velociteY;
		this.pvMax = pvMax;
		this.pvActuel = this.pvMax;
		this.loot = loot;
	}

	public void arreter(){ this.velociteX=0; this.velociteY=0; }
	public void avancer()
	{
		super.x += (this.velociteX*Constantes.TEMPS/10.0); //remplacer TEMPS par PAS_X et PAS_Y ?
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

	public int getLoot(){ return this.loot; }

	public boolean estDetruit(){ return (this.pvActuel <= 0); }

	public void detruire(){ this.pvActuel = 0; }
	public void reconstruire(){ this.pvActuel = pvMax; }

	public String toString()
	{
		return "Asteroide : "+super.toString()+"\n\tVx : "+this.velociteX+"\n\tVy : "+this.velociteY+"\n\tPV : "+this.pvActuel+"/"+this.pvMax;
	}
}
