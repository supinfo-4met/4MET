package com.zenika.supbook.model;

public class Administrator extends AbstractBusinessObject {
	private String login;
	private String password;
	
	public Administrator() {}

	public Administrator(long id, String login, String password) {
		super();
		this.setId(id);
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
