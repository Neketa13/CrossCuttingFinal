package WorkWithFiles;

import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkWithTxt implements WorkWithFile {
    @Override
    public ArrayList<String> read(String in) throws IOException, ParseException {
        FileReader fileReader = new FileReader(in);
        Scanner scan = new Scanner(fileReader);
        ArrayList<String> stringArrayList = new ArrayList<>();
        while (scan.hasNextLine()) {
            stringArrayList.add(scan.nextLine());
        }
        fileReader.close();
        return stringArrayList;
    }

    @Override
    public void write(ArrayList<String> arrayList,String out) throws IOException {
        FileWriter fileWriter = new FileWriter(out);
        for (String element : arrayList) {
            fileWriter.write(String.valueOf(element) + "\n");
        }
        fileWriter.close();
    }

}