<%@page import="java.util.ArrayList"%>
<%@page import="Modal.BEAN.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xóa sinh viên</title>
<link rel="stylesheet" type="text/css" href="./css/login.css">
<style>
.form-message {
    display: none;
    font-size: 1.2rem;
    line-height: 1.6rem;
    padding: 4px 0 0;
    transform: translateX(10%);
}
</style>
</head>
<body>
	<%
		SinhVien s = (SinhVien) request.getAttribute("SV");
	%>
	<div class="main">
        <form action="DeleteSV?IDSV=<%= request.getParameter("IDSV") %>" method="POST" name="form1" class="form" id="form-1">
        	<h3 class="heading">Xóa sinh viên</h3>
            
            <div class="form-group">
                <label for="firstname" class="form-label">Mã sinh viên</label>
                <input type="text" id="firstname" name="IDSV" class="form-control" value="<%= s.getIDSV() %>" disabled>
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>
            
            <div class="form-group">
                <label for="firstname" class="form-label">Họ tên</label>
                <input type="text" id="firstname" name="TenSV" class="form-control" value="<%= s.getTenSV() %>" disabled>
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>
            
            <div class="form-group">
                <label for="gender" class="form-label">Giới tính</label>
                <div class="gender">
                    <div class="radio">
                        <input type="radio" name="GioiTinh" id="male" value="Nam" checked disabled>
                        <label for="male" class="radio-label">Nam</label>
                    </div>
                    <div class="radio">
                        <input type="radio" name="GioiTinh" id="female" value="Nữ" disabled>
                        <label for="female" class="radio-label">Nữ</label>
                    </div>
                </div>
                <span class="form-message"></span>
                <p class=breaker></p>
                <script>
                	let radios = document.querySelectorAll('input[type=radio]');
                	Array.from(radios).forEach(radio => { 
                		if (radio.value == '<%= s.getGioiTinh() %>') {
                			radio.checked = true;
                		}
                	});
                </script>
            </div>
        	
        	<div class="form-group">
			    <label for="select" class="form-label">Khoa</label>
			    <select name=IDK id="select" class="form-control" disabled>
					<%
		               ArrayList<Khoa> listKhoa = (ArrayList<Khoa>) request.getAttribute("ListKhoa");
		               for (int i = 0; i < listKhoa.size(); i++) {
		            %>
		            <option value="<%= listKhoa.get(i).getIDK() %>"><%= listKhoa.get(i).getTenKhoa() %></option>
		            <% } %>
			    </select>
			    <script>
                	var select = document.querySelector('#select');
                	for (var i = 0; i < select.options.length; i++) {
                		if (select.options[i].value == '<%= s.getIDK() %>') { 
                			select.selectedIndex = i;
                		}
                	}
                </script>
			</div>

            <input class="btn" type="Submit" value="Xóa sinh viên">
           	<a href="ViewAllSV" class="btn">Quay lại</a>
        </form>
    </div>
</body>
</html>