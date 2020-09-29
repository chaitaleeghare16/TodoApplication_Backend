package GetUsers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class GetAllUserFromDao {
	
	static GetAllUserFromDao getalluserfromdb =null;
	
	public static GetAllUserFromDao getInstance()
	{
		if(getalluserfromdb == null)
		{
			getalluserfromdb = new GetAllUserFromDao();
		}
		return getalluserfromdb;
	}
	
	
	
	


	public static List<user> getAllUser() throws SQLException, ClassNotFoundException
	{
		System.out.println("inside Dao class");
		Connection conn = DataBaseConnection.getDBConnection();
		List<user> result = getallusers(conn);
		
		return result;
	}
	
	
	public static List<user> getallusers(Connection conn)
	{
		user u = null;
		List<user> list = new ArrayList<>();
		Connection connect = conn;
		ResultSet rs=null;
		PreparedStatement st = null;
		
		try
		{
			String sql ="select * from userData";
			st = connect.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next())
			{
				int id =rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				String usertype=rs.getString(7);
				String status = rs.getString(8);
				u = new user(id,firstname,lastname,email,password,usertype,status);
				
				list.add(u);
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
