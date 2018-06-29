package com.classmanager.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classmanager.app.model.User;

public interface UserRepo extends JpaRepository<User,Long> {

}
