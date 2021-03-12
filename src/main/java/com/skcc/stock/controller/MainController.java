package com.skcc.stock.controller;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skcc.stock.option.DocumentType;
import com.skcc.stock.service.StockService;
import com.skcc.stock.util.ConnectionUtils;
import com.skcc.stock.util.HttpUtils;

@Controller
public class MainController {
	
	@Autowired
	StockService service;
	
	@PostConstruct
	public void init() throws KeyManagementException, NoSuchAlgorithmException {
		ConnectionUtils.ignoreSSL();
	}
	
	@GetMapping("/main")
	public String main(){ 
		return "index.html"; 
	}
	
	@ResponseBody 
	@PostMapping("/main")
	public String json(HttpServletRequest request) throws IOException{
		String contentType = HttpUtils.getContentType(request);
		String data = HttpUtils.getData(request);
		String result = null;
		try {
			if("json".equals(contentType)) {
				result = service.getStockInfo(DocumentType.Json, data);
			} else if ("xml".equals(contentType)) {
				result = service.getStockInfo(DocumentType.Xml, data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
