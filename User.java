package models;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * User for data base 
	 */
	private String firstName;
	private String lastName;
	private Integer id;
	private String email;
	private String phoneNumber;
	private String username;
	private String password;
	private boolean isLoggedIn;
	private boolean isStudent;
	private boolean islecturer;
	
	public User(String firstName, String lastName, Integer id, String email, String phoneNumber, String username,
			String password, boolean isLoggedIn,boolean islecturer,boolean isStudent ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.isLoggedIn = isLoggedIn;
		this.islecturer = islecturer;
		this.isStudent = isStudent;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean islecturer() {
		return islecturer;
	}
	public boolean isStudent() {
		return isStudent;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}	
	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}	
	public void setlecturer(boolean islecturer) {
		this.islecturer = islecturer;
	}	
}
