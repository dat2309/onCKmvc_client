package com.se.onck3client.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CreditCard {
	
	private Integer id;
	
	
	private String numer;
	
	
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumer() {
		return numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CreditCard(Integer id, String numer, String type) {
		super();
		this.id = id;
		this.numer = numer;
		this.type = type;
	}

	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}