<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%= a %>
<% int a = 10; %>
<%! int a = 20; %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login screen</title>
</head>
<body>
	<%
		String temp = "haha";
		session.setAttribute("temp", temp);
	%>
	<form action="checkLogin.jsp" method="post">
		User_name: <input type="text" name="username" />
		Password: <input type="password" name="password" />
		<input type="submit" value="Login" />
		<input type="reset" value="Reset" />
	</form>
</body>
</html>