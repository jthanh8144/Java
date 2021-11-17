package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Modal.BEAN.*;
import Modal.BO.*;

@WebServlet("/TimKiemServlet")
public class TimKiemServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destination = null;
		String select = request.getParameter("select");
		String inp = request.getParameter("inp");
		ArrayList<NhanVien> listNV = null;
		NhanVienBO nhanVienBO = new NhanVienBO();
		
		listNV = nhanVienBO.getListNVSearch(select, inp);
		request.setAttribute("ListNV", listNV);
		destination = "/ListNV.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
