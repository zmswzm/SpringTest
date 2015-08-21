package com.lxj.service.Impl;

import java.util.List;

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
		try{
			userDao.addUser(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	@Override
	public List<User> getUserListByPage(int pageNo, int pageSize) {
		return userDao.getUserList(pageNo, pageSize);
	}
	@Override
	public int getTotal() {
		return userDao.getCount();
	}
	@Override
	public boolean updateUser(User user) {
		try{
			userDao.updateUser(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	@Override
	public boolean deleteUser(int id) {
		try{
			userDao.deleteUser(id);
			return true;
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			return false;
		}
	}


}
