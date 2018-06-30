package com.classmanager.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.classmanager.app.model.Course;
import com.classmanager.app.repo.CourseRepo;

@RestController
@RequestMapping(value="/Course", produces= {MediaType.APPLICATION_JSON_VALUE })
public class CourseController {
	
	@Autowired
	private CourseRepo courseRepo;

	@GetMapping
	private List<Course> getAll(){
		return courseRepo.findAll();
	}
	
	@PostMapping
	private void addCourse(Course course) {
		courseRepo.save(course);
	}
	
	@GetMapping(value="/{id}")
	private Optional<Course> getCourseById(@PathVariable("id") Long id) {
		return courseRepo.findById(id);
	}
	
	@GetMapping(value="delete/{id}")
	private void deleteCourse(@PathVariable("id") Long id) {
		courseRepo.deleteById(id);
	}
	
}
