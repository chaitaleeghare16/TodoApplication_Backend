package ChangetaskStatus;


	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class DataBaseConnection {
		
		
		public static  Connection getDBConnection() throws SQLException, ClassNotFoundException
		{
			final String  dbDriver = "com.mysql.cj.jdbc.Driver";
			
			final String url ="jdbc:mysql://localhost:3306/React";
			final String username ="root";
			final String password ="Home@123";
			Connection conn=null;
			
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("Inside DataBseConnection");
			
			
			return conn;
			
		}
		
		
	}



