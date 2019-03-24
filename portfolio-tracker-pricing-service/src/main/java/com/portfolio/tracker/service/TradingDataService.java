package com.portfolio.tracker.service;

import java.util.List;

import com.portfolio.tracker.model.TradeData;

public interface TradingDataService {

	List<TradeData> findTradeDataByCode(URL url, String codes);

	public enum URL {
		STOCK("https://www.worldtradingdata.com/api/v1/stock"),
		FUND("https://www.worldtradingdata.com/api/v1/mutualfund");
		
		private String url;

		URL(String url) {
			this.url = url;
		}

		public String getBaseUrl() {
			return url;
		}

	}
}
