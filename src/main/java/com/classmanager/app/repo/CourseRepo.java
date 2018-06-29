package com.classmanager.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.classmanager.app.model.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

}
