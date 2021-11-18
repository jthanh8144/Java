<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tìm kiếm</title>
<link rel="stylesheet" type="text/css" href="./css/home.css">
</head>
<body>
	<% 
	if (session.getAttribute("user") != null) {
	%>
		<h1>Welcome <%= session.getAttribute("user") %></h1>
	<% } %>
	<ul class="list">
        <li class="item">
            <a href="search.jsp" class="link">Tìm kiếm</a>
        </li>
        <% 
		if (session.getAttribute("isAdmin") != null) {
			if ((boolean) session.getAttribute("isAdmin") == true) {
		%>
		<li class="item">
			<a href="ViewAllUser" class="link">Danh sách tài khoản</a>
		</li>
		<% 	}
		} %>
        <li class="item">
            <a href="Logout" class="link">Đăng xuất</a>
        </li>
    </ul>
</body>
</html>