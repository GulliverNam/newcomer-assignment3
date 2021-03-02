package com.skcc.stock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

	@GetMapping("/main")
	public String main(){ 
		return "index.html"; 
	} 
	
	@ResponseBody 
	@PostMapping(value="/main", produces="application/x-json")
	public String json(HttpServletRequest request){

		return null;
	}

}