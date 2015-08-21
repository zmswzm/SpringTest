package com.lxj.dao;

import java.util.List;

import com.lxj.entity.User;




public interface UserDao {
   public void addUser(User user);
   public void updateUser(User user);
   public void deleteUser(int id);
   public List<User> getUserList(Integer pageNo,Integer pageSize);
   public int getCount();
}
