package com.portfolio.tracker.service;

import java.util.List;

import com.portfolio.tracker.model.PortfolioData;

public interface PortfolioService {

	List<PortfolioData> getStockQuotes(Long userId);

	List<PortfolioData> getFundQuotes(Long userId);

}
