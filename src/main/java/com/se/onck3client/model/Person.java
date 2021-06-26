package com.se.onck3client.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



public class Person {
	
	private Integer id;
	
	
	private String firstName;
	
	
	private String lastName;
	
	
	private Double money;
	
	
	private List<CreditCard> creditCards;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	
	
	public CreditCard getCreditCard(int theId) {
		if(creditCards !=null) {
			for(CreditCard c : creditCards) {
				if(c.getId() == theId)
					return c;
			}
		}
		return null;
	}
	
	public void addCreditCard(CreditCard c) {
		if(creditCards == null) {
			creditCards = new ArrayList<CreditCard>();
		}
		creditCards.add(c);
	}

	public Person(Integer id, String firstName, String lastName, Double money, List<CreditCard> creditCards) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.money = money;
		this.creditCards = creditCards;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
