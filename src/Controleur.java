package deskastre;

import deskastre.modele.entite.*;
import deskastre.vue.*;
import deskastre.modele.*;

import java.awt.Point;
import java.util.List;

public class Controleur
{
	private Jeu metier;
	private FenetreJeu ihm;

	public Controleur()
	{
		this.metier = new Jeu();
		this.ihm = new FenetreJeu( this );
	}

	public List<Entite> getEnsEntite()
	{
		return this.metier.getEnsEntite();
	}

	public String getNomEntite( Point point )
	{
		return this.metier.getNomEntite( point );
	}

	public static void main( String[] args )
	{
		new Controleur();
	}
}
