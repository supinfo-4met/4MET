package com.zenika.supbook.model;

public class User extends AbstractBusinessObject {
	private String login;
	private String email;

	public User() {
	}
	
	public User(long id, String login, String email) {
		this.setId(id);
		this.login = login;
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
