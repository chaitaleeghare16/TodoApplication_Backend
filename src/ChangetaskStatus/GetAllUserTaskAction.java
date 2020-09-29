package ChangetaskStatus;
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
	
	
	public static  List<task>  getallusertaskaction1(int taskid) throws SQLException, ClassNotFoundException
	{
		System.out.println("inside action1");
		 List<task> result = GetAllUserManager1.getallusermanager1(taskid);
		return result;
		
	}



}
