package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Modal.BEAN.*;
import Modal.BO.*;

@WebServlet("/XemThongTinNVPBServlet")
public class XemThongTinNVPBServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		String IDPB = request.getParameter("IDPB");
		ArrayList<NhanVien> listNV = null;
		NhanVienBO nhanVienBO = new NhanVienBO();
		
		listNV = nhanVienBO.getListNVPB(IDPB);
		request.setAttribute("ListNV", listNV);
		destination = "/ListNV.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
