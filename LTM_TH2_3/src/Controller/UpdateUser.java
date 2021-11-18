package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modal.BEAN.*;
import Modal.BO.*;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		String username = request.getParameter("username");
		
		AdminBO adminBO = new AdminBO();
		Admin admin = adminBO.getUser(username);
		request.setAttribute("user", admin);
		
		destination = "/update.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destination = null;
		String username = request.getParameter("username");
		String role = request.getParameter("role");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		AdminBO adminBO = new AdminBO();
		adminBO.updateUser(username, role, firstname, lastname);
		
		destination = "/ViewAllUser";
		response.sendRedirect(request.getContextPath() + destination);
	}
}
