<%@page import="java.util.ArrayList"%>
<%@page import="Modal.BEAN.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách nhân viên</title>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<style>
.form {
    display: flex;
    flex-direction: column;
}
.del-mul-btn {
    margin: 10px 10px 0 auto;
}
</style>
</head>
<body>
	<% if (session.getAttribute("user") != null) { %>
		<h1>Welcome <%= session.getAttribute("user") %></h1>
	<% }
	ArrayList<Admin> listUser = (ArrayList<Admin>) request.getAttribute("ListUser"); 
	if (listUser.size() > 0) {
		%>
	<table border="1" width="100%">
		<caption>Danh sách user</caption>
		<tr>
		    <th>Role</th>
		    <th>Tên tài khoản</th>
		    <th>Họ</th>
		    <th>Tên</th>
		    <% 
			if (session.getAttribute("isAdmin") != null) {
				if ((boolean) session.getAttribute("isAdmin") == true) {
			%>
			<th></th>
    		<th></th>
			<%	}
			} %>
		</tr>
	<%	for (int i = 0; i < listUser.size(); i++) { %>
		<tr>
			<td><%= listUser.get(i).getRole() %></td>
			<td><%= listUser.get(i).getUsername() %></td>
			<td><%= listUser.get(i).getFirstname() %></td>
			<td><%= listUser.get(i).getLastname() %></td>
			<% 
			if (session.getAttribute("isAdmin") != null) {
				if ((boolean) session.getAttribute("isAdmin") == true) {
			%>
			<td><a href="UpdateUser?username=<%= listUser.get(i).getUsername() %>">Cập nhật</a></td>
			<td><a href="DeleteUser?username=<%= listUser.get(i).getUsername() %>">Xóa</a></td>
			<% 	}
			} %>
		</tr>
		<% } %>
	</table>
	
	<% } else { %>
	<h3>Không có kết quả nào</h3>
	<% } %>
	
</body>
</html>