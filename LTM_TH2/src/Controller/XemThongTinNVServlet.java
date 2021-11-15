package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Modal.BEAN.*;
import Modal.BO.*;

@WebServlet("/XemThongTinNVServlet")
public class XemThongTinNVServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		ArrayList<NhanVien> listNV = null;
		NhanVienBO nhanVienBO = new NhanVienBO();
		
		listNV = nhanVienBO.getListNV();
		request.setAttribute("ListNV", listNV);

		String mode = "";
		if (request.getParameter("mode") != null) {
			mode = request.getParameter("mode");
		}
		switch (mode) {
		case "del":
			destination = "/ListNV.jsp?mode=del";
			break;
		case "delNVs":
			destination = "/ListNV.jsp?mode=delNVs";
			break;
		default:
			destination = "/ListNV.jsp";
			break;
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
