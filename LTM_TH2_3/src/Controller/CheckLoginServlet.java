package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modal.BO.*;

@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		
		if (checkLoginBO.isValidUser(userName, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userName);
			session.setAttribute("isAdmin", checkLoginBO.isAdmin(userName));
			destination = "/index.jsp";
			response.sendRedirect(request.getContextPath() + destination);
		} else {
			destination = "/TryAgain";
			response.sendRedirect(request.getContextPath() + destination);
		}
	}
}
