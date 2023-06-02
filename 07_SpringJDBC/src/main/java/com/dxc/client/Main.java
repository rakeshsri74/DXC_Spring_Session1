package com.dxc.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dxc.config.AppConfig;
import com.dxc.dao.PersonDAO;
import com.dxc.model.Person;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PersonDAO personDAO = ctx.getBean(PersonDAO.class);
		
		System.out.println("List of person");
		for(Person p : personDAO.getAllPerson()) {
			System.out.println(p);
		}
		
		System.out.println("Person with Id:2");
		Person personById = personDAO.getPersonById(2);
		System.out.println(personById);
		

		/*System.out.println("Creating person");
		Person person = new Person(3,"Swati","Srivastava",48);
		personDAO.createPerson(person);
		System.out.println("Inserted");*/
		
		/*System.out.println("Updating Person");
		Person personUpdate = personDAO.getPersonById(3);
		personUpdate.setFirstName("Reema");
		personUpdate.setLastName("Tanuja");
		personUpdate.setAge(21);
		personDAO.updatePerson(personUpdate);
		System.out.println("Updated");*/
		
		System.out.println("Deleting person");
		
		Person personDelete = personDAO.getPersonById(3);
		personDAO.deletePerson(personDelete);
		System.out.println("deleted");
		
		

	}

}
