package com.classmanager.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classmanager.app.model.Assignment;

public interface AssignmentRepo extends JpaRepository<Assignment, Long>{

}
