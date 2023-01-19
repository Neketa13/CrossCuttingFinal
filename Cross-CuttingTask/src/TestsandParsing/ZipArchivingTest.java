package TestsandParsing;

import Archive.ZipArchiving;
import WorkWithFiles.WorkWithTxt;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class ZipArchivingTest {
    ZipArchiving zip=new ZipArchiving();
    WorkWithTxt work=new WorkWithTxt();

    @Test
    public void archiving() throws IOException, ParseException {
        zip.archiving("input.txt");
        zip.deArchiving("D://Java_laba/Cross-CuttingTask/archive.zip");
        ArrayList<String> list= new ArrayList<>();
        list.add("3 * (sin (pi) - 2) / e/(-1)");
        list.add("3+2");
        list.add("4*4-7");
        Assert.assertEquals(work.read("input.txt"),list);
    }

    @Test
    public void deArchiving() throws IOException, ParseException {
        zip.archiving("input.txt");
        zip.deArchiving("D://Java_laba/Cross-CuttingTask/archive.zip");
        ArrayList<String> list= new ArrayList<>();
        list.add("3 * (sin (pi) - 2) / e/(-1)");
        list.add("3+2");
        list.add("4*4-7");
        Assert.assertEquals(work.read("input.txt"),list);
    }
}