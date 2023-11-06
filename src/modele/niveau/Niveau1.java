package deskastre.modele.niveau;

import deskastre.VariablesUtilisateur;

public class Niveau1 extends AbstractNiveau
{
	public Niveau1()
	{
		super(0.001);
		super.setInformations("Niveau1", "Premier niveau du jeu");
		String[] ensImagesAsteroide = new String[]{"asteroide_0.png"}; //remplacer par juste un nom global ??
		super.setStyle( VariablesUtilisateur.REP_IMAGE+VariablesUtilisateur.REP_BACKGROUND+"test-fond-vide.png" );
	}


	public void setStyle( String background )
	{
		this.background = background;
		//this.ensImagesAsteroide = ensImagesAsteroide;
	}

	/*public void setPropriete( double[] ensProbaAsteroide )
	{
		this.ensProbaAsteroide = ensProbaAsteroide;
	}*/

	public void actualiser()
	{
	
	}
	
	public boolean estTermine()
	{
		return false;
	}
}
