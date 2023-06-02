package com.dxc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dxc.model.Person;
import com.dxc.model.PersonMapper;

@Component
public class PersonDAOImpl implements PersonDAO {

	JdbcTemplate jdbcTemplate;
	
	private final String FIND_PERSON = "select * from person where id = ?";
	private final String FIND_ALL = "select * from person";
	private final String INSERT = "insert into person(id,first_name,last_name,age) values(?,?,?,?)";
	private final String UPDATE = "update person set first_name=?,last_name=?,age=? where id=?";
	private final String DELETE =  "delete from person where id=?";
	
	@Autowired
	public PersonDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Person getPersonById(int id) {
		return jdbcTemplate.queryForObject(FIND_PERSON,new Object[] {id},new PersonMapper());
	}

	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(FIND_ALL,new PersonMapper());
	}

	public boolean createPerson(Person person) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(INSERT,person.getId(),person.getFirstName(),person.getLastName(),person.getAge()) > 0;
	}

	public boolean updatePerson(Person person) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(UPDATE,person.getFirstName(),person.getLastName(),person.getAge(),person.getId()) > 0;
	}

	public boolean deletePerson(Person person) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(DELETE,person.getId()) > 0;
	}

}
