package TestsandParsing;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class ParsingTest {

    @Test
    public void fileParsing() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, SAXException, XMLStreamException, ParserConfigurationException, ParseException, TransformerException {
        Parsing test=new Parsing();
        ArrayList<String> str=new ArrayList<String>();
        ArrayList<String> result=new ArrayList<String>();
        str.add("13/2+3");
        result.add("9.5");
        str.add("13/2");
        result.add("6.5");
        str.add("13*(10+3)");
        result.add("169.0");
        Assert.assertEquals(test.FileParsing(str),result);
    }
}