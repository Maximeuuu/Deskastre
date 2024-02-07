package deskastre.modele;

import deskastre.VariablesUtilisateur;
import deskastre.modele.entite.*;
import deskastre.modele.entite.propriete.*;
import deskastre.modele.joueur.*;
import deskastre.modele.outil.OutilsImage;
import deskastre.modele.parametre.*;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList; //listes thread-safe

import javax.swing.ImageIcon;

import java.awt.*;

/**
 * Classe principale qui genere une partie
 * @autor : Maximeuuu
 */
public class Jeu
{
	private List<AbstractEntite> ensEntite;
	private Joueur statsJoueur;
	private double tempsDebut;
	
	//TODO: à remplacer par le ParametresNiveau
	private ParametresAsteroide pa1;
	private ParametresAsteroide pa2;

	public Jeu()
	{
		this.tempsDebut = System.nanoTime();

		this.ensEntite = new CopyOnWriteArrayList<AbstractEntite>();

		this.statsJoueur = new Joueur();

		AbstractEntite entite;
		ImageIcon image;
		Polygon masque;

		/*entite = new Entite( new Point(0,0), new Dimension(1920,1080), "background/test-fond-galaxies.jpg" );
		this.ensEntite.add( entite );*/

		entite = new Statistique( new Point(20,20), this.statsJoueur );
		this.ensEntite.add( entite );

		image = OutilsImage.getResizeImage( new Dimension((int)(128*4*1.5),128*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_VAISSEAUX + "vaisseau_3_armed.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Vaisseau( new Point( (int)(Constantes.DIMENSIONS_JEU.getWidth())/2, (int)(Constantes.DIMENSIONS_JEU.getHeight())/2), image, masque , 5);
		this.ensEntite.add( entite );
		
		LectureParametresAsteroide lpa;
		lpa = new LectureParametresAsteroide("/data/configurations/asteroides/astV.xml");
		this.pa1 = lpa.getParametresAsteroide();
		
		lpa = new LectureParametresAsteroide("/data/configurations/asteroides/astH.xml");
		this.pa2 = lpa.getParametresAsteroide();
	}
	
	//TEST
	private void initialiserAsteroidesCoins()
	{
		ImageIcon image;
		Polygon masque;
		AbstractEntite entite;

		image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + "asteroide_5.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Asteroide( new Point(0,0), image, masque );
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );

		image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + "asteroide_5.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Asteroide( new Point(0,1080), image, masque );
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );

		image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + "asteroide_5.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Asteroide( new Point(1920,0), image, masque );
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );

		image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + "asteroide_5.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Asteroide( new Point(1920,1080), image, masque );
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );
	}

	//TEST
	private void initialiserAsteroidesPregeneres()
	{
		ImageIcon image;
		Polygon masque;
		AbstractEntite entite;

		image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + "asteroide_1.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Asteroide( new Point(800,100), image, masque );
		((Asteroide)entite).setVelocite(0,1);
		this.ensEntite.add( entite );

		image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + "asteroide_3.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Asteroide( new Point(-50,-50), image, masque );
		((Asteroide)entite).setVelocite(0.5,0.5);
		this.ensEntite.add( entite );

		image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + "asteroide_2.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Asteroide( new Point(900,120), image, masque );
		((Asteroide)entite).setVelocite(-0.8,0);
		this.ensEntite.add( entite );

		image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + "asteroide_5.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Asteroide( new Point(100,500), image, masque );
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );

		image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + "asteroide_5.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Asteroide( new Point(1200,800), image, masque );
		((Asteroide)entite).setVelocite(-0.5,-0.1);
		this.ensEntite.add( entite );

		image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + "asteroide_1.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Asteroide( new Point(0,0), image, masque );
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );

		image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + "asteroide_4.png" );
		masque = OutilsImage.getMasqueImage( image );
		entite = new Asteroide( new Point( (int)(Constantes.DIMENSIONS_JEU.getWidth())-200, (int)(Constantes.DIMENSIONS_JEU.getHeight())-200 ), image, masque );
		((Asteroide)entite).setVelocite(0,0);
		this.ensEntite.add( entite );
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
					
					if( indice < this.ensEntite.size() ) //important car les listes peuvent être modifiées en cours de route
						this.ensEntite.remove( indice );
				}
			}

			if( entite instanceof Statistique )
			{
				((Statistique)entite).majDimension();
			}
			
			if( entite instanceof Vaisseau )
			{
				double conso = 0.01;
				boolean aConsomme = ((Vaisseau)entite).reservoir.consommerCarburant( conso );
				
				if( aConsomme )
				{
					this.statsJoueur.majDistance();
					this.statsJoueur.majConsommation( -conso );
				}
			}
			
			indice++;
		}
		
		//TODO: à gérer plutot avec un parametreNiveau
		if( (int)(Math.random()*80) == 1 )
		{
			if( (int)(Math.random()*2) == 1 )
			{
				this.ensEntite.add( pa1.creerAsteroide() );
			}
			else
			{
				this.ensEntite.add( pa2.creerAsteroide() );
			}
		}
			
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
		
		if( entite instanceof Vaisseau )
		{
			int carburant = 1;
			System.out.println( "Vaisseau cliqué" );
			
			boolean aAjoute = ((Vaisseau)entite).reservoir.ajouterCarburant( carburant );
			if( aAjoute )
				this.statsJoueur.majConsommation( carburant );
		}
		
		return true;
	}

	//TODO: retourner l'entite directement ?
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
