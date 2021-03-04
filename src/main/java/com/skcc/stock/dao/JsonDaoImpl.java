package com.skcc.stock.dao;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.skcc.stock.option.DocumentType;
import com.skcc.stock.option.Stock;
import com.skcc.stock.util.ConnectionUtils;

@Component
public class JsonDaoImpl implements DocumentDao {
	
	@Override
	public String fillDocument(String data) throws IOException {
		JsonNode json = Stock.mapper.readValue(data, JsonNode.class);
		JsonNode items = json.get("items");
		for(JsonNode item : items) {
		    JsonNode stockInfo = ConnectionUtils.getResponse(item.get("cd").toString().replaceAll("\"", ""));
		    ((ObjectNode)item).remove("cd");
		    for(String key : Stock.codeMap.keySet()) {
		    	((ObjectNode)item).put(Stock.codeMap.get(key), stockInfo.get(key).toString().replaceAll("\"", ""));
		    }
		}
		return json.toPrettyString();
	}
	
	@Override
	public DocumentType getDocumentType() {
		return DocumentType.Json;
	}
	
}
