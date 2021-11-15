package Controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Modal.BO.*;

@WebServlet("/XoaNVsServlet")
public class XoaNVsServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		String[] IDNVs = request.getParameterValues("IDNV");
		NhanVienBO nhanVienBO = new NhanVienBO();

		nhanVienBO.deleteNVs(IDNVs);
		destination = "/XemThongTinNVServlet";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
