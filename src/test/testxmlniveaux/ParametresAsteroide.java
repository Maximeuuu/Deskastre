package test.testxmlniveaux;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import deskastre.modele.entite.Asteroide;

public class ParametresAsteroide
{
	//images
	private List<String> ensCheminImage;

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
		String image = "objets/asteroide_4.png"; //this.ensCheminImage.get(0)
		double velociteX = this.rangeVx.genererValeur();
		double velociteY = this.rangeVy.genererValeur();
		int pvMax = (int)this.rangePv.genererValeur();

		return new Asteroide( position, dimension, image, velociteX, velociteY, pvMax );
	}

	//constructeur
	public ParametresAsteroide()
	{
		this.ensCheminImage = new ArrayList<>();
	}

	public List<String> getEnsCheminImage() {
		return ensCheminImage;
	}

	public void setEnsCheminImage(List<String> ensCheminImage) {
		this.ensCheminImage = ensCheminImage;
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
		return "ParametresAsteroide [ensCheminImage=" + ensCheminImage + ", rangePosX=" + rangePosX + ", rangePosY="
				+ rangePosY + ", rangeVx=" + rangeVx + ", rangeVy=" + rangeVy + ", rangePv=" + rangePv + ", rangeLoot="
				+ rangeLoot + "]";
	}
}
