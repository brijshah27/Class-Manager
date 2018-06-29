package com.classmanager.app.model;

import java.io.File;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Assignment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private File assignment;
	
	@ManyToOne
	@JoinColumn(name="fk_course")
	private Course course;
	
	private Date dueDate;
	
	public Assignment() {
	}

	public Assignment(Long id, File assignment, Course course, Date dueDate) {
		super();
		this.id = id;
		this.assignment = assignment;
		this.course = course;
		this.dueDate = dueDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public File getAssignment() {
		return assignment;
	}

	public void setAssignment(File assignment) {
		this.assignment = assignment;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
}
