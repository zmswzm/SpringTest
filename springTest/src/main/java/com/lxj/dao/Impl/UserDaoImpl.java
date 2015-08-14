package com.lxj.dao.Impl;

import org.springframework.stereotype.Repository;

import com.lxj.dao.UserDao;
import com.lxj.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    
	
	@Override
	public void addUser(User user) {
		String sql = "insert into user(name,phone,email) values (?,?,?) ";
		Object[] params = new Object[]{user.getName(),user.getPhone(),user.getEmail()};
		add(sql, params);
	}

}
