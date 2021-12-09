<%@page import="java.util.ArrayList"%>
<%@page import="Modal.BEAN.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Danh sách sinh viên</title>
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
         .add-btn {
         margin-left: auto;
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
      <% 
         String IDK = "";
         if (request.getParameter("IDK") != null) {
          IDK = request.getParameter("IDK");
         }
         ArrayList<SinhVien> listSV = (ArrayList<SinhVien>) request.getAttribute("ListSV");
         ArrayList<String> listTenKhoa = (ArrayList<String>) request.getAttribute("ListTenKhoa");
         if (listSV.size() > 0) {
      %>
      <div class="header">
         <form method="POST" action="ViewSVK">
            <select name="IDK" class="select">
               <option value="">Tất cả sinh viên</option>
               <%
                  ArrayList<Khoa> listKhoa = (ArrayList<Khoa>) request.getAttribute("ListKhoa");
                  for (int i = 0; i < listKhoa.size(); i++) {
                  %>
               <option value="<%= listKhoa.get(i).getIDK() %>"><%= listKhoa.get(i).getTenKhoa() %></option>
               <% } %>
            </select>
            <input type="submit" value="Xem" class="btn">
            <script>
               var select = document.querySelector('#select');
               for (var i = 0; i < select.options.length; i++) {
               	if (select.options[i].value == '<%= IDK %>') { 
               		select.selectedIndex = i
               	}
               }
            </script>
         </form>
         <a href="AddSV" class="add-btn btn">Thêm sinh viên</a>
      </div>
      <table border="1" width="100%">
         <caption>Danh sách sinh viên</caption>
         <tr>
            <th>Mã sinh viên</th>
            <th>Tên sinh viên</th>
            <th>Giới tính</th>
            <th>Tên khoa</th>
            <th></th>
            <th></th>
         </tr>
         <%	for (int i = 0; i < listSV.size(); i++) { %>
         <tr>
            <td><%= listSV.get(i).getIDSV() %></td>
            <td><%= listSV.get(i).getTenSV() %></td>
            <td><%= listSV.get(i).getGioiTinh() %></td>
            <td><%= listTenKhoa.get(i) %></td>
            <td><a href="UpdateSV?IDSV=<%= listSV.get(i).getIDSV() %>">Cập nhật</a></td>
            <td><a href="DeleteSV?IDSV=<%= listSV.get(i).getIDSV() %>">Xóa</a></td>
         </tr>
         <% } %>
      </table>
      <% } else { %>
      <h3>Không có kết quả nào</h3>
      <% } %>
   </body>
</html>