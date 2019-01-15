/**
 *  Version: 1.0
 * 	Class: LoginHandler
 * 	Description: Handles login functionality
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */


package naartjie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginHandler 
{
	//Properties
	private String sqlStatement;
	private PreparedStatement stmt;
	private Connection con;
	private String hash;
	private ResultSet result;
	
	
	//Methods
	
	//Validates Login Details
	public Staff validateLogin(Staff person) 
	{
		con = DBConnector.createConnection();
		EncryptionHandler en = new EncryptionHandler();
		hash = en.encrypt(person.getPassword());
		sqlStatement ="SELECT staff.role, person.name FROM staff INNER JOIN person ON staff.personId=person.personId WHERE username=? AND password=?";
		try 
		{
			stmt = con.prepareStatement(sqlStatement);
			stmt.setString(1, person.getUsername());
			stmt.setString(2, hash);
			result = stmt.executeQuery();
			if(result.next()) 
			{
				person.setRole(result.getString(1));
				person.setName(result.getString(2));
				con.close();
				return person;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		person.setRole("Incorrect");
		return person;
	}

}
