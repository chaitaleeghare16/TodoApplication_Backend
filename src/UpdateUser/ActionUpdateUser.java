package UpdateUser;

import java.sql.SQLException;


public class ActionUpdateUser {

	static ActionUpdateUser actionUpdateUser = null;

	public static ActionUpdateUser getInstance() {
		if (actionUpdateUser == null) {
			actionUpdateUser = new ActionUpdateUser();
		}
		return actionUpdateUser;
	}

	public static String actionUpdateUser(int userId, String status) throws ClassNotFoundException, SQLException {
		System.out.println("Inside action"+userId+" "+status);
		
		String result = UpdateUserManager.managerUpdateUser(userId,status);
		return result;
	}

	
}
