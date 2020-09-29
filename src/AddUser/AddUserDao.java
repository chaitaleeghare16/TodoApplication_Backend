package AddUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class AddUserDao {

	static AddUserDao loginDao = null;

	public static AddUserDao getInstance() {
		if (loginDao == null) {
			loginDao = new AddUserDao();
		}
		return loginDao;
	}

	public static String daoLogin(String firstName, String lastName,String email, String password,String cpassword,String usertype,String status,String code) throws ClassNotFoundException, SQLException {

		Connection con = DataBaseConnection.getDBConnection();
		String result = checkUserNamePass(firstName,lastName,email, password,cpassword,usertype,status,code,con);
		return result;

	}

	private static String checkUserNamePass(String firstName, String lastName,String email, String password,String cpassword, String usertype,String status,String code,Connection con) {

		int rs =0;
		PreparedStatement preparedStatement=null;
		String result = null;
		String sql = "INSERT INTO userData (firstName,lastName,email, password,cpassword,usertype,status,verificationcode)" +
		        "VALUES (?,?,?,?,?,?,?,?)";


		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, cpassword);
			preparedStatement.setString(6, usertype);
			preparedStatement.setString(7, status);
			preparedStatement.setString(8, code);
			
			
			
			rs=preparedStatement.executeUpdate(); 

			if (rs>=1) {
				System.out.println("insert Successfull");
				result = "insert Successfull";
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
