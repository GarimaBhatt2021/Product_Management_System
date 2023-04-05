package com.productManagement.serviceImpl;

import org.springframework.stereotype.Service;
import com.productManagement.dao.UserDao;
import com.productManagement.entities.User;
import com.productManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	 private UserDao userDao;

	    public UserServiceImpl(UserDao userDao) {
	        this.userDao = userDao;
	    }

	    public User saveUser(User user){
	        return userDao.save(user);
	    }

	    public Integer isUserPresent(User user){
	        User user1 = userDao.getUserByName(user.getName());
	        return user1!=null ? user1.getId(): null ;
	    }

	}