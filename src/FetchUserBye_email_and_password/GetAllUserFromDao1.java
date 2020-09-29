package FetchUserBye_email_and_password;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	
	
	


	public static user getAllUser1(String email,String password) throws SQLException, ClassNotFoundException
	{
		System.out.println("inside Dao class");
		Connection conn = DataBaseConnection.getDBConnection();
		user result = getallusers(email,password,conn);
		
		return result;
	}
	
	
	public static user getallusers(String email,String password,Connection conn)
	{
		user u = null;
		
//		List<user> list = new ArrayList<>();
		Connection connect = conn;
		ResultSet rs=null;
		PreparedStatement st = null;
		//boolean status = false;
		String userType="";
		try
		{
			
			String sql ="select * from userData where email=? and password=?";
			st = connect.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, password);
			
			rs = st.executeQuery();
			//status=rs.next();
			
			
			while(rs.next()) {
			int id = rs.getInt(1);
			
			String fname = rs.getString(2);
			
			String lname = rs.getString(3);
			String emailid =rs.getString(4);
			String pswd = rs.getString(5);
			String usertype=rs.getString(7);
			String status =rs.getString(8);
			
			u = new user(id,fname,lname,usertype,status,emailid);
			
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
		return u;
		
		
	}

}
