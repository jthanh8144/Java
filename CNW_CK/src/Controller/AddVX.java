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

@WebServlet("/AddVX")
public class AddVX extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VacxinBO vacxinBO = new VacxinBO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		
		String lastID = vacxinBO.getLastID();
		String nextID = lastID.substring(0, 2);
        int ID = Integer.parseInt(lastID.substring(2)) + 1;
        if (ID < 10) {
            nextID += "00" + ID;
        } else if (ID < 100) {
            nextID += "0" + ID;
        } else {
            nextID += ID;
        }
        request.setAttribute("nextID", nextID);
		
		destination = "/addVX.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destination = null;

		String MaVacxin = request.getParameter("MaVacxin");
		String TenVacxin = request.getParameter("TenVacxin");
		int SoMui = Integer.parseInt(request.getParameter("SoMui"));
		String MoTa = request.getParameter("MoTa");
		int GiaVacxin = Integer.parseInt(request.getParameter("GiaVacxin"));
		String TenHangSX = request.getParameter("TenHangSX");
		Vacxin vacxin = new Vacxin();
		vacxin.setMaVacxin(MaVacxin);
		vacxin.setTenVacxin(TenVacxin);
		vacxin.setSoMui(SoMui);
		vacxin.setMoTa(MoTa);
		vacxin.setGiaVacxin(GiaVacxin);
		vacxin.setTenHangSX(TenHangSX);
		vacxinBO.addVX(vacxin);
		
		destination = "/ViewAllVX";
		response.sendRedirect(request.getContextPath() + destination);
	}
}
