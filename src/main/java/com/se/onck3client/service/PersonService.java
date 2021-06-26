package com.se.onck3client.service;

import java.util.List;

import com.se.onck3client.model.Person;



public interface PersonService {
	public List<Person> getPersons();
	public Person getPerson(int id);
	public void deletePerson(int id);
	public void savePerson(Person person);

}
