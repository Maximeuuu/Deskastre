package deskastre.modele;

import deskastre.modele.entite.*;
import deskastre.modele.entite.propriete.*;
import deskastre.modele.joueur.*;
import deskastre.modele.Constantes;

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
	private List<AbstractEntite> ensEntite;
	private Joueur statsJoueur;
	private double tempsDebut;

	public Jeu()
	{
		this.tempsDebut = System.nanoTime();

		this.ensEntite = new CopyOnWriteArrayList<AbstractEntite>();

		this.statsJoueur = new Joueur();

		AbstractEntite entite;

		/*entite = new Entite( new Point(0,0), new Dimension(1920,1080), "background/test-fond-vide.png" );
		this.ensEntite.add( entite );*/

		entite = new Statistique( new Point(20,20), this.statsJoueur );
		this.ensEntite.add( entite );

		entite = new Vaisseau(  new Point( (int)(Constantes.DIMENSIONS_JEU.getWidth()-700)/2, (int)(Constantes.DIMENSIONS_JEU.getHeight()-500)/2) , new Dimension(700,500), "vaisseaux/vaisseau1.png", 5);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(800,100), new Dimension(70*4,70*4), "objets/asteroide_4.png"); //480/270   70/70
		((Asteroide)entite).setVelocite(0,1);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(-50,-50), new Dimension(70*4,70*4), "objets/asteroide_2.png");
		((Asteroide)entite).setVelocite(0.5,0.5);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(900,120), new Dimension(70*4,70*4), "objets/asteroide_3.png");
		((Asteroide)entite).setVelocite(-0.8,0);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(100,500), new Dimension(70*4,70*4), "objets/asteroide_0.png");
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(1200,800), new Dimension(70*4,70*4), "objets/asteroide_0.png");
		((Asteroide)entite).setVelocite(-0.5,-0.1);
		this.ensEntite.add( entite );

		entite = new Asteroide( new Point(0,0), new Dimension(70*4,70*4), "objets/asteroide_4.png");
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );

		System.out.println( new Point2D.Double(0,0) == new Point2D.Double(0,0) );
		System.out.println( (new Point2D.Double(0,0)).equals(new Point2D.Double(0,0)) );
		System.out.println( new Joueur().hashCode() );

		entite = new Asteroide( new Point( (int)(Constantes.DIMENSIONS_JEU.getWidth())-200, (int)(Constantes.DIMENSIONS_JEU.getHeight())-200 ), new Dimension(70*4,70*4), "objets/asteroide_1.png");
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );

		/*entite = new Asteroide( new Point(800,100), new Dimension(250,250), "objets/asteroide.png");
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

		entite = new Asteroide( new Point( (int)(Constantes.DIMENSIONS_JEU.getWidth())-200, (int)(Constantes.DIMENSIONS_JEU.getHeight())-200 ), new Dimension(200,200), "objets/asteroide.png");
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );*/
	}

	public void actualiser()
	{
		int indice = 0;
		for( AbstractEntite entite : this.ensEntite )
		{
			if( entite instanceof IDeplacable )
			{
				((IDeplacable)(entite)).avancer();
				//System.out.println( (Point2D)entite ); //DEBUG: afficher les coordonnees de chaque élements déplacés

				if( !this.entiteIsVisibleOnScreen( entite ) )
				{
					double timefin = System.nanoTime();
					System.out.println("Destruction d'une entite à "+(timefin - this.tempsDebut)/1_000_000_000.0);
					this.ensEntite.remove( indice );
				}
			}

			if( entite instanceof Statistique )
			{
				((Statistique)entite).majDimension();
			}
			indice++;
		}
		this.statsJoueur.majDistance();
	}

	public boolean entiteIsVisibleOnScreen( AbstractEntite entite )
	{
		Rectangle rectangleEcran = new Rectangle( Constantes.DIMENSIONS_JEU );
		return entite.estPlaceDans( rectangleEcran );
	}

	public List<AbstractEntite> getEnsEntite()
	{
		return this.ensEntite;
	}

	public boolean zoneCliquee( Point point )
	{
		int indice = this.getIndiceEntite( point );
		if( indice == -1 ){ System.out.println("entite null"); return false; }

		AbstractEntite entite = this.ensEntite.get( indice );
		if( entite instanceof IDestructible )
		{
			((IDestructible)entite).perdrePv();

			if( ((IDestructible)entite).estDetruit() )
			{
				System.out.println("Destruction d'une entite " + entite.toString() );
				this.statsJoueur.asteroideDetruit();
				this.ensEntite.remove( indice );
			}
		}
		return true;
	}

	public int getIndiceEntite( Point point )
	{
		List<AbstractEntite> copieEnsEntite = new ArrayList<>(this.ensEntite);
		Collections.reverse( copieEnsEntite ); // -> pb ?

		//on parcourt dans le sens inverse pour que la premiere image selectionnee soit la derniere posee
		int indice=copieEnsEntite.size()-1;
		for( AbstractEntite entite : copieEnsEntite  )
		{
			if( entite instanceof IInteraction )
			{
				if( ((IInteraction)(entite)).estSelectionne( point ) )
				{
					return indice;
				}
			}
			indice--;
		}

		return -1;
	}

	/**
	 * Méthode à utiliser avec parcimonie car affecter une liste par rapport à cet entite n'est pas possible
	 **/
	public AbstractEntite getEntite( Point point )
	{
		return this.ensEntite.get( this.getIndiceEntite( point ) );
	}

	public String getNomEntite( Point point )
	{
		AbstractEntite entite = this.getEntite( point );
		if( entite == null ){ return ""; }
		else{ return entite.getClass().getName(); }
	}
}
