package Modal.BO;

import java.util.ArrayList;

import Modal.BEAN.SinhVien;
import Modal.DAO.SinhVienDAO;


public class SinhVienBO {
	SinhVienDAO sinhVienDAO = new SinhVienDAO();
	
	public ArrayList<SinhVien> getAllSV() {
		return sinhVienDAO.getAllSV();
	}
	
	public ArrayList<SinhVien> getSVK(String IDK) {
		return sinhVienDAO.getSVK(IDK);
	}
	
	public void addSV(SinhVien s) {
		sinhVienDAO.addSV(s);
	}
	
	public String lastIDSV() {
		return sinhVienDAO.lastIDSV();
	}
	
	public SinhVien getSV(String IDSV) {
		return sinhVienDAO.getSV(IDSV);
	}
	
	public void updateSV(SinhVien s) {
		sinhVienDAO.updateSV(s);
	}
	
	public void deleteSV(String IDSV) {
		sinhVienDAO.deleteSV(IDSV);
	}
}
