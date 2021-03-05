package com.skcc.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.stock.dao.DocumentDao;
import com.skcc.stock.dao.DocumentDaoFactory;
import com.skcc.stock.option.DocumentType;

@Service
public class StockService {
	@Autowired
	private DocumentDaoFactory factory;
	
	public String getStockInfo(DocumentType type, String data) throws Exception {
		DocumentDao dao = factory.findDocType(type);
		return dao.fillDocument(data);
	}
}
