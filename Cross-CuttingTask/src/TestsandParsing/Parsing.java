package TestsandParsing;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.json.simple.parser.ParseException;
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



public class Parsing {

    public ArrayList<String> FileParsing(ArrayList<String> list) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, XMLStreamException, ParserConfigurationException, TransformerException, SAXException, ParseException {

        ArrayList<String> newList = new ArrayList<>();

        for (String element : list) {
            Expression expression = new ExpressionBuilder(element).variables("pi", "e").build().setVariable("pi", Math.PI).setVariable("e", Math.E);
            try {
                newList.add(String.valueOf(expression.evaluate()));
                System.out.println(expression.evaluate());
            } catch (Throwable cause) {
                if (cause instanceof ArithmeticException && "Division by zero!".equals(cause.getMessage())) {
                    System.out.println(Double.POSITIVE_INFINITY);
                } else {
                    System.out.println(Double.NaN);
                }
            }
        }
        return newList;


    }
    }

