package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoManager {

	public Connection getConnection() {
		Connection conn = null;
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", ""); 
		} catch (SQLException | ClassNotFoundException sqle){
			sqle.printStackTrace();
		}
		return conn;
	}
	
	public void cleanup(Connection conn, ResultSet rs){
		try{
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(conn !=null){
				conn.close();
				conn = null;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void cleanupConn(Connection conn){
		cleanup(conn,null);
	}
	

	private Connection conn;

}


