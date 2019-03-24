package com.portfolio.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.tracker.dto.Quote;
import com.portfolio.tracker.dto.repo.QuoteRepository;

@RestController
@RequestMapping("/quotes")
public class QuoteController {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@RequestMapping(value="/{userId}")
	public List<Quote> getFundsByUser(@PathVariable("userId") Long userId) {
		return quoteRepository.findByUserId(userId);
	}

	@RequestMapping(name="/", method= RequestMethod.POST)
	public Quote create(@RequestBody Quote fund) {
		return quoteRepository.save(fund);
	}

}
