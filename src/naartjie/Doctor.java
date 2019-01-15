/**
 *  Version: 1.0
 * 	Class: Doctor
 * 	Description: Doctor Object and Properties
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */


package naartjie;

import java.util.Date;

public class Doctor extends Staff
{
	//Constant
	private static final long serialVersionUID = 1L;
	
	//Properties
	private String speciality;
	private String officeNumber;
	
	//Remove Constructors
	protected Doctor(String title, String name, String address, String email, int telephone, String dOB,
			char gender, String staffNo, String username, String password, Date dateJoined, String role,
			String speciality, String officeNumber) {
		super(title, name, address, email, telephone, dOB, gender, staffNo, username, password, dateJoined, role);
		this.speciality = speciality;
		this.officeNumber = officeNumber;
	}
	
	//Getters and Setters
	protected String getSpeciality() {
		return speciality;
	}
	protected void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	protected String getOfficeNumber() {
		return officeNumber;
	}
	protected void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	
	
}
