package deskastre.modele.niveau;

public class AbstractNiveau //TODO en cours de modifications !
{
	private String nom;
	private String description;
	private String background;

	private Integer dureeMinNiveau;
	private Integer dureeMaxNiveau;
	private int tempsEcouleNiveau;

	private Integer nbMaxAsteroideSimultane;
	private Integer nbMinAsteroideSimultane;
	private integer nbAsteroideActuel;






	private double probaActualisation;



	private String[] ensImagesAsteroide;

	private double[] ensProbaAsteroide;

	private int nbAsteroideActuel;
	private boolean active;
	private int nbAsteroideTotal;

	public AbstractNiveau( double probaActualisation )
	{
		this.probaActualisation = probaActualisation;
	}

	public void setInformations( String nom, String description )
	{
		this.nom = nom;
		this.description = description;
	}

	public void setStyle( String background, String[] ensImagesAsteroide )
	{
		this.background = background;
		this.ensImagesAsteroide = ensImagesAsteroide;
	}

	public void setPropriete( double[] ensProbaAsteroide )
	{
		this.ensProbaAsteroide = ensProbaAsteroide;
	}

	public void actualiser();
	public boolean estTermine();

}
