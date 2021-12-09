package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modal.BEAN.*;
import Modal.BO.*;

@WebServlet("/AddSV")
public class AddSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		SinhVienBO sinhVienBO = new SinhVienBO();
		KhoaBO khoaBO = new KhoaBO();
		ArrayList<Khoa> listKhoa = khoaBO.getListKhoa();
		request.setAttribute("ListKhoa", listKhoa);
		
		String lastID = sinhVienBO.lastIDSV();
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
		
		destination = "/add.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destination = null;
		SinhVienBO svBO = new SinhVienBO();
		
		String IDSV = request.getParameter("IDSV");
		String TenSV = request.getParameter("TenSV");
		String GioiTinh = request.getParameter("GioiTinh");
		String IDK = request.getParameter("IDK");
		SinhVien sinhVien = new SinhVien();
		sinhVien.setIDSV(IDSV);
		sinhVien.setTenSV(TenSV);
		sinhVien.setGioiTinh(GioiTinh);
		sinhVien.setIDK(IDK);
		svBO.addSV(sinhVien);
		
		destination = "/ViewAllSV";
		response.sendRedirect(request.getContextPath() + destination);
	}
}
