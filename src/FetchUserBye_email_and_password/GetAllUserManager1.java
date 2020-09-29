package FetchUserBye_email_and_password;
import java.sql.SQLException;
import java.util.List;



public class GetAllUserManager1 {
	
	static GetAllUserManager1 getallusermanager=null;
	
	public static GetAllUserManager1 getInstance()
	{
		if(getallusermanager == null)
		{
			getallusermanager = new GetAllUserManager1();
		}
		return getallusermanager;
	}
	
	
	


	public static user getallusermanager1(String email,String password) throws SQLException, ClassNotFoundException
	{
		System.out.println("inside manager");
        user result = GetAllUserFromDao1.getAllUser1(email,password);
		return result;
		
	}

}
