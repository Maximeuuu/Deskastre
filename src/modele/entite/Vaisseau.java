package deskastre.modele.entite;

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

	Entite bouclier;

	public Vaisseau(  Point position, Dimension dimension, String image, int degat )
	{
		super( position, dimension, image );

		this.degat = degat;
		this.velociteX = 0;
		this.velociteY = 0;
		this.masque = OutilsImage.getPolygoneSimplifie( OutilsImage.getMasqueImage( super.getImage() ), 1.0 );
	}

	public int getPuissanceAttaque(){ return this.degat; }
	public void setPuissanceAttaque( int degat ){ this.degat = degat; }

	public boolean estSelectionne( Point p ){ return masque.contains( p ); }
}
