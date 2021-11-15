package Controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Modal.BO.*;

@WebServlet("/XoaNVServlet")
public class XoaNVServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		String IDNV = request.getParameter("IDNV");
		NhanVienBO nhanVienBO = new NhanVienBO();

		nhanVienBO.deleteNV(IDNV);
		destination = "/XemThongTinNVServlet";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
