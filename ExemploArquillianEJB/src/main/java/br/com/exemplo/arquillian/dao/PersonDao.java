package br.com.exemplo.arquillian.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.exemplo.arquillian.modelo.Person;

@Stateless
public class PersonDao {
 
      @PersistenceContext(name="test")
      EntityManager em;
 
      public void save (Person p) {
            em.persist (p);
      }
      
      public void update (Person p) {
            em.merge (p);
      }
 
      public Person seek (int id) {
            return em.find (Person.class, id);
      }
 
      public List <Person> searchAllPersons () {
            return  em.createQuery( "SELECT p FROM Person p ORDER BY p.id", Person.class).getResultList();
      }
	
	public int soma(int valor1, int valor2){
		return valor1 + valor2;
	}
}
