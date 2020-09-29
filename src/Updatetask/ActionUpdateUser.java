package Updatetask;

import java.sql.SQLException;


public class ActionUpdateUser {

	static ActionUpdateUser actionUpdateUser = null;

	public static ActionUpdateUser getInstance() {
		if (actionUpdateUser == null) {
			actionUpdateUser = new ActionUpdateUser();
		}
		return actionUpdateUser;
	}

	public static String actionUpdateUser(String taskname,String taskdesc,int taskid,String taskstatus) throws ClassNotFoundException, SQLException {
		System.out.println("Inside action");
		
		String result = UpdateUserManager.managerUpdateUser(taskname,taskdesc,taskid,taskstatus);
		return result;
	}

	
}
