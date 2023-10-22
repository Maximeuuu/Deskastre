package deskastre.modele.entite;

import java.awt.Point;
import java.awt.Dimension;

public abstract class AbstractEntite extends Point
{
	private Dimension dimension;
	private boolean visibilite;

	public AbstractEntite( Point position, Dimension dimension )
	{
		super( position );
		this.dimension = dimension;
		this.visibilite = true;
	}

	public void setVisibilite( boolean visibilite ){ this.visibilite = visibilite; }
	public boolean getVisibilite(){ return this.visibilite; }

	public Dimension getDimension(){ return this.dimension; }
	public void setDimension( Dimension dimension ){ this.dimension = dimension; }
}
