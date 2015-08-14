package com.lxj.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxj.dao.UserDao;
import com.lxj.entity.User;
import com.lxj.service.UserService;
@Repository
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserDao userDao;
	@Override
	public boolean addUser(User user) {
		userDao.addUser(user);
		return true;
	}


}
