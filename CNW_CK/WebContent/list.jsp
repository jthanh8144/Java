<%@page import="java.util.ArrayList"%>
<%@page import="Modal.BEAN.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Danh sách vắc xin</title>
      <link rel="stylesheet" type="text/css" href="./css/styles.css">
      <style>
         .form {
         display: flex;
         flex-direction: column;
         }
         .header {
         display: flex;
         flex-direction: row;
         align-content: center;
         padding: 10px;
         }
         .back-btn {
         display: block;
         padding: 10px;
         }
         .select {
         height: 35px;
         padding: 0 10px;
         }
         .btn {
         outline: none;
         background-color: #41dfd7;
         padding: 9px 12px;
         font-weight: 600;
         color: #fff;
         border: none;
         font-size: 14px;
         border-radius: 8px;
         cursor: pointer;
         min-width: 80px;
         }
         .btn:hover {
         background-color: #45ece4;
         color: #fff;
         }
      </style>
   </head>
   <body>
   	<a href="index.jsp" class="back-btn">Trang chủ</a>
      <% 
         ArrayList<Vacxin> listVX = (ArrayList<Vacxin>) request.getAttribute("ListVX");
         if (listVX.size() > 0) {
      %>
      
      <table border="1" width="100%">
         <caption>Danh sách sinh viên</caption>
         <tr>
            <th>Mã vắcxin</th>
            <th>Tên vắcxin</th>
            <th>Số mũi</th>
            <th>Mô tả</th>
            <th>Giá vắcxin</th>
            <th>Tên hãng sản xuất</th>
          <% if (request.getAttribute("mode") != null) { %>
         	<th></th>
         <% } %>
         </tr>
         <%	for (int i = 0; i < listVX.size(); i++) { %>
         <tr>
            <td><%= listVX.get(i).getMaVacxin() %></td>
            <td><%= listVX.get(i).getTenVacxin() %></td>
            <td><%= listVX.get(i).getSoMui() %></td>
            <td><%= listVX.get(i).getMoTa() %></td>
            <td><%= listVX.get(i).getGiaVacxin() %></td>
            <td><%= listVX.get(i).getTenHangSX() %></td>
         <% if (request.getAttribute("mode") != null) { %>
         	<td><a href="UpdateVX?MaVacxin=<%= listVX.get(i).getMaVacxin() %>">Cập nhật</a></td>
         <% } %>
         </tr>
         <% } %>
      </table>
      <% } else { %>
      <h3>Không có kết quả nào</h3>
      <% } %>
   </body>
</html>