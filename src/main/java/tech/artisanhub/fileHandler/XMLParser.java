package tech.artisanhub.fileHandler;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParser {
    private static String xmlLocation = "src/main/java/properties.xml";
    private static File inputFile = new File(xmlLocation);
    private static DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    public static String getEmailApiKey() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("email-config");
        String apiKey = null;
        Node nNode = nList.item(0);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            apiKey = eElement.getElementsByTagName("api-key").item(0).getTextContent();
        }
        return apiKey;
    }

    public static String getSenderEmail() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("email-config");
        String email = null;
        Node nNode = nList.item(0);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            email = eElement.getElementsByTagName("sender").item(0).getTextContent();
        }
        return email;
    }

    public static String getAllowedFileExtensions() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("file-operations");
        String extensions = null;
        Node nNode = nList.item(0);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            extensions = eElement.getElementsByTagName("allowed-extensions").item(0).getTextContent();
        }
        return extensions;
    }

    public static String getShapeletDirName() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("file-operations");
        String extensions = null;
        Node nNode = nList.item(0);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            extensions = eElement.getElementsByTagName("shapelet-dir-name").item(0).getTextContent();
        }
        return extensions;
    }
}
