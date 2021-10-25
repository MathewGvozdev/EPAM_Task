package by.epam.task;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {

    private static List<ParkPlant> plants = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("D:/IDEA/EPAM_Task/src/by/epam/task/plants.xml"), handler);

        XMLHandler.countTotalHeight(plants);
        XMLHandler.countAmountOfPlants(plants);
    }

    private static class XMLHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("tree".equals(qName)) {
                String name = attributes.getValue("name");
                int minHeight = Integer.parseInt(attributes.getValue("minHeight"));
                int maxHeight = Integer.parseInt(attributes.getValue("maxHeight"));
                int amount = Integer.parseInt(attributes.getValue("amount"));
                for (int i = 0; i < amount; i++) {
                    int height = XMLHandler.defineRange(minHeight, maxHeight);
                    plants.add(new Tree(name, height));
                }

            }
            if ("bush".equals(qName)) {
                String name = attributes.getValue("name");
                int minHeight = Integer.parseInt(attributes.getValue("minHeight"));
                int maxHeight = Integer.parseInt(attributes.getValue("maxHeight"));
                int amount = Integer.parseInt(attributes.getValue("amount"));
                for (int i = 0; i < amount; i++) {
                    int height = XMLHandler.defineRange(minHeight, maxHeight);
                    plants.add(new Bush(name, height));
                }
            }
        }

        private static int defineRange(int minHeight, int maxHeight) {
            Random range = new Random();
            return minHeight + range.nextInt(maxHeight - minHeight);
        }

        public static void countTotalHeight (List<ParkPlant> plants) {
            int totalHeight = 0;
            for (ParkPlant plant : plants) {
                totalHeight += plant.getHeight();
            }
            System.out.println(totalHeight);
        }

        public static void countAmountOfPlants (List<ParkPlant> plants) {
            System.out.println(plants.size());
        }
    }
}
