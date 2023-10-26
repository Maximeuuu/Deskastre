package deskastre;

import deskastre.modele.entite.*;
import deskastre.vue.*;
import deskastre.modele.*;
import deskastre.vue.ConfigurationInterface;

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
	//private ConfigurationInterface config;

	public Controleur()
	{
		ConfigurationInterface.initProprietes( ConfigurationInterface.ECRAN_PRINCIPAL );
		System.out.println( ConfigurationInterface.ecran() );
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

	/*public boolean fenetreEstTransparente()
	{
		return ConfigurationInterface.transparence();
	}

	public Dimension getDimensionEcran()
	{
		return ConfigurationInterface.ecran();
	}*/

	public static void main( String[] args )
	{
		SwingUtilities.invokeLater(() ->
		{
			new Controleur();
		});
	}
}
