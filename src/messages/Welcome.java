package messages;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import beans.Post;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		ArrayList<Post> postList = new ArrayList<Post>();
		ResultSet rs = null;
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", ""); 
			String query = "select post_id, post_title, post_content  from announcement;";			
			rs = connection.prepareStatement(query).executeQuery();
			while (rs.next()){
				int id = rs.getInt(1);
				String postTitle = rs.getString(2);
				String postContent = rs.getString(3);
				if(postContent == null){
					postContent = ""; 							
						
				}
				String safeContent = Jsoup.clean(postContent, Whitelist.basic());
				Post post = new Post(id,postTitle,postContent);
				
				postList.add(post);
			}
			
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
		
			e2.printStackTrace();
		} finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
System.out.println("COMPLETELY BOGUS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
			}
		}
		
		 request.setAttribute("postList", postList);

		 RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/postView.jsp");
	   
	        dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
