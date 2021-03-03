package com.skcc.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skcc.stock.dto.JsonItem;
import com.skcc.stock.dto.JsonItems;
import com.skcc.stock.dto.XmlItem;
import com.skcc.stock.dto.XmlItems;

// Controller단에서 전문처리 부분 적용

@Controller
public class MainController {

	@GetMapping("/main")
	public String main(){ 
		return "index.html"; 
	}
	
	@ResponseBody 
	@PostMapping(value="/main", produces="application/json")
	public String json(@RequestBody JsonItems items){
		System.out.println("post json");
		for (JsonItem item : items.getItems()) {
			System.out.println(item);
		}
		return null;
	}
	
	@ResponseBody 
	@PostMapping(value="/main", produces="text/xml")
	public String xml(@RequestBody XmlItems xmlItems){
		System.out.println("post xml");
		for(XmlItem item : xmlItems.getItems()) {
			System.out.println(item);
		}
		return null;
	}

	
}
