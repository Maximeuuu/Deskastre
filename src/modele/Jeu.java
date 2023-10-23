package deskastre.modele;

import deskastre.modele.entite.*;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class Jeu
{
	private List<Entite> ensEntite;

	public Jeu()
	{
		this.ensEntite = new ArrayList<Entite>();

		Entite entite = new Vaisseau( new Point(100,100), new Dimension(700,500), "vaisseaux/vaisseau1.png", 5);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(800,100), new Dimension(250,250), "objets/asteroide.png");
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(900,120), new Dimension(100,100), "objets/asteroide.png");
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(1200,800), new Dimension(100,100), "objets/asteroide.png");
		this.ensEntite.add( entite );
	}
	
	public void actualiser()
	{
		for( Entite entite : this.ensEntite ) //penser à parcourir dans le sens inverse par la suite (parce que les images se superposent donc la dernière images doit être la première à pouvoir être selectionnée)
		{
			if( entite instanceof IDeplacable )
			{
				((IDeplacable)(entite)).deplacer( (int)(entite.getX()-10), (int)(entite.getY()) );
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
		
		if( entite == null ){ return false; }
		
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
		for( Entite entite : this.ensEntite ) //penser à parcourir dans le sens inverse par la suite (parce que les images se superposent donc la dernière images doit être la première à pouvoir être selectionnée)
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
