package Updatetask;

import java.sql.SQLException;



public class UpdateUserManager {
	static UpdateUserManager updateUserManager = null;

	public static UpdateUserManager getInstance() {
		if (updateUserManager == null) {
			updateUserManager = new UpdateUserManager();
		}
		return updateUserManager;
	}

	public static String managerUpdateUser(String taskname,String taskdesc,int taskid,String taskstatus) throws ClassNotFoundException, SQLException {
		System.out.println("Inside manager");
		String result = UpdateUserDao.updateUserDao(taskname,taskdesc,taskid,taskstatus);

		return result;

	}

	


}
