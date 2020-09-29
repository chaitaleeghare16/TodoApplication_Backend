package Checkmailexist;
import java.sql.SQLException;
import java.util.List;


public class MailExistAction {
static MailExistAction getalluseraction=null;
	
	public static MailExistAction getInstance()
	{
		if(getalluseraction == null)
		{
			getalluseraction = new MailExistAction();
		}
		return getalluseraction;
	}
	
	
	


	public static int getcount(String email) throws ClassNotFoundException, SQLException {
		System.out.println("inside action1");
		int result = MailExistManager.getcount(email);
		return result;
	}



}
