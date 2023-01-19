package WorkWithFiles;

import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WorkWithXML implements WorkWithFile {

    @Override
    public ArrayList<String> read(String in) throws IOException, ParseException, SAXException, ParserConfigurationException {
        ArrayList<String> stringArrayList = new ArrayList<>();
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(in);
        Node root = document.getDocumentElement();
        NodeList examples = root.getChildNodes();
        for (int i = 0; i < examples.getLength(); i++) {
            Node example = examples.item(i);
            if (example.getNodeType() != Node.TEXT_NODE) {
                stringArrayList.add(example.getChildNodes().item(0).getTextContent());
            }
        }

        return stringArrayList;
    }


    @Override
    public void write(ArrayList<String> arrayList, String out) throws IOException, XMLStreamException {

        XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newFactory();
        XMLStreamWriter writer=xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(out));
        writer.writeStartDocument();
        writer.writeCharacters("\n");
        writer.writeStartElement("root");
        for (String element : arrayList)
        {
            writer.writeCharacters("\n");
            writer.writeStartElement("font");
            writer.writeCharacters(element);
            writer.writeEndElement();
        }writer.writeCharacters("\n");

        writer.writeEndDocument();
    }
}
