/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project03;

import java.util.List;
import org.jboss.logging.Param;
 
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository
public interface CharacterRepository extends CrudRepository<Character, Long>{
    List<Character> findAllByGroupID(Long groupID);
} 
