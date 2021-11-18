<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tìm kiếm</title>
<link rel="stylesheet" type="text/css" href="./css/search.css">
</head>
<body>
	<% 
	if (session.getAttribute("user") != null) {
	%>
		<h1>Welcome <%= session.getAttribute("user") %></h1>
	<% } %>
	<div class="main">
        <div class="container">
            <form action="Search" method="POST">
                <input type="text" name="inp" class="form-control">
                <input class="btn" type="Submit" value="Tìm kiếm">
            </form>
        </div>
    </div>
</body>
</html>