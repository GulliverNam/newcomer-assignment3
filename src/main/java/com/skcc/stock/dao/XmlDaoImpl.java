package com.skcc.stock.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.skcc.stock.option.DocumentType;
import com.skcc.stock.option.Stock;
import com.skcc.stock.util.JsonUtils;

@Component
public class XmlDaoImpl implements DocumentDao {
	
	@Override
	public String fillDocument(String data) throws IOException, JDOMException {
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream xmlStream = new ByteArrayInputStream(data.getBytes("UTF-8"));
		Document xml = saxBuilder.build(xmlStream);
		List<Element> xmlInput = xml.getRootElement().getChildren();
		
		for(Element item : xmlInput) {
	        JsonNode stockInfo = JsonUtils.getResponse(item.getAttributeValue("code"));
	        item.removeAttribute("cd");
	        for(String key : Stock.codeMap.keySet()) {
	        	item.setAttribute(Stock.codeMap.get(key), stockInfo.get(key).toString().replaceAll("\"", ""));
	        }
		}
		
		return new XMLOutputter(Format.getPrettyFormat()).outputString(xml);
	}

	@Override
	public DocumentType getDocumentType() {
		return DocumentType.Xml;
	}

}
