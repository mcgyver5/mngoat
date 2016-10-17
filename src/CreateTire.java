

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateTire
 */
@WebServlet(description = "Allows Creation of Row In Tire Table", urlPatterns = { "/CreateTire" })
public class CreateTire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", ""); // can through sql exception
			String query = "";
		
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", ""); // can through sql exception
			
			connection.prepareStatement("insert into tire (id, tire_vendor, tire_name, width_cm,cost)" 
					+ "values (51, 'Kenda', 'Pathfinder', 32, 19);").execute();		
			// query from the db
		
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String manufacturer = request.getParameter("manufacturer");
		String countryOfOrigin = request.getParameter("countryOfOrigin");
		String width = request.getParameter("width");
		String price = request.getParameter("price");
		String weight = request.getParameter("weight");
		// validation:  All params must be in the request but they can all be blank
		// width, price, weight must be numeric.
		// brand, model, manufacturer, coo must be < 100 chars.
		int cents =0;
		int widthmm =0;
		int weightg =0;
		String intPrice = price.replace(".", "");
		System.out.println("HERE IS PRICE STRING: " + intPrice);
		Connection connection =null;
		try{
			cents = Integer.parseInt(intPrice);
			widthmm = Integer.parseInt(width);
			weightg = Integer.parseInt(weight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", ""); // can through sql exception
			
			String query = "";
		
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", ""); // can through sql exception
			
			PreparedStatement stmt = connection.prepareStatement("insert into tire "
					+ "(id, tire_vendor, tire_name, tire_manufacturer, country_of_origin, width_cm, cost, tire_weight)" 
					+ "values (NEXT VALUE FOR tireseq, ?, ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, brand);
			stmt.setString(2, model);
			stmt.setString(3, manufacturer);
			stmt.setString(4, countryOfOrigin);
			stmt.setInt(5, widthmm);
			stmt.setInt(6,cents);
			stmt.setInt(7, weightg);
			
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
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/tireView.jsp");
   
        dispatcher.forward(request, response);
	}

}
