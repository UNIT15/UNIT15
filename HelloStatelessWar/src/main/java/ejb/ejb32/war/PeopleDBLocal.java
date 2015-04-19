/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Дарья
 */
@Local
public interface PeopleDBLocal {

    void addPeople(People people);
    List<People> getAllPeople();
    People getPeople(People people);
    void deletePeople(People people);
    void editPeople(People people);
    
}
