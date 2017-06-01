package bikeparts;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BikePartDAOImpl;
import beans.BikePart;

@WebServlet(urlPatterns={"/BikeParts", "/CreatePart","/DeletePart"})
public class BikeParts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BikeParts() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		BikePartDAOImpl btdao = null;
		
			try {
				btdao = new BikePartDAOImpl();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		List<BikePart> parts = null;
		
		if(request.getParameter("action") != null){
			String action = request.getParameter("action");
			if(action.equals("delete")){
				String partId = request.getParameter("partId");
				int intId = Integer.parseInt(partId);
				btdao.deleteByID(intId);
			}
		}
		String searchString = "";
			if(request.getParameter("searchString") !=null && request.getParameter("searchString").length() > 0){
		
				searchString = request.getParameter("searchString");
				
				parts = btdao.findByLike(searchString);
			} else {
				searchString = "Everything";
				parts = btdao.findAll();
			}
		request.setAttribute("searchString",searchString);
		request.setAttribute("partList", parts);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/partView.jsp");
   
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String make = request.getParameter("brand");
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
		
		Connection connection =null;
		try{
			cents = Integer.parseInt(intPrice);
			widthmm = Integer.parseInt(width);
			weightg = Integer.parseInt(weight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BikePart part = new BikePart();
	
		part.setSize(widthmm);
		part.setCountryOfOrigin(countryOfOrigin);
		part.setManufacturer(manufacturer);
		part.setMake(make);
		part.setModel(model);
		part.setPrice(cents);
		part.setSize(widthmm);
		part.setWeight(weightg);
		BikePartDAOImpl btdao = null;
		try {
			btdao = new BikePartDAOImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btdao.insertBikePart(part);

        response.sendRedirect("BikeParts");
	}

}
