package UpdateUser;

import java.sql.SQLException;



public class UpdateUserManager {
	static UpdateUserManager updateUserManager = null;

	public static UpdateUserManager getInstance() {
		if (updateUserManager == null) {
			updateUserManager = new UpdateUserManager();
		}
		return updateUserManager;
	}

	public static String managerUpdateUser(int userId, String status) throws ClassNotFoundException, SQLException {
		System.out.println("Inside manager"+userId+" "+status);
		String result = UpdateUserDao.updateUserDao(userId,status);

		return result;

	}

	


}
