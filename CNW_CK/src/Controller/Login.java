package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modal.BO.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		LoginBO loginBO = new LoginBO();
		
		if (loginBO.isValidUser(userName, password)) {
			destination = "/index.jsp";
			response.sendRedirect(request.getContextPath() + destination);
		} else {
			destination = "/login.jsp";
			response.sendRedirect(request.getContextPath() + destination);
		}
	}
}
