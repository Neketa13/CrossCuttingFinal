package TestsandParsing;

import WorkWithFiles.WorkWithJSON;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class WorkWithJSONTest {
    WorkWithJSON work=new WorkWithJSON();

    @Test
    public void read() throws IOException, ParseException {
        ArrayList<String> arrayList=work.read("inputJSON.json");
        Assert.assertEquals("3/2",arrayList.get(0));

    }

    @Test
    public void write() throws IOException, ParseException {
        ArrayList<String> output=new ArrayList<String>();
        output.add("13.0");
        output.add("12.0");
        work.write(output,"outputJSON.json");
        Assert.assertEquals(output,work.read("outputJSON.json"));
    }
}