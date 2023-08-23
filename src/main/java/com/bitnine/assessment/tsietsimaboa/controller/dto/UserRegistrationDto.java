package com.bitnine.assessment.tsietsimaboa.controller.dto;

public class UserRegistrationDto {

	private String firstname;
	private String lastname;
	private String telephone;
	private String email;
	private String username;
	private String password;
	
	public UserRegistrationDto() {
		
	}
	
	public UserRegistrationDto(String Firstname, String Lastname, String Telephone, String Email, String Username, String Password) {
		super();
		this.firstname = Firstname;
		this.lastname = Lastname;
		this.telephone = Telephone;
		this.email = Email;
		this.username = Username;
		this.password = Password;
	}
	
	public void setFirstname(String Firstname) {
		this.firstname = Firstname;
	}
	
	public void setLastname(String Lastname) {
		this.lastname = Lastname;
	}
	
	public void setTelephone(String Telephone) {
		this.telephone = Telephone;
	}
	
	public void setEmail(String Email) {
		this.email = Email;
	}
	
	public void setUsername(String Username) {
		this.username = Username;
	}
	
	public void setPassword(String Password) {
		this.password = Password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
