package getReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import AddUser.DataBaseConnection;



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
	
	
	
	


	public static List<Integer> getAllUser1() throws SQLException, ClassNotFoundException
	{
		System.out.println("inside Dao class");
		Connection conn = DataBaseConnection.getDBConnection();
		List<Integer> result = getallusers(conn);
		
		return result;
	}
	
	
	public static List<Integer> getallusers(Connection conn)
	{
		
		
	
		
		ArrayList<Integer> al = new ArrayList<>();
		Connection connect = conn;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		PreparedStatement st3 = null;
		//boolean status = false;
		String userType="";
		try
		{
			
			String sql1 ="select count(*) from userData where created_ts >= (DATE_SUB(now(), INTERVAL 7 DAY)); ";
			st1 = connect.prepareStatement(sql1);
			
			
			String sql2 ="select count(*) from userData where updated_ts >= (DATE_SUB(now(), INTERVAL 7 DAY)) ";
			st2 = connect.prepareStatement(sql2);
			
			
			String sql3 ="select count(*) from Task ";
			st3 = connect.prepareStatement(sql3);
			
			
			
			rs1 = st1.executeQuery();
			rs2 = st2.executeQuery();
			rs3 = st3.executeQuery();
			
			while(rs1.next())
			{
				
			   al.add(rs1.getInt(1));
			
				
			}
			
			while(rs2.next())
			{
				
			   al.add(rs2.getInt(1));
			
				
			}
			
			while(rs3.next())
			{
				
			   al.add(rs3.getInt(1));
			
				
			}
			
			System.out.println(al);
			return al;
			
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		finally
		{
			try {
				if(rs1!=null)
				{
					rs1.close();
				}
			}catch(SQLException e)
			{
				System.out.println(e);
			}
			try
			{
				if(st1!=null)
				{
					st1.close();
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
		return al;
		
		
	}

}
