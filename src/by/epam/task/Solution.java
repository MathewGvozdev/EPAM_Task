package by.epam.task;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws ParserConfigurationException, IOException,
            SAXException, TransformerException {

        XMLReader.readXML();
        XMLReader.printResults();
        XMLWriter.writeXML();
    }
}