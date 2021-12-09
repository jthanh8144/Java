<%@page import="java.util.ArrayList"%>
<%@page import="Modal.BEAN.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉnh sửa thông tin sinh viên</title>
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
        <form action="UpdateSV?IDSV=<%= request.getParameter("IDSV") %>" method="POST" name="form1" class="form" id="form-1">
        	<h3 class="heading">Sửa thông tin sinh viên</h3>
            
            <div class="form-group">
                <label for="firstname" class="form-label">Mã sinh viên</label>
                <input type="text" id="firstname" name="IDSV" class="form-control" value="<%= s.getIDSV() %>" readonly>
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>
            
            <div class="form-group">
                <label for="firstname" class="form-label">Họ tên</label>
                <input type="text" id="firstname" name="TenSV" class="form-control" value="<%= s.getTenSV() %>">
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>
            
            <div class="form-group">
                <label for="gender" class="form-label">Giới tính</label>
                <div class="gender">
                    <div class="radio">
                        <input type="radio" name="GioiTinh" id="male" value="Nam" checked>
                        <label for="male" class="radio-label">Nam</label>
                    </div>
                    <div class="radio">
                        <input type="radio" name="GioiTinh" id="female" value="Nữ">
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
			    <select name=IDK id="select" class="form-control">
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
                			select.selectedIndex = i
                		}
                	}
                </script>
			</div>

            <input class="btn" type="Submit" value="Lưu thay đổi">
           	<a href="ViewAllSV" class="btn">Quay lại</a>
        </form>
    </div>
    
    <script>
        const inputs = document.querySelectorAll('.form-control');
        const form = document.querySelector('#form-1');

        function getParent(element, selector) {
            while (element.parentElement) {
                if (element.parentElement.matches(selector)) {
                    return element.parentElement;
                }
                element = element.parentElement;
            }
        }

        Array.from(inputs).forEach(input => {
            input.onblur = function() {
                if (!input.value) {
                    getParent(input, '.form-group').classList.add('invalid');
                } else {
                    getParent(input, '.form-group').classList.remove('invalid');
                }
            }
            input.oninput = function() {
                getParent(input, '.form-group').classList.remove('invalid');
            }
        });
    </script>
</body>
</html>