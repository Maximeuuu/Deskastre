package deskastre.modele.entite;

import java.awt.Polygon;
import java.awt.Point;

public class Vaisseau extends Entite implements IAttaque, IDeplacable, IInteraction
{
	int degat;
	int velociteX;
	int velociteY;
	Polygon masque;

	Entite bouclier;

	public Vaisseau()
	{

	}

	public int getPuissanceAttaque(){ return this.degat; }
	public void setPuissanceAttaque( int degat ){ this.degat = degat; }

	public int getVelociteX(){ return this.velociteX; }
	public int getVelociteY(){ return this.velociteY; }
	public void arreter(){ this.velociteX=0; this.velociteY=0; }
	public void deplacer( int x, int y ){ super.x = x; super.y = y; }

	public boolean estSelectionne( Point p ){ return masque.contains( p ); }



}
