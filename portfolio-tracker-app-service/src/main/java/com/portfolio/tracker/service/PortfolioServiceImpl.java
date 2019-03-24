package com.portfolio.tracker.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.tracker.model.PortfolioData;
import com.portfolio.tracker.model.UserQuote;
import com.portfolio.tracker.service.util.ServiceUtil;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	private ServiceUtil util;

	@Override
	public List<PortfolioData> getStockQuotes(Long userId) {

		return getCurrentFinancialData(userId, "stock");

	}

	@Override
	public List<PortfolioData> getFundQuotes(Long userId) {

		return getCurrentFinancialData(userId, "fund");

	}

	public List<PortfolioData> getCurrentFinancialData(Long userId, String type) {

		// calling db micro-service to fetch quotes associated an user.

		List<UserQuote> quotes = util.callDBService(userId);
		if (quotes != null && !quotes.isEmpty()) {

			Map<String, UserQuote> quoteMap = quotes.stream().filter(quote -> quote.getType().equalsIgnoreCase(type))
					.collect(Collectors.toMap(UserQuote::getQuote, Function.identity()));

			// calling pricing micro-service to fetch fresh pricing quotes.

			List<PortfolioData> portfolioData = util.callPricingService(String.join(",", quoteMap.keySet()), type);

			return getProcessedData(portfolioData, quoteMap);

		}

		return Collections.emptyList();
	}

	private List<PortfolioData> getProcessedData(List<PortfolioData> portfolioData, Map<String, UserQuote> quoteMap) {

		portfolioData.forEach(new Consumer<PortfolioData>() {

			@Override
			public void accept(PortfolioData data) {
				UserQuote quote = quoteMap.get(data.getCode());
				data.setTotalValue(quote.getQuantity() * data.getCurrentPrice());
				data.setProfitMargin(data.getTotalValue() - (quote.getQuantity() * quote.getPrice()));
				data.setPurchasePrice(quote.getPrice());
				data.setQuantity(quote.getQuantity());
				data.setPurchaseDate(quote.getDate());
			}
		});
		return portfolioData;
	}

}
