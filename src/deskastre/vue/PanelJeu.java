package deskastre.vue;

import deskastre.Controleur;
import deskastre.modele.entite.Entite;
import deskastre.modele.entite.AbstractEntite;
import deskastre.modele.entite.Statistique;

import java.util.List;

import javax.swing.*;
import javax.swing.text.html.parser.Element;

import java.awt.*;
import java.awt.event.*;

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
		this.addMouseListener( this );
		this.setDoubleBuffered(true);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		/* Mise à l'échelle automatique */
		g2.scale( this.ctrl.getEchelleUtilisateur(0), this.ctrl.getEchelleUtilisateur(1) );

		List<AbstractEntite> ensElement = this.ctrl.getEnsEntite();
		for( AbstractEntite element : ensElement )
		{
			if( element instanceof Statistique )
			{
				//System.out.println( ((Statistique)element).toString() );
				if( this.ctrl.transparenceFenetrePossible() )
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
				Entite entite = (Entite)element;
				ImageIcon imageIcon = entite.getImage();
				g2.drawImage( imageIcon.getImage(), PanelJeu.getCentreX(entite, imageIcon), PanelJeu.getCentreY(entite, imageIcon), this );
			}
		}

		g2.dispose();
	}

	private static int getCentreX( Entite entite, ImageIcon image )
	{
		return (int) (entite.getX() - image.getIconWidth()/2);
	}

	private static int getCentreY( Entite entite, ImageIcon image )
	{
		return (int) (entite.getY() - image.getIconHeight()/2);
	}

	private static void drawStatistique( Statistique stat, Graphics2D g2 )
	{
		g2.setColor(Color.BLACK); // Couleur du texte
		String[] lignes = stat.getInformations().split("\n"); // Sépare la chaîne en lignes
		int y = (int)stat.getY()+g2.getFontMetrics().getHeight();
		for (String ligne : lignes)
		{
			g2.drawString(ligne, (int)stat.getX(), y);
			y += g2.getFontMetrics().getHeight(); // Incrémente la position Y pour la prochaine ligne
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		//System.out.println(e.getPoint());
		double timedeb = System.nanoTime();
		Point point = e.getPoint();
		this.ctrl.zoneCliqueeJeu( new Point( (int)(point.getX()*1/this.ctrl.getEchelleUtilisateur(0)), (int)(point.getY()*1/this.ctrl.getEchelleUtilisateur(1)) ) );
		double timefin = System.nanoTime();
		System.out.println( timefin - timedeb);
	}
	@Override
	public void mouseExited(MouseEvent e){}
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseReleased(MouseEvent e){}
	@Override
	public void mouseClicked(MouseEvent e)
	{
		//mettre dans mousePressed ou mouseClicked
	}
}
