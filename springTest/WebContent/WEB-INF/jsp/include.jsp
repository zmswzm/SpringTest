<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.4.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.4.3/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.4.3/themes/color.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.4.3/demo/demo.css">
    <script type="text/javascript" src="<%=basePath %>js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>jquery-easyui-1.4.3/plugins/jquery.form.js"></script>
</head>

</html>