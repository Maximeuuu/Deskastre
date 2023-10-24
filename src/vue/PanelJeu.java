package deskastre.vue;

import deskastre.Controleur;
import deskastre.modele.entite.Entite;
import deskastre.modele.entite.AbstractEntite;
import deskastre.modele.joueur.Statistique;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

/**
 * Panel principal de jeu
 * @autor : Maximeuuu
 */
public class PanelJeu extends JPanel implements MouseListener
{
	private Controleur ctrl;

	public PanelJeu( Controleur ctrl )
	{
		this.ctrl = ctrl;
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

		List<AbstractEntite> ensElement = this.ctrl.getEnsEntite();
		for( AbstractEntite element : ensElement )
		{
			if( element instanceof Statistique ) //problème : impossible d'afficher le texte ?
			{
				System.out.println( ((Statistique)element).toString() );
				g2.setColor(new Color(255, 255, 255)); // Arrière-plan semi-transparent
				g2.fillRect(0,0, 100, 100); // Dessine un rectangle d'arrière-plan
				g2.setColor(Color.BLACK); // Couleur du texte
				g2.drawString( ((Statistique)element).toString(), (int)element.getX(), (int)element.getY() );
			}

			if( element instanceof Entite )
			{
				g2.drawImage( ((Entite)(element)).getImage().getImage(), (int)element.getX(), (int)element.getY(), this );
			}
		}

		g2.dispose();
	}

	public void mousePressed(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{
		this.ctrl.zoneCliquee( e.getPoint() );
	}
}
