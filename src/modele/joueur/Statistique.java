package deskastre.modele.joueur;

import deskastre.modele.entite.AbstractEntite;
import deskastre.Constantes;

import java.awt.Point;

/**
 * Statistiques sur la partie en cours
 * @autor : Maximeuuu
 */
public final class Statistique extends AbstractEntite
{
	private double distance;
	private double vitesse;
	private int carburant;
	private int asteroide;
	private int argent;

	public Statistique( Point position )
	{
		super( position, null );
		this.distance = 0.0;
		this.vitesse = 5;
		this.carburant = 20;
		this.asteroide = 0;
		this.argent = 0;
	}

	public void asteroideDetruit(){ this.asteroide++; }
	public void setVitesse( int vitesse ){ this.vitesse = vitesse; }

	public void majDistance()
	{
		double tempsEnSecondes = Constantes.TEMPS / 1000.0; // Conversion en secondes
    	this.distance += this.vitesse * tempsEnSecondes;
	} //par la suite sera surement faux

	public String toString()
	{
		String sRet = "Stats : \n" +
        	" - distance : " + String.format("%.2f m", this.distance) +
        	"\n - vitesse : " + String.format("%.2f m/s", this.vitesse) +
        	"\n - carburant : " + String.format("%d litres", this.carburant) +
        	"\n - metaux : " + String.format("%d asteroides", this.asteroide) +
        	"\n - argent : " + String.format("%d €", this.argent);

    	return sRet;
	}

}
