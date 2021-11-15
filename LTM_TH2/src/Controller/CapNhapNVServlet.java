package Controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Modal.BEAN.*;
import Modal.BO.*;

@WebServlet("/CapNhapNVServlet")
public class CapNhapNVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destination = null;
		String IDNV = request.getParameter("IDNV");
		String HoTen = request.getParameter("HoTen");
		String IDPB = request.getParameter("IDPB");
		String DiaChi = request.getParameter("DiaChi");
		NhanVien nv = new NhanVien();
		nv.setIDNV(IDNV);
		nv.setHoTen(HoTen);
		nv.setIDPB(IDPB);
		nv.setDiaChi(DiaChi);
		
		NhanVienBO nhanVienBO = new NhanVienBO();
		nhanVienBO.updateNV(nv);
		destination = "/XemThongTinNVServlet";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
