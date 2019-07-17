package com.st.models;

public class Author {

	private int authId;
	private String authName;
	
	
	
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	
	public Author() {}
	
	public Author(int id, String name) {
		this.authId = id;
		this.authName = name;
	}
	
}
