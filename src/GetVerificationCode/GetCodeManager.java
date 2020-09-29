package GetVerificationCode;

import java.sql.SQLException;



public class GetCodeManager {

	static GetCodeManager loginManager = null;

	public static GetCodeManager getInstance() {
		if (loginManager == null) {
			loginManager = new GetCodeManager();
		}
		return loginManager;
	}



	public static String getcodemanager(String email) throws ClassNotFoundException, SQLException {
		System.out.println("Inside manager");
		String result = GetCodeDao.getdao(email);

		return result;
	}

}
