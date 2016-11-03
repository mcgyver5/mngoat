package messages;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreatePostServlet
 */
@WebServlet(urlPatterns={"/CreatePostServlet", "/DeletePost"})
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Did Get");
		String action = request.getParameter("action");
		String postId = request.getParameter("postId");
		//int id = Integer.parseInt(postId);
		int id = 0;
		if(action.equals("delete")){
			Connection connection = null;
			ResultSet rs = null;
			try{
				id = Integer.parseInt(postId);
			} catch (NumberFormatException nfe){
				System.out.println("Number Format exception... string was " + postId + " and we tried to make it a number...");
				nfe.printStackTrace();
			}
			try {
				connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", "");
				Class.forName("org.hsqldb.jdbcDriver");
				PreparedStatement ps = null;
				String query = "DELETE FROM announcement WHERE post_id = ?";
				ps = connection.prepareStatement(query);
				ps.setInt(1, id);
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // can through sql exception
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try{
					connection.close();
					connection = null;
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Deleted Post ID " + postId);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//String ctx = request.getContextPath();
		//response.getWriter().append("<br><a href='" + ctx + "/minitgoat/Welcome'>Read Posts</a> ");
		//response.getWriter().append("<br><a href='" + ctx + "/minitgoat'>HOME</a> ");
		response.sendRedirect("Welcome");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("postTitle");
		String content = request.getParameter("postContent");
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", "");
			Class.forName("org.hsqldb.jdbcDriver");
			PreparedStatement ps = null;
			rs = connection.prepareStatement("Select MAX(post_id) from announcement").executeQuery();
			rs.next();
			int j = rs.getInt(1);
			rs.close();
			rs = null;
			
			int jplus = j + 1;
			String query = "INSERT INTO announcement (post_id,post_title,post_content) values (?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, jplus);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // can through sql exception
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try{
				connection.close();
				connection = null;
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("Welcome");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	//	response.getWriter().append("<br><a href='/minitgoat/Welcome'>Read Posts</a> ");
	//	response.getWriter().append("<br><a href='/minitgoat'>HOME</a> ");
	}

}
