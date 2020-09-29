package VerificationStatus;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import GetTask.GetAllUserTaskAction;
import GetTask.task;
import GetUsers.GetAllUserAction;
import GetUsers.user;

/**
 * Servlet implementation class getCode
 */
@WebServlet("/verificationstatus")
public class VerificationStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public VerificationStatusServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");//allow reactJs to fetch data
		PrintWriter out = response.getWriter();
		
		try {

			String email=request.getParameter("email");
			System.out.println("email :"+email);
			String result = verificationstatusAction.getcodeaction(email);
			Map<String,String> map = new HashMap<>();
			map.put("result", result);
		     System.out.println("map"+map);
			
			includeJSONResponse(map, request, response);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public String getJSONFromObject(Object object) {
		String jsonData = null;
		
		 ObjectMapper writeMapper = new ObjectMapper();
		 
		    
		try {
			
		    jsonData = writeMapper.writeValueAsString(object);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in  getJSONFromObject ");
		}
		return jsonData;
	}

	
	public String getValidJsonFromObject(Map<String,String> jsonMap) {
		if (null == jsonMap || jsonMap.isEmpty()) {
		    
			jsonMap = new HashMap<String,String>();
			
		}
		return getJSONFromObject(jsonMap);
	}
	

	
	public void includeJSONResponse(Map<String, String> jsonMap, HttpServletRequest request, HttpServletResponse response) {
		String jsonString = getValidJsonFromObject(jsonMap);
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			System.out.println("before write :: " + response.isCommitted());
			response.getWriter().write(jsonString);
			
			
			System.out.println("jsonString :: " + jsonString);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in  includeJSONResponse");
		}
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
