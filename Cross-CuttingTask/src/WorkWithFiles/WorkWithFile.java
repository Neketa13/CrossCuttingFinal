package WorkWithFiles;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;

public interface WorkWithFile {
    ArrayList<String> read(String in) throws IOException, ParseException, SAXException, ParserConfigurationException;
    void write(ArrayList<String> arrayList, String out) throws IOException, XMLStreamException;
}
