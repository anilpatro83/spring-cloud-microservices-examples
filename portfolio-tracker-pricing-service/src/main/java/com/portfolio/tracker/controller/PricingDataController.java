package com.portfolio.tracker.controller;

import static com.portfolio.tracker.service.TradingDataService.URL.FUND;
import static com.portfolio.tracker.service.TradingDataService.URL.STOCK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.tracker.model.TradeData;
import com.portfolio.tracker.service.TradingDataService;

@RestController
@RequestMapping("/pricing")
public class PricingDataController {

	@Autowired
	private TradingDataService tradingDataService;

	@RequestMapping(value = "/stock")
	public List<TradeData> findByStockCode(@RequestParam("codes") String codes) {
		return tradingDataService.findTradeDataByCode(STOCK, codes);
	}

	@RequestMapping(value = "/fund")
	public List<TradeData> findByFundCode(@RequestParam("codes") String codes) {
		return tradingDataService.findTradeDataByCode(FUND, codes);
	}

}
