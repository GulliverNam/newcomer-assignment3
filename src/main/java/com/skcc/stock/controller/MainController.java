package com.skcc.stock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skcc.stock.service.StockService;

@Controller
public class MainController {
	
	@Autowired
	StockService service;
	
	@GetMapping("/main")
	public String main(){ 
		return "index.html"; 
	}
	
	@ResponseBody 
	@PostMapping("/main")
	public String json(HttpServletRequest request){
		String result = null;
		try {
			result = service.getStockInfo(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
