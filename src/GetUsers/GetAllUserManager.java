package GetUsers;
import java.sql.SQLException;
import java.util.List;

public class GetAllUserManager {
	
	static GetAllUserManager getallusermanager=null;
	
	public static GetAllUserManager getInstance()
	{
		if(getallusermanager == null)
		{
			getallusermanager = new GetAllUserManager();
		}
		return getallusermanager;
	}
	
	
	


	public static List<user> getallusermanager() throws SQLException, ClassNotFoundException
	{
		System.out.println("inside manager");
		List<user> result = GetAllUserFromDao.getAllUser();
		return result;
		
	}

}
