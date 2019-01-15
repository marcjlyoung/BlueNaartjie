/**
 *  Version: 1.0
 * 	Class: Staff
 * 	Description: Staff Object and Properties
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */

package naartjie;

import java.util.Date;

public class Staff extends Person
{
	
	//Constants
	private static final long serialVersionUID = 1L;
	
	//Properties
	private String staffNo;
	private String username;
	private String password;
	private Date dateJoined;
	private String role;
	
	//Remove Constructor
	protected Staff(String title, String name, String address, String email, int telephone, String dOB,
			char gender, String staffNo, String username, String password, Date dateJoined, String role) {
		super(title, name, address, email, telephone, dOB, gender);
		this.staffNo = staffNo;
		this.username = username;
		this.password = password;
		this.dateJoined = dateJoined;
		this.role = role;
	}
	
	//Getters and Setters
	protected String getStaffNo() {
		return staffNo;
	}
	protected void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	protected Date getDateJoined() {
		return dateJoined;
	}
	protected void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}
	protected String getRole() {
		return role;
	}
	protected void setRole(String role) {
		this.role = role;
	}
	
	
	
}
