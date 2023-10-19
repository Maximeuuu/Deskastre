
import java.util.List;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Affichage
{
	public static final String REP_IMAGES = "./../../lib/images/";

	//dimensions en % -> mettre ces valeurs dans des objets adaptés dans "modele"
	public static final int LONGUEUR_INTERRACTION = 20;
	public static final int LONGUEUR_ASTEROIDE    = 5;
	public static final int HAUTEUR_ASTEROIDE     = 5;
	public static final int LONGUEUR_INFORMATION  = 10;
	public static final int HAUTEUR_INFORMATION   = 10;

	public static final Dimension DIM_ECRAN = Toolkit.getDefaultToolkit().getScreenSize();;

	private FenetreTransparente vaisseau;
	private FenetreTransparente interraction;
	private List<FenetreTransparente> ensAsteroide;
	private FenetreTransparente information;

	public Affichage()
	{
		this.vaisseau = new FenetreVaisseau();

		//Créer une méthode private pour initialiser les fenetes

		/*larg = LONGUEUR_VAISSEAU * DIM_ECRAN.width / 100;
		haut = HAUTEUR_VAISSEAU * DIM_ECRAN.width / 100;
		posX = (DIM_ECRAN.width-larg)/2;
		posY = (DIM_ECRAN.height-haut)/2;
		this.vaisseau = new FenetreTransparente( new PanelImage( "Vaisseau" ), posX, posY, larg, haut );

		//this.interraction = new FenetreTransparente( panelAsupr, posX, posY, larg, haut );

		larg = LONGUEUR_ASTEROIDE * DIM_ECRAN.width / 100;
		haut = HAUTEUR_ASTEROIDE * DIM_ECRAN.width / 100;
		posX = DIM_ECRAN.width-larg;
		posY = 0;
		this.ensAsteroide = new ArrayList<FenetreTransparente>();
		this.ensAsteroide.add( new FenetreTransparente( null, posX, posY, larg, haut ) );

		larg = LONGUEUR_INFORMATION * DIM_ECRAN.width / 100;
		haut = HAUTEUR_INFORMATION * DIM_ECRAN.width / 100;
		posX = 0;
		posY = 0;
		this.information = new FenetreTransparente( null, posX, posY, larg, haut );*/
	}
}
