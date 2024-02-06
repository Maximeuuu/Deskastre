package deskastre.modele.parametre;

public class LectureParametresNiveau extends AbstractLectureParametres
{
	public LectureParametresNiveau( String nomFichier )
	{
		super( nomFichier );
	}

	public ParametresNiveau getParametresNiveau()
	{
		ParametresNiveau parametresNiveau = new ParametresNiveau();

		parametresNiveau.setTitre( this.getValeurString( "titre" ) );
		parametresNiveau.setDescription( this.getValeurString( "description" ) );
		parametresNiveau.setBackground( this.getValeurString( "background" ) );
		parametresNiveau.setCycleApparition( this.getValeurInt( "cycleApparition" ) );
		parametresNiveau.setProbabiliteApparition( this.getValeurDouble( "probabiliteApparition" ) );

		if( this.aDureeMax() )
		{
			parametresNiveau.setDureeMax( this.getValeurInt( "dureeMax" ) );
		}

		if( this.aPointsMax() )
		{
			parametresNiveau.setPointsMax( this.getValeurInt( "pointsMax" ) );
		}

		if( this.aAsteroidesMax() )
		{
			parametresNiveau.setAsteroidesMax( this.getValeurInt( "asteroidesMax" ) );
		}

		return parametresNiveau;
	}
}
