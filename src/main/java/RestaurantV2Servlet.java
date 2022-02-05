import devopsproject.restaurant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestaurantV2Servlet
 */
@WebServlet("/RestaurantV2Servlet")
public class RestaurantV2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306/restaurantdetails";
	private String jdbcUsername = "root";

	private String jdbcPassword = "password";

	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_RESTAURANTS_SQL = "INSERT INTO restaurantdetails"
			+ " (name,address,image,phone,description) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_RESTAURANT_BY_ID = "select name,address,image,phone,description from restaurantdetails where name =?";
	private static final String SELECT_ALL_RESTAURANTS = "select * from restaurantdetails ";
	private static final String DELETE_RESTAURANTS_SQL = "delete from restaurantdetails where name = ?;";
	private static final String UPDATE_RESTAURANTS_SQL = "update restaurantdetails set name = ?,address = ?,image = ?,phone = ?,description = ? where name = ?;";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestaurantV2Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/RestaurantV2Servlet/delete":
				deleteUser(request, response);
				break;
			case "/RestaurantV2Servlet/edit":
				showEditForm(request, response);
				break;
			case "/RestaurantV2Servlet/update":
				updateUser(request, response);
				break;
			case "/RestaurantV2Servlet/dashboard":
				listRestaurants(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listRestaurants(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<restaurant> restaurants = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESTAURANTS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				String image = rs.getString("image");
				int phone = rs.getInt("phone");
				String description = rs.getString("description");
				restaurants.add(new restaurant(name, address, image, phone, description));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listRestaurants", restaurants);
		request.getRequestDispatcher("/addR.jsp").forward(request, response);
	}

	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String name = request.getParameter("name");
		restaurant existingUser = new restaurant("", "", "", 0, "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESTAURANT_BY_ID);) {
			preparedStatement.setString(1, name);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				name = rs.getString("name");
				String address = rs.getString("address");
				String image = rs.getString("image");
				int phone = rs.getInt("phone");
				String description = rs.getString("description");
				existingUser = new restaurant(name, address, image, phone, description);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("restaurant", existingUser);
		request.getRequestDispatcher("/restaurantEdit.jsp").forward(request, response);
	}

	// method to update the user table base on the form data
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String oriName = request.getParameter("oriName");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String image = request.getParameter("image");
		//int phone = Integer.parseInt(getParameter("phone"));
		String description = request.getParameter("description");

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_RESTAURANTS_SQL);) {
			statement.setString(1, name);
			statement.setString(2, address);
			statement.setString(3, image);
			//statement.setInt(4, phone);
			statement.setString(5, description);
			statement.setString(6, oriName);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8088/devopsproject/RestaurantV2Servlet/dashboard");
	}

	// method to delete user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
	//Step 1: Retrieve value from the request
		String name = request.getParameter("name");
	 //Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection(); PreparedStatement statement =
				connection.prepareStatement(DELETE_RESTAURANTS_SQL);) {
			statement.setString(1, name);
			int i = statement.executeUpdate();
	 }
	 response.sendRedirect("http://localhost:8088/devopsproject/RestaurantV2Servlet/dashboard");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			 "jdbc:mysql://localhost:3306/restaurantdetails", "root", "password");
			 PreparedStatement ps = con.prepareStatement("insert into restaurantdetails(name,address,image,phone,description) values(?,?,?,?,?)");
			 ps.setString(1, name);
			 ps.setString(2, address);
			 ps.setString(3, image);
			 ps.setString(4, phone);
			 ps.setString(5, description);
			
			//Step 6: perform the query on the database using the prepared statement
			 int i = ps.executeUpdate();
			
			 if (i > 0){
			PrintWriter writer = response.getWriter();
			writer.println("<h1>" + "You have successfully added a restaurant!" +
			"</h1>");
			writer.close();
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
