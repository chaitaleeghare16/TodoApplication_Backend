package GetVerificationCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import AddUser.DataBaseConnection;



public class GetCodeDao {

	static GetCodeDao loginDao = null;

	public static GetCodeDao getInstance() {
		if (loginDao == null) {
			loginDao = new GetCodeDao();
		}
		return loginDao;
	}

	public static String getdao(String email) throws ClassNotFoundException, SQLException {

		Connection con = DataBaseConnection.getDBConnection();
		String result = checkUserNamePass(email,con);
		return result;

	}

	private static String checkUserNamePass(String email, Connection con) {

		ResultSet rs =null;
		PreparedStatement st=null;
		String result = null;
		String sql1 = "select verificationcode from userData where email=?";
		
		


		try {
			st = con.prepareStatement(sql1);
			
			st.setString(1, email);
			
			
			rs = st.executeQuery();
			//status=rs.next();
			
			
			while(rs.next()) {
			String code = rs.getString(1);
			
			result=code;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

					

			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	

}
