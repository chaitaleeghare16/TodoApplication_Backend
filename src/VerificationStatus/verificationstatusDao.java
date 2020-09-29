package VerificationStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import AddUser.DataBaseConnection;



public class verificationstatusDao {

	static verificationstatusDao loginDao = null;

	public static verificationstatusDao getInstance() {
		if (loginDao == null) {
			loginDao = new verificationstatusDao();
		}
		return loginDao;
	}

	public static String getdao(String email) throws ClassNotFoundException, SQLException {

		Connection con = DataBaseConnection.getDBConnection();
		String result = changeverificationstatus(email,con);
		return result;

	}

	private static String changeverificationstatus(String email, Connection con) {

		ResultSet rs =null;
		PreparedStatement st=null;
		String result = null;
		int count=0;
		String sql1 = "update userData set verificationstatus=1 where email=?";
		
		


		try {
			st = con.prepareStatement(sql1);
			
			
			st.setString(1, email);
			
			
			count=st.executeUpdate(); 

			if (count>0) {
				System.out.println("verification status update Successfully");
				result = "verification status  updated Successfully";
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
