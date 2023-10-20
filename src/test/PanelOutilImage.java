
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class PanelOutilImage extends JPanel implements MouseListener
{
	private ImageIcon image1;
	private ImageIcon image2;
	private Polygon p1;
	private Polygon p2;

	public PanelOutilImage()
	{
		/*this.image1 = getToolkit().getImage( Affichage.REP_IMAGES+"vaisseaux/"+"vaisseau1.png" );
		this.image2 = getToolkit().getImage( Affichage.REP_IMAGES+"objets/"+"asteroide.png" );
		
		this.p1 = OutilsImage.getFigureImage( this.image1, new Point(10,10) );
		this.p2 = OutilsImage.getFigureImage( this.image2, new Point(300,300) );*/
		
		this.image1 = new ImageIcon( Affichage.REP_IMAGES+"vaisseaux/"+"vaisseau1.png" );
		this.image2 = new ImageIcon( Affichage.REP_IMAGES+"objets/"+"asteroide.png" );
		
		this.p1 = OutilsImage.getFigureImage( this.image1, new Point(10,10) );
		this.p2 = OutilsImage.getFigureImage( this.image2, new Point(300,300) );
	
		this.setBackground( new Color(0,0,0,0) );
		this.repaint();
		this.addMouseListener( this );
		this.setDoubleBuffered(true);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		
		
		g2.drawImage( this.image1.getImage(), 10,10, this);
		g2.drawImage( this.image2.getImage(), 300,300, this);


		g2.dispose();
	}

	public void mousePressed(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{
		System.out.println( "clic" );
		System.out.println( e.getPoint() );
		if( this.p1.contains( e.getPoint() ) )
		{
			System.out.println("vaisseau1");
		}
		
		if( this.p2.contains( e.getPoint() ) )
		{
			System.out.println("asteroide");
		}
	}
}
