package admin;


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
 * Servlet implementation class CreateUser
 * urlPatterns={"/CreatePostServlet", "/DeletePost"}
 */
@WebServlet(urlPatterns={"/admin/CreateUser","/admin/DeleteUser"})
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("delete")){
			String userId = request.getParameter("userId");
			Connection connection = null;
			ResultSet rs = null;
			int id = Integer.parseInt(userId);
			try {
				connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", "");
				Class.forName("org.hsqldb.jdbcDriver");
				PreparedStatement ps = null;
				String query = "DELETE FROM users WHERE user_id = ?";
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
		response.sendRedirect("UserList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", ""); // can through sql exception
			
		
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", ""); // can through sql exception
			
			PreparedStatement stmt = connection.prepareStatement("insert into users "
					+ "(user_id, username, password, user_role)" 
					+ "values (NEXT VALUE FOR tireseq, ?, ?, ?);");
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, role);

			
			stmt.execute();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} finally {
			try{
			connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		/**
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/admin/users.jsp");
   
        dispatcher.forward(request, response);
        **/
		response.sendRedirect("UserList");
	}

}
