<%@page import="java.util.ArrayList"%>
<%@page import="Modal.BEAN.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉnh sửa thông tin vắcxin</title>
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
	Vacxin vacxin = (Vacxin) request.getAttribute("vacxin");
	%>
	<div class="main">
        <form action="UpdateVX" method="POST" name="form1" class="form" id="form-1">
        	<h3 class="heading">Chỉnh sửa vắcxin</h3>
            
            <div class="form-group">
                <label for="firstname" class="form-label">Mã vắcxin</label>
                <input type="text" id="firstname" name="MaVacxin" class="form-control" value="<%= vacxin.getMaVacxin() %>" readonly>
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>
            
            <div class="form-group">
                <label for="firstname" class="form-label">Tên vắcxin</label>
                <input type="text" id="firstname" name="TenVacxin" class="form-control" value="<%= vacxin.getTenVacxin() %>">
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>
            
            <div class="form-group">
                <label for="firstname" class="form-label">Số mũi</label>
                <input type="text" id="firstname" name="SoMui" class="form-control" value="<%= vacxin.getSoMui() %>">
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>
            
            <div class="form-group">
                <label for="firstname" class="form-label">Mô tả</label>
                <textarea id="firstname" name="MoTa" class="form-control"><%= vacxin.getMoTa() %></textarea>
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>
            
            <div class="form-group">
                <label for="firstname" class="form-label">Giá vắcxin</label>
                <input type="text" id="firstname" name="GiaVacxin" class="form-control" value="<%= vacxin.getGiaVacxin() %>">
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>
            
            <div class="form-group">
                <label for="firstname" class="form-label">Tên hãng SX</label>
                <input type="text" id="firstname" name="TenHangSX" class="form-control" value="<%= vacxin.getTenHangSX() %>">
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>

            <input class="btn" type="Submit" value="Lưu thay đổi">
           	<a href="index.jsp" class="btn">Quay lại</a>
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