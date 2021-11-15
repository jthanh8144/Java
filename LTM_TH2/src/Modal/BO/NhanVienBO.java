package Modal.BO;

import java.util.ArrayList;

import Modal.BEAN.NhanVien;
import Modal.DAO.NhanVienDAO;

public class NhanVienBO {
	NhanVienDAO nhanVienDAO = new NhanVienDAO();
	
	public ArrayList<NhanVien> getListNV() {
		return nhanVienDAO.getListNV();
	}
	
	public ArrayList<NhanVien> getListNVPB(String IDPB) {
		return nhanVienDAO.getListNVPB(IDPB);
	}
	
	public ArrayList<NhanVien> getListNVSearch(String select, String inp) {
		return nhanVienDAO.getListNVSearch(select, inp);
	}
	
	public void addNV(NhanVien nv) {
		nhanVienDAO.addNV(nv);
	}
	
	public String getLastIDNV() {
		return nhanVienDAO.getLastIDNV();
	}
	
	public void deleteNV(String IDNV) {
		nhanVienDAO.deleteNV(IDNV);
	}
	
	public void deleteNVs(String[] IDNVs) {
		nhanVienDAO.deleteNVs(IDNVs);
	}
	
	public NhanVien getNV(String IDNV) {
		return nhanVienDAO.getNV(IDNV);
	}
	
	public void updateNV(NhanVien nv) {
		nhanVienDAO.updateNV(nv);
	}
	
	
}
