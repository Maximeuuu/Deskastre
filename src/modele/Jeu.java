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

		Entite entite = new Vaisseau( new Point(100,100), new Dimension(500,500), "vaisseaux/vaisseau1.png", 5);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(400,100), new Dimension(250,250), "objets/asteroide.png");
		this.ensEntite.add( entite );
	}

	public List<Entite> getEnsEntite()
	{
		return this.ensEntite;
	}

	public String getNomEntite( Point point )
	{
		for( Entite entite : this.ensEntite ) //penser à parcourir dans le sens inverse par la suite (parce que les images se superposent donc la dernière images doit être la première à pouvoir être selectionnée)
		{
			if( entite instanceof IInteraction )
			{
				if( ((IInteraction)(entite)).estSelectionne( point ) )
				{
					return entite.getClass().getName();
				}
			}
		}
		return null;
	}
}
