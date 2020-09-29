package getReport;


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
import GetUsers.user;
import UpdateUser.ActionUpdateUser;


@WebServlet("/report")
public class GetAllUserReportServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetAllUserReportServlet1() {
        super();
        System.out.println("inside getAllUserServlet1 class");       
    }

	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json");
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");//allow reactJs to fetch data
		PrintWriter out = response.getWriter();
		
		try {

			
			
			List<Integer> result = GetAllUserTaskAction.getallusertaskaction1();
			Map<String,List<Integer>> map = new HashMap<>();
			map.put("result",result);
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

	
	public String getValidJsonFromObject(Map<String, List<Integer>> jsonMap) {
		if (null == jsonMap || jsonMap.isEmpty()) {
		    
			jsonMap = new HashMap<String, List<Integer>>();
			
		}
		return getJSONFromObject(jsonMap);
	}
	

	
	public void includeJSONResponse(Map<String,List<Integer>> jsonMap, HttpServletRequest request, HttpServletResponse response) {
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

}