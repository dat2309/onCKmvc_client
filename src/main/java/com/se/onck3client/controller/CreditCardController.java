package com.se.onck3client.controller;

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
import com.se.onck3client.service.CreditCardService;
import com.se.onck3client.service.PersonService;

@Controller
@RequestMapping("/creditcard")
public class CreditCardController {
	@Autowired
	private CreditCardService creditCardService;
	@Autowired
	private PersonService personService;
	
	@GetMapping("/delete")
	public String deleteCreditCard(@RequestParam("creditCardId")int id) {
		creditCardService.deleteCreditCard(id);
		return "redirect:/person/list";
	}
	
	@PostMapping("/save")
	public String saveCreditCard(@ModelAttribute("creditCard")CreditCard creditCard, @RequestParam("personId")int personId) {
		creditCardService.saveCreditCard(creditCard, personId);
		
		Person p = personService.getPerson(personId);
		p.addCreditCard(creditCard);
		personService.savePerson(p);
		
		return "redirect:/person/list";
	}
	
	@PostMapping("/update")
	public String updateCreditCard(@ModelAttribute("creditCard")CreditCard creditCard, @RequestParam("personId")int personId) {
		creditCardService.saveCreditCard(creditCard, personId);
		
		Person p = personService.getPerson(personId);
		CreditCard c = p.getCreditCard(creditCard.getId());
		c.setNumer(creditCard.getNumer());
		c.setType(creditCard.getType());
		personService.savePerson(p);
		
		return "redirect:/person/list";
	}
	
	@GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel, @RequestParam("personId") int personId) {
        
        CreditCard theCard = new CreditCard();
        theModel.addAttribute("creditCard", theCard);
        theModel.addAttribute("personId", personId);
        theModel.addAttribute("isUpdate", false);
        return "form-credit";    }  
    
     @GetMapping("/showFormForUpdate")
   public String showFormForUpdate(   @RequestParam("personId") int personId,@RequestParam("creditCardId") int creditCardId,Model theModel) {
        
        CreditCard theCreditCard = creditCardService.getCreditCard(creditCardId);
        
        theModel.addAttribute("creditCard", theCreditCard);
        theModel.addAttribute("personId", personId);
        theModel.addAttribute("isUpdate", true);
        
        return "form-credit";    }
	
	

}
