package com.skcc.stock.dto;

import java.util.List;

public class JsonItems {
	private List<JsonItem> items;
	
	public JsonItems() {
	}

	public JsonItems(List<JsonItem> items) {
		this.items = items;
	}

	public List<JsonItem> getItems() {
		return items;
	}

	public void setItems(List<JsonItem> items) {
		this.items = items;
	}
	
	
}
