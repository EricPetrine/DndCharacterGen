/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project03;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Controller
public class ServerController{
    @Autowired
    private CharacterRepository repository;
    Application app;
    int curHP;
    CharacterStats CS = new CharacterStats();
    SaveCharacter saveChar= new SaveCharacter();
    Character Character = new Character();
    String race;
    String Class;
    int level;
    ArrayList<Integer> rawScores = new ArrayList<>();
    ArrayList<Integer> asMods = new ArrayList<>();
    ArrayList<String> charGroup;
    ArrayList<String> charInfo;
    String name;
    String alignment;
    Long groupID;
    String[] charInGroup;

    
    @GetMapping("/home")
    public String home(String name, Model model){
        return "home";
    }
    
    @GetMapping("/homepage")
    public String homepage(Model mode){
        return "homepage";
    }
    
    @GetMapping("/charactercreate")
    public String makecharacter(Model model){
        return"characterrace";
    }
    
    @GetMapping("/Tiefling")
    public String tieflingInfo(){
        race = "tiefling";
        return"tieflingInfo";
    }
    
    @GetMapping("/Dwarf")
    public String dwarfInfo(){
        race = "dwarf";
        return"dwarfInfo";
    }
    
    @GetMapping("/Human")
    public String humanInfo(){
        race = "human";
        return"human";
    }
    
    @GetMapping("/Dragonborn")
    public String dragonbornInfo(){
        race = "dragonborn";
        return"dragonbornInfo";
    }
    
    @GetMapping("/Elf")
    public String elfInfo(){
        race = "elf";
        return"elfInfo";
    }
    
    @GetMapping("/Gnome")
    public String gnomeInfo(){
        race = "gnome";
        return"gnomeInfo";
    }
    
    @GetMapping("/Half-orc")
    public String halfOrcInfo(){
        race = "half-orc";
        return"halforcInfo";
    }
    
    @GetMapping("/Halfling")
    public String halflingInfo(){
        race = "halfling";
        return"halflingInfo";
    }
    
    @GetMapping("/class")
    public String classes(){
        System.out.println("Race: " +race);
        return "classes";
    }
    
    @GetMapping("/Barbarian")
    public String barbCreate(){
        Class = "barbarian";
        return"characterSpecs";
    }
    
    @GetMapping("/Bard")
    public String bardCreate(){
        Class = "bard";
        return"characterSpecs";
    }
    
    @GetMapping("/Cleric")
    public String clericCreate(){
        Class = "cleric";
        return"characterSpecs";
    }
    
    @GetMapping("/Druid")
    public String druidCreate(){
        Class = "druid";
        return"characterSpecs";
    }
    
    @GetMapping("/Fighter")
    public String fighterCreate(){
        Class = "fighter";
        return"characterSpecs";
    }
    
    @GetMapping("/Monk")
    public String monkCreate(){
        Class = "monk";
        return"characterSpecs";
    }
    
    @GetMapping("/Paladin")
    public String paladinCreate(){
        Class = "paladin";
        return"characterSpecs";
    }
    
    @GetMapping("/Ranger")
    public String rangerCreate(){
        Class = "ranger";
        return"characterSpecs";
    }
    
    @GetMapping("/Rogue")
    public String rougueCreate(){
        Class = "rogue";
        return"characterSpecs";
    }
    
    @GetMapping("/Sorcerer")
    public String sorcererCreate(){
        Class = "sorcerer";
        return"characterSpecs";
    }
    
    @GetMapping("/Warlock")
    public String warlockCreate(){
        Class = "warlock";
        return"characterSpecs";
    }
    
    @GetMapping("/Wizard")
    public String wizardCreate(){
        Class = "wizard";

        return"characterSpecs";
    }

    
    @RequestMapping(value="/characterDisplay")
    public String characterDisplay(@RequestParam("level") int ilevel, 
            @RequestParam("name") String iname,
            @RequestParam("Alignment") String ialignment, 
            @RequestParam("groupID") Long groupId, Model model){
        level = ilevel;
        name = iname;
        groupID = groupId;
        alignment = ialignment;
        rawScores = CS.rollRawStats(race, Class, level);
        asMods = CS.configureRawStats(rawScores);
        model.addAttribute("STR", rawScores.get(0));
        model.addAttribute("STRMOD", asMods.get(0));
        model.addAttribute("DEX", rawScores.get(1));
        model.addAttribute("DEXMOD", asMods.get(1));
        model.addAttribute("CON", rawScores.get(2));
        model.addAttribute("CONMOD", asMods.get(2));
        model.addAttribute("INT", rawScores.get(3));
        model.addAttribute("INTMOD", asMods.get(3));
        model.addAttribute("WIS", rawScores.get(4));
        model.addAttribute("WISMOD", asMods.get(4));
        model.addAttribute("CHA", rawScores.get(5));
        model.addAttribute("CHAMOD", asMods.get(5));
        model.addAttribute("alignment", alignment);
        model.addAttribute("HP", asMods.get(6));
        model.addAttribute("curHP", asMods.get(6));
        model.addAttribute("name", name);
        
        return"madeCharacter";
        
        
    }
    
