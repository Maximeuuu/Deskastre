package deskastre.modele.entite.regles;

import java.awt.Image;

/**
 * Classe principale pour les propriétés des entites
 * Correspond à un ensemble de règles qui définissent un certain type d'entite
 * @autor : Maximeuuu
 */
public abstract class AbstractRegles
{
	protected Image[] images;
	//private boolean attaquable; //controlable ...
	
	public AbstractRegles( Image[] images )
	{
		this.images = images;
	}
	
	public AbstractRegles( Image image )
	{
		this.images = new Image[1];
		this.images[0] = image;
	}
	
	public Image getImage()
	{
		int indice = (int)( Math.random() * images.length );
		return this.images[indice];
	}
	
	public String toString()
	{
		String s="{";
		
		for( int cptImage=0; cptImage<this.images.length; cptImage++ )
		{
			s+=this.images[cptImage];
			if( cptImage < this.images.length-1 ){ s+=", "; }
		}
		
		return s+"}";
	}
}

