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
	public static final int ECRAN_PRINCIPAL = -1;

	private static int numEcran = ECRAN_PRINCIPAL;
	private static double dpi = 96.0;
	private static Dimension ecran = new Dimension(1920,1080);
	private static boolean transparence = false;

	/*par la suite :
	private ConfigurationInterface(){...}
	private static initConfiguration( if( this.instance == null : this.instance = new ConfigurationInterface(); return this.instacne(); ) )
	public majPropriete();
	*/

	public static void initProprietes( int numEcran )
	{
		GraphicsDevice gd;
		if( numEcran == ConfigurationInterface.ECRAN_PRINCIPAL ){ gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); }
		else{ gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[numEcran]; }

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		ConfigurationInterface.dpi = toolkit.getScreenResolution()/100;

        //double screenScaleFactor = toolkit.getScreenResolution() / ConfigurationInterface.dpi; // Récupère le facteur de mise à l'échelle de l'écran
        int screenWidth = (int) (toolkit.getScreenSize().getWidth() * ConfigurationInterface.dpi);
        int screenHeight = (int) (toolkit.getScreenSize().getHeight() * ConfigurationInterface.dpi);

		/*DisplayMode dm = gd.getDisplayMode();
		int screenWidth = dm.getWidth();
		int screenHeight = dm.getHeight();*/
		ConfigurationInterface.ecran.setSize( screenWidth, screenHeight );



		ConfigurationInterface.transparence = gd.getDefaultConfiguration().isTranslucencyCapable();
	}

	public static int numeroEcran(){ return ConfigurationInterface.numEcran; }
	public static Dimension ecran(){ return ConfigurationInterface.ecran; }
	public static boolean transparence(){ return ConfigurationInterface.transparence; }
}
