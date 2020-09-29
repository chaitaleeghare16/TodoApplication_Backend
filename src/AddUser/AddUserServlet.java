
package AddUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;






@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	String email=null;

	public AddUserServlet() {
		System.out.println("Inside AddUserServlet Constructor...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		//PrintWriter out = response.getWriter();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Origin", "*");

		try {
			
			 
			        
			 
			
			JSONObject jsonObject = getJsonObject(req, response);

			String firstName = jsonObject.getString("FirstName");
			String lastName = jsonObject.getString("LastName");
		    email = jsonObject.getString("Email");
			String password = jsonObject.getString("Password");
			String cpassword = jsonObject.getString("ConfirmPassword");
			
			String usertype = jsonObject.getString("UserType");
			String status = jsonObject.getString("Status");
			
			
			
			
			Random rnd = new Random();
	        int number = rnd.nextInt(999999);
	       String code = String.format("%06d", number);
	    
			 
			
			System.out.println(email);
			System.out.println(password);
			
			User u = new User(email,code);
			System.out.println(u.getCode());
			
			SendMail.sendEmail(u);
		
			String result = AddUserAction.actionLogin(firstName,lastName,email, password,cpassword,usertype,status,code);
			
			
			JSONObject json = new JSONObject();
			json.putOnce("result", result);

			
			response.getWriter().write(json.toString());

		} catch (JSONException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//send mail to user
	
	
    
	
	
	public static JSONObject getJsonObject(HttpServletRequest request, HttpServletResponse response) {

		StringBuffer sb = new StringBuffer();
		String line = null;
		JSONObject jsonObject = null;

		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				sb.append(line);
			jsonObject = new JSONObject(sb.toString());
			System.out.println(jsonObject);
		} catch (Exception e) {
			System.out.println("Error" + e);
		}

		return jsonObject;
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}






















