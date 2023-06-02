package com.dxc.dao;

import java.util.List;

import com.dxc.model.Person;

public interface PersonDAO {

	Person getPersonById(int id);
	List<Person> getAllPerson();
	boolean createPerson(Person person);
	boolean updatePerson(Person person);
	boolean deletePerson(Person person);
}
