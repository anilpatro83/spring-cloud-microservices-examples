package com.portfolio.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.tracker.model.PortfolioData;
import com.portfolio.tracker.service.PortfolioService;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

	@Autowired
	private PortfolioService portfolioService;

	@RequestMapping(value = "/stock/{userId}")
	public List<PortfolioData> getStocksByUser(@PathVariable("userId") Long userId) {
		return portfolioService.getStockQuotes(userId);

	}

	@RequestMapping(value = "/fund/{userId}")
	public List<PortfolioData> getFundsByUser(@PathVariable("userId") Long userId) {
		return portfolioService.getFundQuotes(userId);

	}

}
