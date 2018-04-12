/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project03;

import java.util.ArrayList;

/**
 *
 * @author Eric
 */
public class CharacterStats {
    int HP;
    int STR;
    int DEX;
    int CON;
    int INT;
    int WIS;
    int CHA;
    int HPmod;
    int STRmod;
    int DEXmod;
    int CONmod;
    int INTmod;
    int WISmod;
    int CHAmod;
    public ArrayList<Integer> rollRawStats(String race, String Class, int level){
        HP = 0;
        if("barbarian".equals(Class)){
            for(int i = 0; level > i; i++)
            HP += (int) (Math.random()*12) +1;
        }
        else if("bard".equals(Class)){
            for(int i = 0; level > i; i++){
                HP += (int) (Math.random()* 8) +1;
            }
        }
        else if("cleric".equals(Class)){
            for(int i = 0; level > i; i++){
                HP += (int) (Math.random()* 8) +1;
            }
        }
        else if("druid".equals(Class)){
            for(int i = 0; level > i; i++){
                HP += (int) (Math.random()* 8) +1;
            }
        }
        else if("fighter".equals(Class)){
            for(int i = 0; level > i; i++){
                HP += (int) (Math.random()* 10) +1;
            }
        }
        else if("monk".equals(Class)){
            for(int i = 0; level > i; i++){
                HP += (int) (Math.random()* 8) +1;
            }
        }
        else if("paladin".equals(Class)){
            for(int i = 0; level > i; i++){
                HP += (int) (Math.random()* 10) +1;
            }
        }
        else if("ranger".equals(Class)){
            for(int i = 0; level > i; i++){
                HP += (int) (Math.random()* 10) +1;
            }
        }
        else if("rogue".equals(Class)){
            for(int i = 0; level > i; i++){
                HP += (int) (Math.random()* 8) +1;
            }
        }
        else if("sorcerer".equals(Class)){
            for(int i = 0; level > i; i++){
                HP += (int) (Math.random()* 6) +1;
            }
        }
        else if("warlock".equals(Class)){
            for(int i = 0; level > i; i++){
                HP += (int) (Math.random()* 8) +1;
            }
        }
        else if("wizard".equals(Class)){
            for(int i = 0; level > i; i++){
                HP += (int) (Math.random()* 6) +1;
            }
        }
        else{
            System.out.println("Class: " + Class + " not found");
        }
        
        for(int s = 0; s < 7; s++){
            int as = 0;
            for(int i = 0; i < 4; i++){
                as += (int) (Math.random()* 6);
            }
            switch (s){
                case 1: STR = as; break;
                case 2: DEX = as; break;
                case 3: CON = as; break;
                case 4: INT = as; break;
                case 5: WIS = as; break;
                case 6: CHA = as; break;
            }
           
        }
        System.out.println("Race: " + race);
        switch(race){
            
            case"dragonborn": STR = STR + 2;
            CHA = CHA + 1;
            break;
            case"dwarf": CON = CON + 2;
            break;
            case"elf": DEX = DEX + 2;
            break;
            case"gnome": INT = INT + 2;
            break;
            case"half-orc": STR = STR + 2;
            CON = CON + 1;
            break;
            case"hafling": DEX = DEX + 2;
            break;
            case"human": STR++; DEX++; CON++; INT++; WIS++; CHA++;
            break;
            case"tiefling": INT++;
            CHA = CHA + 2;
            break;
        }
        
        ArrayList<Integer> rawScores = new ArrayList<Integer>();
        rawScores.add(STR);
        rawScores.add(DEX);
        rawScores.add(CON);
        rawScores.add(INT);
        rawScores.add(WIS);
        rawScores.add(CHA);
        rawScores.add(HP);
        return rawScores;
    }
    
    
    public ArrayList<Integer> configureRawStats(ArrayList<Integer> rawScores){
        ArrayList<Integer> abilityModifier = new ArrayList<Integer>();
        for(int i = 0; i < rawScores.size() -1; i++ ){
            switch (rawScores.get(i)){
                case 1: abilityModifier.add(-5);
                break;
                case 2: abilityModifier.add(-4);
                break;
                case 3: abilityModifier.add(-4);
                break;
                case 4: abilityModifier.add(-3);
                break;
                case 5: abilityModifier.add(-3);
                break;
                case 6: abilityModifier.add(-2);
                break;
                case 7: abilityModifier.add(-2);
                break;
                case 8: abilityModifier.add(-1);
                break;
                case 9: abilityModifier.add(-1);
                break;
                case 10: abilityModifier.add(0);
                break;
                case 11: abilityModifier.add(0);
                break;
                case 12: abilityModifier.add(1);
                break;
                case 13: abilityModifier.add(1);
                break;
                case 14: abilityModifier.add(2);
                break;
                case 15: abilityModifier.add(2);
                break;
                case 16: abilityModifier.add(3);
                break;
                case 17: abilityModifier.add(3);
                break;
                case 18: abilityModifier.add(4);
                break;
                case 19: abilityModifier.add(4);
                break;
                case 20: abilityModifier.add(5);
                break;
                case 21: abilityModifier.add(5);
                break;
                case 22: abilityModifier.add(6);
                break;
                case 23: abilityModifier.add(6);
                break;
                case 24: abilityModifier.add(7);
                break;
                case 25: abilityModifier.add(7);
                break;
                case 26: abilityModifier.add(8);
                break;
                case 27: abilityModifier.add(8);
                break;
                case 28: abilityModifier.add(9);
                break;
                case 29: abilityModifier.add(9);
                break;
                case 30: abilityModifier.add(10);
            } 
        }
            System.out.println("STR: " + abilityModifier.get(0));
            System.out.println("DEX: " + abilityModifier.get(1));
            System.out.println("CON: " + abilityModifier.get(2));
            System.out.println("INT: " + abilityModifier.get(3));
            System.out.println("WIS: " + abilityModifier.get(4));
            System.out.println("CHA: " + abilityModifier.get(5));
            abilityModifier.add(HP + abilityModifier.get(2));
            System.out.println("HP: " + abilityModifier.get(6));
            System.out.println("END CHARACTER SPECS");
           
        return abilityModifier;
    }
    
}
