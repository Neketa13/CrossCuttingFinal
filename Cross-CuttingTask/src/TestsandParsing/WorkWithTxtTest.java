package TestsandParsing;

import WorkWithFiles.WorkWithTxt;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class WorkWithTxtTest {
    WorkWithTxt work=new WorkWithTxt();

    @Test
    public void read() throws IOException, ParseException {
        ArrayList<String> arrayList=work.read("input.txt");
        Assert.assertEquals("3 * (sin (pi) - 2) / e/(-1)",arrayList.get(0));
    }

    @Test
    public void write() throws IOException, ParseException {
        ArrayList<String> output=new ArrayList<String>();
        output.add("13.0");
        output.add("12.0");
        work.write(output,"output.txt");
        Assert.assertEquals(output,work.read("output.txt"));
    }
}