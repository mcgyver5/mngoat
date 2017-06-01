package user;

import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDAOImpl;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doDelete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet in RegisterUser.....  should not be called");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doHead(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doOptions(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost in RegisterUser.....");
		System.out.println(req.getParameterMap());
		String userName = req.getParameter("userName");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String password = req.getParameter("password");
		String emailAddress = req.getParameter("emailAddress");
		User user = new User(userName,
				firstName,lastName, 
				password, 
				emailAddress,
				"member");
		System.out.println("created User but not saved yet to db:");
		System.out.println(user.getUserName());
		
		System.out.println(user.getEmailAddress());
		UserDAOImpl udao = new UserDAOImpl();
		udao.insertUser(user);
		//find out userID 
		List<User> users = udao.findByName(userName);
		int userID = users.get(0).getUserId();
		//resp.addCookie(arg0);
		
		resp.sendRedirect("users/login.jsp?u=" + userID);
	
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPut(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doTrace(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#getLastModified(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected long getLastModified(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return super.getLastModified(req);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#getInitParameter(java.lang.String)
	 */
	@Override
	public String getInitParameter(String name) {
		// TODO Auto-generated method stub
		return super.getInitParameter(name);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#getInitParameterNames()
	 */
	@Override
	public Enumeration<String> getInitParameterNames() {
		// TODO Auto-generated method stub
		return super.getInitParameterNames();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#getServletConfig()
	 */
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#getServletContext()
	 */
	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return super.getServletContext();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return super.getServletInfo();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#getServletName()
	 */
	@Override
	public String getServletName() {
		// TODO Auto-generated method stub
		return super.getServletName();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

}
