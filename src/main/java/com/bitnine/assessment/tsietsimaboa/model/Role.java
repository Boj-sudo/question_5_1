package com.bitnine.assessment.tsietsimaboa.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roleTable")
public class Role {

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long role_id;
	
	@Column(name = "usertype", length = 50, nullable = false)
	private String usertype;
	
	@ManyToMany(mappedBy = "usertypes")
	private Collection<User> users;
	
	public Role() {
		
	}
	
	public Role(Long id) {
		super();
		this.role_id = id;
	}
	
	public Role(String usertype) {
		super();
		this.usertype = usertype;
	}
	
	public void setId(Long id) {
		this.role_id = id;
	}
	
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
	public Long getId() {
		return role_id;
	}
	
	public String getUsertype() {
		return usertype;
	}
	
	public Collection<User> getUsers() {
		return users;
	}
}
