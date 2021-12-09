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

@WebServlet("/DeleteSV")
public class DeleteSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		SinhVienBO sinhVienBO = new SinhVienBO();
		KhoaBO khoaBO = new KhoaBO();
		ArrayList<Khoa> listKhoa = khoaBO.getListKhoa();
		request.setAttribute("ListKhoa", listKhoa);
		
		String IDSV = request.getParameter("IDSV");
		SinhVien s = sinhVienBO.getSV(IDSV);
		request.setAttribute("SV", s);
		
		destination = "/delete.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destination = null;
		SinhVienBO svBO = new SinhVienBO();
		
		String IDSV = request.getParameter("IDSV");
		svBO.deleteSV(IDSV);
		
		destination = "/ViewAllSV";
		response.sendRedirect(request.getContextPath() + destination);
	}
}
