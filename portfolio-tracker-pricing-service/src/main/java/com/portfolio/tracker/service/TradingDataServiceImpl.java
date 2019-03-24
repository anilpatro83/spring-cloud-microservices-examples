package com.portfolio.tracker.service;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.tracker.model.FolioData;
import com.portfolio.tracker.model.TradeData;

@Service
public class TradingDataServiceImpl implements TradingDataService {

	@Value("${finance.api.token}")
	private String token;

	@Override
	public List<TradeData> findTradeDataByCode(URL url, String codes) {
		return getTradingData(url.getBaseUrl() + "?symbol=" + codes + "&api_token=" + token);
	}

	private List<TradeData> getTradingData(String url) {
		FolioData data = null;
		HttpClient httpClient = null;
		try {
			httpClient = HttpClientBuilder.create().build();
			HttpGet getRequest = new HttpGet(url);
			getRequest.addHeader("accept", "application/json");
			HttpResponse response = httpClient.execute(getRequest);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}
			ObjectMapper mapper = new ObjectMapper();
			data = mapper.readValue(EntityUtils.toString(response.getEntity()), FolioData.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
		}
		return data.getTradeData();
	}

}
