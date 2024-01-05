package deskastre.modele.entite;

import java.awt.geom.Point2D;
import java.awt.Dimension;
import java.awt.Shape;

/**
 * Classe principale pour une entite du jeu
 * L'utilisation de Point2D.Double est très importante, elle permet une meilleure fluidité pour l'affichage et ne pas avoir de problèmes avec les coordonnées en double (exemple : point qui se bloquait en 0,0)
 * Remplacer Point2D.Double par un Point reviendrait à devoir changer tout le code au niveau des positions
 * @autor : Maximeuuu
 */
public abstract class AbstractEntite extends Point2D.Double
{
	private Dimension dimension;
	private boolean visibilite;

	public AbstractEntite( Point2D position, Dimension dimension )
	{
		super( position.getX(), position.getY() );
		this.dimension = dimension;
		this.visibilite = true;
	}

	public boolean estPlaceDans( Shape figure )
	{
		boolean contientOrigine = (figure.contains( super.getX(), super.getY() )                                                      );
		boolean contientObjet   = (figure.contains( super.getX()+this.dimension.getWidth(), super.getY()+this.dimension.getHeight() ) );
		return (contientOrigine || contientObjet);
	}

	public void setVisibilite( boolean visibilite ){ this.visibilite = visibilite; }
	public boolean getVisibilite(){ return this.visibilite; }

	public Dimension getDimension(){ return this.dimension; }
	public void setDimension( Dimension dimension ){ this.dimension = dimension; }

	/*@Override //important -> par la suite enlever le "extends Points2D" pcq ça fait n'imp peut etre ??? -> pb vient des listes et equals
	public boolean equals( Object o ){ return false; }*/
}
