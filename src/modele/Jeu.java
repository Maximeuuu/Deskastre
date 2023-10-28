package deskastre.modele;

import deskastre.modele.entite.*;
import deskastre.modele.joueur.*;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList; //listes thread-safe
import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Classe principale qui genere une partie
 * @autor : Maximeuuu
 */
public class Jeu
{
	private Dimension ecran;
	private List<AbstractEntite> ensEntite;
	private Statistique statsJoueur;

	public Jeu( Dimension ecran )
	{
		this.ecran = ecran;

		this.ensEntite = new CopyOnWriteArrayList<AbstractEntite>();

		this.statsJoueur = new Statistique( new Point(20,20) );
		this.ensEntite.add( statsJoueur );

		Entite entite;

		entite = new Vaisseau(  new Point( (int)(this.ecran.getWidth()-700)/2, (int)(this.ecran.getHeight()-500)/2) , new Dimension(700,500), "vaisseaux/vaisseau1.png", 5);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(800,100), new Dimension(250,250), "objets/asteroide.png");
		((Asteroide)entite).setVelocite(0,1);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(-50,-50), new Dimension(100,100), "objets/asteroide.png");
		((Asteroide)entite).setVelocite(0.5,0.5);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(900,120), new Dimension(100,100), "objets/asteroide.png");
		((Asteroide)entite).setVelocite(-0.8,0);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(100,500), new Dimension(100,100), "objets/asteroide.png");
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(1200,800), new Dimension(100,100), "objets/asteroide.png");
		((Asteroide)entite).setVelocite(-0.5,-0.1);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(0,0), new Dimension(200,200), "objets/asteroide.png");
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point( (int)(this.ecran.getWidth())-200, (int)(this.ecran.getHeight())-200 ), new Dimension(200,200), "objets/asteroide.png");
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );
	}

	public void actualiser()
	{
		for( AbstractEntite entite : this.ensEntite ) //penser à parcourir dans le sens inverse par la suite (parce que les images se superposent donc la dernière images doit être la première à pouvoir être selectionnée)
		{
			if( entite instanceof IDeplacable )
			{
				((IDeplacable)(entite)).avancer();
				//System.out.println( (Point2D)entite ); //DEBUG: afficher les coordonnees de chaque élements déplacés

				if( !this.entiteIsVisibleOnScreen( entite ) )
				{
					System.out.println("Destruction d'une entite");
					this.ensEntite.remove( entite );
				}
			}

			if( entite instanceof Statistique )
			{
				((Statistique)entite).majDimension();
			}
		}
		this.statsJoueur.majDistance();
	}

	public boolean entiteIsVisibleOnScreen( AbstractEntite entite )
	{
		Rectangle rectangleEcran = new Rectangle( this.ecran );
		return entite.estPlaceDans( rectangleEcran );
	}

	public List<AbstractEntite> getEnsEntite()
	{
		return this.ensEntite;
	}

	public boolean zoneCliquee( Point point )
	{
		AbstractEntite entite = this.getEntite( point );

		if( entite == null ){ System.out.println("entite null"); return false; }

		if( entite instanceof IDestructible )
		{
			((IDestructible)entite).perdrePv();

			if( ((IDestructible)entite).estDetruit() )
			{
				System.out.println("Destruction d'une entite");
				this.statsJoueur.asteroideDetruit();
				this.ensEntite.remove( entite );
			}
		}
		return true;
	}

	public AbstractEntite getEntite( Point point )
	{
		List<AbstractEntite> copieEnsEntite = new ArrayList<>(this.ensEntite);
		Collections.reverse( copieEnsEntite );

		//on parcourt dans le sens inverse pour que la premiere image selectionnee soit la derniere posee
		for( AbstractEntite entite : copieEnsEntite  )
		{
			if( entite instanceof IInteraction )
			{
				if( ((IInteraction)(entite)).estSelectionne( point ) )
				{
					return entite;
				}
			}
		}

		return null;
	}

	public String getNomEntite( Point point )
	{
		AbstractEntite entite = this.getEntite( point );
		if( entite == null ){ return ""; }
		else{ return entite.getClass().getName(); }
	}
}
