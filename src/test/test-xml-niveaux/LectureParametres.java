import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class LectureParametres
{
	private File fichierXML;
	private Element racine;
	
	public LectureParametres( String nomFichier )
	{
		//FIXME: ajouter le chemin relatif du projet avant avec URL
		
		this.fichierXML = new File( nomFichier );
		Document document = LectureParametres.ouvrirFichierXML( this.fichierXML );
		this.racine = document.getDocumentElement();
		
		
	}
	
	private static Document ouvrirFichierXML( File fichierXML )
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance( );
		DocumentBuilder builder = factory.newDocumentBuilder( );
		Document document = builder.parse( fichierXML );
		
		return document;
	}

	private ParametresNiveau getParametresNiveau ( )
	{
		
	}
	
	private ParametresAsteroide getParametresAsteroide( );
	
	private int numeroAsteroide( /*...*/ );
	
	private List<Image> getImages( NodeList noeud )
	{
		List<Image> ensImage = new ArrayList<Image>();
		
		NodeList imagesNodeList = racine.getElementsByTagName( "image" ); //FIXME : passer par le noeud (asteroides/ast_X/images)
		for( int i = 0; i < imagesNodeList.getLength( ); i++ )
		{
			String nomImage = imagesNodeList.item( i ).getTextContent( );
			//FIXME: ajouter le chemin relatif avec URL
			//URL cheminImage;
			ensImage.add( new Image( cheminImage ) );
		}
		
		return ensImage;
	}
	
	private Object[] getValeurs( NodeList noeud ); //pour le min et le max

}
