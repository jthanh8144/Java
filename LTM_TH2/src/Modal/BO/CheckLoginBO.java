package Modal.BO;

import Modal.DAO.*;

public class CheckLoginBO {
	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	
	public boolean isValidUser(String userName, String password) {
		return checkLoginDAO.isExistUser(userName, password);
	}
}
