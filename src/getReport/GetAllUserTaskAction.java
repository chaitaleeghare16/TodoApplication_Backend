package getReport;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


public class GetAllUserTaskAction {
static GetAllUserTaskAction getalluseraction=null;
	
	public static GetAllUserTaskAction getInstance()
	{
		if(getalluseraction == null)
		{
			getalluseraction = new GetAllUserTaskAction();
		}
		return getalluseraction;
	}
	
	
	public static  List<Integer>  getallusertaskaction1() throws SQLException, ClassNotFoundException
	{
		System.out.println("inside action1");
		 List<Integer> result = GetAllUserManager1.getallusermanager1();
		return result;
		
	}



}
