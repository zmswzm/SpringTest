package com.lxj.util;

public class StringUtil
{
   public static boolean isNotEmpty(String str){
	   if(str==null){
		   return false;
	   }
	   if("".equals(str.trim())){
		   return false;
	   }
	   return true;
   }
}
