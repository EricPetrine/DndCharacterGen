/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project03;
/**
 *
 * @author Eric
 */
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class Application {
//            CharacterRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    
//    @Bean
////    public void saveToDB(ArrayList<Integer> asMods, ArrayList<Integer> rawScores, int curHP, String alignment, String name, String Class, String race, int level, long groupID){       
////
////        repository.save(new Character(groupID, curHP, asMods.get(6), rawScores.get(0), asMods.get(0), rawScores.get(1), asMods.get(1), rawScores.get(3), asMods.get(3), level, rawScores.get(2), asMods.get(2), rawScores.get(4), asMods.get(4), rawScores.get(5), asMods.get(5), name, Class, race, alignment));
////    }
}
