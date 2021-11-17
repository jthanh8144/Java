<%@page import="java.util.ArrayList"%>
<%@page import="Modal.BEAN.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phòng ban</title>
<link rel="stylesheet" type="text/css" href="./css/styles1.css">
</head>
<body>
	<% session.setAttribute("isLogin", true); %>
	<a href="home.jsp" class="back">Trang chủ</a>
	<div class="main">
		<% if (((String) request.getParameter("mode")).equals("add") == true ) { %>
		<form action="ThemPBServlet" method="POST" class="form" id="form">
			<div class="form-group">
                <label for="IDPB" class="form-label">Mã phòng ban</label>
                <input type="text" id="IDPB" name="IDPB" class="form-control" value="<%= (String) request.getAttribute("nextID") %>" readonly>
            </div>

            <div class="form-group">
                <label for="TenPB" class="form-label">Tên phòng ban</label>
                <input type="text" id="TenPB" name="TenPB" class="form-control">
            </div>

            <div class="form-group">
                <label for="MoTa" class="form-label">Mô tả</label>
                <input type="text" id="MoTa" name="MoTa" class="form-control">
            </div>

            <div class="form-group">
                <input class="btn" type="Submit" value="Thêm phòng ban">
                <input class="btn" type="Reset" value="Reset">
            </div>
        </form>
		<% } else { 
			PhongBan pb = (PhongBan) request.getAttribute("PhongBan");
		%>
		<form action="CapNhapPBServlet" method="POST" class="form" id="form">
			<div class="form-group">
                <label for="IDPB" class="form-label">Mã phòng ban</label>
                <input type="text" id="IDPB" name="IDPB" class="form-control" value="<%= pb.getIDPB() %>" readonly>
            </div>

            <div class="form-group">
                <label for="TenPB" class="form-label">Tên phòng ban</label>
                <input type="text" id="TenPB" name="TenPB" class="form-control" value="<%= pb.getTenPB() %>">
            </div>

            <div class="form-group">
                <label for="MoTa" class="form-label">Mô tả</label>
                <input type="text" id="MoTa" name="MoTa" class="form-control" value="<%= pb.getMoTa() %>">
            </div>

            <div class="form-group">
                <input class="btn" type="Submit" value="Lưu thay đổi">
                <input class="btn" type="Reset" value="Reset">
            </div>
        </form>
		<% } %>
    </div>
    
    
</body>
</html>