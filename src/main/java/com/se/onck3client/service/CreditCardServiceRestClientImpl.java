package com.se.onck3client.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.onck3client.model.CreditCard;

@Service
public class CreditCardServiceRestClientImpl implements CreditCardService{
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());
	private RestTemplate restTemplate;
	
	

	public CreditCardServiceRestClientImpl(@Value("${crm.rest.url.credit}") String restUrl,RestTemplate restTemp) {
		super();
		crmRestUrl = restUrl;
		restTemplate = restTemp;
		logger.info("Loaded properties: "+crmRestUrl);
	}

	@Override
	public List<CreditCard> getCreditCards() {
		ResponseEntity<List<CreditCard>> responseEntity = restTemplate.exchange(crmRestUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<CreditCard>>() {});
		List<CreditCard> list = responseEntity.getBody();
		return list;
	}

	@Override
	public CreditCard getCreditCard(int id) {
		CreditCard c = restTemplate.getForObject(crmRestUrl+"/"+id, CreditCard.class);
		return c;
	}

	@Override
	public void deleteCreditCard(int id) {
		restTemplate.delete(crmRestUrl+"/"+id);
		
	}

	@Override
	public void saveCreditCard(CreditCard creditCard, int personId) {
		if(creditCard.getId() == null) {
			restTemplate.postForEntity(crmRestUrl, creditCard, String.class);
		}else {
			restTemplate.put(crmRestUrl, creditCard);
		}
		
	}

}
