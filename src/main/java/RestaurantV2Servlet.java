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
			Class.forName("com.mysql.jdbc.Driver");
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
			case "/insert":
				break;
			case "/delete":
				break;
			case "/edit":
				break;
			case "/update":
				break;
			default:
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
