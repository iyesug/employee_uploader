<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
		<link rel="stylesheet" type="text/css" href="js/bootstrap.css">
    <title>Login</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function imgfun(img){
			//alert("ok");
			img.src="CheckCodeAction.action?date="+new Date();
		}
	</script>
  </head>
  
  <body>
  
    <form action="LoginAction!login.action" method="post" >
    	账号<input type="text" name="user.name" value="admin"><br/>
    	密码<input type="password" name="password" value="admin"><br />
    	验证<input type="text" name="checkcode"><img src="CheckCodeAction.action" onclick="imgfun(this)"/><br />
    	<input type="submit"><br />
    	${result}
    </form><br />

    
  </body>
</html>
