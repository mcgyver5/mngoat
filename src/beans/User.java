package beans;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	int userId;
	String userName;
	String password;
	String userRole;
	String emailAddress;
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	String firstName;
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public User(int userId, 
			String userName, 
			
			String password, 
			String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
	}
	/*
	 * Roles:  admin, member, guest
	 */
	public User(
			String userName, 
			String firstName,
			String lastName,
			String password, 
			String emailAddress,
			String userRole) {
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
	}
	String lastName;
	ArrayList<Bike> bikes;
	
	void addBike(Bike bike){
		// called when user saves a bike
		this.bikes.add(bike);
	}
	// one user has many bikes.
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String username, String firstName, String lastName, String emailAddress, String password,
			String role) {
		this.userId = id;
		this.userName = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		
		this.password = password;
		this.userRole = role;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userRole=" + userRole
				+ ", emailAddress=" + emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", bikes="
				+ bikes + "]";
	}
	
	
	
}
