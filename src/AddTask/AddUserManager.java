package AddTask;

import java.sql.SQLException;



public class AddUserManager {

	static AddUserManager loginManager = null;

	public static AddUserManager getInstance() {
		if (loginManager == null) {
			loginManager = new AddUserManager();
		}
		return loginManager;
	}

	public static String managerLogin( String taskname, String taskdesc,String status, String email) throws ClassNotFoundException, SQLException {
		System.out.println("Inside manager");
		String result = AddUserDao.daoLogin(taskname,taskdesc,status,email);

		return result;

	}

}
