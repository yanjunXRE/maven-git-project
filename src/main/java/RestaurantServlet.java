
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestaurantServlet
 */
@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String image = request.getParameter("image");
		String phone = request.getParameter("phone");
		String description = request.getParameter("description");
		try { 
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/restaurant_app", "root", "password");
			 PreparedStatement ps = con.prepareStatement("insert into restaurantdetails(name,address,image,phone,description) values(?,?,?,?,?)");
			 ps.setString(1, name);
			 ps.setString(2, address);
			 ps.setString(3, image);
			 ps.setString(4, phone);
			 ps.setString(5, description);
			
			//Step 6: perform the query on the database using the prepared statement
			 int i = ps.executeUpdate();
			
			 if (i > 0){
				 response.sendRedirect("http://localhost:8088/devopsproject/RestaurantV2Servlet/dashboard");
			}
			}
			//Step 8: catch and print out any exception
			catch (Exception exception) {
			 System.out.println(exception);
			 out.close();
			}

		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
