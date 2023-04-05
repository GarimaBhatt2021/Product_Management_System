package com.productManagement.service;

import com.productManagement.entities.User;

public interface UserService {

	User saveUser(User user);

	Integer isUserPresent(User user);

}
