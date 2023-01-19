package Encryption;

import WorkWithFiles.WorkWithTxt;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DecryptorTest {
    WorkWithTxt work=new WorkWithTxt();

    @Test
    public void decrypt() throws IOException, ParseException {
        File src = new File("D:/Java_laba/Cross-CuttingTask/inputFile.txt");
        File dst =new File("D:/Java_laba/Cross-CuttingTask/outputFile.txt");
        Encryptor en = Encryptor.getEncrypter(true);
        Decryptor de = Decryptor.getDecrypter(true);
        en.encrypt(src,dst);
        de.decrypt(dst,src);
        ArrayList<String>list=new ArrayList<>();
        list.add("Hello world!");
        Assert.assertEquals(list,work.read("inputFile.txt"));
    }
}