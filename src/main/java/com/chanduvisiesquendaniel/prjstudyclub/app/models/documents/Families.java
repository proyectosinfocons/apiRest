package com.chanduvisiesquendaniel.prjstudyclub.app.models.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="families")
public class Families {
	@Id
	private String id;
	
	private List<Family> members;
	
	public Families(String id, List<Family> members) {
		
		this.id = id;
		this.members = members;
	}
	
	public Families() {}
	
	public Families(List<Family> members) {
		this.members= members;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Family> getMembers() {
		return members;
	}
	public void setMembers(List<Family> members) {
		this.members = members;
	}
	
	
	
	
	
	

}
