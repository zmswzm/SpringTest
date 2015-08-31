package com.lxj.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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
  @RequestMapping("/userListExt.do")
  @ResponseBody
  public Map<String,Object> userListExt(int page,int limit){
	  Map<String,Object> map = new HashMap<String,Object>(); 
	  List<User> userList = userService.getUserListByPage(page, limit);
	  int count = userService.getTotal();
	  map.put("total", count);
	  map.put("rows", userList);
	  map.put("success", "success");
	  map.put("message", "message");
      return map; 
  }
  
  @RequestMapping("/userAddExt.do")
  @ResponseBody
  public  Map<String,Object> userAddExt(HttpServletRequest request){
	  String jsonUser = getRequestPayLoad(request);
	  User user =this.stringToPOJO(jsonUser,User.class);
	  Map<String,Object> map = new HashMap<String,Object>(); 
	  map.put("errorMsg", userService.addUser(user));
	  return map;
  }
  @RequestMapping("/userDeleteExt.do")
  @ResponseBody
  public Map<String,Object> userDeleteExt(HttpServletRequest request){
	  String jsonUser = getRequestPayLoad(request);
	  User user =this.stringToPOJO(jsonUser,User.class);
	  Map<String,Object> map = new HashMap<String,Object>();
	  map.put("errorMsg", userService.deleteUser(user.getId()));
	  return map;
  }
  @RequestMapping("/userUpdateExt.do")
  @ResponseBody
  public Map<String,Object> userUpdateExt(HttpServletRequest request){
	  Map<String,Object> map = new HashMap<String,Object>();
	  String jsonUser = getRequestPayLoad(request);
	  User user =this.stringToPOJO(jsonUser,User.class);
	  map.put("errorMsg", userService.updateUser(user));
	  return map;
  }
  
  /**
   * 接收RequestPayLoad传递参数
   * @param request
   * @return
   */
  private static String getRequestPayLoad(HttpServletRequest request){
	  StringBuffer para = new StringBuffer();
	  try
	{
		BufferedReader reader = request.getReader();
		char[]buff = new char[1024];  
		int len;  
        while((len = reader.read(buff)) != -1) {  
                 para.append(buff,0, len);  
        }
	} catch (IOException e)
	{
		e.printStackTrace();
	}
	  return para.toString();
  }
  /**
   * 将JSON格式的字符串转为Java POJO
   * @param jsonStr
   * @param entityClass
   * @return
   */
  private static <T> T stringToPOJO(String jsonStr,Class entityClass){
	  ObjectMapper objectMapper = new ObjectMapper();
	  T t = null;
	  try
	{
		t = (T) objectMapper.readValue(jsonStr, entityClass);
	} catch (JsonParseException e)
	{
		e.printStackTrace();
	} catch (JsonMappingException e)
	{
		e.printStackTrace();
	} catch (IOException e)
	{
		e.printStackTrace();
	}
	return t;
  }
}
