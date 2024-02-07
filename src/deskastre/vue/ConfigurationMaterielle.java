package deskastre.vue;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

/**
 * Configuration de l'ecran utilisateur
 * @autor : Maximeuuu
 */
public final class ConfigurationMaterielle
{
	//ATTENTION : Constantes à changer avec connaissance de cause
	public static final int ECRAN_PRINCIPAL = -1;
	public static final int DPI_DEFAUT = 96; //DPI par défaut de Windows
	public static final Dimension RESOLUTION_DEFAUT = deskastre.modele.Constantes.DIMENSIONS_JEU;
	public static final boolean WINDOW_TRANSPARENCE = false; //Etat le plus sécurisé
	public static final double ECHELLE_DEFAUT = 1.0;

	private int numEcran;
	private double dpi;
	private Dimension ecran;
	private boolean transparence;
	private double[] echelle;

	/*//par la suite créer un usineur pour n'avoir qu'une instance...
	private static initConfiguration( if( this.instance == null : this.instance = new ConfigurationInterface(); return this.instacne(); ) )
	*/
	public ConfigurationMaterielle( int numEcran )
	{
		this.numEcran 		= numEcran;
		this.dpi 			= ConfigurationMaterielle.DPI_DEFAUT;
		this.ecran 			= new Dimension( ConfigurationMaterielle.RESOLUTION_DEFAUT );
		this.transparence 	= ConfigurationMaterielle.WINDOW_TRANSPARENCE;
		this.echelle        = new double[]{ConfigurationMaterielle.ECHELLE_DEFAUT, ConfigurationMaterielle.ECHELLE_DEFAUT};

		this.majProprietes();
	}

	public ConfigurationMaterielle()
	{
		this( ConfigurationMaterielle.ECRAN_PRINCIPAL );
	}

	/**
	 * Permet d'initialiser avec les configurations exactes de l'ordinateur
	 */
	public void majProprietes()
	{
		GraphicsDevice gd;

		//Récupération des propriétés de l'écran utilisé
		if( this.numEcran == ConfigurationMaterielle.ECRAN_PRINCIPAL ){ gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); }
		else{ gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[numEcran]; }

		//Capacité à creer des fenetres transparente par l'OS
		this.transparence = gd.getDefaultConfiguration().isTranslucencyCapable();

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		//Récupération du DPI (correspond à la "mise à l'échelle" dans Windows)
		System.out.println("dpi : " + toolkit.getScreenResolution());
		this.dpi = (double)toolkit.getScreenResolution(); // /ConfigurationMaterielle.DPI_DEFAUT;

		int screenWidthReel = (int)(toolkit.getScreenSize().getWidth());
        int screenHeightReel = (int)(toolkit.getScreenSize().getHeight());

		//adaptation des dimensions en fonction du DPI pour obtenir les dimensions correctes
        int screenWidthVirtuel = (int) (screenWidthReel * this.dpi/(double)(DPI_DEFAUT));
        int screenHeightVirtuel = (int) (screenHeightReel * this.dpi/(double)(DPI_DEFAUT));

		//affectation des nouvelles valeurs d'écran
		this.ecran.setSize( screenWidthVirtuel, screenHeightVirtuel );

		//mise à l'échelle
		this.echelle[0] = screenWidthReel / (double)RESOLUTION_DEFAUT.getWidth() ; //screenWidth / ((double)(ConfigurationMaterielle.RESOLUTION_DEFAUT.getWidth()) * this.dpi );
		this.echelle[1] = screenHeightReel / (double)RESOLUTION_DEFAUT.getHeight(); //screenHeight / ((double)(ConfigurationMaterielle.RESOLUTION_DEFAUT.getHeight()) * this.dpi );
	}

	public int getNumeroEcran(){ return this.numEcran; }
	public Dimension getDimensionEcran(){ return this.ecran; }
	public boolean getTransparence(){ return this.transparence; }
	public double[] getEchelle(){ return this.echelle; }

	public String toString()
	{
		String sRet = "propriétés : \n"+
			"\tEcran="+this.numEcran+"\n"+
			"\tDPI="+this.dpi+"\n"+
			"\tResolution="+this.ecran.getWidth()+"/"+this.ecran.getHeight()+"\n"+
			"\tTransparence="+this.transparence+"\n"+
			"\tEchelle="+this.echelle[0]+":"+this.echelle[1]+"\n";
		return sRet;
	}
}
