package com.skcc.stock.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.stock.dao.DocumentDao;
import com.skcc.stock.dao.DocumentDaoFactory;
import com.skcc.stock.option.DocumentType;
import com.skcc.stock.util.ConnectionUtils;
import com.skcc.stock.util.HttpUtils;

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	private DocumentDaoFactory factory;
	
	@Override
	public String getStockInfo(HttpServletRequest request) throws Exception {
		ConnectionUtils.ignoreSSL();
		String contentType = HttpUtils.getContentType(request);
		String data = HttpUtils.getData(request);
		DocumentDao dao = null;
		if("json".equals(contentType)) {
			dao = factory.findDocType(DocumentType.Json);
		} else if ("xml".equals(contentType)) {
			dao = factory.findDocType(DocumentType.Xml);
		}
		return dao.fillDocument(data);
	}
}
