package getReport;
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
	
	
	


	public static List<Integer> getallusermanager1() throws SQLException, ClassNotFoundException
	{
		System.out.println("inside manager");
        List<Integer> result = GetAllUserFromDao1.getAllUser1();
		return result;
		
	}

}
