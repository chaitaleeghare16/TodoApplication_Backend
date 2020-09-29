package AddTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import AddUser.DataBaseConnection;



public class AddUserDao {

	static AddUserDao loginDao = null;

	public static AddUserDao getInstance() {
		if (loginDao == null) {
			loginDao = new AddUserDao();
		}
		return loginDao;
	}

	public static String daoLogin(String taskname, String taskdesc,String status, String email) throws ClassNotFoundException, SQLException {

		Connection con = DataBaseConnection.getDBConnection();
		String result = checkUserNamePass(taskname,taskdesc,status,email,con);
		return result;

	}

	private static String checkUserNamePass( String taskname, String taskdesc,String status, String email,Connection con) {

		int rs =0;
		PreparedStatement preparedStatement=null;
		String result = null;
		String sql = "INSERT INTO Task (taskname,taskdesc,status,useremail) VALUES (?,?,?,?)";


		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, taskname);
			preparedStatement.setString(2, taskdesc);
			preparedStatement.setString(3, status);
			preparedStatement.setString(4, email);
			
			
			rs=preparedStatement.executeUpdate(); 

			if (rs>=1) {
				System.out.println(" task insert Successfull");
				result = "task insert Successfull";
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
