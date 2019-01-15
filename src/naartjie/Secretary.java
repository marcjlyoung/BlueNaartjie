/**
 *  Version: 1.0
 * 	Class: Secretary
 * 	Description: Secretary Object and Properties
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */
package naartjie;

import java.util.Date;

public class Secretary extends Staff
{
	//Constants
	private static final long serialVersionUID = 1L;
	
	//Properties
	private String deskNumber;

	//Remove Constructor
	protected Secretary(String title, String name, String address, String email, int telephone, String dOB,
			char gender, String staffNo, String username, String password, Date dateJoined, String role,
			String deskNumber) {
		super(title, name, address, email, telephone, dOB, gender, staffNo, username, password, dateJoined, role);
		this.deskNumber = deskNumber;
	}

	//Getters and Setters
	protected String getDeskNumber() {
		return deskNumber;
	}

	protected void setDeskNumber(String deskNumber) {
		this.deskNumber = deskNumber;
	}
	
}
