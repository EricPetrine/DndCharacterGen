/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project03;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;

/**
 *
 * @author Eric
 */
public class SaveCharacter {
    ArrayList<String> rawScores;
    ArrayList<String> abilityMods;
    ArrayList<String> charDetails;
    ArrayList<String> charAdd;
    String name;
    String alignment;
    int groupID;
    
    public void writeToJson(ArrayList<Integer> rawScores, ArrayList<Integer> abilityMods, String name, String alignment, int groupID, int level){
        ObjectMapper mapper = new ObjectMapper();
        String groupId = Integer.toString(groupID);
        JSONObject obj = new JSONObject();
        JSONObject nObj = new JSONObject();
        JSONParser parser = new JSONParser();
        nObj.put("Name", name);
        nObj.put("GroupID", groupId);
        obj.put("name", name);
        obj.put("level", level);
        obj.put("alignment", alignment);
        obj.put("groupID", groupID);
        obj.put("rawSTR", rawScores.get(0));
        obj.put("rawDEX", rawScores.get(1));
        obj.put("rawCON", rawScores.get(2));
        obj.put("rawDEX", rawScores.get(3));
        obj.put("rawWIS", rawScores.get(4));
        obj.put("rawCHA", rawScores.get(5));
        obj.put("modSTR", abilityMods.get(0));
        obj.put("modDEX", abilityMods.get(1));
        obj.put("modCON", abilityMods.get(2));
        obj.put("modDEX", abilityMods.get(3));
        obj.put("modWIS", abilityMods.get(4));
        obj.put("modCHA", abilityMods.get(5));
       
        try(FileWriter file = new FileWriter(name+ ".json", true)){
            file.write(obj.toString());
            file.flush();
        }catch(IOException e){
            System.out.println("Failed to create file");
        }
        try(FileWriter nameFile = new FileWriter("name.json")){
                nameFile.write(nObj.toString());
                nameFile.flush();
            }catch(IOException e){
                System.out.println(e);
            }
        
        System.out.println("Json file: " + obj);
        System.out.println("Json file: " + nObj);
        
    }
    
    public ArrayList<String> groupID(){
        JSONParser parser = new JSONParser();
        ArrayList<String> Id = new ArrayList<String>();        
        
        try{
            Object obj = parser.parse(new FileReader("name.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            Id.add((String) jsonObject.get("GroupID"));
            
            
            
        }catch(IOException e){
            System.out.println(e);
        } catch(ParseException e){
            System.out.print(e);
        }
        return Id;
        
    }
    
        public ArrayList<String> charName(){
        JSONParser parser = new JSONParser();
        ArrayList<String> charName = new ArrayList<String>();        
        
        try{
            Object obj = parser.parse(new FileReader("name.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            charName.add((String) jsonObject.get("Name"));
            
            
            
        }catch(IOException e){
            System.out.println(e);
        } catch(ParseException e){
            System.out.print(e);
        }
        return charName;
        
    }
    
    public ArrayList<String> returnCharacter(String name){
        this.name = name;
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(name + ".json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            
            
            
            
        }catch(IOException e){
            System.out.println(e);
        } catch(ParseException e){
            System.out.print(e);
        }
        return charDetails;
    }
}
