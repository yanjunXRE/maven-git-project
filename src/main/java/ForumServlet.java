
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForumServlet
 */
@WebServlet("/ForumServlet")
public class ForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForumServlet() {
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
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String type = request.getParameter("type");
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/forum", "root", "password");
			
			 PreparedStatement ps = con.prepareStatement("insert into forum(title,text,type) values(?,?,?)");
			
			 
			 ps.setString(1, title);
			 ps.setString(2, text);
			 ps.setString(3, type);
			
			//Step 6: perform the query on the database using the prepared statement
			 int i = ps.executeUpdate();
			
			 if (i > 0){
			//PrintWriter writer = response.getWriter();
			//writer.println("<h1>" + "You have successfully registered an account!" +
		//	"</h1>");
		//	writer.close();
			response.sendRedirect("http://localhost:8090/devopsproject/GuideServlet");
			}
			}
			//Step 8: catch and print out any exception
			catch (Exception exception) {
			 System.out.println(exception);
			 out.close();
			}
		
		
		doGet(request, response);
	}

}
