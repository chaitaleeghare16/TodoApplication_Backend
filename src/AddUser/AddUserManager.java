package AddUser;

import java.sql.SQLException;



public class AddUserManager {

	static AddUserManager loginManager = null;

	public static AddUserManager getInstance() {
		if (loginManager == null) {
			loginManager = new AddUserManager();
		}
		return loginManager;
	}

	public static String managerLogin(String firstName, String lastName,String email, String password,String cpassword,String usertype,String status,String code) throws ClassNotFoundException, SQLException {
		System.out.println("Inside manager");
		String result = AddUserDao.daoLogin(firstName,lastName,email, password,cpassword,usertype,status,code);

		return result;

	}

}
