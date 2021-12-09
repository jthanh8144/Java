package Modal.BO;

import java.util.ArrayList;

import Modal.BEAN.Khoa;
import Modal.DAO.KhoaDAO;

public class KhoaBO {
	KhoaDAO khoaDAO = new KhoaDAO();
	
	public ArrayList<Khoa> getListKhoa() {
		return khoaDAO.getListKhoa();
	}
	
	public String getTenKhoa(String IDK) {
		return khoaDAO.getTenKhoa(IDK);
	}
}
