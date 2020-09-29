package ChangetaskStatus;
import java.sql.SQLException;
import java.util.HashMap;
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
	
	
	


	public static List<task> getallusermanager1(int taskid) throws SQLException, ClassNotFoundException
	{
		System.out.println("inside manager");
        List<task> result = GetAllUserFromDao1.getAllUser1(taskid);
		return result;
		
	}

}
