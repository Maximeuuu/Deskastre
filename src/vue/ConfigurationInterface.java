package deskastre.vue;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.DisplayMode;
import java.awt.Toolkit;

/**
 * Configuration de l'interface
 * @autor : Maximeuuu
 */
public final class ConfigurationInterface
{
	//ATTENTION : Constantes à changer avec connaissance de cause
	public static final int ECRAN_PRINCIPAL = -1;
	public static final int DPI_DEFAUT = 96; //DPI par défaut de Windows
	public static final Dimension RESOLUTION_DEFAUT = new Dimension(1920,1080); //Dimension choisie pour le jeu
	public static final boolean WINDOW_TRANSPARENCE = false; //Etat le plus sécurisé

	private int numEcran;
	private double dpi;
	private Dimension ecran;
	private boolean transparence;

	/*//par la suite créer un usineur pour n'avoir qu'une instance...
	private static initConfiguration( if( this.instance == null : this.instance = new ConfigurationInterface(); return this.instacne(); ) )
	*/
	public ConfigurationInterface( int numEcran )
	{
		this.numEcran 		= numEcran;
		this.dpi 			= ConfigurationInterface.DPI_DEFAUT;
		this.ecran 			= ConfigurationInterface.RESOLUTION_DEFAUT;
		this.transparence 	= ConfigurationInterface.WINDOW_TRANSPARENCE;

		this.majProprietes();
	}

	public ConfigurationInterface()
	{
		this( ConfigurationInterface.ECRAN_PRINCIPAL );
	}

	/**
	 * Permet d'initialiser avec les configurations exactes de l'ordinateur
	 */
	public void majProprietes()
	{
		GraphicsDevice gd;

		//Récupération des propriétés de l'écran utilisé
		if( this.numEcran == ConfigurationInterface.ECRAN_PRINCIPAL ){ gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); }
		else{ gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[numEcran]; }

		//Capacité à creer des fenetres transparente par l'OS
		this.transparence = gd.getDefaultConfiguration().isTranslucencyCapable();

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		//Récupération du DPI (correspond à la "mise à l'échelle" dans Windows)
		this.dpi = toolkit.getScreenResolution()/ConfigurationInterface.DPI_DEFAUT;

		//adaptation des dimensiosn en fonction du DPI
        int screenWidth = (int) (toolkit.getScreenSize().getWidth() * this.dpi);
        int screenHeight = (int) (toolkit.getScreenSize().getHeight() * this.dpi);

		//affectation des nouvelles valeurs d'écran
		this.ecran.setSize( screenWidth, screenHeight );
	}

	public int getNumeroEcran(){ return this.numEcran; }
	public Dimension getDimensionEcran(){ return this.ecran; }
	public boolean getTransparence(){ return this.transparence; }
}
