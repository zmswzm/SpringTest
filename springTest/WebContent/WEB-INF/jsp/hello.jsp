<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
<script type="text/javascript">
 function check(){
	 var value= document.getElementById("idNo").value;
	 var regex =  /^\d{6}(18|19|20)\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/;
	 if(regex.test(value)){
		 alert("验证通过！");
	 }else{
		 alert("验证不通过！");
	 }
	 
 }
</script>
</head>
<body>
${message}
<input type="text" id="idNo" onblur="check()">
</body>
</html>