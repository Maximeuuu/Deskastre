import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class LectureAsteroideXML {
    public static void main(String[] args) {
        // Chemin vers le fichier XML que vous souhaitez lire
        String cheminFichier = args[0]+".xml";

        try {
            File fichierXML = new File(cheminFichier);

            // Créez un objet DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Créez un objet DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Analysez le fichier XML
            Document document = builder.parse(fichierXML);

            // Récupérez les éléments du document
            Element racine = document.getDocumentElement();

            // Extrayez les informations
            NodeList imagesNodeList = racine.getElementsByTagName("image");
            String[] images = new String[imagesNodeList.getLength()];
            for (int i = 0; i < imagesNodeList.getLength(); i++) {
                images[i] = imagesNodeList.item(i).getTextContent();
            }

            double probaApparition = Double.parseDouble(racine.getElementsByTagName("probaApparition").item(0).getTextContent());
            int pvMin = Integer.parseInt(racine.getElementsByTagName("pvMin").item(0).getTextContent());
            int pvMax = Integer.parseInt(racine.getElementsByTagName("pvMax").item(0).getTextContent());
            double vxMin = Double.parseDouble(racine.getElementsByTagName("vxMin").item(0).getTextContent());
            double vxMax = Double.parseDouble(racine.getElementsByTagName("vxMax").item(0).getTextContent());
            double vyMin = Double.parseDouble(racine.getElementsByTagName("vyMin").item(0).getTextContent());
            double vyMax = Double.parseDouble(racine.getElementsByTagName("vyMax").item(0).getTextContent());

            // Instanciez la classe ReglesAsteroide avec les données extraites
            ReglesAsteroide regles = new ReglesAsteroide(images, probaApparition, pvMin, pvMax, vxMin, vxMax, vyMin, vyMax);

            // Utilisez l'instance regles comme nécessaire
            System.out.println("Règles d'astéroïde : " + regles.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

