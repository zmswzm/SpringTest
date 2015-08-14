package com.lxj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxj.service.UserService;

@Repository
@Controller
@RequestMapping("/user")
public class UserController {
	
  @Autowired
  private UserService userService;
  public String a;
  
  @RequestMapping("/add")
  public String addUserView(){
	  return "hello";
  }
  
}
