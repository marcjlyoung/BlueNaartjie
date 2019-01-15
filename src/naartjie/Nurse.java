/**
 *  Version: 1.0
 * 	Class: Nurse
 * 	Description: Nurse Object and Properties
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */

package naartjie;

import java.util.Date;

public class Nurse extends Staff
{
	//Constants
	private static final long serialVersionUID = 1L;
	
	//Properties
	private String pharmacy;

	//Remove Constructor
	protected Nurse(String title, String name, String address, String email, int telephone, String dOB,
			char gender, String staffNo, String username, String password, Date dateJoined, String role,
			String pharmacy) {
		super(title, name, address, email, telephone, dOB, gender, staffNo, username, password, dateJoined, role);
		this.pharmacy = pharmacy;
	}
	
	//Getters and Setters
	protected String getPharmacy() {
		return pharmacy;
	}

	protected void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}

}
