package deskastre.modele;

import deskastre.modele.entite.*;

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
	private List<Entite> ensEntite;

	public Jeu()
	{
		this.ensEntite = new CopyOnWriteArrayList<Entite>();

		Point pTest = new Point(0,0);
		System.out.println( pTest );
		pTest.translate(-50,-50);
		System.out.println( pTest );

		Entite entite = new Vaisseau( new Point(100,100), new Dimension(700,500), "vaisseaux/vaisseau1.png", 5);
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
	}

	public void actualiser()
	{
		for( Entite entite : this.ensEntite ) //penser à parcourir dans le sens inverse par la suite (parce que les images se superposent donc la dernière images doit être la première à pouvoir être selectionnée)
		{
			if( entite instanceof IDeplacable )
			{
				((IDeplacable)(entite)).avancer();
				System.out.println( (Point2D)entite );

				if( !entite.isVisibleOnScreen( new Dimension(1920,1080) ) )
				{
					System.out.println("Destruction d'une entite");
					this.ensEntite.remove( entite );
				}
			}
		}
	}

	public List<Entite> getEnsEntite()
	{
		return this.ensEntite;
	}

	public boolean zoneCliquee( Point point )
	{
		Entite entite = this.getEntite( point );

		if( entite == null ){ System.out.println("entite null"); return false; }

		if( entite instanceof IDestructible )
		{
			((IDestructible)entite).perdrePv();

			if( ((IDestructible)entite).estDetruit() )
			{
				System.out.println("Destruction d'une entite");
				this.ensEntite.remove( entite );
			}
		}
		return true;
	}

	public Entite getEntite( Point point )
	{
		List<Entite> copieEnsEntite = new ArrayList<>(this.ensEntite);
		Collections.reverse( copieEnsEntite );

		//on parcourt dans le sens inverse pour que la premiere image selectionnee soit la derniere posee
		for( Entite entite : copieEnsEntite  )
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
		Entite entite = this.getEntite( point );
		if( entite == null ){ return ""; }
		else{ return entite.getClass().getName(); }
	}
}
