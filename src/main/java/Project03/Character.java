/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project03;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Eric
 */
@Entity
public class Character implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;
    @Id        
    private Long groupID;
    @Column(name="curHP")
    private int curHP;
    @Column(name="maxHP")
    private int maxHP;
    @Column(name="rawStr")
    private int rawStr;
    @Column(name="strMod")
    private int strMod;
    @Column(name="rawDex")
    private int rawDex;
    @Column(name="dexMod")
    private int dexMod;
    @Column(name="rawInt")
    private int rawInt;
    @Column(name="intMod")
    private int intMod;
    @Column(name="Level")
    private int lvl;
    @Column(name="rawCon")
    private int rawCon;
    @Column(name="conMod")
    private int conMod;
    @Column(name="rawWis")
    private int rawWis;
    @Column(name="wisMod")
    private int wisMod;
    @Column(name="rawCha")
    private int rawCha;
    @Column(name="chaMod")
    private int modCha;
    @Column(name="name")
    private String name;
    @Column(name="charClass")
    private String charClass;
    @Column(name="race")
    private String race;
    @Column(name="alignment")
    private String alignment;
   
   public Character(){}
   
   public Character(Long groupID, int curHP, int maxHP, int rawStr, int strMod, int rawDex,
   int dexMod, int rawInt, int intMod, int lvl, int rawCon, int conMod, int rawWis, int wisMod,
   int rawCha, int modCha, String name, String charClass, String race, String alignment){
    super();
    this.groupID = groupID;
    this.curHP = curHP;
    this.maxHP = maxHP;
    this.rawStr= rawStr;
    this.strMod = strMod;
    this.rawDex = rawDex;
    this.dexMod = dexMod;
    this.rawInt = rawInt;
    this.intMod = intMod;
    this.lvl = lvl;
    this.rawCon = rawCon;
    this.conMod = conMod;
    this.rawWis = rawWis;
    this.wisMod = wisMod;
    this.rawCha = rawCha;
    this.modCha = modCha;
    this.name = name;
    this.charClass = charClass;
    this.race = race;
    this.alignment = alignment;
}
   
   @Override
   public String toString(){
       return String.format("Character[groupID=%d, name='%s', charClass='%s', race='%s', alignment='%s', lvl=%d, curHP=%d, maxHP=%d, rawStr=%d,"
               + " strMod=%d, rawDex=%d, dexMod=%d, rawInt=%d, intMod=%d, rawCon=%d, "
               + "conMod=%d, rawWis=%d, wisMod=%d, rawCha=%d, modCha=%d ]", groupID, name, charClass, race, alignment, lvl, curHP, maxHP, rawStr,
               strMod, rawDex, dexMod, rawInt, intMod, rawCon, conMod, rawWis, wisMod, rawCha, modCha);
   }
   
//   @Bean
//   public CommandLineRunner addToDB(){
//       return(args) -> {
//           repository.save(new Character(groupID, curHP, maxHP, rawStr, strMod, rawDex, dexMod, rawInt, intMod, lvl, rawCon, conMod, rawWis, wisMod, rawCha, modCha, name, charClass, race, alignment));
//       };
//   }

//   
//   public int getGroupID(){
//       return groupID;
//   }
//   public void setGroupID(int groupID){
//       this.groupID = groupID;
//   }
//   public int getcurHP(){
//       return curHP;
//   }
//   public void setcurHP(int curHP){
//       this.curHP= curHP;
//   }
//   public int getMaxHP(){
//       return maxHP;
//   }
//   public void setMaxHP(int maxHP){
//       this.maxHP = maxHP;
//   }
//   public int getRawStr(){
//       return rawStr;
//   }
//   public void setRawStr(int rawStr){
//       this.rawStr = rawStr;
//   }
//   public int getStrMod(){
//       return strMod;
//   }
//   public void setStrMod(int strMod){
//       this.strMod = strMod;
//   }
//   public int getRawDex(){
//       return rawDex;
//   }
//   public void setRawDex(int rawDex){
//       this.rawDex = rawDex;
//   }
//   public int getDexMod(){
//       return dexMod;
//   }
//   public void setDexMod(int dexMod){
//       this.dexMod = dexMod;
//   }
//   
//   public void saveToDB(int groupID, int curHP, int maxHP, int rawStr, int strMod, int rawDex,
//   int dexMod, int rawInt, int intMod, int lvl, int rawCon, int conMod, int rawWis, int wisMod,
//   int rawCha, int chaMod, String name, String charClass, String race, String alignment){
//       String sql = "INSERT INTO CHARACTERS " + "VALUES ('" + name + "', '" + charClass + "', " + groupID + ", '" + race + "', '"
//               + alignment + "', " + lvl + ", " + maxHP + ", " + curHP + ", " + rawStr + ", " + strMod + ", " + rawDex + ", " + dexMod + ", "
//               + rawCon + ", " + conMod + ", " + rawInt + ", " + intMod + ", " + rawWis + ", " + wisMod + ", "+ rawCha + ", " + chaMod + ");"; 
//       Connection conn = null;
//       Statement stmt = null;
//       try{
//           Class.forName(JDBC_DRIVER);
//           conn = DriverManager.getConnection(DB_URL, USER, PASS);
//           System.out.println("Connected to DB!");
//           stmt = conn.createStatement();
//           System.out.println("Inserting into table...");
//           stmt.executeUpdate(sql);
//           System.out.println("SQL statement inserted!");
//       }catch(SQLException se){
//           se.printStackTrace();
//       }catch (ClassNotFoundException ex) {
//           ex.printStackTrace();
//        }finally{
//           try{
//               if(conn!=null){
//                   conn.close();
//               }
//               }catch (SQLException se){
//                 se.printStackTrace();
//               }
//           }
//   }
//   public void createTable(){
//       String sql = "CREATE TABLE CHARACTER" +
//            "(" +
//            "name varchar(250) not null, " +
//            "charClass varchar(250) not null, " +
//            "groupID integer not null, " +
//            "race varchar(250) not null, " +
//            "alignment varchar(250) not null, " +
//            "lvl integer not null, " +
//            "maxHP integer not null, " +
//            "curHP integer not null, " +
//            "rawSTR integer not null, " +
//            "strMOD integer not null, " +
//            "rawDex integer not null, " +
//            "dexMOD integer not null, " +
//            "rawCON integer not null, " +
//            "conMOD integer not null, " +
//            "rawINT integer not null, " +
//            "intMOD integer not null, " +
//            "rawWIS integer not null," +
//            "wisMOD integer not null," +
//            "rawCHA integer not null," +
//            "chaMOD integer not null" +
//        ")";
//              Connection conn = null;
//              Statement stmt = null;
//       try{
//           Class.forName(JDBC_DRIVER);
//           conn = DriverManager.getConnection(DB_URL, USER, PASS);
//           System.out.println("Connected to DB!");
//           stmt = conn.createStatement();
//           System.out.println("Inserting into table...");
//           stmt.executeUpdate(sql);
//           System.out.println("Table created!");
//       } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Character.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(Character.class.getName()).log(Level.SEVERE, null, ex);
//        }
//   }
}
