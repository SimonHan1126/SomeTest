package json;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonObject {
    public static void main(String[] args) {
        String jsonFilePath = "/Users/simon.han/Documents/database/json/MS_MacroStock";
        String cscFilesPath = "/Users/simon.han/Documents/database/csv/MS_MacroStock";
        File jsonFileFolder = new File(jsonFilePath);
        File[] jsonFiles = jsonFileFolder.listFiles();


        Gson gson = new Gson();

        try {
            for (File jsonFile : jsonFiles) {
                System.out.println(jsonFile.getName());
                JsonReader reader = new JsonReader(new FileReader(jsonFilePath + "/" + jsonFile.getName()));
                gson.
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
