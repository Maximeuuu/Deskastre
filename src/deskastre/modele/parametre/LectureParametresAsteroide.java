package deskastre.modele.parametre;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import deskastre.modele.entite.Asteroide;
import deskastre.modele.outil.Range;
import deskastre.modele.Constantes;

public class LectureParametresAsteroide extends AbstractLectureParametres
{
	public LectureParametresAsteroide( String nomFichier )
	{
		super( nomFichier );
	}

	public ParametresAsteroide getParametresAsteroide()
	{
		ParametresAsteroide pa = new ParametresAsteroide();

		pa.setEnsCheminImage( this.getImages( super.racine.getElementsByTagName( "image" ) ) );

		pa.setRangePosX( this.getRangePourcentage( "posX", Constantes.DIMENSIONS_JEU.width ) ); //FIXME: les données sont stockées en pourcentages mais utilisées en pixel
		pa.setRangePosY( this.getRangePourcentage( "posY", Constantes.DIMENSIONS_JEU.height ) );
		pa.setRangeVx( this.getRange( "vx" ) );
		pa.setRangeVy( this.getRange( "vy" ) );
		pa.setRangePv( this.getRange( "pv" ) );
		pa.setRangeLoot( this.getRange( "loot" ) );

		return pa;
	}

	private List<String> getImages( NodeList noeud )
	{
		List<String> ensImage = new ArrayList<String>();

		for( int i = 0; i < noeud.getLength(); i++ )
		{
			ensImage.add( noeud.item( i ).getTextContent() );
		}

		return ensImage;
	}

	private Range getRangePourcentage ( String nomBalise, int valeurReference )
	{
		Node noeud = super.racine.getElementsByTagName( nomBalise ).item(0);
		NamedNodeMap attributs = noeud.getAttributes();
		
		double min = valeurReference * Double.parseDouble( attributs.getNamedItem("min").getNodeValue() ) / 100.0;
		double max = valeurReference * Double.parseDouble( attributs.getNamedItem("max").getNodeValue() ) / 100.0;
		System.out.println( min + " - " + max );
		
		return Range.creerRange( min, max );
	}

	private Range getRange( String nomBalise )
	{
		Node noeud = super.racine.getElementsByTagName( nomBalise ).item(0);
		NamedNodeMap attributs = noeud.getAttributes();
		
		double min = Double.parseDouble( attributs.getNamedItem("min").getNodeValue() );
		double max = Double.parseDouble( attributs.getNamedItem("max").getNodeValue() );
		
		return Range.creerRange( min, max );
	}

	public static void main(String[] args)
	{
		LectureParametresAsteroide lpa = new LectureParametresAsteroide("/data/asteroides/ast1.xml");
		ParametresAsteroide pa = lpa.getParametresAsteroide();
		System.out.println(pa);
		
		Asteroide a1 = pa.creerAsteroide();
		System.out.println(a1);

		Asteroide a2 = pa.creerAsteroide();
		System.out.println(a2);
	}
}
