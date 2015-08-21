package com.lxj.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxj.entity.User;
import com.lxj.service.UserService;

@Repository
@Controller
@RequestMapping("/user")
public class UserController {
	
  @Autowired
  private UserService userService;
  
  @RequestMapping("/userList.do")
  public String userList(){
	return "list";  
  }
  
  @RequestMapping("/userListExe.do")
  @ResponseBody
  public Map<String,Object> userListExe(int page,int rows){
	  Map<String,Object> map = new HashMap<String,Object>(); 
	  List<User> userList = userService.getUserListByPage(page, rows);
	  int count = userService.getTotal();
	  map.put("total", count);
	  map.put("rows", userList);
      return map; 
  }
  
  @RequestMapping("/userAdd.do")
  @ResponseBody
  public  Map<String,Object> userAddExe(User user){
	  Map<String,Object> map = new HashMap<String,Object>(); 
	  map.put("errorMsg", userService.addUser(user));
	  return map;
  }
  
  @RequestMapping("/userUpdate.do")
  @ResponseBody
  public Map<String,Object> userUpdate(User user,int id){
	  Map<String,Object> map = new HashMap<String,Object>();
	  user.setId(id);
	  map.put("errorMsg", userService.updateUser(user));
	  return map;
  }
  
  @RequestMapping("/userDelete.do")
  @ResponseBody
  public Map<String,Object> userDelete(int id){
	  Map<String,Object> map = new HashMap<String,Object>();
	  map.put("errorMsg", userService.deleteUser(id));
	  return map;
  }
}
