package com.lxj.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lxj.dao.UserDao;
import com.lxj.entity.User;

@Repository
public  class UserDaoImpl extends BaseDaoImpl implements UserDao {
    
	
	@Override
	public void addUser(User user) {
		String sql = "insert into user(name,phone,email) values (?,?,?) ";
		Object[] params = {user.getName(),user.getPhone(),user.getEmail()};
		crud(sql, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList(Integer pageNo, Integer pageSize) {
		String sql = "select * from user limit ?,?";
		pageNo = (pageNo-1)*pageSize;
		Integer[] params = {pageNo,pageSize};
		return (List<User>) getpageList(sql, params);
	}

	@Override
	public int getCount() {
		String sql = "select count(*) from user";
		return getCount(sql);
	}

	@Override
	public void updateUser(User user) {
		String sql = "update user set name = ?,phone=?, email=? where id = ?";
		Object[] params = {user.getName(),user.getPhone(),user.getEmail(),user.getId()};
		crud(sql, params);
	}

	@Override
	public void deleteUser(int id) {
		String sql = "delete from user where id=?";
		Object[] params = {id};
		crud(sql,params);
		
	}

}
