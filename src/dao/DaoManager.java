package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoManager {

	public DaoManager() throws Exception{
		try{
			InitialContext ctx = new InitialContext(); 
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	

	private Connection conn;

}


