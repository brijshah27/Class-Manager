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

import com.classmanager.app.model.User;
import com.classmanager.app.repo.UserRepo;

@RestController
@RequestMapping(value="/User", produces= {MediaType.APPLICATION_JSON_VALUE })
public class UserController {
	@Autowired
	UserRepo userRepo;
	
	@GetMapping
	private List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@PostMapping
	private void addUser(User user) {
		userRepo.save(user);
	}
	
	@GetMapping(value="/{id}")
	private Optional<User> findById(@PathVariable("id") Long id) {
		return userRepo.findById(id);
	}
	
	@GetMapping(value="/delete")
	private void deleteUser(User user) {
		userRepo.delete(user);
	}
	
	@GetMapping(value="/delete/{id}")
	private void deleteUser(@PathVariable("id") Long id) {
		userRepo.deleteById(id);
	}

}
