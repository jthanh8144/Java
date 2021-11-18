package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Modal.BEAN.*;
import Modal.BO.*;

@WebServlet("/Search")
public class Search extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		String inp = request.getParameter("inp");
		ArrayList<Admin> listUser = null;
		AdminBO adminBO = new AdminBO();
		
		listUser = adminBO.search(inp);
		request.setAttribute("ListUser", listUser);
		destination = "/list.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
