package Modal.BO;

import java.util.ArrayList;

import Modal.BEAN.Vacxin;
import Modal.DAO.VacxinDAO;

public class VacxinBO {
	VacxinDAO vacxinDAO = new VacxinDAO();
	
	public String getLastID() {
		return vacxinDAO.getLastID();
	}
	
	public ArrayList<Vacxin> getAllVX() {
		return vacxinDAO.getAllVX();
	}
	
	public Vacxin getVX(String MaVacxin) {
		return vacxinDAO.getVX(MaVacxin);
	}
	
	public void addVX(Vacxin s) {
		vacxinDAO.addVX(s);
	}
	
	public void updateVX(Vacxin s) {
		vacxinDAO.updateVX(s);
	}
}
