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

@WebServlet("/ViewSVK")
public class ViewSVK extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		KhoaBO khoaBO = new KhoaBO();
		ArrayList<Khoa> listKhoa = khoaBO.getListKhoa();
		request.setAttribute("ListKhoa", listKhoa);
		
		String IDK = request.getParameter("IDK");
		if (IDK.equals("") == true) {
			response.sendRedirect(request.getContextPath() + "/ViewAllSV");
		} else {
			String destination = null;
			ArrayList<SinhVien> listSV = null;
			SinhVienBO svBO = new SinhVienBO();
			ArrayList<String> listTenKhoa = new ArrayList<String>();
			
			listSV = svBO.getSVK(IDK);
			request.setAttribute("ListSV", listSV);
			
			for (int i = 0; i < listSV.size(); i++) {
				listTenKhoa.add(khoaBO.getTenKhoa(listSV.get(i).getIDK()));
			}
			request.setAttribute("ListTenKhoa", listTenKhoa);
			
			destination = "/list.jsp?IDK=" + IDK;
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
	}

}
