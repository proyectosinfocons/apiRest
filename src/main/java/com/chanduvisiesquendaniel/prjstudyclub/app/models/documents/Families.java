package com.chanduvisiesquendaniel.prjstudyclub.app.models.documents;

import java.util.List;

public class Families {
	private String id;
	private List<Family> members;
	public Families(String id, List<Family> members) {
		
		this.id = id;
		this.members = members;
	}
	public Families() {}
	
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
