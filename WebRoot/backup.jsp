<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>备份接口测试</title>

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
	<h1>备份测试接口</h1>
	<br>
	<br>
	<form action="servlet/DoloadServlet" method="post" enctype="multipart/form-data">
		USERID<input type="text" name="Id"><br><br>
	    USERNAME<input type="text" name="Username"><br><br> 
		USERFILE<input type="file" name="Ufile"><br><br>
		<input type="submit" value="保 存">
	</form>
</body>
</html>
