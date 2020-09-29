package Checkmailexist;
import java.sql.SQLException;
import java.util.List;



public class MailExistManager {
	
	static MailExistManager getallusermanager=null;
	
	public static MailExistManager getInstance()
	{
		if(getallusermanager == null)
		{
			getallusermanager = new MailExistManager();
		}
		return getallusermanager;
	}
	
	
	


	





	public static int getcount(String email) throws ClassNotFoundException, SQLException {
		System.out.println("inside manager");
        int result = MailExistDao.getcount(email);
		return result;
		
	}

}
