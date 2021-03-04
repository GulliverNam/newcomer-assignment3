package com.skcc.stock.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public interface StockService {
	public String getStockInfo(HttpServletRequest request) throws Exception;
}

