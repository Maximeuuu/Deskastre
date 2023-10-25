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

import java.awt.Graphics2D;


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
				//System.out.println( ((Statistique)element).toString() );
				if( this.ctrl.fenetreEstTransparente() )
				{ //TODO : les dimensions et positions du rectangle ne sont pas bonnes
					g2.setColor(new Color(225, 215, 236, 220));

					FontMetrics fontMetrics = g2.getFontMetrics(); // Obtenir les informations sur la police actuelle
					String text = new String(new char[(int)element.getDimension().getWidth()]).replace('\0', 'X'); // Créez une chaîne de caractères répétée numberOfCharacters fois
					int stringWidth = fontMetrics.stringWidth(text);

					g2.fillRect((int)element.getX(),(int)element.getY(), stringWidth, (int)element.getDimension().getHeight()*g2.getFontMetrics().getHeight()); // Dessine un rectangle d'arrière-plan
				}

				g2.setColor(new Color(255,255,255));
				PanelJeu.drawStatistique( ((Statistique)element), g2 );
			}

			if( element instanceof Entite )
			{
				g2.drawImage( ((Entite)(element)).getImage().getImage(), (int)element.getX(), (int)element.getY(), this );
			}
		}

		g2.dispose();
	}

	private static void drawStatistique( Statistique stat, Graphics2D g2 )
	{
		g2.setColor(Color.BLACK); // Couleur du texte
		String[] lignes = stat.toString().split("\n"); // Sépare la chaîne en lignes
		int y = (int)stat.getY()+g2.getFontMetrics().getHeight();
		for (String ligne : lignes)
		{
			g2.drawString(ligne, (int)stat.getX(), y);
			y += g2.getFontMetrics().getHeight(); // Incrémente la position Y pour la prochaine ligne
		}
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
