<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="/js/jquery-2.2.1.js"></script>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
		<script type="text/javascript">

	</script>
  </head>
  
  <body>
    <form action="ChangeAction.action" method="post" >

    	姓名<input type="text" name="emp.name" disabled="true " value="${name}"> <br />

    	  部门    	  		<s:select name="emp.department" list="listDep" value="emp.department" 
    	  		listKey="name" listValue="name" ></s:select>
    	  		
 <br/>
    
      职务	<s:select name="emp.job" list="listjob" value="emp.job" 
      listKey="name" listValue="name"></s:select>
  <br/>
<input type="submit" value="确定">

    </form>
         
     ${result};
         

  </body>
</html>
