package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Modal.BEAN.*;
import Modal.BO.*;

@WebServlet("/UIFormNVServlet")
public class UIFormNVServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String mode = request.getParameter("mode");
		String destination = null;
		ArrayList<PhongBan> listPB = null;
		PhongBanBO phongBanBO = new PhongBanBO();
		NhanVienBO nhanVienBO = new NhanVienBO();
		
		listPB = phongBanBO.getListPB();
		request.setAttribute("ListPB", listPB);

		if (mode.equals("add") == true) {
			String lastID = nhanVienBO.getLastIDNV();
			String nextID = lastID.substring(0, 2);
	        int ID = Integer.parseInt(lastID.substring(2)) + 1;
	        if (ID < 10) {
	            nextID += "0" + ID;
	        } else {
	            nextID += ID;
	        }
	        request.setAttribute("nextID", nextID);
		} else {
			String IDNV = request.getParameter("IDNV");
			NhanVien nhanVien = nhanVienBO.getNV(IDNV);
	        request.setAttribute("NhanVien", nhanVien);
		}
		
		destination = "/FormNV.jsp?mode=" + mode;
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
