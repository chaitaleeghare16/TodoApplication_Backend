
package AddTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;



@WebServlet("/AddTaskServlet")
public class AddUserServlet extends HttpServlet {

	public AddUserServlet() {
		System.out.println("Inside AddUserServlet Constructor...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		//PrintWriter out = response.getWriter();

		try {
			
		
			JSONObject jsonObject = getJsonObject(req, response);

			String taskname = jsonObject.getString("taskname");
			String taskdesc = jsonObject.getString("taskdescription");
			String status = jsonObject.getString("taskstatus");
			String email = jsonObject.getString("email");
			
			
			
			 
			
			System.out.println(email);
			System.out.println(status);

			String result = AddUserAction.actionLogin(taskname,taskdesc,status,email);
		
			JSONObject json = new JSONObject();
			json.putOnce("result", result);

			//response.setHeader("Access-Control-Allow-Origin", "*");
			//response.addHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().write(json.toString());

		} catch (JSONException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
			System.out.println(jsonObject);
		} catch (Exception e) {
			System.out.println("Error" + e);
		}

		return jsonObject;
	}

}






















/*
 * ArrayList<String> arrayList = new ArrayList<>(); arrayList.add("Dagdu");
 * arrayList.add("Rohit"); arrayList.add("Dagdu"); arrayList.add("Prajkta");
 * 
 * JSONObject jsonObject = new JSONObject(); try { jsonObject.put("NameList",
 * arrayList); } catch (JSONException e) { e.printStackTrace(); }
 * System.out.println(jsonObject);
 * resp.getWriter().write(jsonObject.toString());
 */
