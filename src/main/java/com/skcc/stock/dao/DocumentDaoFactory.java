package com.skcc.stock.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skcc.stock.option.DocumentType;

@Component
public class DocumentDaoFactory {
	private Map<DocumentType, DocumentDao> docs;
	
	@Autowired
	public DocumentDaoFactory(Set<DocumentDao> docSet) {
		createDoc(docSet);
	}
	
	public DocumentDao findDocType(DocumentType documentType) {
		return docs.get(documentType);
	}

	private void createDoc(Set<DocumentDao> docSet) {
		docs = new HashMap<DocumentType, DocumentDao>();
		docSet.forEach(doc -> docs.put(doc.getDocumentType(), doc));
	}
}
