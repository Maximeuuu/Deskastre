package deskastre.modele.parametre;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.Polygon;

import deskastre.modele.entite.Asteroide;
import deskastre.modele.outil.Range;
import deskastre.modele.outil.OutilsImage;
import deskastre.VariablesUtilisateur;

/**
 * Classe principale pour les propriétés des entites
 * Correspond à un ensemble de règles qui définissent un certain type d'entite
 * @autor : Maximeuuu
 */
public class ParametresAsteroide
{
	//images
	private List<String> ensNomImage;

	//repartition
	private Range rangePosX;
	private Range rangePosY;
	private Range rangeVx;
	private Range rangeVy;
	private Range rangePv;
	private Range rangeLoot;

	public Asteroide creerAsteroide()
	{
		Point position = new Point( (int)this.rangePosX.genererValeur(), (int)this.rangePosY.genererValeur() );
		Dimension dimension = new Dimension(70*4,70*4);
		
		//FIXME: mettre un tirage aléatoire de l'indice de l'image
		ImageIcon image = OutilsImage.getResizeImage( new Dimension(70*4,70*4), VariablesUtilisateur.REP_IMAGE + VariablesUtilisateur.REP_OBJETS + this.ensNomImage.get(0) );
		Polygon masque = OutilsImage.getMasqueImage( image );
		double velociteX = this.rangeVx.genererValeur();
		double velociteY = this.rangeVy.genererValeur();
		int pvMax = (int)this.rangePv.genererValeur();
		int loot  = (int)this.rangeLoot.genererValeur();

		return new Asteroide( position, image, masque, velociteX, velociteY, pvMax, loot );
	}

	//constructeur
	public ParametresAsteroide()
	{
		this.ensNomImage = new ArrayList<>();
	}

	public List<String> getEnsCheminImage() {
		return ensNomImage;
	}

	//TODO: renommer en setEnsNomImage
	public void setEnsCheminImage(List<String> ensNomImage) {
		this.ensNomImage = ensNomImage;
	}

	public Range getRangePosX() {
		return rangePosX;
	}

	public void setRangePosX(Range rangePosX) {
		this.rangePosX = rangePosX;
	}

	public Range getRangePosY() {
		return rangePosY;
	}

	public void setRangePosY(Range rangePosY) {
		this.rangePosY = rangePosY;
	}

	public Range getRangeVx() {
		return rangeVx;
	}

	public void setRangeVx(Range rangeVx) {
		this.rangeVx = rangeVx;
	}

	public Range getRangeVy() {
		return rangeVy;
	}

	public void setRangeVy(Range rangeVy) {
		this.rangeVy = rangeVy;
	}

	public Range getRangePv() {
		return rangePv;
	}

	public void setRangePv(Range rangePv) {
		this.rangePv = rangePv;
	}

	public Range getRangeLoot() {
		return rangeLoot;
	}

	public void setRangeLoot(Range rangeLoot) {
		this.rangeLoot = rangeLoot;
	}

	public String toString()
	{
		return "ParametresAsteroide [ensCheminImage=" + ensNomImage + ", rangePosX=" + rangePosX + ", rangePosY="
				+ rangePosY + ", rangeVx=" + rangeVx + ", rangeVy=" + rangeVy + ", rangePv=" + rangePv + ", rangeLoot="
				+ rangeLoot + "]";
	}
}
