package DeleteTask;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;





public class GetAllUserFromDao1 {
	
	static GetAllUserFromDao1 getalluserfromdb =null;
	
	public static GetAllUserFromDao1 getInstance()
	{
		if(getalluserfromdb == null)
		{
			getalluserfromdb = new GetAllUserFromDao1();
		}
		return getalluserfromdb;
	}
	
	
	
	


	public static String getAllUser1(int taskid) throws SQLException, ClassNotFoundException
	{
		System.out.println("inside Dao class");
		Connection conn = DataBaseConnection.getDBConnection();
		String result = getallusers(taskid,conn);
		
		return result;
	}
	
	
	public static String getallusers(int taskid,Connection conn)
	{
		task task = null;
		String result=null;
		List<task> list = new ArrayList<>();
		
		int count=0;
		Connection connect = conn;
		ResultSet rs=null;
		PreparedStatement st = null;
		//boolean status = false;
		String userType="";
		try
		{
			
			String sql ="delete from Task where tid=? ";
			st = connect.prepareStatement(sql);
			st.setInt(1, taskid);
			
			
			count=st.executeUpdate(); 

			if (count>0) {
				System.out.println("delete Successfully");
				result = "task  deleted Successfully";
			} 
			
			
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		finally
		{
			try {
				if(rs!=null)
				{
					rs.close();
				}
			}catch(SQLException e)
			{
				System.out.println(e);
			}
			try
			{
				if(st!=null)
				{
					st.close();
				}
			}catch(SQLException e)
			{
				System.out.println(e);
			}
			try
			{
				if(conn!=null)
				{
					conn.close();
				}
			}catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return result;
		
		
	}

}
