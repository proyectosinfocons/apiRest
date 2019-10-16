package com.chanduvisiesquendaniel.prjstudyclub.app.models.documents;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "family")
public class Family {
	
	@Id
	private String id;

	@NotEmpty
	private String fullname;

	@NotEmpty
	private char sexuality;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDay;

	@NotEmpty
	private String documentType;

	@NotEmpty
	private String numberDocument;

	public Family(String id, String fullname, char sexuality, Date birthDay,
			String documentType, String numberDocument) {
		
		this.id = id;
		this.fullname = fullname;
		this.sexuality = sexuality;
		this.birthDay = birthDay;
		this.documentType = documentType;
		this.numberDocument = numberDocument;
	}

	public Family() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public char getSexuality() {
		return sexuality;
	}

	public void setSexuality(char sexuality) {
		this.sexuality = sexuality;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}
	
	
	


	
	
	
	
	

}
