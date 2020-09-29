package VerificationStatus;

import java.sql.SQLException;



public class verificationstatusManager {

	static verificationstatusManager loginManager = null;

	public static verificationstatusManager getInstance() {
		if (loginManager == null) {
			loginManager = new verificationstatusManager();
		}
		return loginManager;
	}



	public static String getcodemanager(String email) throws ClassNotFoundException, SQLException {
		System.out.println("Inside manager");
		String result = verificationstatusDao.getdao(email);

		return result;
	}

}
