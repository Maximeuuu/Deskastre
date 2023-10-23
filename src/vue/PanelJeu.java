package deskastre.vue;

import deskastre.Controleur;
import deskastre.modele.entite.Entite;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class PanelJeu extends JPanel implements MouseListener
{
	/*private ImageIcon image1;
	private ImageIcon image2;
	private Polygon p1;
	private Polygon p2;*/
	private Controleur ctrl;

	public PanelJeu( Controleur ctrl )
	{
		this.ctrl = ctrl;
		/*this.image1 = new ImageIcon( Affichage.REP_IMAGES+"vaisseaux/"+"vaisseau1.png" );
		this.image2 = new ImageIcon( Affichage.REP_IMAGES+"objets/"+"asteroide.png" );

		this.p1 = OutilsImage.getFigureImage( this.image1, new Point(10,10) );
		this.p2 = OutilsImage.getFigureImage( this.image2, new Point(300,300) );*/

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

		List<Entite> ensEntite = this.ctrl.getEnsEntite();
		for( Entite entite : ensEntite )
		{
			g2.drawImage( entite.getImage().getImage(), (int)entite.getX(), (int)entite.getY(), this );
		}

		/*g2.drawImage( this.image1.getImage(), 10,10, this);
		g2.drawImage( this.image2.getImage(), 300,300, this);*/

		//System.out.println("repaintG2 " + ensEntite.size() );

		g2.dispose();
	}

	public void mousePressed(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{
		System.out.println( "clic" );
		
		this.ctrl.zoneCliquee( e.getPoint() );
	}
}
