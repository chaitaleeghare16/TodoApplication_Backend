package UpdateUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import GetUsers.DataBaseConnection;

public class UpdateUserDao {
	static UpdateUserDao updateUserDao = null;

	public static UpdateUserDao getInstance() {
		if (updateUserDao == null) {
			updateUserDao = new UpdateUserDao();
		}
		return updateUserDao;
	}

	public static String updateUserDao(int userId,String status) throws ClassNotFoundException, SQLException {
		System.out.println("Inside dao" +userId+" "+status);
		Connection con = DataBaseConnection.getDBConnection();
		String result = updateUser(userId, status, con);
		return result;

	}

	private static String updateUser(int userId, String status, Connection con) {

		
		int count =0;
		PreparedStatement preparedStatement=null;
		String result = null;
		
		 
		String sql = "UPDATE userData SET status=? ,updated_ts=CURRENT_TIMESTAMP() WHERE id=? " ;
		 
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, status);
			
			preparedStatement.setInt(2, userId);
			count=preparedStatement.executeUpdate(); 

			if (count>0) {
				System.out.println("update Successfully");
				result = "user updated Successfully";
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
