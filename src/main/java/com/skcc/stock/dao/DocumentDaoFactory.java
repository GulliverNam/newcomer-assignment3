package com.skcc.stock.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skcc.stock.option.DocumentType;

@Component
public class DocumentDaoFactory {
	private Map<DocumentType, DocumentDao> documents;
	
	@Autowired
	public DocumentDaoFactory(Set<DocumentDao> documentSet) {
		createDoc(documentSet);
	}
	
	public DocumentDao findDocType(DocumentType documentType) {
		return documents.get(documentType);
	}

	private void createDoc(Set<DocumentDao> documentSet) {
		documents = new HashMap<DocumentType, DocumentDao>();
		documentSet.forEach(doc -> documents.put(doc.getDocumentType(), doc));
	}
}
