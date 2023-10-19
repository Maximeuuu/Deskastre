import java.awt.Frame;
import javax.swing.OverlayLayout;

public class FenetreVaisseau extends FenetreTransparente
{
	//private Vaisseau modele;

	public static final int LONGUEUR_VAISSEAU     = 50;
	public static final int HAUTEUR_VAISSEAU      = 20;

	public FenetreVaisseau( /*Vaisseau modele*/ )
	{
		/*//this.modele = modele;
		String image = Affichage.REP_IMAGES+"Vaisseau"+".png";

		int larg, haut, posX, posY;

		larg = LONGUEUR_VAISSEAU * Affichage.DIM_ECRAN.width / 100;
		haut = HAUTEUR_VAISSEAU * Affichage.DIM_ECRAN.width / 100;
		posX = (Affichage.DIM_ECRAN.width-larg)/2;
		posY = (Affichage.DIM_ECRAN.height-haut)/2;

		super( new PanelImage(image), posX, posY, larg, haut);*/

		super
		(
			new PanelImage( Affichage.REP_IMAGES+"vaisseaux/"+"vaisseau1.png" ),
			(Affichage.DIM_ECRAN.width-LONGUEUR_VAISSEAU * Affichage.DIM_ECRAN.width / 100)/2,
			(Affichage.DIM_ECRAN.height-HAUTEUR_VAISSEAU * Affichage.DIM_ECRAN.width / 100)/2,
			LONGUEUR_VAISSEAU * Affichage.DIM_ECRAN.width / 100,
			HAUTEUR_VAISSEAU * Affichage.DIM_ECRAN.width / 100
		);
		
		this.setLayout( new OverlayLayout(this.getContentPane()) );
		this.add( new PanelImage( Affichage.REP_IMAGES+"vaisseaux/"+"vaisseau1.png" ) );
		this.add( new PanelImage( Affichage.REP_IMAGES+"objets"+"asteroide.png" ) );
	}
}
