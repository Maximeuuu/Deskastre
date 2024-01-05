package deskastre.modele.niveau;

import deskastre.modele.entite.regles.*;

import java.util.List;
import java.awt.Image;

public abstract class AbstractNiveau //TODO en cours de création
{
	protected String nom;
	protected String description;
	protected String background;

	protected Integer dureeMinNiveau;
	protected Integer dureeMaxNiveau;
	protected int tempsEcouleNiveau;

	protected Integer nbMaxAsteroideSimultane;
	protected Integer nbMinAsteroideSimultane;
	protected Integer nbAsteroideActuel;

	protected List<AbstractRegles> ensRegles; //jsp
	protected List<Image> ensImage; // images générée une fois à réutiliser pour chaque entites
	
	protected double probaActualisation; //proba de passer à un niveau suivant (?)


/* // anciens attributs à remplacer par ceux au dessus
	private String[] ensImagesAsteroide;

	private double[] ensProbaAsteroide;

	private int nbAsteroideActuel;
	private boolean active;
	private int nbAsteroideTotal;*/
	
	public void addRegle( AbstractRegles regle ){ this.ensRegles.add( regle ); }

	public AbstractNiveau( double probaActualisation )
	{
		this.probaActualisation = probaActualisation;
	}

	public void setInformations( String nom, String description )
	{
		this.nom = nom;
		this.description = description;
	}

	public void setStyle( String background )
	{
		this.background = background;
	}

	/*public void setPropriete( double[] ensProbaAsteroide )
	{
		this.ensProbaAsteroide = ensProbaAsteroide;
	}*/

	public abstract void actualiser();
	public abstract boolean estTermine();

}
