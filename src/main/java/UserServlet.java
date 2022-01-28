
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

import devopsproject.user;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Step 1: Prepare list of variables used for database connections
    private String jdbcURL = "jdbc:mysql://localhost:3306/restaurant_user";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    //Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
    private static final String INSERT_USERS_SQL = "INSERT INTO user" + " (email,password) VALUES " + " (?, ?);";
    private static final String SELECT_USER_BY_ID = "select email,password from user where email =?";
    private static final String SELECT_ALL_USERS = "select * from user ";
    private static final String DELETE_USERS_SQL = "delete from user where email = ?;";
    private static final String UPDATE_USERS_SQL = "update user set email = ?,password= ? where email = ?;";
    //Step 3: Implement the getConnection method which facilitates connection to the database viaJDBC
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
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 4: Depending on the request servlet path, determine the function to invoke using thefollow switch statement.
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 case "/UserServlet/delete":
		// deleteUser(request, response);
		 break;
		 case "/UserServlet/edit":
		// showEditForm(request, response);
		 break;
		 case "/UserServlet/update":
		// updateUser(request, response);
		 break;
		 case "/UserServlet/dashboard":
		 listUsers(request, response);
		 break;
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 } 
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	//Step 5: listUsers function to connect to the database and retrieve all users records
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException
	{
	List <user> users = new ArrayList <>();
	 try (Connection connection = getConnection();
	 // Step 5.1: Create a statement using connection object
	 PreparedStatement preparedStatement =
	connection.prepareStatement(SELECT_ALL_USERS);) {
	 // Step 5.2: Execute the query or update query
	 ResultSet rs = preparedStatement.executeQuery();
	 // Step 5.3: Process the ResultSet object.
	 while (rs.next()) {

	 String password = rs.getString("password");
	 String email = rs.getString("email");
	
	 users.add(new user(email, password));
	 }
	 } catch (SQLException e) {
	 System.out.println(e.getMessage());
	 }
	// Step 5.4: Set the users list into the listUsers attribute to be pass to the userportal.jsp
	request.setAttribute("listUsers", users);
	request.getRequestDispatcher("/userportal.jsp").forward(request, response);
	}
	
//	//method to get parameter, query database for existing user data and redirect to user edit page
//		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//		throws SQLException, ServletException, IOException {
//		//get parameter passed in the URL
//		String name = request.getParameter("name");
//		user existingUser = new user("", "");
//		// Step 1: Establishing a Connection
//		try (Connection connection = getConnection();
//		// Step 2:Create a statement using connection object
//		PreparedStatement preparedStatement =
//		connection.prepareStatement(SELECT_USER_BY_ID);) {
//		preparedStatement.setString(1, name);
//		// Step 3: Execute the query or update query
//		ResultSet rs = preparedStatement.executeQuery();
//		// Step 4: Process the ResultSet object
//		while (rs.next()) {
//		
//		//System.out.println("name is "+name);
//
//		String password = rs.getString("pwd");
//		String email = rs.getString("email");
//		
//		existingUser = new user (email ,password);
//		}
//		} catch (SQLException e) {
//		System.out.println(e.getMessage());
//		}
//		//Step 5: Set existingUser to request and serve up the userEdit form
//		request.setAttribute("user", existingUser);
//		request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
//		}
//		
//		
//		//method to update the user table base on the form data
//		private void updateUser(HttpServletRequest request, HttpServletResponse response)
//		throws SQLException, IOException {
//		//Step 1: Retrieve value from the request
//		String oriName = request.getParameter("oriEmail");
//		
//		 String password = request.getParameter("password");
//		 String email = request.getParameter("email");
//		
//
//		 //Step 2: Attempt connection with database and execute update user SQL query
//		 try (Connection connection = getConnection(); PreparedStatement statement =
//		connection.prepareStatement(UPDATE_USERS_SQL);) {
//		 statement.setString(1, password);
//		 statement.setString(2, email);
//		
//		 statement.setString(3, oriName);
//		 int i = statement.executeUpdate();
//		 }
//		 //Step 3: redirect back to UserServlet (note: remember to change the url to your projectname)
//		 response.sendRedirect("http://localhost:8080/UserServlet/userportal");
//		}
//		
//		//method to delete user
//		private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//		throws SQLException, IOException {
//		//Step 1: Retrieve value from the request
//		 String name = request.getParameter("email");
//		 //Step 2: Attempt connection with database and execute delete user SQL query
//		 try (Connection connection = getConnection(); PreparedStatement statement =
//		connection.prepareStatement(DELETE_USERS_SQL);) {
//		 statement.setString(1, name);
//		 int i = statement.executeUpdate();
//		 }
//		 //Step 3: redirect back to UserServlet dashboard (note: remember to change the url toyour project name)
//		 response.sendRedirect("http://localhost:8080/devopsproject/UserServlet/userportal");
//		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
