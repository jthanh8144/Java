<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tìm kiếm</title>
<link rel="stylesheet" type="text/css" href="./css/search.css">
</head>
<body>
	<div class="main">
        <div class="container">
            <form action="TimKiemServlet" method="POST">
                <select name="select" id="select" class="form-control">
                    <option value="">Tìm kiếm theo</option>
                    <option value="IDNV">Mã nhân viên</option>
                    <option value="HoTen">Tên nhân viên</option>
                    <option value="DiaChi">Địa chỉ</option>
                </select>
                <input type="text" name="inp" class="form-control">
                <input class="btn" type="Submit" value="Tìm kiếm">
                <input class="btn" type="Reset" value="Reset">
            </form>
        </div>
    </div>
</body>
</html>