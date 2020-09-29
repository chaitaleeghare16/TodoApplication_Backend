package Checkmailexist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import AddUser.DataBaseConnection;


public class MailExistDao {
	
	static MailExistDao getalluserfromdb =null;
	
	public static MailExistDao getInstance()
	{
		if(getalluserfromdb == null)
		{
			getalluserfromdb = new MailExistDao();
		}
		return getalluserfromdb;
	}
	
	
	
	


	public static int getcount(String email) throws SQLException, ClassNotFoundException
	{
		System.out.println("inside Dao class");
		Connection conn = DataBaseConnection.getDBConnection();
		int result = getEmailCount(email,conn);
		
		return result;
	}
	
	
	public static int getEmailCount(String email,Connection conn)
	{
		
		

		Connection connect = conn;
		ResultSet rs=null;
		PreparedStatement st = null;
		int result =0;
		
		try
		{
			
			String sql ="select count(*) from userData where email=?";
			st = connect.prepareStatement(sql);
			st.setString(1, email);
			
			
			rs = st.executeQuery();
			//status=rs.next();
			
			
			while(rs.next()) {
			int emailcount = rs.getInt(1);
			
			result=emailcount;
			
			
			
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
