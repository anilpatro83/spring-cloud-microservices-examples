package com.portfolio.tracker.service.util;

import static org.springframework.http.HttpMethod.GET;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.portfolio.tracker.model.PortfolioData;
import com.portfolio.tracker.model.UserQuote;

@Component
public class ServiceUtil {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${pricing.service.url}")
	private String pricingService;

	@Value("${db.service.url}")
	private String dbService;

	public List<UserQuote> callDBService(Long userId) {
		ParameterizedTypeReference<List<UserQuote>> responseType = new ParameterizedTypeReference<List<UserQuote>>() {};
		String dbServiceURL = dbService + userId;
		ResponseEntity<List<UserQuote>> response = restTemplate.exchange(dbServiceURL, GET, null, responseType);
		return response != null ? response.getBody() : Collections.emptyList();
	}

	public List<PortfolioData> callPricingService(String codes, String type) {
		ParameterizedTypeReference<List<PortfolioData>> responseType = new ParameterizedTypeReference<List<PortfolioData>>() {};
		String pricingUrl = pricingService + "/" + type + "?codes=" + codes;
		ResponseEntity<List<PortfolioData>> response = restTemplate.exchange(pricingUrl, GET, null, responseType);
		return response != null ? response.getBody() : Collections.emptyList();
	}

}
