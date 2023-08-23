package com.bitnine.assessment.tsietsimaboa.model;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "userTable")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@Column(name = "firstname", length = 50, nullable = false)
	private String firstname;
	
	@Column(name = "lastname", length = 50, nullable = false)
	private String lastname;
	
	@Column(name = "telephone", length = 20, nullable = false)
	private String telephone;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", length = 250, nullable = false)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable (
			name = "users_roles",
			joinColumns = @JoinColumn (
					name = "user_id", referencedColumnName = "user_id"),
			inverseJoinColumns = @JoinColumn (
					name = "role_id", referencedColumnName = "role_id"))
	
	private Collection<Role> usertypes;
	
	public User() {
		
	}
	
	public User(String Firstname, String Lastname, String Telephone, String Email, String Username, String Password, Collection<Role> Usertypes) {
		super();
		this.firstname = Firstname;
		this.lastname = Lastname;
		this.email = Email;
		this.telephone = Telephone;
		this.username = Username;
		this.password = Password;
		this.usertypes = Usertypes;
	}
	
	public void setId(Long id) {
		this.user_id = id;
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
	
	public void setUsertypes(Collection<Role> Usertypes) {
		this.usertypes = Usertypes;
	}
	
	public Long getId() {
		return user_id;
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
	
	public Collection<Role> getUsertypes() {
		return usertypes;
	}
}
