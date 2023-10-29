package deskastre.modele.entite;

import deskastre.modele.entite.AbstractEntite;
import deskastre.modele.joueur.IInformation;
import deskastre.modele.joueur.Joueur;

import java.awt.Point;
import java.awt.Dimension;

/**
 * Entite permettant d'afficher des informations
 * @autor : Maximeuuu
 */
public final class Statistique extends AbstractEntite
{
	private IInformation info;

	public Statistique( Point position, IInformation info )
	{
		super( position, new Dimension(0,0) );
		this.info = info;
	}

	public void majDimension() //ajouter des paramètres : TailleCaractere, adapter majDimension() et adapter PanelJeu.paintComponent()
	{
		int maxWidth=0;
		int maxHeigth=0;

		String[] lignes = this.info.toString().split("\n");
		for( String ligne : lignes )
		{
			if( ligne.length() > maxWidth ){ maxWidth = ligne.length(); }
			maxHeigth++;
		}

		super.setDimension( new Dimension(maxWidth, maxHeigth) );
	}

}
