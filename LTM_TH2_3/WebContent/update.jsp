<%@page import="Modal.BEAN.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
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
	Admin user = (Admin) request.getAttribute("user");
	%>
	<div class="main">
        <form action="UpdateUser?username=<%= user.getUsername() %>" method="POST" name="form1" class="form" id="form-1">
        	<h3 class="heading">Cập nhật user</h3>
        	
        	<div class="form-group">
			    <label for="select" class="form-label">Role</label>
			    <select name="role" id="select" class="form-control">
			        <option value="admin">Admin</option>
			        <option value="user">User</option>
			    </select>
			    <script>
                	var select = document.querySelector('#select');
                	for (var i = 0; i < select.options.length; i++) {
                		if (select.options[i].value == '<%= user.getRole() %>') { 
                			select.selectedIndex = i
                		}
                	}
                </script>
			</div>
            
            <div class="form-group">
                <label for="firstname" class="form-label">Họ</label>
                <input type="text" id="firstname" name="firstname" class="form-control" value="<%= user.getFirstname() %>">
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>

            <div class="form-group">
                <label for="lastname" class="form-label">Tên</label>
                <input type="text" id="lastname" name="lastname" class="form-control" value="<%= user.getLastname() %>">
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>

            <input class="btn" type="Submit" value="Lưu thay đổi">
            <input class="btn" type="Reset" value="Reset">
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