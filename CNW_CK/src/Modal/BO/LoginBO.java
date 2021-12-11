package Modal.BO;

import Modal.DAO.*;

public class LoginBO {
	LoginDAO loginDAO = new LoginDAO();
	
	public boolean isValidUser(String userName, String password) {
		return loginDAO.isExistUser(userName, password);
	}
	
	public boolean isAdmin(String username) {
		return loginDAO.isAdmin(username);
	}
}
