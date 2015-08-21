package com.lxj.service;

import java.util.List;

import com.lxj.entity.User;

public interface UserService {
   public boolean addUser(User user);
   public boolean updateUser(User user);
   public boolean deleteUser(int id);
   public List<User> getUserListByPage(int pageNo,int pageSize);
   public int getTotal();
}
