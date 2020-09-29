package VerificationStatus;

import java.sql.SQLException;


public class verificationstatusAction {

	static verificationstatusAction actionLogin = null;

	public static verificationstatusAction getInstance() {
		if (actionLogin == null) {
			actionLogin = new verificationstatusAction();
		}
		return actionLogin;
	}

	
	public static String getcodeaction(String email) throws ClassNotFoundException, SQLException {
		System.out.println("Inside action");
		String result = verificationstatusManager.getcodemanager(email);
		return result;
	}

}
