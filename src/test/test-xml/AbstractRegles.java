import java.awt.Image;

/**
 * Classe principale pour les propriétés des entites
 * Correspond à un ensemble de règles qui définissent un certain type d'entite
 * @autor : Maximeuuu
 */
public abstract class AbstractRegles
{
	protected String[] images;
	//private boolean attaquable; //controlable ...
	
	public AbstractRegles( String[] images )
	{
		this.images = images;
	}
	
	public AbstractRegles( String image )
	{
		this.images = new String[1];
		this.images[0] = image;
	}
	
	public String getImage()
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

