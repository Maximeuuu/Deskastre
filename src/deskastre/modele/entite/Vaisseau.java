package deskastre.modele.entite;

import deskastre.modele.entite.propriete.*;

import java.awt.Polygon;
import java.awt.Point;
import java.awt.Dimension;

/**
 * Entite correspondant au joueur
 * @autor : Maximeuuu
 */
public class Vaisseau extends Entite implements IAttaque, IInteraction
{
	int degat;
	int velociteX;
	int velociteY;
	Polygon masque;

	Reservoir reservoir;

	//int distanceBase;

	Entite bouclier;

	public Vaisseau(  Point position, Dimension dimension, String image, int degat )
	{
		super( position, dimension, image );

		this.degat = degat;
		this.velociteX = 0;
		this.velociteY = 0;
		this.masque = OutilsImage.getPolygoneSimplifie( OutilsImage.getMasqueImage( super.getImage() ) );
	}

	public int getPuissanceAttaque(){ return this.degat; }
	public void setPuissanceAttaque( int degat ){ this.degat = degat; }

	public boolean estSelectionne( Point p ){ return masque.contains( p ); }



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
