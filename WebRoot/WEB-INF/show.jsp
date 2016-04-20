<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'fail.jsp' starting page</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="js/bootstrap.css">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div id="a">

		<table border="1" align="center">


			<tr>
				<td width="150" align="center">头像</td>
				<td width="150" align="center">名字</td>
				<td width="150" align="center">部门</td>
				<td width="150" align="center">职务</td>
				<td colspan="2" width="150" align="center"><s:a
						action="SelectAction!execute.action">添加</s:a></td>
			</tr>
			<s:iterator value="#request.listemp" id="emp">
				<tr>
	
					<td  width="100"  height="100" align="center"><img src="<s:property value="img" />" width="100%" height="100%" /></td>
					<td width="150" align="center"><s:property value="name" />
					</td>
					
					<td width="150" align="center"><s:property value="department" /></td>
							
					<td width="150" align="center"><s:property value="job" />
					</td>
					
					<td align="center"><s:a
							action="SelectAction!del?emp.name=%{name}">删除</s:a></td>
							
					<td align="center"><s:a
							action="SelectAction!upDate?emp.name=%{name}">修改</s:a></td>
				</tr>
			</s:iterator>

		</table>
	</div>


</body>
</html>
