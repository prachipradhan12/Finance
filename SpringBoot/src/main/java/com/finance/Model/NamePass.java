package com.finance.Model;

public class NamePass {
	private String name;
	private String password;
	
	public NamePass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NamePass(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
