package entity;
import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class JsonToMap {

    public static Map<String, String> cityMap() {
        Path path = Paths.get("src", "resource", "comuni.json");
        Map<String, String> retvalue = new HashMap<>();
        try {
            String jsonContent = Files.readString(path);
            JsonArray jsonArray = JsonParser.parseString(jsonContent).getAsJsonArray();

            for (JsonElement element : jsonArray){
                JsonObject city = element.getAsJsonObject();

                String name = city.get("nome").getAsString();
                String acronym = city.get("sigla").getAsString();
                String catastralCode = city.get("codiceCatastale").getAsString();
                String key = name + " (" + acronym + ")";

                retvalue.put(key,catastralCode);

            }
        } catch (IOException e) {
            System.out.println("Error on the reading of the file " + e.getMessage());
        } catch (JsonParseException e){
            System.out.println("Error on the parsing of Json " + e.getMessage());
        }

        return retvalue;
    }


    public static Map<String,String> checkCodeMap(String fileName){
        Map<String,String> retvalue = new HashMap<>();
        Path path = Paths.get("src","resource","fiscalCode",fileName);
        try {
            String jsonContent = Files.readString(path);
            JsonArray jsonArray = JsonParser.parseString(jsonContent).getAsJsonArray();
            for (JsonElement element : jsonArray){
                JsonObject code = element.getAsJsonObject();
                String key = code.get("key").getAsString();
                String value = code.get("value").getAsString();
                retvalue.put(key,value);
            }

        } catch (IOException e) {
            System.out.println("Error on the reading of the file " + e.getMessage());
        } catch (JsonParseException e){
            System.out.println("Error on the parsing of Json " + e.getMessage());
        }


        return retvalue;
    }

    //Scegliere un nome migliore al posto del name per prendere o la citta' o la provincia
    public static ArrayList<String> cityArray(String name){
        ArrayList<String> retvalue = new ArrayList<>();
        Path path = Paths.get("src","resource", "comuni.json");
        try{
            String jsonContent = Files.readString(path);
            JsonArray jsonArray = JsonParser.parseString(jsonContent).getAsJsonArray();

            for (JsonElement element : jsonArray){
                JsonObject city = element.getAsJsonObject();
                retvalue.add(city.get(name).getAsString().toUpperCase());
            }
        }catch (IOException e) {
            System.out.println("Error on the reading of the file " + e.getMessage());
        } catch (JsonParseException e){
            System.out.println("Error on the parsing of Json " + e.getMessage());
        }

        return retvalue;
    }



}
