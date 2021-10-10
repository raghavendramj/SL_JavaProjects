package com.simplilearn.modal;

public class Employee {

	private Long id;
	private String username;
	private String password;
	private String email;
	private String country;

	public Employee() {
	}

	public Employee(Long id, String username, String password, String email, String country) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
