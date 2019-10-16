package com.chanduvisiesquendaniel.prjstudyclub.app.models.documents;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="student")
public class Student extends Family{
	
	@Id
	private String id;
	
	private List<Family> parents;
	
	private List<Family> brothers;
	
	private Family spouse;

	public Student(String id, String fullname, char sexuality, Date birthDay, String documentType,
			String numberDocument, String id2, List<Family> parents, List<Family> brothers, Family spouse) {
		super(id, fullname, sexuality, birthDay, documentType, numberDocument);
		id = id2;
		this.parents = parents;
		this.brothers = brothers;
		this.spouse = spouse;
	}

	public Student() {
		super();
	}

	public Student(String id, String fullname, char sexuality, Date birthDay, String documentType,
			String numberDocument) {
		super(id, fullname, sexuality, birthDay, documentType, numberDocument);
	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Family> getParents() {
		return parents;
	}

	public void setParents(List<Family> parents) {
		this.parents = parents;
	}

	public List<Family> getBrothers() {
		return brothers;
	}

	public void setBrothers(List<Family> brothers) {
		this.brothers = brothers;
	}

	public Family getSpouse() {
		return spouse;
	}

	public void setSpouse(Family spouse) {
		this.spouse = spouse;
	}
	
	
	
	
	
	
		
}
