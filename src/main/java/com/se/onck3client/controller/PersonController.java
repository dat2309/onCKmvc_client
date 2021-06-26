package com.se.onck3client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.onck3client.model.CreditCard;
import com.se.onck3client.model.Person;
import com.se.onck3client.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/list")
	public String getPersons(Model model) {
		List<Person> list = personService.getPersons();
		model.addAttribute("persons", list);
		return "list-person";
	}
	
	@GetMapping("/delete")
	public String deletePerson(@RequestParam("personId")int id ) {
		personService.deletePerson(id);
		return "redirect:/person/list";
	}
	
	@PostMapping("/save")
	public String savePerson(@ModelAttribute("person")Person person) {
		List<CreditCard> creditCards=null;
		if(person.getId() != null) {
			Person p = personService.getPerson(person.getId());
			creditCards = p.getCreditCards();
		}else {
			creditCards = new ArrayList<CreditCard>();
		}
		person.setCreditCards(creditCards);
		personService.savePerson(person);
		return "redirect:/person/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updatePerson(@RequestParam("personId") int personId, Model model) {
		Person p = personService.getPerson(personId);
		model.addAttribute("person", p);
		return "form-person";
	}
	
	@GetMapping("/showFormForAdd")
	public String addPerson(Model model) {
		Person p = new Person();
		model.addAttribute("person", p);
		return "form-person";
	}

}
