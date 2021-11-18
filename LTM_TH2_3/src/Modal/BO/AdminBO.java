package Modal.BO;

import java.util.ArrayList;

import Modal.BEAN.*;
import Modal.DAO.AdminDAO;

public class AdminBO {
	AdminDAO adminDAO = new AdminDAO();
	
	public void addUser(Admin ad) {
		adminDAO.addUser(ad);
	}
	
	public void delUser(String username) {
		adminDAO.delUser(username);
	}
	
	public void updateUser(String username, String role, String firstname, String lastname) {
		adminDAO.updateUser(username, role, firstname, lastname);
	}
	
	public ArrayList<Admin> search(String inp) {
		return adminDAO.search(inp);
	}
	
	public ArrayList<Admin> getListUser() {
		return adminDAO.getListUser();
	}
	
	public Admin getUser(String username) {
		return adminDAO.getUser(username);
	}
}
