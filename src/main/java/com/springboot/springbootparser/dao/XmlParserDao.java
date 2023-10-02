package com.springboot.springbootparser.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.springbootparser.entity.Person;
import com.springboot.springbootparser.repository.PersonRepository;

@Component
public class XmlParserDao {

	@Autowired
	PersonRepository personRepository;
	
	public Boolean loadPersons(List<Person> listOfPersons) {
		Boolean success = Boolean.FALSE;
		if (!listOfPersons.isEmpty()) {
			for (Person person : listOfPersons) {
				personRepository.save(person);
				success = Boolean.TRUE;
			}
		}
		return success;
	}

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
}
