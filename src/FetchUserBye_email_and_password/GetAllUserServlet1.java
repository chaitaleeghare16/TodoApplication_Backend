package FetchUserBye_email_and_password;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;


import GetUsers.GetAllUserAction;

import UpdateUser.ActionUpdateUser;


@WebServlet("/GetAllUserServletbyemailnpswd")
public class GetAllUserServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetAllUserServlet1() {
        super();
        System.out.println("inside getAllUserServlet1 class");       
    }

	
	
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("*************");
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");//allow reactJs to fetch data
		//PrintWriter out = response.getWriter();
		
		
		
		try {
			
			System.out.println("*************");
			JSONObject jsonObject = getJsonObject(request, response);
			System.out.println(jsonObject);
			String email =jsonObject.getString("username");
			String password = jsonObject.getString("password");
			
			
			System.out.println(email); 
			 
			System.out.println(password);

			user result = GetAllUserAction1.getalluseraction1(email, password);
			
			System.out.println(result);
		
			JSONObject json = new JSONObject();
			
			json.put("result", result.getFirstname());
			json.put("result1", result.getLastname());
			json.put("result2", result.getUsertype());
			json.put("result3", result.getStatus());
			json.put("result4", result.getEmail());
			json.put("result5", result.getId());
			

			response.getWriter().write(json.toString());

		} catch (JSONException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static JSONObject getJsonObject(HttpServletRequest request, HttpServletResponse response) {

		StringBuffer sb = new StringBuffer();
		String line = null;
		JSONObject jsonObject = null;

		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				sb.append(line);
			jsonObject = new JSONObject(sb.toString());
			System.out.println("Update user"+jsonObject);
		} catch (Exception e) {
			System.out.println("Error" + e);
		}

		return jsonObject;
	}


}