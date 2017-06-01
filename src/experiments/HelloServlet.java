package experiments;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static List<User> userList = new ArrayList<User>();
	
	//Just prepare static data to display on screen
	static {
		userList.add(new User("Bill", "Gates"));
		userList.add(new User("Steve", "Jobs"));
		userList.add(new User("Larry", "Page"));
		userList.add(new User("Sergey", "Brin"));
		userList.add(new User("Larry", "Ellison"));
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Put the user list in request and 
		//let freemarker paint it.
		System.out.println("doGet");
		request.setAttribute("users", userList);
		
		request.getRequestDispatcher("/freemarker/index.ftl").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DdoPost...");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		if(null != firstname && null != lastname
				&& !firstname.isEmpty() && !lastname.isEmpty()) {
			
			synchronized (userList) {
				userList.add(new User(firstname, lastname));
			}
			
		}
		
		doGet(request, response);
	}
}
