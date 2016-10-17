package admin;


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
import beans.Post;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/admin/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FOUND SERVLET ANYWAYS........................0000");
		Connection connection = null;
		ArrayList<Post> postList = new ArrayList<Post>();
		ResultSet rs = null;
		System.out.println("FOUND SERVLET ANYWAYS........................45");
		
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
				Post post = new Post(id,postTitle,safeContent);
				
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("postList", postList);
		System.out.println("FOUND " + postList.size());
		
		 request.setAttribute("postList", postList);
			System.out.println("FOUND SERVLET ANYWAYS........................91");

		 RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/minitgoat/admin/admin.jsp");
			System.out.println("FOUND SERVLET ANYWAYS........................95");

			response.sendRedirect("/minitgoat/admin/feedbacks.jsp");
//	        dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

