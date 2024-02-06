package deskastre.modele.entite;

import deskastre.modele.entite.propriete.*;

import java.awt.Polygon;

import javax.swing.ImageIcon;

import java.awt.Point;

/**
 * Entite correspondant au joueur
 * @autor : Maximeuuu
 */
public class Vaisseau extends Entite implements IAttaque, IInteraction
{
	private int degat;
	private int velociteX;
	private int velociteY;
	private Polygon masque;
	public Reservoir reservoir;

	//int distanceBase;

	Entite bouclier;

	public Vaisseau( Point position, ImageIcon image, Polygon masque, int degat )
	{
		super( position, image );

		this.degat = degat;
		this.velociteX = 0;
		this.velociteY = 0;
		this.masque = masque;
		
		this.reservoir = new Reservoir(10);
		this.reservoir.remplir();
	}

	public int getPuissanceAttaque(){ return this.degat; }
	public void setPuissanceAttaque( int degat ){ this.degat = degat; }

	public boolean estSelectionne( Point p )
	{
		Point p2 = new Point( p );
		p2.translate( (int)(-super.getX()), (int)(-super.getY()) ); //les masques sont places en (0,0) donc on se met a l'origine du repere de la fenetre
		return masque.contains( p2 );
	}



	public class Reservoir
	{
		double carburant;
		int capacite;
		double consommation;

		public Reservoir( int capacite )
		{
			this.capacite = capacite;
			this.carburant = 0.0;
			this.consommation = 1.0;
		}

		public boolean setCapacite( int capacite )
		{
			if( capacite <= this.capacite ){ return false; }
			this.capacite = capacite;
			return true;
		}

		public boolean estVide()
		{
			return (this.carburant < 0.0);
		}

		public boolean peutAvancer()
		{
			return (this.carburant < this.consommation);
		}

		public boolean ajouterCarburant( int volume )
		{
			if( volume < 0 || (this.carburant+volume) > this.capacite ){ return false; }
			this.carburant += volume;
			return true;
		}
		
		public boolean consommerCarburant( double volume )
		{
			if( volume < 0 || (this.carburant-volume) < 0 ){ return false; }
			this.carburant -= volume;
			return true;
		}

		public double remplir()
		{
			double delta = this.capacite - this.carburant;
			this.carburant = this.capacite;
			return delta;
		}

		public double vider()
		{
			double delta = this.carburant;
			this.carburant = 0;
			return delta;
		}
	}
}
