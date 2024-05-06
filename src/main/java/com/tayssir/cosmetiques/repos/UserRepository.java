package com.tayssir.cosmetiques.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tayssir.cosmetiques.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername (String username);
	}
