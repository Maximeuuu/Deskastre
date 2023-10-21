import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class OutilsImage
{
	/* ancienne version
	public static Polygon getFigureImage( Image image, Point origine )
	{
		// Reset du polygone de l'image
		Polygon polygone = new Polygon();
		ImageIcon icone = new ImageIcon( image );
		image.flush();

		// Création d'une BufferedImage
		System.out.println( icone.getIconWidth() );
		System.out.println( icone.getIconHeight() );
		
		BufferedImage bImage = new BufferedImage(icone.getIconWidth(), icone.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D    bGr = bImage.createGraphics();

		System.out.println( bImage.getWidth() );
		System.out.println( bImage.getHeight() );

		bGr.drawImage(icone.getImage(), 0, 0, null);
		bGr.dispose();

		// On note tout les points sur les bords droit puis gauche
		for (int y = 0; y < bImage.getHeight(); y++)
		{
			for (int x = bImage.getWidth() - 1; x >= 0; x--)
			{
				if ( bImage.getRGB( (int)(origine.getX()), (int)(origine.getY()) ) != 0 )
				{
					System.out.println("point");
					polygone.addPoint( (int)(origine.getX() + x), (int)(origine.getY() + y) );
					break;
				}
			}
		}

		for (int y = bImage.getHeight() - 1; y >= 0; y--)
		{
			for (int x = 0; x < bImage.getWidth(); x++)
			{
				if ( bImage.getRGB( (int)(origine.getX()), (int)(origine.getY()) ) != 0 )
				{
					polygone.addPoint( (int)(origine.getX() + x), (int)(origine.getY() + y) );
					break;
				}
			}
		}

		System.out.println( "fin " );
		for( int i=0; i<polygone.npoints; i++)
		{
			System.out.println( polygone.xpoints[i] + " : "+ polygone.ypoints[i] );
		}
		return polygone;
	}*/
	
	
	public static Polygon getFigureImage( ImageIcon icone, Point origine )
	{
		// Reset du polygone de l'image
		Polygon polygone = new Polygon();

		// Création d'une BufferedImage
		BufferedImage bImage = new BufferedImage(icone.getIconWidth(), icone.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D    bGr = bImage.createGraphics();

		bGr.drawImage(icone.getImage(), 0, 0, null);
		bGr.dispose();

		// On note tout les points sur les bords droit puis gauche
		for (int y = 0; y < bImage.getHeight(); y++)
		{
			for (int x = bImage.getWidth() - 1; x >= 0; x--)
			{
				if ( bImage.getRGB( (int)(x), (int)(y) ) != 0 )
				{
					polygone.addPoint( (int)(origine.getX() + x), (int)(origine.getY() + y) );
					break;
				}
			}
		}

		for (int y = bImage.getHeight() - 1; y >= 0; y--)
		{
			for (int x = 0; x < bImage.getWidth(); x++)
			{
				if ( bImage.getRGB( (int)(x), (int)(y) ) != 0 )
				{
					polygone.addPoint( (int)(origine.getX() + x), (int)(origine.getY() + y) );
					break;
				}
			}
		}

		return polygone;
	}
}
