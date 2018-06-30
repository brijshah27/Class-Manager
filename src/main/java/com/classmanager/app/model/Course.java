package com.classmanager.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String courseName;
	
	private String courseId;

	@ManyToMany(mappedBy = "courses")
	private List<User> users;

	@OneToMany(mappedBy = "course")
	private List<Assignment> assignments = new ArrayList<Assignment>();

	public Course(Long id, String courseName, String courseId ,List<User> users, List<Assignment> assignments) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseId = courseId;
		this.users = users;
		this.assignments = assignments;
	}

	public Course() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	

}
