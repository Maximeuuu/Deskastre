package deskastre.modele;

import java.awt.Dimension;

/**
 * Classe utilitaire contenant les constantes du projet
 * Constantes à ne pas modifier
 * @autor : Maximeuuu
 */
public abstract class Constantes
{
	public static final String REP_IMAGE = "./../lib/images/"; //à deplacer dans un fichier VariableUtilisateur
	//repAsteroide //repVaisseau...

	public static final Dimension DIMENSIONS_JEU = new Dimension(1920,1080);
	public static final int TEMPS = 16; //nb pixel en fonction des FPS - a modifier niveau calcul
	public static final int FPS = 60;
}
