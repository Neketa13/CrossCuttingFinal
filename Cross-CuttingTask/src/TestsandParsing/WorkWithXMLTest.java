package TestsandParsing;

import WorkWithFiles.WorkWithXML;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;

public class WorkWithXMLTest {
    WorkWithXML work=new WorkWithXML();

    @Test
    public void read() throws IOException, ParseException, ParserConfigurationException, SAXException {
        ArrayList<String> arrayList=work.read("inputXML.xml");
        Assert.assertEquals("3+4/3+2",arrayList.get(0));
    }

    @Test
    public void write() throws XMLStreamException, IOException, ParseException, ParserConfigurationException, SAXException {
        ArrayList<String> output=new ArrayList<String>();
        output.add("13.0");
        output.add("12.0");
        work.write(output,"outputXML.xml");
        Assert.assertEquals(output,work.read("outputXML.xml"));
    }
}