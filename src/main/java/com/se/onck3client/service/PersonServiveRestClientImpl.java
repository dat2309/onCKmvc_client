package com.se.onck3client.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.onck3client.model.Person;

@Service
public class PersonServiveRestClientImpl implements PersonService{
	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public PersonServiveRestClientImpl(RestTemplate restTemp,@Value("${crm.rest.url.person}") String theUrl) {
		super();
		restTemplate = restTemp;
		crmRestUrl = theUrl;
		logger.info("Loaded properties: "+crmRestUrl);
	}

	@Override
	public List<Person> getPersons() {
		ResponseEntity<List<Person>> responseEntity = restTemplate.exchange(crmRestUrl, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<Person>>() {});
		List<Person> list = responseEntity.getBody();
		
		return list;
	}

	@Override
	public Person getPerson(int id) {
		Person p = restTemplate.getForObject(crmRestUrl + "/"+id, Person.class);
		return p;
	}

	@Override
	public void deletePerson(int id) {
		restTemplate.delete(crmRestUrl+"/"+id);
		
	}

	@Override
	public void savePerson(Person person) {
		if(person.getId() == null) {
			restTemplate.postForEntity(crmRestUrl, person, String.class);
		}else {
			restTemplate.put(crmRestUrl, person);
		}
		
	}

}
