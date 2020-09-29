package Updatetask;

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

	public static String updateUserDao(String taskname,String taskdesc,int taskid,String taskstatus) throws ClassNotFoundException, SQLException {
		System.out.println("Inside dao");
		Connection con = DataBaseConnection.getDBConnection();
		String result = updateUser(taskname,taskdesc,taskid,taskstatus, con);
		return result;

	}

	private static String updateUser(String taskname,String taskdesc,int taskid,String taskstatus, Connection con) {

		
		int count =0;
		PreparedStatement preparedStatement=null;
		String result = null;
		
		 
		String sql = "UPDATE Task SET taskname=? ,taskdesc=?,status=? WHERE tid=? " ;
		 
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, taskname);
			
			preparedStatement.setString(2, taskdesc);
			preparedStatement.setString(3, taskstatus);
			preparedStatement.setInt(4, taskid);
			
			count=preparedStatement.executeUpdate(); 

			if (count>0) {
				System.out.println("update Successfully");
				result = "task updated Successfully";
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
