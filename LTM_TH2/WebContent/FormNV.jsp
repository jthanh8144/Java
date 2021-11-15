<%@page import="java.util.ArrayList"%>
<%@page import="Modal.BEAN.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nhân viên</title>
<link rel="stylesheet" type="text/css" href="./css/styles1.css">
</head>
<body>
	<a href="index.jsp" class="back">Trang chủ</a>
	<div class="main">
		<% if (((String) request.getParameter("mode")).equals("add") == true ) { %>
		<form action="ThemNVServlet" method="POST" class="form" id="form">
			<div class="form-group">
                <label for="IDNV" class="form-label">Mã nhân viên</label>
                <input type="text" id="IDNV" name="IDNV" class="form-control" value="<%= (String) request.getAttribute("nextID") %>" readonly>
            </div>

            <div class="form-group">
                <label for="HoTen" class="form-label">Họ tên</label>
                <input type="text" id="HoTen" name="HoTen" class="form-control">
            </div>

            <div class="form-group">
                <label for="IDPB" class="form-label">Mã phòng ban</label>
                <!-- <input type="text" id="PhongBan" name="IDPB" class="form-control"> -->
                <select name="IDPB" id="select-PB" class="form-control">
                    <option value="">Chọn phòng ban</option>
                    <%
                    ArrayList<PhongBan> listPB = (ArrayList<PhongBan>) request.getAttribute("ListPB");
                	for (int i = 0; i < listPB.size(); i++) {
                	%>
                	<option value="<%= listPB.get(i).getIDPB() %>"><%= listPB.get(i).getTenPB() %></option>
                	<% } %>
                </select>
                <span class="form-message">Chọn một phòng ban</span>
                <p class=breaker></p>
            </div>

            <div class="form-group">
                <label for="DiaChi" class="form-label">Địa chỉ</label>
                <input type="text" id="DiaChi" name="DiaChi" class="form-control">
            </div>

            <div class="form-group">
                <input class="btn" type="Submit" value="Thêm nhân viên">
                <input class="btn" type="Reset" value="Reset">
            </div>
        </form>
		<% } else { 
			NhanVien nv = (NhanVien) request.getAttribute("NhanVien");
		%>
		<form action="CapNhapNVServlet" method="POST" class="form" id="form">
			<div class="form-group">
                <label for="IDNV" class="form-label">Mã nhân viên</label>
                <input type="text" id="IDNV" name="IDNV" class="form-control" value="<%= nv.getIDNV() %>" readonly>
            </div>

            <div class="form-group">
                <label for="HoTen" class="form-label">Họ tên</label>
                <input type="text" id="HoTen" name="HoTen" class="form-control" value="<%= nv.getHoTen() %>"> 
            </div>

            <div class="form-group">
                <label for="IDPB" class="form-label">Mã phòng ban</label>
                <!-- <input type="text" id="PhongBan" name="IDPB" class="form-control"> -->
                <select name="IDPB" id="select-PB" class="form-control">
                    <option value="">Chọn phòng ban</option>
                    <%
                    ArrayList<PhongBan> listPB = (ArrayList<PhongBan>) request.getAttribute("ListPB");
                	for (int i = 0; i < listPB.size(); i++) {
                	%>
                	<option value="<%= listPB.get(i).getIDPB() %>"><%= listPB.get(i).getTenPB() %></option>
                	<% } %>
                </select>
                <script>
                	var select = document.querySelector('#select-PB');
                	for (var i = 0; i < select.options.length; i++) {
                		if (select.options[i].value == '<%= nv.getIDPB() %>') { 
                			select.selectedIndex = i
                		}
                	}
                </script>
                <span class="form-message">Chọn một phòng ban</span>
                <p class=breaker></p>
            </div>

            <div class="form-group">
                <label for="DiaChi" class="form-label">Địa chỉ</label>
                <input type="text" id="DiaChi" name="DiaChi" class="form-control" value="<%= nv.getDiaChi() %>">
            </div>

            <div class="form-group">
                <input class="btn" type="Submit" value="Lưu thay đổi">
                <input class="btn" type="Reset" value="Reset">
            </div>
        </form>
		<% } %>
            
    </div>
    
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var submitBtn = document.querySelector('input[type="Submit"]');
            var select = document.querySelector('#select-PB');
            var errMessage = document.querySelector('.form-message');
            select.onchange = () => {
                if (select.selectedIndex != 0) {
                    errMessage.style.display = 'none';
                } else {
                    errMessage.style.display = 'block';
                }
            }
            submitBtn.onclick = (e) => {
                e.preventDefault();
                if (select.selectedIndex == 0) {
                    errMessage.style.display = 'block';
                }
                else {
                    document.querySelector('#form').submit();
                }
            }
        });
    </script>
</body>
</html>