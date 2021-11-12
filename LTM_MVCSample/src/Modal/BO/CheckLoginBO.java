package Modal.BO;

import java.util.ArrayList;

import Modal.BEAN.*;
import Modal.DAO.*;

public class CheckLoginBO {
	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	
	public boolean isValidUser(String userName, String password) {
		return checkLoginDAO.isExistUser(userName, password);
	}
	
	public ArrayList<Wife> getWifeList(String userName) {
		return checkLoginDAO.getWifeList(userName);
	}
}
