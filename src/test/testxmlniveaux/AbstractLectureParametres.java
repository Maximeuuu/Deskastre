package test.testxmlniveaux;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AbstractLectureParametres
{
	protected Document documentXML;
	protected Element racine;
	
	public AbstractLectureParametres( String nomFichier )
	{
		//FIXME: ajouter le chemin relatif du projet avant avec URL
		
		File fichierXML = new File( nomFichier );
		this.documentXML = AbstractLectureParametres.ouvrirFichierXML( fichierXML );
		this.racine = this.documentXML.getDocumentElement();
	}
	
	private static Document ouvrirFichierXML( File fichierXML )
	{
		Document document = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance( );

		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder( );
			document = builder.parse( fichierXML );
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
		
		return document;
	}

	public String getValeurUniqueString( String nomBalise )
	{
		NodeList noeud = this.racine.getElementsByTagName( nomBalise );
		return noeud.item( 0 ).getTextContent( );
	}

	public int getValeurUniqueInt( String nomBalise )
	{
		NodeList noeud = this.racine.getElementsByTagName( nomBalise );
		return Integer.parseInt( noeud.item( 0 ).getTextContent( ) );
	}

	public double getValeurUniqueDouble( String nomBalise )
	{
		NodeList noeud = this.racine.getElementsByTagName( nomBalise );
		return Double.parseDouble( noeud.item( 0 ).getTextContent( ) );
	}

	public List<String> getListeString( String nomBalise )
	{
		List<String> liste = new ArrayList<String>();
		NodeList noeud = this.racine.getElementsByTagName( nomBalise );
		for( int i = 0; i < noeud.getLength(); i++ )
		{
			liste.add( noeud.item( i ).getTextContent() );
		}
		return liste;
	}
}
