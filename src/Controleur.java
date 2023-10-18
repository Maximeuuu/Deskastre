package deskastre;

//import deskastre.modele.*;
import deskastre.vue.*;

public class Controleur
{
	//private Jeu metier
	private Affichage ihm;

	public Controleur()
	{
		this.ihm = new Affichage();
	}

	public static void main( String[] args )
	{
		new Controleur();
	}
}
