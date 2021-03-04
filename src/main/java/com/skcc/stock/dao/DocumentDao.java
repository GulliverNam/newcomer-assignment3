package com.skcc.stock.dao;

import com.skcc.stock.option.DocumentType;

public interface DocumentDao {
	public String fillDocument(String data) throws Exception;
	DocumentType getDocumentType();
}
