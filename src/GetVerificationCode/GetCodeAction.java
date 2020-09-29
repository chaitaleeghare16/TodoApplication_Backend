package GetVerificationCode;

import java.sql.SQLException;


public class GetCodeAction {

	static GetCodeAction actionLogin = null;

	public static GetCodeAction getInstance() {
		if (actionLogin == null) {
			actionLogin = new GetCodeAction();
		}
		return actionLogin;
	}

	
	public static String getcodeaction(String email) throws ClassNotFoundException, SQLException {
		System.out.println("Inside action");
		String result = GetCodeManager.getcodemanager(email);
		return result;
	}

}
