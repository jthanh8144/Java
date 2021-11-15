package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Modal.BEAN.*;
import Modal.BO.*;

@WebServlet("/XemPBServlet")
public class XemPBServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		ArrayList<PhongBan> listPB = null;
		PhongBanBO phongBanBO = new PhongBanBO();
		
		listPB = phongBanBO.getListPB();
		request.setAttribute("ListPB", listPB);
		String mode = "";
		if (request.getParameter("mode") != null) {
			mode = request.getParameter("mode");
		}
		switch (mode) {
		case "del":
			destination = "/ListPB.jsp?mode=del";
			break;
		case "delNVs":
			destination = "/ListPB.jsp?mode=delNVs";
			break;
		default:
			destination = "/ListPB.jsp";
			break;
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
