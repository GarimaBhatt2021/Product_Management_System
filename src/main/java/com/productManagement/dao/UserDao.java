package com.productManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.productManagement.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	 public User getUserByName(String name);
	
}
