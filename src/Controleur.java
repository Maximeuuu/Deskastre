package deskastre;

import deskastre.modele.entite.*;
import deskastre.vue.*;
import deskastre.modele.*;
import deskastre.vue.ConfigurationInterface;

import java.awt.Point;
import java.awt.Dimension;
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
	private ConfigurationInterface config;
	private Jeu metier;
	private FenetreJeu ihm;
	private Timer timer;

	public Controleur()
	{
		this.config = new ConfigurationInterface();

		this.metier = new Jeu( this.config.getDimensionEcran() );
		this.ihm = new FenetreJeu( this );

		this.timer = new Timer();

		timer.schedule(new TimerTask() {
            @Override
            public void run() {
				// Réactualiser l'IHM
                Controleur.this.ihm.repaint();

                // Réactualiser le modèle
				Controleur.this.metier.actualiser();
            }
        }, 0, Constantes.TEMPS);

		/*double drawIntervale = 1_000_000_000/60;
		double nextDrawTime = System.nanoTime() + drawIntervale;
		while( true )
		{
			this.metier.actualiser();
			this.ihm.repaint();

			try
			{
				double remainingTime = nextDrawTime - System.nanoTime();
				if( remainingTime < 0 ){ remainingTime = 0; }
				Thread.sleep( (long)remainingTime/1_000_000 );
			}
			catch( Exception e ){}

			nextDrawTime += drawIntervale;
		}*/
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
		this.metier.zoneCliquee( point );
	}

	public boolean fenetreEstTransparente()
	{
		return this.config.getTransparence();
	}

	public Dimension getDimensionEcran()
	{
		return this.config.getDimensionEcran();
	}

	public static void main( String[] args )
	{
		SwingUtilities.invokeLater(() ->
		{
			new Controleur();
		});
	}
}
