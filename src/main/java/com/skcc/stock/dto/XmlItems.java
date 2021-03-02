package com.skcc.stock.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="items")
public class XmlItems {
	@XmlElement(name="item")
	private List<XmlItem> items;

	public XmlItems() {
	}
	
	public XmlItems(List<XmlItem> items) {
		this.items = items;
	}

	public List<XmlItem> getItems() {
		return items;
	}

	public void setItems(List<XmlItem> items) {
		this.items = items;
	}
	
}
