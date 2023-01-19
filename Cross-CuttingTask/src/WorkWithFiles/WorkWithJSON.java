package WorkWithFiles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WorkWithJSON implements WorkWithFile {
    @Override
    public ArrayList<String> read(String in) throws IOException, ParseException {
        ArrayList<String> arrayList = new ArrayList<>();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(in));
        int i = 0;
        while(i != jsonObject.size()){
            arrayList.add((String)jsonObject.get("str" + i));
            ++i;
        }
        return arrayList;    }

    @Override
    public void write(ArrayList<String> arrayList, String out) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(out));
        JSONObject resultJson = new JSONObject();
        try {
            for (int i = 0; i < arrayList.size(); ++i) {
                resultJson.put("str" + i, arrayList.get(i));
            }

            writer.write(resultJson.toJSONString());
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
