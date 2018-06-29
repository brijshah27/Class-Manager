package com.classmanager.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class User {

	public enum Type {
		STUDENT, PROFESSOR, ADMIN;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	private String email;

	private String fullName;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	private Type type;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="user_course", joinColumns= {@JoinColumn(name="fk_user")}, inverseJoinColumns= {@JoinColumn(name="fk_course")})
	private List<Course> courses;

	public User() {
	}

	public User(Long id, String username, String email, String fullName, String password, Type type) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.type = type;
	}

	public User(Long id, String username, String email, String fullName, String password, Type type,
			List<Course> courses) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.type = type;
		this.courses = new ArrayList<Course>();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
