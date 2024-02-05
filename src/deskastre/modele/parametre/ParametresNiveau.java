package deskastre.modele.parametre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import deskastre.modele.entite.Asteroide;

public class ParametresNiveau
{
	//informations
	private String titre;
	private String description;

	//proprietes
	private String background;
	//private String musique;

	//conditions
	private Integer dureeMax;
	private Integer pointsMax;
	private Integer asteroidesMax;

	//apparition
	private int cycleApparition;
	private double probabiliteApparition;
	private int minAsteroide;
	private int maxAsteroide;

	//asteroides
	private Map<ParametresAsteroide, Double> ensParametresAstroideProbabilises;

	public ParametresNiveau ()
	{
		this.ensParametresAstroideProbabilises = new HashMap<ParametresAsteroide, Double>();
	}

	public boolean aDureeMax()
	{
		return this.dureeMax != null;
	}

	public boolean aPointsMax()
	{
		return this.pointsMax != null;
	}

	public boolean aAsteroidesMax()
	{
		return this.asteroidesMax != null;
	}

	public void ajouterParametresAsteroide(ParametresAsteroide parametresAsteroide, double probabilite)
	{
		this.ensParametresAstroideProbabilises.put(parametresAsteroide, probabilite);
	}




	public String getTitre() {
		return titre;
	}

	public String getDescription() {
		return description;
	}

	public String getBackground() {
		return background;
	}

	public Integer getDureeMax() {
		return dureeMax;
	}

	public Integer getPointsMax() {
		return pointsMax;
	}

	public Integer getAsteroidesMax() {
		return asteroidesMax;
	}

	public int getCycleApparition() {
		return cycleApparition;
	}

	public double getProbabiliteApparition() {
		return probabiliteApparition;
	}

	public int getMinAsteroide() {
		return minAsteroide;
	}

	public int getMaxAsteroide() {
		return maxAsteroide;
	}

	public Map<ParametresAsteroide, Double> getEnsParametresAstroideProbabilises() {
		return ensParametresAstroideProbabilises;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public void setDureeMax(Integer dureeMax) {
		this.dureeMax = dureeMax;
	}

	public void setPointsMax(Integer pointsMax) {
		this.pointsMax = pointsMax;
	}

	public void setAsteroidesMax(Integer asteroidesMax) {
		this.asteroidesMax = asteroidesMax;
	}

	public void setCycleApparition(int cycleApparition) {
		this.cycleApparition = cycleApparition;
	}

	public void setProbabiliteApparition(double probabiliteApparition) {
		this.probabiliteApparition = probabiliteApparition;
	}

	public void setMinAsteroide(int minAsteroide) {
		this.minAsteroide = minAsteroide;
	}

	public void setMaxAsteroide(int maxAsteroide) {
		this.maxAsteroide = maxAsteroide;
	}

	public void setEnsParametresAstroideProbabilises(Map<ParametresAsteroide, Double> ensParametresAstroideProbabilises) {
		this.ensParametresAstroideProbabilises = ensParametresAstroideProbabilises;
	}
	
}
