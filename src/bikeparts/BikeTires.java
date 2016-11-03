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
import dao.BikeTireDAOImpl;
import beans.BikeTire;

@WebServlet(urlPatterns={"/BikeTires", "/CreateTire","/DeleteTire"})
public class BikeTires extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BikeTires() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if(request.getParameter("action") != null){
			String action = request.getParameter("action");
			if(action.equals("delete")){
				
			}
		}
		
		BikeTireDAOImpl btdao = null;
		try {
			btdao = new BikeTireDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<BikeTire> tires = null;
		
		if(request.getParameter("action") != null){
			String action = request.getParameter("action");
			if(action.equals("delete")){
				String tireId = request.getParameter("tireId");
				int intId = Integer.parseInt(tireId);
				btdao.deleteByID(intId);
			}
		}
			if(request.getParameter("searchString") !=null){
				String searchString = request.getParameter("searchString");
				tires = btdao.findByLike(searchString);
			} else {
				tires = btdao.findAll();
			}
	
		request.setAttribute("tireList", tires);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/tireView.jsp");
   
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
		System.out.println("HERE IS PRICE STRING: " + intPrice);
		
		Connection connection =null;
		try{
			cents = Integer.parseInt(intPrice);
			widthmm = Integer.parseInt(width);
			weightg = Integer.parseInt(weight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BikeTire tire = new BikeTire();
	
		tire.setSize(widthmm);
		tire.setCountryOfOrigin(countryOfOrigin);
		tire.setManufacturer(manufacturer);
		tire.setMake(make);
		tire.setModel(model);
		tire.setPrice(cents);
		tire.setSize(widthmm);
		tire.setWeight(weightg);
		BikeTireDAOImpl btdao = null;
		try {
			btdao = new BikeTireDAOImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btdao.insertBikeTire(tire);

        response.sendRedirect("BikeTires");
	}

}
