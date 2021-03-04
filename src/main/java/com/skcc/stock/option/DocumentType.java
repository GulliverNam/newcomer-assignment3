package com.skcc.stock.option;

public enum DocumentType {
	Json("json", "JSON"), Xml("xml", "XML");
	
	private String lowerCase;
	private String upperCase;
	
	DocumentType(String lowerCase, String upperCase) {
		this.lowerCase = lowerCase;
		this.upperCase = upperCase;
	}

	public String getLowerCase() {
		return lowerCase;
	}

	public String getUpperCase() {
		return upperCase;
	}

}
