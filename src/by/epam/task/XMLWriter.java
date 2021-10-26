package by.epam.task;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLWriter {

    private static final File OUTPUT_FILE = new File("D:/IDEA/EPAM_Task/src/by/epam/task/xmlfiles/info.xml");
    private static final Park INSTANCE = Park.getInstance(new PlantFactory());

    public static void writeXML() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("Park");
        root.setAttribute("totalHeight", XMLReader.countTotalHeight(INSTANCE));
        root.setAttribute("totalPlants", XMLReader.countAmountOfPlants(INSTANCE));
        document.appendChild(root);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult file = new StreamResult(OUTPUT_FILE);
        transformer.transform(source, file);
    }
}
