package com.lxj.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxj.entity.Referral;
import com.lxj.entity.User;
import com.lxj.service.ReferralService;

@Controller
@RequestMapping("/treatment")
public class ReferralController
{
  @Autowired
  private ReferralService referralService;
  @RequestMapping("/list.do")
  public String listView(){
	  return "treatment/list";
  }
  
  @RequestMapping("/listExe.do")
  @ResponseBody
  public HashMap<String,Object> list(int page,int rows,Referral referral,HttpServletRequest request){
	  HashMap<String,Object> map = new HashMap<String,Object>();
	  //获取当前登录用户信息
	  HttpSession session = request.getSession();
	  User user = (User) session.getAttribute("user");
	  int total = referralService.countReferral(referral,user);
	  List<Referral> list = referralService.getReferralList(page, rows, referral,user);
	  map.put("total", total);
	  map.put("rows", list);
	  return map;
  }
}
