/**
 *  Version: 1.0
 * 	Class: Admin
 * 	Description: Admin Object and Properties
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */

package naartjie;

import java.util.Date;

public class Admin extends Staff {
	
	//Constants
	private static final long serialVersionUID = 1L;
	
	//Properties
	private Date lastLogin;

	//Remove Constructor
	protected Admin(String title, String name, String address, String email, int telephone, String dOB,
			char gender, String staffNo, String username, String password, Date dateJoined, String role,
			Date lastLogin) {
		super(title, name, address, email, telephone, dOB, gender, staffNo, username, password, dateJoined, role);
		this.lastLogin = lastLogin;
	}

	//Getters and Setters
	protected Date getLastLogin() {
		return lastLogin;
	}

	protected void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	

}
