/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.ejb32.war;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Дарья
 */
@Stateless
public class PeopleDB implements PeopleDBLocal {
    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public void addPeople(People people) {
        em.persist(people);
    }

    @Override
    public void editPeople(People people) {
        em.merge(people);
    }

    @Override
    public void deletePeople(People people) {
        em.remove(people);
    }

    @Override
    public People getPeople(People people) {
        return em.find(People.class, people);
    }

    @Override
    public List<People> getAllPeople() {
        return em.createNamedQuery("People.getAll").getResultList();
    }

   
}
