import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LectureFichierXML {
    public static void main(String[] args) {
        // Chemin vers le fichier XML que vous souhaitez lire
        String cheminFichier = args[0]+".xml";

        try {
            // Créez un objet DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Créez un objet DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Chargez le fichier XML
            File fichierXML = new File(cheminFichier);
            Document document = builder.parse(fichierXML);

            // Obtenez la racine du document
            Node racine = document.getDocumentElement();

            // Appelez une fonction récursive pour afficher les éléments du document
            afficherElements(racine, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fonction récursive pour afficher les éléments du document XML
    private static void afficherElements(Node node, String espacement) {
        System.out.println(espacement + "Élément : " + node.getNodeName());

        // Vérifiez si l'élément a des nœuds enfants
        NodeList enfants = node.getChildNodes();
        for (int i = 0; i < enfants.getLength(); i++) {
            Node enfant = enfants.item(i);
            if (enfant.getNodeType() == Node.ELEMENT_NODE) {
                afficherElements(enfant, espacement + "  ");
            }
        }
    }
}

