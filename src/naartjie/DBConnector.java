/**
 *  Version: 1.0
 * 	Class: DBConnector
 * 	Description: Handles Database connectivity and properties
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */


package naartjie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	//Properties
	private static Connection con;
	private static String jdbcUrl = "jdbc:mysql://localhost/Naartjie";
	private static String driver = "com.mysql.jdbc.Driver";
	
	
	//Creates the database connection
	protected static Connection createConnection() {
		try {
			Class.forName(driver);
		    con = DriverManager.getConnection(jdbcUrl, "root", "");
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return con;
	}
	
	//Getters and Setters 
	protected void setUrl(String url) {
		DBConnector.jdbcUrl = url; 
	}
	
	protected String getUrl() {
		return DBConnector.jdbcUrl;
	}

	protected void setDriver(String driver) {
		DBConnector.driver = driver; 
	}
	
	protected String getDriver() {
		return DBConnector.driver;
	}
}
