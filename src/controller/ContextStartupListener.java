package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hsqldb.Server;

/**
 * Application Lifecycle Listener implementation class ContextStartupListener
 *
 */
@WebListener
public class ContextStartupListener implements ServletContextListener, ServletContextAttributeListener {
	Server hsqlServer = null;
	
    /**
     * Default constructor. 
     */
    public ContextStartupListener() {
    	System.out.println("Context Default Constructor");

    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("Context Destroyed...");
		hsqlServer.stop();
		hsqlServer = null;
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void createTireTable(Connection connection){
    	ResultSet countRS = null;
		//connection.prepareStatement("drop table tire if exists;").execute();
		try {
			connection.prepareStatement("create table if not exists tire (id integer, tire_vendor varchar(100), "
					+ "tire_name varchar(100) not null, "
					+ "width_cm integer, "
					+ "cost integer, "
					+ "tire_weight integer, "
					+ "tire_manufacturer varchar(100), "
					+ "country_of_origin varchar(100))").execute();
		
    	countRS = connection.prepareStatement("select count(*)  from tire;").executeQuery();
		countRS.next();
		int tireCount = countRS.getInt(1);
		if(tireCount < 4){
			connection.prepareStatement("insert into tire (id, tire_vendor, tire_name, width_cm,cost)" 
				+ "values (1, 'Schwalbe', 'Big Apple', 59, 34);").execute();
			connection.prepareStatement("insert into tire (id, tire_vendor, tire_name, width_cm,cost)" 
				+ "values (2, 'Continental', 'Contact', 37, 31);").execute();
			connection.prepareStatement("insert into tire (id, tire_vendor, tire_name, width_cm,cost)" 
				+ "values (3, 'Schwalbe', 'Big Apple', 54, 45);").execute();		
			connection.prepareStatement("insert into tire (id, tire_vendor, tire_name, width_cm,cost)" 
				+ "values (4, 'Maxxis', 'Hookworm', 49, 23);").execute();		
			connection.prepareStatement("insert into tire (id, tire_vendor, tire_name, width_cm,cost)" 
				+ "values (5, 'Nokian', 'Hakkeplitta', 32, 32);").execute();		
		}
		} catch (SQLException e) {
			System.out.println("Error creating or populating Tire Table");
			e.printStackTrace();
		} finally {
			if(countRS != null){
				try {
					countRS.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }
    
    public void createUserTable(Connection connection){
    	//connection.prepareStatement("drop table users if exists;").execute();
		try{
		connection.prepareStatement("create table if not exists users ("
				+ "user_id integer, username varchar(500), password varchar(200), first_name varchar(200), "
				+ "last_name varchar(200), email_address varchar(200), user_role varchar(200))").execute();
		ResultSet countUsers = connection.prepareStatement("Select count(*) from users").executeQuery();
		countUsers.next();
		int userCount = countUsers.getInt(1);
		if(userCount < 1){
			System.out.println("adding users.....");
			//add 5 users...
			connection.prepareStatement("INSERT INTO users (user_id, username, first_name, last_name, email_address, password, user_role) "
					+ "values (10,'admin', 'Kai', 'Strom', 'k@k.com', 'f@c3800|<', 'admin')").execute();
			connection.prepareStatement("INSERT INTO users (user_id, username, first_name, last_name, email_address, password, user_role) "
					+ "values (11,'joe', 'Joe', 'Piscapo', 'k@k.com','Secret_1234', 'user')").execute();
			connection.prepareStatement("INSERT INTO users (user_id, username, first_name, last_name, email_address, password, user_role) "
					+ "values (12,'tim', 'Tim', 'Mac', 'k@k.com','Password_1234', 'user')").execute();
			connection.prepareStatement("INSERT INTO users (user_id, username, first_name, last_name, email_address, password, user_role) "
					+ "values (13,'max', 'Max', 'Strohs', 'k@k.com','monkey1', 'user')").execute();
			connection.prepareStatement("INSERT INTO users (user_id, username, first_name, last_name, email_address, password, user_role)"
					+ " values (25,'betty', 'Betsy', 'Kind', 'k@k.com','monkey12', 'member')").execute();
			
		}
		} catch (Exception e){
			System.out.println("errors in creating or populating user table");
			e.printStackTrace();
		}
    }
    
    public void createAnnouncementTable(Connection connection){
    	ResultSet countRS2 = null;
		try {
			//	connection.prepareStatement("drop table announcement if exists;").execute();
			connection.prepareStatement("create table if not exists announcement ("
					+ "post_id integer, post_title varchar(20), post_content varchar(1200))"
					).execute();
			countRS2 = connection.prepareStatement("select count(*) from announcement").executeQuery();
			countRS2.next();
			int countPosts = countRS2.getInt(1);
			if(countPosts < 1){
				connection.prepareStatement("INSERT INTO ANNOUNCEMENT (post_id,post_title,post_content) values "
						+ "(101,'WELCOME TO MNGoat','This Post should allow HTML Markup like <b>BOLD</b> "
						+ "OK ')").execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(countRS2 != null){
				try {
					countRS2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		}
    }
    
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        System.out.println("Context initialized");
        Connection connection = null;
		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "bikes");
		hsqlServer.setDatabasePath(0, "file:bikesdb");
		hsqlServer.start();
		// connect
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bikes", "sa", ""); 
			createUserTable(connection);
			createAnnouncementTable(connection);
			createTireTable(connection);
			connection.prepareStatement("create table if not exists hint (hint_id integer, hint_text varchar(500),"
					+ "page_id varchar(100), hint_step integer)").execute();
			connection.prepareStatement("Create SEQUENCE if not exists tireseq START WITH 65").execute();
			connection.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} finally {
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

    }
	
}
