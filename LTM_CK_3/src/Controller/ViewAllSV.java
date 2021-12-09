package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modal.BEAN.*;
import Modal.BO.*;

@WebServlet("/ViewAllSV")
public class ViewAllSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		ArrayList<SinhVien> listSV = null;
		SinhVienBO svBO = new SinhVienBO();
		KhoaBO khoaBO = new KhoaBO();
		ArrayList<Khoa> listKhoa = khoaBO.getListKhoa();
		ArrayList<String> listTenKhoa = new ArrayList<String>();
		
		request.setAttribute("ListKhoa", listKhoa);
		
		listSV = svBO.getAllSV();
		request.setAttribute("ListSV", listSV);
		
		for (int i = 0; i < listSV.size(); i++) {
			listTenKhoa.add(khoaBO.getTenKhoa(listSV.get(i).getIDK()));
		}
		request.setAttribute("ListTenKhoa", listTenKhoa);
		
		destination = "/list.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
