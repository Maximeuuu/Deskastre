package deskastre;

import deskastre.modele.entite.*;
import deskastre.vue.*;
import deskastre.modele.*;

import java.awt.Point;
import javax.swing.SwingUtilities;
import java.util.List;

//Timer
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe permettant la liaison entre le modele et la vue dans le modele MVC
 * @autor : Maximeuuu
 */
public class Controleur
{
	private Jeu metier;
	private FenetreJeu ihm;
	private Timer timer;

	public Controleur()
	{
		this.metier = new Jeu();
		this.ihm = new FenetreJeu( this );
		this.timer = new Timer();

		timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Réactualiser le modèle
				Controleur.this.metier.actualiser();

                // Réactualiser l'IHM
                Controleur.this.ihm.repaint();
            }
        }, 0, Constantes.TEMPS);
	}

	public List<AbstractEntite> getEnsEntite()
	{
		return this.metier.getEnsEntite();
	}

	public String getNomEntite( Point point )
	{
		return this.metier.getNomEntite( point );
	}

	public void zoneCliquee( Point point )
	{
		if( this.metier.zoneCliquee( point ) )
		{
			this.ihm.repaint();
		}
	}

	public boolean fenetreEstTransparente()
	{
		if( this.ihm == null ){ System.out.println("ihm null"); return false; } //je ne sais pas pourquoi il faut ça ; faudra essayer de le supprimer
		return this.ihm.estTransparente();
	}

	public static void main( String[] args )
	{
		SwingUtilities.invokeLater(() ->
		{
			new Controleur();
		});
	}
}
