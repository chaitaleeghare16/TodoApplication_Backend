package AddTask;

import java.sql.SQLException;


public class AddUserAction {

	static AddUserAction actionLogin = null;

	public static AddUserAction getInstance() {
		if (actionLogin == null) {
			actionLogin = new AddUserAction();
		}
		return actionLogin;
	}

	public static String actionLogin(String taskname, String taskdesc,String status, String email) throws ClassNotFoundException, SQLException {
		System.out.println("Inside action");
		String result = AddUserManager.managerLogin(taskname,taskdesc,status,email);
		return result;
	}

}
