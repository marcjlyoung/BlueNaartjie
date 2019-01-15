/**
 *  Version: 1.0
 * 	Class: AdminHandler
 * 	Description:  Handles Admin functionality
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */


package naartjie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminHandler 
{
		//Properties
		private String sqlStatement;
		private PreparedStatement stmt;
		
		
		//Methods
		
		protected void findAdmin(String search, JTable table) 
		{
			Connection con = DBConnector.createConnection();
			try
			{
				sqlStatement ="SELECT staffNo, username, name FROM staff INNER JOIN person ON staff.personId = person.personId WHERE username LIKE '%"+ search+"%'";
				stmt = con.prepareStatement(sqlStatement);
				ResultSet resultset = stmt.executeQuery(sqlStatement);
				
				while(resultset.next())
				{
					String staffno = resultset.getString("staffNo");
					String username = resultset.getString("username");
					String name = resultset.getString("name");
					table.add(table, new Object[] {staffno, username, name});
				}
				con.close();
			}
			catch(SQLException e) 
			{
				System.out.println(e);
			}
		}

	public void fAdmin(String search, JTable table) 
	{
		String sqlStatement;
		PreparedStatement stmt;
		Connection con = DBConnector.createConnection();
		try
		{
			DefaultTableModel model = new DefaultTableModel(new String[] {"StaffNo", "Username","Name"},  0);
			sqlStatement ="SELECT staffNo, username, name FROM staff INNER JOIN person ON staff.personId = person.personId WHERE username LIKE '%"+ search+"%' OR name LIKE'%"+search+"%' OR staffNo LIKE'%"+search+"%'";
			stmt = con.prepareStatement(sqlStatement);
			ResultSet resultset = stmt.executeQuery(sqlStatement);
			while(resultset.next())
			{
				String staffno = resultset.getString("staffNo");
				String username = resultset.getString("username");
				String name = resultset.getString("name");
				model.addRow(new Object[] {staffno, username, name});
			}
			table.setModel(model);
			con.close();
		}
		catch(SQLException e) 
		{
			System.out.println(e);
		}
	}
	
	public String dateJoined()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = Calendar.getInstance().getTime(); 
		return (dateFormat.format(date));
	}
	
	public void insertNurse(String Title, String name, String address, String email, int tel, String DOB, char gender, String staffno, String username, String password, Date Joined, String pharm )
	{
		String role = "Nurse";
		Nurse r = new Nurse(Title, name, address, email, tel, DOB, gender, staffno, username, password, Joined, role, pharm);
		
		Title = r.getTitle();
		name = r.getName();
		address = r.getAddress();
		email = r.getEmail();
		tel = r.getTelephone();
		DOB = r.getdOB();
		gender = r.getGender();
		staffno = r.getStaffNo();
		username = r.getUsername();
		EncryptionHandler e = new EncryptionHandler();
		password = e.encrypt(r.getPassword());
		
		Joined = r.getDateJoined();
		pharm = r.getPharmacy();
		String g = gender+"";
		String dob = r.getdOB();
		boolean recordAdded = false;

		
		java.util.Date D = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			D = format.parse(dob);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		java.sql.Date sDOB = new java.sql.Date(D.getTime());
		java.sql.Date sJoined = new java.sql.Date(Joined.getTime());
		
	
		try
		{
			Connection con = DBConnector.createConnection();
			
			String checkID = "SELECT staffNo FROM staff WHERE staffNo = ?";
			PreparedStatement ps = con.prepareStatement(checkID);
			ps.setString(1, staffno);
			ResultSet rs1 = ps.executeQuery();
			if(!rs1.next())
				{
					recordAdded = true;
				}
			
			if(recordAdded)
			{
				String personSqlStament = "INSERT INTO person (title, name, address, email, telephone, dateOfBirth, gender)" + "VALUES(?,?,?,?,?,?,?)";
				PreparedStatement personStmt = con.prepareStatement(personSqlStament);
				personStmt.setString(1, Title);
				personStmt.setString(2, name);
				personStmt.setString(3, address);
				personStmt.setString(4, email);
				personStmt.setInt(5, tel);
				personStmt.setDate(6, sDOB);
				personStmt.setString(7, g);
				personStmt.executeUpdate();
				
				String pID = "SELECT max(personId) FROM person";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(pID);
				int mid =0;
				while(rs.next())
				{
					mid = rs.getInt(1);
				}
				System.out.println(mid);
				
				String staffSqlStatement = "INSERT INTO staff (staffNo, username, password, dateJoined, role, personId)" + "VALUES(?,?,?,?,?,?)";
				PreparedStatement staffStmt = con.prepareStatement(staffSqlStatement);
				staffStmt.setString(1, staffno);
				staffStmt.setString(2, username);
				staffStmt.setString(3, password);
				staffStmt.setDate(4, sJoined);
				staffStmt.setString(5, role);
				staffStmt.setInt(6, mid);
				staffStmt.executeUpdate();
				
				String sqlStatement = "INSERT INTO nurse (staffNo, pharmacy)" + "VALUES(?,?)";
				PreparedStatement stmt = con.prepareStatement(sqlStatement);
				stmt.setString(1, staffno);
				stmt.setString(2, pharm);
				stmt.executeUpdate();
				con.close();
				
				JOptionPane.showMessageDialog(null, name + " has been successfully added to the system");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"StaffNo already exists","Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch (Exception x) 
		{
			x.printStackTrace();
		}
		
	}
	public void insertDoctor(Doctor doc)
	{
		String role = "Doctor";
		String Title = doc.getTitle();
		String name = doc.getName();
		String email = doc.getEmail();
		int tel = doc.getTelephone();
		String address = doc.getAddress();
		char gender = doc.getGender();
		String staffno = doc.getStaffNo();
		String username = doc.getUsername();
		EncryptionHandler e = new EncryptionHandler();
		String password = e.encrypt(doc.getPassword());
		Date Joined = doc.getDateJoined();
		String speciality = doc.getSpeciality();
		String officeNo = doc.getOfficeNumber();
		String dob = doc.getdOB();
		boolean recordAdded = false;
		
		java.util.Date D = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			D = format.parse(dob);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		java.sql.Date sDOB = new java.sql.Date(D.getTime());
		java.sql.Date sJoined = new java.sql.Date(Joined.getTime());
		
		try
		{
			Connection con = DBConnector.createConnection();
			
			String checkID = "SELECT staffNo FROM staff WHERE staffNo = ?";
			PreparedStatement ps = con.prepareStatement(checkID);
			ps.setString(1, staffno);
			ResultSet rs1 = ps.executeQuery();
			if(!rs1.next())
				{
					recordAdded = true;
				}
			if(recordAdded)
			{
				String personSqlStament = "INSERT INTO person (title, name, address, email, telephone, dateOfBirth, gender)" + "VALUES(?,?,?,?,?,?,?)";
				PreparedStatement personStmt = con.prepareStatement(personSqlStament);
				personStmt.setString(1, Title);
				personStmt.setString(2, name);
				personStmt.setString(3, address);
				personStmt.setString(4, email);
				personStmt.setInt(5, tel);
				personStmt.setDate(6, sDOB);
				personStmt.setString(7, gender+"");
				personStmt.executeUpdate();
				
				String pID = "SELECT max(personId) FROM person";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(pID);
				int mid =0;
				while(rs.next())
				{
					mid = rs.getInt(1);
				}
				
				String staffSqlStatement = "INSERT INTO staff (staffNo, username, password, dateJoined, role, personId)" + "VALUES(?,?,?,?,?,?)";
				PreparedStatement staffStmt = con.prepareStatement(staffSqlStatement);
				staffStmt.setString(1, staffno);
				staffStmt.setString(2, username);
				staffStmt.setString(3, password);
				staffStmt.setDate(4, sJoined);
				staffStmt.setString(5, role);
				staffStmt.setInt(6, mid);
				staffStmt.executeUpdate();
				
				String sqlStatementDoctor = "INSERT INTO doctor (staffNo, speciality, officeNumber)" + "VALUES(?,?,?)";
				PreparedStatement stmtD = con.prepareStatement(sqlStatementDoctor);
				stmtD.setString(1, staffno);
				stmtD.setString(2, speciality);
				stmtD.setString(3, officeNo);
				stmtD.executeUpdate();
				JOptionPane.showMessageDialog(null, name + " has been successfully added to the system");
				con.close();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"StaffNo already exists","Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch (Exception x) 
		{
			x.printStackTrace();
		}
		
	}
	
	public void insertSecretary(Secretary secretary)
	{
		String Title = secretary.getTitle();
		String name = secretary.getName();
		String address = secretary.getAddress();
		String email = secretary.getEmail();
		int tel = secretary.getTelephone();
		Date Joined = secretary.getDateJoined();
		char gender = secretary.getGender();
		String staffno = secretary.getStaffNo();
		String username = secretary.getUsername();
		EncryptionHandler e = new EncryptionHandler();
		String password = e.encrypt(secretary.getPassword());
		String deskNo = secretary.getDeskNumber();
		String role = "Secretary";
		String dob = secretary.getdOB();
		boolean recordAdded = false;
		
		java.util.Date D = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			D = format.parse(dob);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		java.sql.Date sDOB = new java.sql.Date(D.getTime());
		java.sql.Date sJoined = new java.sql.Date(Joined.getTime());
		
		try
		{
			Connection con = DBConnector.createConnection();
			
			String checkID = "SELECT staffNo FROM staff WHERE staffNo = ?";
			PreparedStatement ps = con.prepareStatement(checkID);
			ps.setString(1, staffno);
			ResultSet rs1 = ps.executeQuery();
			if(!rs1.next())
				{
					recordAdded = true;
				}
			if(recordAdded)
			{
				String personSqlStament = "INSERT INTO person (title, name, address, email, telephone, dateOfBirth, gender)" + "VALUES(?,?,?,?,?,?,?)";
				PreparedStatement personStmt = con.prepareStatement(personSqlStament);
				personStmt.setString(1, Title);
				personStmt.setString(2, name);
				personStmt.setString(3, address);
				personStmt.setString(4, email);
				personStmt.setInt(5, tel);
				personStmt.setDate(6, sDOB);
				personStmt.setString(7, gender+"");
				personStmt.executeUpdate();
				
				String pID = "SELECT max(personId) FROM person";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(pID);
				int mid =0;
				while(rs.next())
				{
					mid = rs.getInt(1);
				}
				
				String staffSqlStatement = "INSERT INTO staff (staffNo, username, password, dateJoined, role, personId)" + "VALUES(?,?,?,?,?,?)";
				PreparedStatement staffStmt = con.prepareStatement(staffSqlStatement);
				staffStmt.setString(1, staffno);
				staffStmt.setString(2, username);
				staffStmt.setString(3, password);
				staffStmt.setDate(4, sJoined);
				staffStmt.setString(5, role);
				staffStmt.setInt(6, mid);
				staffStmt.executeUpdate();
				
				String sqlStatementSecretary = "INSERT INTO secretary (staffNo, desknumber)" + "VALUES(?,?)";
				PreparedStatement stmtD = con.prepareStatement(sqlStatementSecretary);
				stmtD.setString(1, staffno);
				stmtD.setString(2, deskNo);
				stmtD.executeUpdate();
				JOptionPane.showMessageDialog(null, name + " has been successfully added to the system");
				
				con.close();
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"StaffNo already exists","Warning", JOptionPane.WARNING_MESSAGE);
			}
		}	
		
		catch (Exception x) 
		{
			x.printStackTrace();
		}
		
	}
	
	public void insertAdmin(Admin admin)
	{
		String Title = admin.getTitle();
		String name = admin.getName();
		String address = admin.getAddress();
		String email = admin.getEmail();
		int tel = admin.getTelephone();
		Date Joined = admin.getDateJoined();
		char gender = admin.getGender();
		String role = "Admin";
		String username = admin.getUsername();
		EncryptionHandler e = new EncryptionHandler();
		String password = e.encrypt(admin.getPassword());
		String staffno = admin.getStaffNo();
		Date lastLogin = admin.getLastLogin();
		String dob = admin.getdOB();
		boolean recordAdded = false;
		
		java.util.Date D = new Date();
	
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				D = format.parse(dob);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		
		java.sql.Date sDOB = new java.sql.Date(D.getTime());
		java.sql.Date sJoined = new java.sql.Date(Joined.getTime());
		System.out.println("this is the date of birth in isert admin after replace : " +sDOB);
		try
		{
			Connection con = DBConnector.createConnection();
			
			String checkID = "SELECT staffNo FROM staff WHERE staffNo = ?";
			PreparedStatement ps = con.prepareStatement(checkID);
			ps.setString(1, staffno);
			ResultSet rs1 = ps.executeQuery();
			if(!rs1.next())
				{
					recordAdded = true;
				}
			if(recordAdded)
			{
				String personSqlStament = "INSERT INTO person (title, name, address, email, telephone, dateOfBirth, gender)" + "VALUES(?,?,?,?,?,?,?)";
				PreparedStatement personStmt = con.prepareStatement(personSqlStament);
				personStmt.setString(1, Title);
				personStmt.setString(2, name);
				personStmt.setString(3, address);
				personStmt.setString(4, email);
				personStmt.setInt(5, tel);
				personStmt.setDate(6, sDOB);
				personStmt.setString(7, gender+"");
				personStmt.executeUpdate();
				
				String pID = "SELECT max(personId) FROM person";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(pID);
				int mid =0;
				while(rs.next())
				{
					mid = rs.getInt(1);
				}
				
				String staffSqlStatement = "INSERT INTO staff (staffNo, username, password, dateJoined, role, personId)" + "VALUES(?,?,?,?,?,?)";
				PreparedStatement staffStmt = con.prepareStatement(staffSqlStatement);
				staffStmt.setString(1, staffno);
				staffStmt.setString(2, username);
				staffStmt.setString(3, password);
				staffStmt.setDate(4, sJoined);
				staffStmt.setString(5, role);
				staffStmt.setInt(6, mid);
				staffStmt.executeUpdate();
				
				String sqlStatementSecretary = "INSERT INTO admin (staffNo, lastLogin)" + "VALUES(?,?)";
				PreparedStatement stmtD = con.prepareStatement(sqlStatementSecretary);
				stmtD.setString(1, staffno);
				stmtD.setDate(2, (java.sql.Date) lastLogin);
				stmtD.executeUpdate();
				JOptionPane.showMessageDialog(null, name + " has been successfully added to the system");
				
				con.close();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"StaffNo already exists","Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch (Exception x) 
		{
			x.printStackTrace();
		}
	}
	
	public void editSearch(String ID, JTextField usernameField, JTextField passField, JTextField name, JTextField address , JTextField tel, JTextField special, JTextField pharm)
	{
		String u =null;
		String pass = null;
		String Name = null;
		String Address = null;
		int tele = 0;
		String Special = null;
		String Pharm = null;
		boolean recordAdded = true;
		try
		{
			Connection con = DBConnector.createConnection();
			String checkID1 = "SELECT staffNo FROM staff WHERE staffNo = ?";
			PreparedStatement ps1 = con.prepareStatement(checkID1);
			ps1.setString(1, ID);
			ResultSet rs = ps1.executeQuery();
			if(rs.next())
				{
					recordAdded = false;
				}
			if(recordAdded == false)
			{
				try
				{
					String checkID = "SELECT* FROM staff WHERE staffNo = ?";
					PreparedStatement ps = con.prepareStatement(checkID);
					ps.setString(1, ID);
					ResultSet rs1 = ps.executeQuery();
					
					while(rs1.next())
					{
						u = rs1.getString(2);
						pass = rs1.getString(3);
				
						usernameField.setText(u);
						passField.setText(pass);
					}
					
					String checkPersonID = "SELECT name, title, address, email, telephone FROM staff INNER JOIN person ON staff.personId = person.personId WHERE staffNo = ?";
					PreparedStatement ps2 = con.prepareStatement(checkPersonID);
					ps2.setString(1, ID);
					ResultSet rs2 = ps2.executeQuery();
					
					while(rs2.next())
					{
						Name = rs2.getString("name");
						Address = rs2.getString("address");
						tele = rs2.getInt("telephone");
					}
					name.setText(Name);
					address.setText(Address);
					tel.setText(tele+"");
					
					String checkNurseID = "SELECT pharmacy FROM nurse INNER JOIN staff ON staff.staffNo = nurse.staffNo WHERE staff.staffNo = ?";
					PreparedStatement nursest = con.prepareStatement(checkNurseID);
					nursest.setString(1, ID);
					ResultSet Nrs2 = nursest.executeQuery();
					
					while(Nrs2.next())
					{
						Pharm = Nrs2.getString(1);
					}
					pharm.setText(Pharm);
					
					String checkDoctorID = "SELECT speciality FROM doctor INNER JOIN staff ON staff.staffNo = doctor.staffNo WHERE staff.staffNo = ?";
					PreparedStatement doctorst = con.prepareStatement(checkDoctorID);
					doctorst.setString(1, ID);
					ResultSet Drs2 = doctorst.executeQuery();
					
					while(Drs2.next())
					{
						Special = Drs2.getString(1);
					}
					special.setText(Special);
					
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Staff Number does not exist");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Date lastLogin()
	{
		Date date = Calendar.getInstance().getTime(); 
		 java.sql.Date sDate = new java.sql.Date(date.getTime());
		return sDate;
	}
	
	protected void updateDoctor(String search, String u, String pass, String Name, String Address, String tele, String Special, String Pharm, String role)
	{
		String personID =null;
		boolean recordAdded = true;
		try
		{
			EncryptionHandler e = new EncryptionHandler();
			String password = e.encrypt(pass);
			Connection con = DBConnector.createConnection();
		
			String checkID = "SELECT staffNo FROM staff WHERE staffNo = ?";
			PreparedStatement ps = con.prepareStatement(checkID);
			ps.setString(1, search);
			ResultSet rs1 = ps.executeQuery();
			if(rs1.next())
				{
					recordAdded = false;
				}
			if(recordAdded == false)
			{
				try
				{
					int tel = Integer.parseInt(tele);
					String personId = "SELECT personId FROM staff WHERE staffNo = ?";
					PreparedStatement ps2 = con.prepareStatement(personId);
					ps2.setString(1, search);
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next())
						{
							personID = rs2.getString("personId");
						}
					
					String paymentSqlStament = "UPDATE person SET name = ?, address = ?, telephone = ? WHERE personId ="+personID;
					PreparedStatement paymentStmt = con.prepareStatement(paymentSqlStament);
					paymentStmt.setString(1, Name);
					paymentStmt.setString(2, Address);
					paymentStmt.setInt(3, tel);
					paymentStmt.executeUpdate();
					
					String paymentSqlStament1 = "UPDATE staff SET password = ? WHERE staffNo = ?";
					PreparedStatement paymentStmt1 = con.prepareStatement(paymentSqlStament1);
					paymentStmt1.setString(1, password);
					paymentStmt1.setString(2, search);
					paymentStmt1.executeUpdate();
					
					if(role.equals("Doctor"))
					{
						String payment1SqlStament = "UPDATE doctor SET speciality = ? WHERE staffNo = ?";
						PreparedStatement paymentStmt2 = con.prepareStatement(payment1SqlStament);
						paymentStmt2.setString(1, Special);
						paymentStmt2.setString(2, search);
						paymentStmt2.executeUpdate();
					}
					if(role.equals("Nurse"))
					{
						String payment1SqlStament = "UPDATE nurse SET pharmacy = ? WHERE staffNo = ?";
						PreparedStatement paymentStmt2 = con.prepareStatement(payment1SqlStament);
						paymentStmt2.setString(1, Pharm);
						paymentStmt2.setString(2, search);
						paymentStmt2.executeUpdate();
					}
					JOptionPane.showMessageDialog(null,"Update Successful");
				}
				catch(SQLException x)
				{
					x.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Staff Number does not exist","Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
	}
	
	protected void deleteStaff(String ID)
	{
		Connection con = DBConnector.createConnection();
		boolean recordAdded = true;
		try
		{
			String checkID1 = "SELECT staffNo FROM staff WHERE staffNo = ?";
			PreparedStatement ps1 = con.prepareStatement(checkID1);
			ps1.setString(1, ID);
			ResultSet rs = ps1.executeQuery();
			if(rs.next())
				{
					recordAdded = false;
				}
			if(recordAdded == false)
			{
				try
				{
					String personID = null;
					String checkID = "SELECT person.personId FROM staff INNER JOIN person ON staff.personId = person.personId WHERE staff.staffNo = ?";
					PreparedStatement ps = con.prepareStatement(checkID);
					ps.setString(1, ID);
					ResultSet rs1 = ps.executeQuery();
					
					while(rs1.next())
					{
						personID = rs1.getString(1);
					}
					
					sqlStatement ="DELETE FROM staff WHERE staffNo ="+ID;
					stmt = con.prepareStatement(sqlStatement);
					stmt.executeUpdate(sqlStatement);
					
					sqlStatement ="DELETE FROM person WHERE person.personId ="+personID;
					stmt = con.prepareStatement(sqlStatement);
					stmt.executeUpdate(sqlStatement);
					JOptionPane.showMessageDialog(null, "Staff successfully deleted");
				}
				catch(SQLException x)
				{
					x.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Staff Number does not exist","Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}

/*String searches = "SELECT Animals.animal_id, Animals.animal_name, Animals.description,"
        + "Animals.species_id FROM Animals INNER JOIN Species ON "
        + "Animals.species_id = Species.species_id "
        + "WHERE (Species.Species_name LIKE '%"+speciesName+"%')";
        
         PreparedStatement st = conn.prepareStatement(searches);
                  ResultSet rec = st.executeQuery();
*/
