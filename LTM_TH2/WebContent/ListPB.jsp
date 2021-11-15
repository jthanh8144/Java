<%@page import="java.util.ArrayList"%>
<%@page import="Modal.BEAN.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phòng ban</title>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
</head>
<body>
	<% 
	String mode = "";
	if (request.getParameter("mode") != null) {
		mode = request.getParameter("mode");
	}
	ArrayList<PhongBan> listPB = (ArrayList<PhongBan>) request.getAttribute("ListPB"); 
	if (listPB.size() > 0) {
	switch(mode) {
	case "edit":
	%>
	<table border="1" width="100%">
		<caption>Danh sách phòng ban</caption>
		<tr><th>Mã phòng ban</th><th>Tên phòng ban</th><th>Mô tả</th><th>Nhân viên</th></tr>
	<%
		for (int i = 0; i < listPB.size(); i++) {
		%>
		<tr>
			<td><%= listPB.get(i).getIDPB() %></td>
			<td><%= listPB.get(i).getTenPB() %></td>
			<td><%= listPB.get(i).getMoTa() %></td>
			<td><a href="UIFormPBServlet?mode=edit&IDPB=<%= listPB.get(i).getIDPB() %>">Cập nhập <%= listPB.get(i).getTenPB() %></a></td>
		</tr>
		<% } %>
	</table>
	<% 	break;
	default:
	%>
	<table border="1" width="100%">
		<caption>Danh sách phòng ban</caption>
		<tr><th>Mã phòng ban</th><th>Tên phòng ban</th><th>Mô tả</th><th>Nhân viên</th></tr>
	<%
		for (int i = 0; i < listPB.size(); i++) {
		%>
		<tr>
			<td><%= listPB.get(i).getIDPB() %></td>
			<td><%= listPB.get(i).getTenPB() %></td>
			<td><%= listPB.get(i).getMoTa() %></td>
			<td><a href="XemThongTinNVPBServlet?IDPB=<%= listPB.get(i).getIDPB() %>">Xem nhân viên <%= listPB.get(i).getTenPB() %></a></td>
		</tr>
		<% } %>
	</table>
	<%	break;
	} %>
	<% } else { %>
	<h3>Không có kết quả nào</h3>
	<% } %>
</body>
</html>