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
public abstract class ConfigurationInterface
{
	//ATTENTION : Constantes à changer avec connaissance de cause
	public static final int ECRAN_PRINCIPAL = -1;
	public static final int DPI_DEFAUT = 96; //DPI par défaut de Windows
	public static final Dimension RESOLUTION_DEFAUT = new Dimension(1920,1080); //Dimension choisie pour le jeu
	public static final boolean WINDOW_TRANSPARENCE = false; //Etat le plus sécurisé

	private static int numEcran = ECRAN_PRINCIPAL;
	private static double dpi = DPI_DEFAUT;
	private static Dimension ecran = RESOLUTION_DEFAUT;
	private static boolean transparence = WINDOW_TRANSPARENCE;

	/*par la suite peut êter créer une classe instanciable :
	private ConfigurationInterface(){...}
	private static initConfiguration( if( this.instance == null : this.instance = new ConfigurationInterface(); return this.instacne(); ) )
	public majPropriete();
	*/

	/**
	 * Permet d'initialiser avec les configurations exactes de l'ordinateur
	 */
	public static void initProprietes( int numEcran )
	{
		GraphicsDevice gd;

		//Récupération des propriétés de l'écran utilisé
		if( numEcran == ConfigurationInterface.ECRAN_PRINCIPAL ){ gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); }
		else{ gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[numEcran]; }

		//Capacité à creer des fenetres transparente par l'OS
		ConfigurationInterface.transparence = gd.getDefaultConfiguration().isTranslucencyCapable();

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		//Récupération du DPI (correspond à la "mise à l'échelle" dans Windows)
		ConfigurationInterface.dpi = toolkit.getScreenResolution()/ConfigurationInterface.DPI_DEFAUT;

		//adaptation des dimensiosn en fonction du DPI
        int screenWidth = (int) (toolkit.getScreenSize().getWidth() * ConfigurationInterface.dpi);
        int screenHeight = (int) (toolkit.getScreenSize().getHeight() * ConfigurationInterface.dpi);

		//affectation des nouvelles valeurs d'écran
		ConfigurationInterface.ecran.setSize( screenWidth, screenHeight );
	}

	public static int numeroEcran(){ return ConfigurationInterface.numEcran; }
	public static Dimension ecran(){ return ConfigurationInterface.ecran; }
	public static boolean transparence(){ return ConfigurationInterface.transparence; }
}
