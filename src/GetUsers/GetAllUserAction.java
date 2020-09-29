package GetUsers;
import java.sql.SQLException;
import java.util.List;

public class GetAllUserAction {
static GetAllUserAction getalluseraction=null;
	
	public static GetAllUserAction getInstance()
	{
		if(getalluseraction == null)
		{
			getalluseraction = new GetAllUserAction();
		}
		return getalluseraction;
	}
	
	
	


	public static List<user> getalluseraction() throws SQLException, ClassNotFoundException
	{
		System.out.println("inside action");
		List<user>  u = GetAllUserManager.getallusermanager();
		return u;
		
	}

}
