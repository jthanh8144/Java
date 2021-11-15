<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Trang chủ</title>
      
      <link rel="stylesheet" type="text/css" href="./css/home.css">
   </head>
   <body>
      <ul class="list">
         <li class="item">
            <a href="XemThongTinNVServlet" class="link">Xem nhân viên</a>
         </li>
         <li class="item">
            <a href="XemPBServlet" class="link">Xem phòng ban</a>
         </li>
         <li class="item">
            <a href="Search.jsp" class="link">Tìm kiếm</a>
         </li>
         <%
         if (request.getAttribute("isAdmin") != null) {
         %>
         <li class="item">
            <a href="UIFormNVServlet?mode=add" class="link">Thêm nhân viên</a>
         </li>
         <li class="item">
            <a href="XemThongTinNVServlet?mode=edit" class="link">Cập nhập nhân viên</a>
         </li>
         <li class="item">
            <a href="XemThongTinNVServlet?mode=del" class="link">Xóa nhân viên</a>
         </li>
         <li class="item">
            <a href="XemThongTinNVServlet?mode=delNVs" class="link">Xóa nhiều nhân viên</a>
         </li>
         <li class="item">
            <a href="UIFormPBServlet?mode=add" class="link">Thêm phòng ban</a>
         </li>
         <li class="item">
            <a href="XemPBServlet?mode=edit" class="link">Cập nhập thông tin phòng ban</a>
         </li>
         <%
         }
         %>
      </ul>
   </body>
</html>