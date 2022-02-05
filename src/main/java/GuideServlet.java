
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

import devopsproject.forum;

/**
 * Servlet implementation class GuideServlet
 */
@WebServlet("/GuideServlet")
public class GuideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String jdbcURL = "jdbc:mysql://localhost:3306/forum";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	 
	 private static final String INSERT_FORUM_SQL = "INSERT INTO forum" + " (title,text,type) VALUES " +" (?, ?, ?);";
			  private static final String SELECT_FORUM_BY_ID = "select title,text,type from forum where title =?";
			  private static final String SELECT_ALL_FORUM = "select * from forum ";
			  private static final String DELETE_FORUM_SQL = "delete from forum where title = ?;";
			  private static final String UPDATE_FORUM_SQL = "update forum set title = ?,text= ?, type =? where title = ?;";
	 
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
			  
    public GuideServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 
		 case "/GuideServlet/delete":
		deleteForum(request, response);
		 break;
		 case "/GuideServlet/edit":
			 showEditForm(request,response);
		 break;
		 case "/GuideServlet/update":
			 updateForum(request, response);
		 break;
		// default:
		 //case"/GuideServlet/dashboard":
		 listForums(request, response);
		 break;
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void listForums(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		
		List <forum> forums = new ArrayList <>();
		 try (Connection connection = getConnection();
		 // Step 5.1: Create a statement using connection object
		 PreparedStatement preparedStatement =
		connection.prepareStatement(SELECT_ALL_FORUM);) {
		 // Step 5.2: Execute the query or update query
		 ResultSet rs = preparedStatement.executeQuery();
		 // Step 5.3: Process the ResultSet object.
		 while (rs.next()) {
		 String title = rs.getString("title");
		 String text = rs.getString("text");
		 String type = rs.getString("type");
		 
		 forums.add(new forum(title, text, type));
		 }
		 } catch (SQLException e) {
		 System.out.println(e.getMessage());
		 }
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		
		request.setAttribute("listForums", forums);
		request.getRequestDispatcher("/forum.jsp").forward(request, response);}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
			//get parameter passed in the URL
			String name = request.getParameter("title");
			forum existingUser = new forum("", "", "");
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement =
			connection.prepareStatement(SELECT_forum_BY_ID);) {
			preparedStatement.setString(1, name);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
			name = rs.getString("name");
			String password = rs.getString("password");
			String email = rs.getString("email");
			String language = rs.getString("language");
			existingUser = new User(name, password, email, language);
			}
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
			//Step 5: Set existingUser to request and serve up the userEdit form
			request.setAttribute("user", existingUser);
			request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
			}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
