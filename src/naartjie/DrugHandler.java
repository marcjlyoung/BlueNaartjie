/**
 *  Version: 1.0
 * 	Class: Admin
 * 	Description: Handles Drug Object Functionality 
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */


package naartjie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DrugHandler 
{
	//Properties
	private String sqlStatement;
	private PreparedStatement stmt;
	
	//Counts Number of Drugs
	protected Drug countDrugs(Drug drug) {
		Connection con = DBConnector.createConnection();
		try 
		{
			sqlStatement = "SELECT COUNT(drugId) FROM drug";
			stmt = con.prepareStatement(sqlStatement);
			ResultSet res = stmt.executeQuery();
			res.next();
			drug.setNumberOfDrugs(res.getInt(1));
			con.close();
			return drug;
		}
		catch(SQLException e)
		{
			System.out.println(e.fillInStackTrace());
		}
		
		return null;
	}
	
	//Deletes Drugs
	protected boolean deleteDrug(Drug drug) {
		Connection con = DBConnector.createConnection();
		try 
		{
			sqlStatement = "DELETE FROM drug WHERE drugId = ? OR name = ?";
			stmt = con.prepareStatement(sqlStatement);
			stmt.setString(1, drug.getDrugId());
			stmt.setString(2, drug.getDrugId());
			stmt.executeUpdate();
			con.close();
			return true;
		}
		catch(SQLException e)
		{
			System.out.println(e.fillInStackTrace());
		}
		
		return false;
		
	}
	
	//Updates Drugs
	protected boolean updateDrug(Drug drug) 
	{
		Connection con = DBConnector.createConnection();
		try 
		{
			sqlStatement = "UPDATE drug SET name = ?, drugInfo = ? WHERE drugId = ?";
			stmt = con.prepareStatement(sqlStatement);
			stmt.setString(1, drug.getDrugName());
			stmt.setString(2, drug.getDrugDescription());
			stmt.setString(3, drug.getDrugId());
			stmt.executeUpdate();
			con.close();
			return true;
		}
		catch(SQLException e)
		{
			System.out.println(e.fillInStackTrace());
		}
		
		return false;
	}
	
	//Finds an exact Drug
	protected Drug findExactDrug(Drug drug) 
	{
		Connection con = DBConnector.createConnection();
		try
		{	
			sqlStatement ="SELECT drugId, name, drugInfo FROM drug WHERE drugId=? OR name=?";
			stmt = con.prepareStatement(sqlStatement);
			stmt.setString(1, drug.getDrugId());
			stmt.setString(2, drug.getDrugName());
			ResultSet res = stmt.executeQuery();
			if(res.next()) 
			{
				Drug d = new Drug();
				d.setDrugId(res.getString(1));
				d.setDrugName(res.getString(2));
				d.setDrugDescription(res.getString(3));
				con.close();
				return d;
			}
			con.close();
		}
		catch(SQLException e) 
		{
			System.out.println(e.fillInStackTrace());
		}
	
		return null;
	}
	
	//Finds similar Drugs
	protected Drug[] findDrugs(Drug drug)
	{
		Connection con = DBConnector.createConnection();
	
		try
		{	
			int count = 0;
			sqlStatement ="SELECT drugId, name, drugInfo FROM drug WHERE drugId LIKE '%"+drug.getDrugId()+"%' OR name LIKE '%"+drug.getDrugName()+"%'";
			stmt = con.prepareStatement(sqlStatement);
			ResultSet res = stmt.executeQuery();
			res.last();
			Drug[] lists = new Drug[res.getRow()];
			res.beforeFirst();
			if(res.next()) {
				res.previous();
				while(res.next())
				{
					Drug d = new Drug();
					d.setDrugId(res.getString(1));
					d.setDrugName(res.getString(2));
					d.setDrugDescription(res.getString(3));
					lists[count] = d;
					count++;
				}
				con.close();
				return lists;
			}
		}
		catch(SQLException e) 
		{
			System.out.println(e.fillInStackTrace());
		}
		
		return null;
	}
	
	//Adds a Drug
	protected String addDrug(Drug drug) {

		Connection con = DBConnector.createConnection();
		try
		{
			
			sqlStatement ="SELECT drugId FROM drug WHERE drugId=? OR name=?";
			stmt = con.prepareStatement(sqlStatement);
			stmt.setString(1, drug.getDrugId());
			stmt.setString(2, drug.getDrugName());
			ResultSet res = stmt.executeQuery();
			if(res.next())
			{
				con.close();
				return "Failed";
				
			}
			else 
			{
				sqlStatement ="INSERT INTO drug (drugId, name, drugInfo) VALUES (?, ?, ?)";
				stmt = con.prepareStatement(sqlStatement);
				stmt.setString(1, drug.getDrugId());
				stmt.setString(2, drug.getDrugName());
				stmt.setString(3, drug.getDrugDescription());
				stmt.executeUpdate();
				con.close();
				return "Inserted";
			}
			
		}
		catch(SQLException e) 
		{
			System.out.println(e.fillInStackTrace());
		}
		return "Failed";
	}
	
}
