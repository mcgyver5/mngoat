package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;

public class UserDAOImpl implements UserDAO {
	DaoManager dao;
	Connection conn;
	public UserDAOImpl(){
		try{
			dao = new DaoManager();
			conn = dao.getConnection();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public List<User> findAll() {		
		String query = "";
		query = "select user_id, username, first_name, last_name, email_address, password, user_role  from users;";
		return createUserList(query);
	}

	@Override
	public List<User> findById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<User> createUserList(String query){
		ResultSet rs = null;
		ArrayList<User> userList = new ArrayList<User>();
		try {
			rs = conn.prepareStatement(query).executeQuery();
			while (rs.next()){	
				User user = processRow(rs);
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.cleanup(conn, rs);
		return userList;
		
	}

	@Override
	public List<User> findByName(String name) {
		String query = "select * from users where username='" + name + "';";
		//query = "select user_id, username, first_name, last_name, email_address, password, user_role from users where username = '" + name + "';";
		System.out.println("find by name query = " + query);
		return createUserList(query);
	}
	
	private User processRow(ResultSet rs) {
		int id;
		User user = null;
		try {
			ResultSetMetaData rsmd = rs.getMetaData();

			int columnCount = rsmd.getColumnCount();
			for(int x=1; x <= columnCount; x++ ){
				System.out.println(rsmd.getColumnLabel(x));
			}
			id = rs.getInt(1);
			String username = rs.getString(rs.findColumn("USERNAME"));
			String firstName = rs.getString(rs.findColumn("FIRST_NAME"));
			String lastName = rs.getString(rs.findColumn("LAST_NAME"));
			String email = rs.getString(rs.findColumn("EMAIL_ADDRESS"));
			String password = rs.getString(rs.findColumn("PASSWORD"));
			String role = rs.getString(rs.findColumn("USER_ROLE"));
			user = new User(id, username, firstName, lastName, email, password, role); 
			
			System.out.println("in process row adding user to : " + user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		/*
		 * String userName, 
			String firstName,
			String lastName,
			String password, 
			String emailAddress,
			String userRole) {
		 */
//		System.out.println(String.format("ID: %1d, Name: %1s", rs.getInt(1), rs.getString(2)));
}
	@Override
	public boolean insertUser(User user) {
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("insert into users "
					+ "(user_id, username, password, first_name, last_name, email_address, user_role)" 
					+ "values (NEXT VALUE FOR tireseq, ?, ?, ?, ?, ?, ?);");
		
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmailAddress());
			stmt.setString(6, user.getUserRole());
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("INSERT USER DID NOT WORK!");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		PreparedStatement ps = null;
		String query = "DELETE FROM users WHERE user_id = ?";
		try {
			ps = conn.prepareStatement(query);
		
		ps.setInt(1, id);
		ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.cleanupConn(conn);
		return true;
	}

	public List<User> findByNameAndPass(String username, String password) {
		String query = "";
		query = "select user_id, username, password, user_role, first_name, last_name, email_address from users where username= '" + username + "' and password= '" + password + "';";
		return createUserList(query);
	}

}