    @RequestMapping(value="/reroll")
    public String rerollChar(Model model){
        rawScores = CS.rollRawStats(race, Class, level);
        asMods = CS.configureRawStats(rawScores);
        model.addAttribute("STR", rawScores.get(0));
        model.addAttribute("STRMOD", asMods.get(0));
        model.addAttribute("DEX", rawScores.get(1));
        model.addAttribute("DEXMOD", asMods.get(1));
        model.addAttribute("CON", rawScores.get(2));
        model.addAttribute("CONMOD", asMods.get(2));
        model.addAttribute("INT", rawScores.get(3));
        model.addAttribute("INTMOD", asMods.get(3));
        model.addAttribute("WIS", rawScores.get(4));
        model.addAttribute("WISMOD", asMods.get(4));
        model.addAttribute("CHA", rawScores.get(5));
        model.addAttribute("CHAMOD", asMods.get(5));
        model.addAttribute("alignment", alignment);
        model.addAttribute("HP", asMods.get(6));
        model.addAttribute("curHP", asMods.get(6));
        model.addAttribute("name", name);
        
        return"madeCharacter";
        
        
    }
    
    @RequestMapping(value="/save")
    public String saveChar(@RequestParam("curHP") int curHP, Model model){
        System.out.println(groupID+ "," + curHP+ "," +  asMods.get(6)+ "," +  rawScores.get(0)+ "," +  asMods.get(0)+ "," +  rawScores.get(1)+ "," +  asMods.get(1)+ "," +  rawScores.get(3)+ "," +  asMods.get(3)+ "," +  level+ "," +  rawScores.get(2)+ "," +  asMods.get(2)+ "," +  rawScores.get(4)+ "," +  asMods.get(4)+ "," +  rawScores.get(5)+ "," +  asMods.get(5)+ "," +  name + "," +  Class + "," +  race + "," +  alignment);
//        repository.save(new Character(asMods, rawScores, curHP, alignment, name, Class, race, level, groupID));
        repository.save(new Character(groupID, curHP, asMods.get(6), rawScores.get(0), asMods.get(0), rawScores.get(1), asMods.get(1), rawScores.get(3), asMods.get(3), level, rawScores.get(2), asMods.get(2), rawScores.get(4), asMods.get(4), rawScores.get(5), asMods.get(5), name, Class, race, alignment));
        return"homepage";
    }
    
    @RequestMapping(value="/characterview")
    public String savedChars(Model model){
//        charGroup = saveChar.groupID();
//        charInfo = saveChar.charName();
//        model.addAttribute("charInfo", charInfo);
//        model.addAttribute("charGroup", charGroup);
        return"CharacterView";
    }
    @RequestMapping(value="/GroupView")
    public String selectGroup(@RequestParam("groupID") Long groupID, Model model){
        List<Character> groupChar = repository.findAllByGroupID(groupID);
        System.out.println(groupChar);
        String characters = groupChar.toString();
        System.out.println(characters);
        charInGroup = characters.split("'");
        for (String t : charInGroup){
            System.out.println(t);
        } 
        name = charInGroup[1];
        model.addAttribute("groupID", groupID);
        model.addAttribute("name", name);
        return "GroupView";
    }
    
    @RequestMapping(value="1d4")
    public String take1d4(@RequestParam("curHP") int curHP, Model model){
        model.addAttribute("STR", rawScores.get(0));
        model.addAttribute("STRMOD", asMods.get(0));
        model.addAttribute("DEX", rawScores.get(1));
        model.addAttribute("DEXMOD", asMods.get(1));
        model.addAttribute("CON", rawScores.get(2));
        model.addAttribute("CONMOD", asMods.get(2));
        model.addAttribute("INT", rawScores.get(3));
        model.addAttribute("INTMOD", asMods.get(3));
        model.addAttribute("WIS", rawScores.get(4));
        model.addAttribute("WISMOD", asMods.get(4));
        model.addAttribute("CHA", rawScores.get(5));
        model.addAttribute("CHAMOD", asMods.get(5));
        model.addAttribute("alignment", alignment);
        model.addAttribute("HP", asMods.get(6));
        curHP = (int) (curHP - (Math.random()*4) + 1);
        model.addAttribute("curHP", curHP);
        model.addAttribute("name", name);
        return "madeCharacter";
    }
    
