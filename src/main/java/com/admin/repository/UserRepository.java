package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	 User findByEmail(String email);

}
