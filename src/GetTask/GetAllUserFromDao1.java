package GetTask;
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
	
	
	
	


	public static List<task> getAllUser1(String email) throws SQLException, ClassNotFoundException
	{
		System.out.println("inside Dao class");
		Connection conn = DataBaseConnection.getDBConnection();
		List<task> result = getallusers(email,conn);
		
		return result;
	}
	
	
	public static List<task> getallusers(String email,Connection conn)
	{
		task task = null;
		
		List<task> list = new ArrayList<>();
		
		
		Connection connect = conn;
		ResultSet rs=null;
		PreparedStatement st = null;
		//boolean status = false;
		String userType="";
		try
		{
			
			String sql ="select * from task where useremail=? ";
			st = connect.prepareStatement(sql);
			st.setString(1, email);
			
			
			rs = st.executeQuery();
			//status=rs.next();
			
			
			while(rs.next()) {
			int tid = rs.getInt(1);
			
			String taskname = rs.getString(2);
			
			String taskdesc = rs.getString(3);
			String status =rs.getString(4);
			String emailid =rs.getString(5);
			
			
				task = new task(tid,taskname,taskdesc,status,emailid);
				list.add(task);
				System.out.println(list);
				
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
		return list;
		
		
	}

}
