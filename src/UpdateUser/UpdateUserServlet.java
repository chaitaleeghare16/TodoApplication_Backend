package UpdateUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;



/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("*************");
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");//allow reactJs to fetch data
		PrintWriter out = response.getWriter();
		out.print("data post");
		
		
		try {
			
			System.out.println("*************");
			JSONObject jsonObject = getJsonObject(request, response);
			int userId =jsonObject.getInt("id");
			String status = jsonObject.getString("status");
			
			
			System.out.println(userId); 
			 
			System.out.println(status);

			String result = ActionUpdateUser.actionUpdateUser(userId ,status);
		
			JSONObject json = new JSONObject();
			json.putOnce("result", result);

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