        @RequestMapping(value="1d6")
    public String take1d6(@RequestParam("curHP") int curHP, Model model){
        model.addAttribute("STR", rawScores.get(0));
        model.addAttribute("STRMOD", asMods.get(0));
        model.addAttribute("DEX", rawScores.get(1));
        model.addAttribute("DEXMOD", asMods.get(1));
        model.addAttribute("CON", rawScores.get(2));
        model.addAttribute("CONMOD", asMods.get(2));
        model.addAttribute("INT", rawScores.get(3));
        model.addAttribute("INTMOD", asMods.get(3));
        model.addAttribute("WIS", rawScores.get(4));
        model.addAttribute("WISMOD", asMods.get(4));
        model.addAttribute("CHA", rawScores.get(5));
        model.addAttribute("CHAMOD", asMods.get(5));
        model.addAttribute("alignment", alignment);
        model.addAttribute("HP", asMods.get(6));
        curHP = curHP - (int) (Math.random()*6) + 1;
        model.addAttribute("curHP", curHP);
        model.addAttribute("name", name);
        return "madeCharacter";
    }
    
            @RequestMapping(value="1d8")
    public String take1d8(@RequestParam("curHP") int curHP, Model model){
        model.addAttribute("STR", rawScores.get(0));
        model.addAttribute("STRMOD", asMods.get(0));
        model.addAttribute("DEX", rawScores.get(1));
        model.addAttribute("DEXMOD", asMods.get(1));
        model.addAttribute("CON", rawScores.get(2));
        model.addAttribute("CONMOD", asMods.get(2));
        model.addAttribute("INT", rawScores.get(3));
        model.addAttribute("INTMOD", asMods.get(3));
        model.addAttribute("WIS", rawScores.get(4));
        model.addAttribute("WISMOD", asMods.get(4));
        model.addAttribute("CHA", rawScores.get(5));
        model.addAttribute("CHAMOD", asMods.get(5));
        model.addAttribute("alignment", alignment);
        model.addAttribute("HP", asMods.get(6));
        curHP = curHP - (int) (Math.random()*8) +1;
        model.addAttribute("curHP", curHP);
        model.addAttribute("name", name);
        return "madeCharacter";
    }
    
    @RequestMapping(value="1d10")
    public String take1d10(@RequestParam("curHP") int curHP, Model model){
        model.addAttribute("STR", rawScores.get(0));
        model.addAttribute("STRMOD", asMods.get(0));
        model.addAttribute("DEX", rawScores.get(1));
        model.addAttribute("DEXMOD", asMods.get(1));
        model.addAttribute("CON", rawScores.get(2));
        model.addAttribute("CONMOD", asMods.get(2));
        model.addAttribute("INT", rawScores.get(3));
        model.addAttribute("INTMOD", asMods.get(3));
        model.addAttribute("WIS", rawScores.get(4));
        model.addAttribute("WISMOD", asMods.get(4));
        model.addAttribute("CHA", rawScores.get(5));
        model.addAttribute("CHAMOD", asMods.get(5));
        model.addAttribute("alignment", alignment);
        model.addAttribute("HP", asMods.get(6));
        curHP = curHP - (int) (Math.random()*10) +1;
        model.addAttribute("curHP", curHP);
        model.addAttribute("name", name);
        return "madeCharacter";
    }
    
    @RequestMapping(value="1d12")
    public String take1d12(@RequestParam("curHP") int curHP, Model model){
        model.addAttribute("STR", rawScores.get(0));
        model.addAttribute("STRMOD", asMods.get(0));
        model.addAttribute("DEX", rawScores.get(1));
        model.addAttribute("DEXMOD", asMods.get(1));
        model.addAttribute("CON", rawScores.get(2));
        model.addAttribute("CONMOD", asMods.get(2));
        model.addAttribute("INT", rawScores.get(3));
        model.addAttribute("INTMOD", asMods.get(3));
        model.addAttribute("WIS", rawScores.get(4));
        model.addAttribute("WISMOD", asMods.get(4));
        model.addAttribute("CHA", rawScores.get(5));
        model.addAttribute("CHAMOD", asMods.get(5));
        model.addAttribute("alignment", alignment);
        model.addAttribute("HP", asMods.get(6));
        curHP = curHP - (int) (Math.random()*12) +1;
        model.addAttribute("curHP", curHP);
        model.addAttribute("name", name);
        return "madeCharacter";
    }
    

    /*
            level = 1;
        rawScores = CS.rollRawStats(race, Class, level);
        asMods = CS.configureRawStats(rawScores);
    */
    
    
}

