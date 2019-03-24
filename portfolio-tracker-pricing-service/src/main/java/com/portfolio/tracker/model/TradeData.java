package com.portfolio.tracker.model;

import java.io.Serializable;

public class TradeData implements Serializable {
	private static final long serialVersionUID = 7863704535254790739L;

	public TradeData() {
	}

	private String code;
	private String description;
	private Double currentPrice;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	
}
