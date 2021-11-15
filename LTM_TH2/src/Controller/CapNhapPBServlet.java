package Controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Modal.BEAN.*;
import Modal.BO.*;

@WebServlet("/CapNhapPBServlet")
public class CapNhapPBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destination = null;
		String IDPB = request.getParameter("IDPB");
		String TenPB = request.getParameter("TenPB");
		String MoTa = request.getParameter("MoTa");
		PhongBan pb = new PhongBan();
		pb.setIDPB(IDPB);
		pb.setTenPB(TenPB);
		pb.setMoTa(MoTa);
		
		PhongBanBO phongBanBO = new PhongBanBO();
		phongBanBO.updatePB(pb);
		destination = "/XemPBServlet";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}
}
