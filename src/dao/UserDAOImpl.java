package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BikePart;
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
		query = "select user_id, username, password, user_role  from users;";
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
		String query = "";
		query = "select user_id, username, password, user_role  from users where username= '" + name + "';";
		return createUserList(query);
	}
	
	private User processRow(ResultSet rs) {
		int id;
		User user = null;
		try {
			id = rs.getInt(1);
			String username = rs.getString(2);
			String password = rs.getString(3);
			String role = rs.getString(4);
			user = new User(id,username,password,role);
			System.out.println("adding user: " + user);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
//		System.out.println(String.format("ID: %1d, Name: %1s", rs.getInt(1), rs.getString(2)));
}
	@Override
	public boolean insertUser(User user) {
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("insert into users "
					+ "(user_id, username, password, user_role)" 
					+ "values (NEXT VALUE FOR tireseq, ?, ?, ?);");
		
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getUserRole());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

}
