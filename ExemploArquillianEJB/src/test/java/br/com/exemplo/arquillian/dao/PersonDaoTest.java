package br.com.exemplo.arquillian.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.exemplo.arquillian.dao.PersonDao;
import br.com.exemplo.arquillian.modelo.Person;

@RunWith(Arquillian.class)
public class PersonDaoTest{

   @EJB
   PersonDao personDao;
	
	@Deployment
	public static Archive<?> createFileTest() {
		 Archive<?> arquivoTest = ShrinkWrap.create(WebArchive.class, "applicationTest.war")
				 							.addPackage(PersonDao.class.getPackage())
											.addClass(Person.class)
											.addAsResource("META-INF/persistence.xml")
											.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	
		 return arquivoTest;
	}
		
	@Test
	@InSequence(1)
	public void testSavePerson() {
	   Person p1 = new Person();
	   p1.setAge(10);
	   p1.setName("John Snow");
	   personDao.save(p1);
	 
	   Person p2 = new Person();
	   p2.setAge(21);
	   p2.setName("Phelipe Star");
	   personDao.save(p2);
	   
	}
		
	public void testUpdatePersonP1() {
	   Person p1 = personDao.seek(9);
	   p1.setName("Peter");
	   p1.setAge(11);
	   personDao.update(p1);
	   
	   assertEquals("Peter", p1.getName());
	   assertEquals(11, p1.getAge().intValue());
	   
	}
}
