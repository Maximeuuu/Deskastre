//probablement inutile
/*
package deskastre.modele.entite;

import java.awt.Polygon;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Masque
{
	private Polygon forme;
	private double posX;
	private double posY;
	
	public Masque( ImageIcon image, double x, double y )
	{
		this.forme = OutilsImage.getPolygoneSimplifie( OutilsImage.getMasqueImage(image, (int)(x), (int)(y)), 1.0 );
		this.posX = x;
		this.posY = y;
	}
	
	public void setLocation( double x, double y )
	{
		this.posX = x;
		this.posY = y;
		this.majPositionMasque( (int)(x), (int)(y) );
	}
	
	private void majPositionMasque( int x, int y )
	{
		 int deltaX = x - (int) this.posX;
    int deltaY = y - (int) this.posY;
    
    for (int i = 0; i < this.forme.npoints; i++) {
        this.forme.xpoints[i] += deltaX;
        this.forme.ypoints[i] += deltaY;
    }
		this.posX = x;
		this.posY = y;
		
		this.forme.invalidate(); //peut etre inutile
	}
	
	public boolean contains( Point p )
	{
		return this.forme.contains(p);
	}

}*/
