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
	<div class="main">
        <form action="RegisterServlet" method="POST" name="form1" class="form" id="form-1">
        	<h3 class="heading">Đăng kí</h3>
        	
            <div class="form-group">
                <label for="firstName" class="form-label">Họ</label>
                <input type="text" id="firstName" name="firstname" class="form-control">
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>
        	
            <div class="form-group">
                <label for="lastName" class="form-label">Tên</label>
                <input type="text" id="lastName" name="lastname" class="form-control">
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>
        	
            <div class="form-group">
                <label for="username" class="form-label">Tài khoản</label>
                <input type="text" id="username" name="username" class="form-control">
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>

            <div class="form-group">
                <label for="password" class="form-label">Mật khẩu</label>
                <input type="password" id="password" name="password" class="form-control">
                <span class="form-message">Vui lòng nhập trường này</span>
                <p class=breaker></p>
            </div>

            <input class="btn" type="Submit" value="Đăng kí">
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