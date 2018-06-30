package com.classmanager.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classmanager.app.model.Assignment;
import com.classmanager.app.repo.AssignmentRepo;

@RestController
@RequestMapping(value="/Assignments", produces= {MediaType.APPLICATION_JSON_VALUE })
public class AssignmentController {
	@Autowired
	private AssignmentRepo assignmentRepo;

	@PostMapping
	private void addAssignemnt(Assignment assignment) {
		assignmentRepo.save(assignment);
	}
	
	@GetMapping
	private List<Assignment> getAll(){
		return assignmentRepo.findAll();
	}
	
	@GetMapping(value="course/{id}")
	private List<Assignment> getByCourseId(@PathVariable("id") Long id){
		return assignmentRepo.findByCourseId(id);
	}
}
