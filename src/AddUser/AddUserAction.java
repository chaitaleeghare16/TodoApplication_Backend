package AddUser;

import java.sql.SQLException;


public class AddUserAction {

	static AddUserAction actionLogin = null;

	public static AddUserAction getInstance() {
		if (actionLogin == null) {
			actionLogin = new AddUserAction();
		}
		return actionLogin;
	}

	public static String actionLogin(String firstName, String lastName,String email, String password,String cpassword,String usertype,String status,String code) throws ClassNotFoundException, SQLException {
		System.out.println("Inside action");
		String result = AddUserManager.managerLogin(firstName,lastName,email, password,cpassword,usertype,status,code);
		return result;
	}

}
