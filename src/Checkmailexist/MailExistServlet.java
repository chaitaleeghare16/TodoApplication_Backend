package Checkmailexist;


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


@WebServlet("/mailExist")
public class MailExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MailExistServlet() {
        super();
        System.out.println("inside getAllUserServlet1 class");       
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/json");
	response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");//allow reactJs to fetch data
	PrintWriter out = response.getWriter();
	
	String email=request.getParameter("email");
	System.out.println("email :"+email);
	int result=0;
	try {
		result = MailExistAction.getcount(email);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Map<String,Integer> map = new HashMap<>();
	map.put("result", result);
	 System.out.println("map"+map);
	
	includeJSONResponse(map, request, response);
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


public String getValidJsonFromObject(Map<String,Integer> jsonMap) {
	if (null == jsonMap || jsonMap.isEmpty()) {
	    
		jsonMap = new HashMap<String,Integer>();
		
	}
	return getJSONFromObject(jsonMap);
}



public void includeJSONResponse(Map<String, Integer> jsonMap, HttpServletRequest request, HttpServletResponse response) {
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