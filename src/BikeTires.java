

import java.io.IOException;
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

/**
 * Servlet implementation class BikeTires
 */
@WebServlet("/BikeTires")
public class BikeTires extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BikeTires() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<beans.BikeTire> tireList = new ArrayList<beans.BikeTire>();
		Connection connection = null;
		ResultSet rs = null;
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", ""); // can through sql exception
			String query = "";
			if(request.getParameter("searchString") !=null){
				String searchString = request.getParameter("searchString");
				query = "select id, tire_vendor, tire_name, width_cm, cost  from tire WHERE tire_name LIKE '%" + searchString + "%';";
			} else {
				query = "select id, tire_vendor, tire_name, width_cm, cost  from tire;";
			}
			System.out.println(query);
			 rs = connection.prepareStatement(query).executeQuery();

			//ArrayList<beans.BikeTire> tireList = new ArrayList<beans.BikeTire>();
			while (rs.next()){
				int id = rs.getInt(1);
				String vendor = rs.getString(2);
				String tireName = rs.getString(3);
				int size = rs.getInt(4);
				int cost = rs.getInt(5);
				beans.BikeTire tire = new beans.BikeTire(id,vendor,tireName,size,cost);
				tireList.add(tire);
				System.out.println(String.format("ID: %1d, Name: %1s", rs.getInt(1), rs.getString(2)));
			}
			connection.close();
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
		
		 request.setAttribute("tireList", tireList);
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/tireView.jsp");
   
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
