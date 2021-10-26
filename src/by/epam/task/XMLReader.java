package by.epam.task;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class XMLReader {

    private static final File INPUT_FILE = new File("D:/IDEA/EPAM_Task/src/by/epam/task/xmlfiles/plants.xml");
    private static final String TREE = "tree";
    private static final String BUSH = "bush";
    private static final Park park = Park.getInstance(new PlantFactory());

    public static void readXML() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(INPUT_FILE);

        addPlants(document, TREE);
        addPlants(document, BUSH);
    }

    private static void addPlants(Document document, String plantType) {
        NodeList plantTypes = document.getElementsByTagName(plantType);

        for (int i = 0; i < plantTypes.getLength(); i++) {
            NamedNodeMap attributes = plantTypes.item(i).getAttributes();

            String plantName = attributes.getNamedItem("name").getNodeValue();
            int minHeight = Integer.parseInt(attributes.getNamedItem("minHeight").getNodeValue());
            int maxHeight = Integer.parseInt(attributes.getNamedItem("maxHeight").getNodeValue());
            int amount = Integer.parseInt(attributes.getNamedItem("amount").getNodeValue());

            for (int counter = 0; counter < amount; counter++) {
                int height = defineRange(minHeight, maxHeight);
                if (plantType.equals(TREE)) {
                    Plant plant = park.getPlantFactory().growPlant(PlantType.TREE, plantName, height);
                    park.getListOfParkPlants().add(plant);
                }
                if (plantType.equals(BUSH)) {
                    Plant plant = park.getPlantFactory().growPlant(PlantType.BUSH, plantName, height);
                    park.getListOfParkPlants().add(plant);
                }
            }
        }
    }

    private static int defineRange(int minHeight, int maxHeight) {
        Random range = new Random();
        return minHeight + range.nextInt(maxHeight - minHeight);
    }

    public static void printResults() {
        countAmountOfPlants(park);
        countTotalHeight(park);
    }

    public static String countTotalHeight(Park park) {
        int totalHeight = 0;
        for (Plant plant : park.getListOfParkPlants()) {
            totalHeight += plant.getHeight();
        }
        return String.valueOf(totalHeight);
    }

    public static String countAmountOfPlants(Park park) {
        int amountOfPlants = park.getListOfParkPlants().size();
        return String.valueOf(amountOfPlants);
    }
}