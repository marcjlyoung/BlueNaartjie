package naartjie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextArea;

public class ReportGenerator 
{
	private String sqlStatement;
	private java.sql.Statement stmt;
	public void nurse(JTextArea area)
	{
		Connection con = DBConnector.createConnection();
		try
		{
			sqlStatement = "select count(*) from Nurse";
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(sqlStatement);
			
			
			
			while(resultSet.next())
			{
				area.append("\n");
				area.append("  Total Number of nurses: "+(resultSet.getInt(1)+""));
				area.append("\n");
			}
		}
		catch(SQLException e) 
		{
			System.out.println(e);
		}
	}
	
	public void doctor(JTextArea area)
	{
		Connection con = DBConnector.createConnection();
		try
		{
			sqlStatement = "select count(*) from doctor";
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(sqlStatement);
			
			
			
			while(resultSet.next())
			{
				area.append("\n");
				area.append("  Total Number of doctors: "+(resultSet.getInt(1)+""));
				area.append("\n");
			}
		}
		catch(SQLException e) 
		{
			System.out.println(e);
		}
	}
	
	public void secretary(JTextArea area)
	{
		Connection con = DBConnector.createConnection();
		try
		{
			sqlStatement = "select count(*) from secretary";
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(sqlStatement);
			
			
			
			while(resultSet.next())
			{
				area.append("\n");
				area.append("  Total Number of secretaries: "+(resultSet.getInt(1)+""));
				area.append("\n");
			}
		}
		catch(SQLException e) 
		{
			System.out.println(e);
		}
	}
	
	public void admin(JTextArea area)
	{
		Connection con = DBConnector.createConnection();
		try
		{
			sqlStatement = "select count(*) from admin";
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(sqlStatement);
			
			
			
			while(resultSet.next())
			{
				area.append("\n");
				area.append("  Total Number of admins: "+(resultSet.getInt(1)+""));
				area.append("\n");
			}
		}
		catch(SQLException e) 
		{
			System.out.println(e);
		}
	}
	
	public void patient(JTextArea area)
	{
		Connection con = DBConnector.createConnection();
		try
		{
			sqlStatement = "select count(*) from patient";
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(sqlStatement);
			
			
			
			while(resultSet.next())
			{
				area.append("\n");
				area.append("  Total Number of patients: "+(resultSet.getInt(1)+""));
				area.append("\n");
			}
		}
		catch(SQLException e) 
		{
			System.out.println(e);
		}
	}
}
