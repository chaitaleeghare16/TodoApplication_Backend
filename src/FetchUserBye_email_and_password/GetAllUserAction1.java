package FetchUserBye_email_and_password;
import java.sql.SQLException;
import java.util.List;


public class GetAllUserAction1 {
static GetAllUserAction1 getalluseraction=null;
	
	public static GetAllUserAction1 getInstance()
	{
		if(getalluseraction == null)
		{
			getalluseraction = new GetAllUserAction1();
		}
		return getalluseraction;
	}
	
	
	public static user getalluseraction1(String email,String password) throws SQLException, ClassNotFoundException
	{
		System.out.println("inside action1");
		user result = GetAllUserManager1.getallusermanager1(email,password);
		return result;
		
	}



}
