package bikeparts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BikePartDAOImpl;
import beans.BikePart;
import org.apache.log4j.*;
/**
 * Servlet implementation class 
 */
@WebServlet("/PartDetail")
public class PartDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static Logger log = Logger.getLogger(PartDetail.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partId = request.getParameter("partId");
		log.info("User Views Bike Part #" + partId);
		BikePartDAOImpl btdao = null;
		
		try {
			btdao = new BikePartDAOImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BikePart part = btdao.findByID(partId);
		request.setAttribute("part", part);
		try{
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/partDetailView.jsp");
   
        dispatcher.forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
