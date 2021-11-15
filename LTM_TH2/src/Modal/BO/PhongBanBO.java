package Modal.BO;

import java.util.ArrayList;

import Modal.BEAN.*;
import Modal.DAO.*;

public class PhongBanBO {
	PhongBanDAO phongBanDAO = new PhongBanDAO();
	
	public ArrayList<PhongBan> getListPB() {
		return phongBanDAO.getListPB();
	}
	
	public PhongBan getPB(String IDPB) {
		return phongBanDAO.getPB(IDPB);
	}
	
	public String getLastIDPB() {
		return phongBanDAO.getLastIDPB();
	}
	
	public void addPB(PhongBan pb) {
		phongBanDAO.addPB(pb);
	}
	
	public void updatePB(PhongBan pb) {
		phongBanDAO.updatePB(pb);
	}
}
