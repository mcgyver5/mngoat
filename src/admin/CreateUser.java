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

import beans.User;
import dao.UserDAOImpl;

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
		if(action.equals("delete") && request.getParameter("userId") !=null){
			String userId = request.getParameter("userId");
			int id = Integer.parseInt(userId);
			UserDAOImpl udao = new UserDAOImpl();
			udao.deleteById(id);
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
		User user = new User();
		user.setPassword(password);
		user.setUserName(username);
		user.setUserRole(role);
		UserDAOImpl udao = new UserDAOImpl();
		udao.insertUser(user);

		response.sendRedirect("UserList");
	}

}
