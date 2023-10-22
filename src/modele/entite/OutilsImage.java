package deskastre.modele.entite;

import deskastre.Constantes;

import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;

public final class OutilsImage
{
	public static ImageIcon getResizeImage( Dimension dimension, String image )
	{
		try
		{
    		BufferedImage imgOrigine = ImageIO.read(new File(Constantes.REP_IMAGE + image));
    		Image imgResize = imgOrigine.getScaledInstance((int) dimension.getWidth(), (int) dimension.getHeight(), Image.SCALE_SMOOTH);
    		return new ImageIcon(imgResize);
		}
		catch (IOException e)
		{
    		e.printStackTrace();
			return null;
		}
	}

	public static Polygon getMasqueImage( ImageIcon icone, Point origine )
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
