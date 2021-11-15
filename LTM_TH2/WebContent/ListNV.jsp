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
	<% 
	String mode = "";
	if (request.getParameter("mode") != null) {
		mode = request.getParameter("mode");
	}
	ArrayList<NhanVien> listNV = (ArrayList<NhanVien>) request.getAttribute("ListNV"); 
	if (listNV.size() > 0) {
	switch(mode) {
	case "edit":
		%>
	<table border="1" width="100%">
		<caption>Danh sách nhân viên</caption>
		<tr><th>Mã nhân viên</th><th>Họ tên</th><th>Mã phòng ban</th><th>Địa chỉ</th><th></th></tr>
	<%	for (int i = 0; i < listNV.size(); i++) { %>
		<tr>
			<td><%= listNV.get(i).getIDNV() %></td>
			<td><%= listNV.get(i).getHoTen() %></td>
			<td><%= listNV.get(i).getIDPB() %></td>
			<td><%= listNV.get(i).getDiaChi() %></td>
			<td><a href="UIFormNVServlet?mode=edit&IDNV=<%= listNV.get(i).getIDNV() %>">Cập nhập nhân viên</a></td>
		</tr>
		<% } %>
	</table>
	<% 	break;
	case "del":
		%>
	<table border="1" width="100%">
		<caption>Danh sách nhân viên</caption>
		<tr><th>Mã nhân viên</th><th>Họ tên</th><th>Mã phòng ban</th><th>Địa chỉ</th><th></th></tr>
	<%	for (int i = 0; i < listNV.size(); i++) { %>
		<tr>
			<td><%= listNV.get(i).getIDNV() %></td>
			<td><%= listNV.get(i).getHoTen() %></td>
			<td><%= listNV.get(i).getIDPB() %></td>
			<td><%= listNV.get(i).getDiaChi() %></td>
			<td><a href="XoaNVServlet?IDNV=<%= listNV.get(i).getIDNV() %>">Xóa nhân viên</a></td>
		</tr>
		<% } %>
	</table>
	<% 	break;
	case "delNVs":
	%>
	<form action="XoaNVsServlet" method="POST" class="form">
	<table border="1" width="100%">
		<caption>Danh sách nhân viên</caption>
		<tr><th>Mã nhân viên</th><th>Họ tên</th><th>Mã phòng ban</th><th>Địa chỉ</th><th></th></tr>
	<%	for (int i = 0; i < listNV.size(); i++) { %>
		<tr>
			<td><%= listNV.get(i).getIDNV() %></td>
			<td><%= listNV.get(i).getHoTen() %></td>
			<td><%= listNV.get(i).getIDPB() %></td>
			<td><%= listNV.get(i).getDiaChi() %></td>
			<td><input type="checkbox" name="IDNV" value="<%= listNV.get(i).getIDNV() %>"></td>
		</tr>
		<% } %>
	</table>
	<input class="btn del-mul-btn" type="Submit" value="Xóa" disabled>
	</form>
	
	<script>
        document.addEventListener("DOMContentLoaded", function () {
            var delBtn = document.querySelector('.del-mul-btn');
            var checkboxs = document.querySelectorAll('input[name="IDNV"]');
            Array.from(checkboxs).forEach(checkbox => {
                checkbox.onchange = () => {
                    var checkedCount = document.querySelectorAll('input[name="IDNV"]:checked').length;
                    if (checkedCount != 0) {
                        delBtn.disabled = false;
                    } else {
                        delBtn.disabled = true;
                    }
                };
            });
        });
    </script>
	<% break;
	default:
	%>
	<table border="1" width="100%">
		<caption>Danh sách nhân viên</caption>
		<tr><th>Mã nhân viên</th><th>Họ tên</th><th>Mã phòng ban</th><th>Địa chỉ</th></tr>
	<%	for (int i = 0; i < listNV.size(); i++) { %>
		<tr>
			<td><%= listNV.get(i).getIDNV() %></td>
			<td><%= listNV.get(i).getHoTen() %></td>
			<td><%= listNV.get(i).getIDPB() %></td>
			<td><%= listNV.get(i).getDiaChi() %></td>
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