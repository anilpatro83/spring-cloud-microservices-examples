package com.portfolio.tracker.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@JsonDeserialize(using = FolioData.FolioDataDeserializer.class)
public class FolioData implements Serializable {

	private static final long serialVersionUID = -1596638363469089665L;

	private List<TradeData> tradeData = null;

	public List<TradeData> getTradeData() {
		return tradeData;
	}

	public void setTradeData(List<TradeData> tradeData) {
		this.tradeData = tradeData;
	}

	static class FolioDataDeserializer extends StdDeserializer<FolioData> {

		private static final long serialVersionUID = -2131618099124895221L;

		public FolioDataDeserializer() {
			this(null);
		}

		protected FolioDataDeserializer(Class<?> vc) {
			super(vc);
		}

		@Override
		public FolioData deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			FolioData folioData = new FolioData();
			JsonNode rootNode = p.getCodec().readTree(p);
			JsonNode data = rootNode.path("data");
			if (data.isMissingNode()) {
				folioData.setTradeData(Collections.emptyList());
			} else {
				TradeData tradeData = null;
				List<TradeData> dataList = new ArrayList<>();
				for (JsonNode node : data) {
					tradeData = new TradeData();
					tradeData.setCode(node.path("symbol").asText());
					tradeData.setDescription(node.path("name").asText());
					tradeData.setCurrentPrice(node.path("price").asDouble());
					dataList.add(tradeData);
				}
				folioData.setTradeData(dataList);
			}
			return folioData;
		}

	}

}
