/**
 *  Version: 1.0
 * 	Class: PatientHandler
 * 	Description:  Handles Patient functionality
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

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;



public class PatientHandler {
	private String sqlStatement;
	private PreparedStatement stmt;
	
	protected void updatePatientMed(PatientMA patient,Boolean medical, int search, String option) {
		Connection con = DBConnector.createConnection();
		String title = patient.getTitle();
		String name= patient.getName();
		String address = patient.getAddress();
		int tel = patient.getTelephone();
		String email = patient.getEmail();
		String medicalHistory = patient.getMedicalHistory();
		String prescriptions = patient.getPrescriptions();
		String allergies = patient.getAllergies();
		String medAid = patient.getMedicalAid();
		int medAidNo = patient.getMedicalNo();
		int personID =0;
		boolean recordAdded = true;
		System.out.println(option+"good");
		try
		{
			String checkID = "SELECT patientNo FROM patient WHERE patientNo = ?";
			PreparedStatement ps = con.prepareStatement(checkID);
			ps.setInt(1, search);
			ResultSet rs1 = ps.executeQuery();
			if(rs1.next())
				{
					recordAdded = false;
				}
			if(recordAdded == false)
			{
				boolean recordFound = true;
				String existPatientNo = "SELECT patientNo FROM medicalaid WHERE patientNo =?";
				PreparedStatement exist = con.prepareStatement(existPatientNo);
				exist.setInt(1, search);
				ResultSet result = exist.executeQuery();
				if(!result.next())
				{
					recordFound = false;
				}
				
					if(option.equals("Yes"))
					{
						try
						{
							String personId = "SELECT personId FROM patient WHERE patientNo = ?";
							PreparedStatement ps2 = con.prepareStatement(personId);
							ps2.setInt(1, search);
							ResultSet rs2 = ps2.executeQuery();
							if(rs2.next())
								{
									personID = rs2.getInt(1);
								}
							
							String paymentSqlStament = "UPDATE person SET title = ?, name = ?, address = ?, email = ?, telephone = ? WHERE personId ="+personID;
							PreparedStatement paymentStmt = con.prepareStatement(paymentSqlStament);
							paymentStmt.setString(1, title);
							paymentStmt.setString(2, name);
							paymentStmt.setString(3, address);
							paymentStmt.setString(4, email);
							paymentStmt.setInt(5, tel);
							paymentStmt.executeUpdate();
							
							String SqlStament = "UPDATE patient SET allergies = ?, medicalHistory = ?, prescriptions = ? WHERE patientNo ="+search;
							PreparedStatement Stmt = con.prepareStatement(SqlStament);
							Stmt.setString(1, allergies);
							Stmt.setString(2, medicalHistory);
							Stmt.setString(3, prescriptions);
							Stmt.executeUpdate();
							if(recordFound==false)
							{
								String SqlStament3 = "INSERT INTO medicalaid (patientNo, medicalAid, medicalNo)" +"VALUES(?,?,?)";
								PreparedStatement Stmt3 = con.prepareStatement(SqlStament3);
								Stmt3.setInt(1, search);
								Stmt3.setString(2, medAid);
								Stmt3.setInt(3, medAidNo);
								Stmt3.executeUpdate();
								
								SqlStament3 = "UPDATE patient SET hasMedical = ? WHERE patientNo ="+search;
								Stmt3 = con.prepareStatement(SqlStament3);
								Stmt3.setInt(1, 1);
								Stmt3.executeUpdate();
							}
							else
							{
								String SqlStamentMed = "UPDATE medicalaid SET medicalAid = ?, medicalNo = ? WHERE patientNo ="+search;
								PreparedStatement StmtMed = con.prepareStatement(SqlStamentMed);
								StmtMed.setString(1, medAid);
								StmtMed.setInt(2, medAidNo);
								StmtMed.executeUpdate();
								System.out.println("record not found");
							}
							
							JOptionPane.showMessageDialog(null,"Update Successful");
							
						}
						catch(SQLException e) 
						{
							System.out.println(e);
						}
					}
					if(option.equals("No"))
					{
						try
						{
							sqlStatement ="DELETE FROM medicalaid WHERE patientNo ="+search;
							stmt = con.prepareStatement(sqlStatement);
							stmt.executeUpdate(sqlStatement);
							
							sqlStatement = "UPDATE patient SET hasMedical = ? WHERE patientNo ="+search;
							stmt = con.prepareStatement(sqlStatement);
							stmt.setInt(1, 0);
							stmt.executeUpdate();
							JOptionPane.showMessageDialog(null,"Update Successful");
						}
						catch(SQLException e) 
						{
							System.out.println(e);
						}
					}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Patient Number does not exist","Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(SQLException e) 
		{
			System.out.println(e);
		}
	
	}
	
	protected void updatePatient(Patient patient, Boolean medical, int search, String option)
	{
		Connection con = DBConnector.createConnection();
		String title = patient.getTitle();
		String name= patient.getName();
		String address = patient.getAddress();
		int tel = patient.getTelephone();
		String email = patient.getEmail();
		String medicalHistory = patient.getMedicalHistory();
		String prescriptions = patient.getPrescriptions();
		String allergies = patient.getAllergies();
		int personID =0;
		boolean recordAdded = true;
		try
		{
			String checkID = "SELECT patientNo FROM patient WHERE patientNo = ?";
			PreparedStatement ps = con.prepareStatement(checkID);
			ps.setInt(1, search);
			ResultSet rs1 = ps.executeQuery();
			if(rs1.next())
				{
					recordAdded = false;
				}
			if(recordAdded == false)
			{
				if(option=="No")
				{
					try
					{
						String personId = "SELECT personId FROM patient WHERE patientNo = ?";
						PreparedStatement ps2 = con.prepareStatement(personId);
						ps2.setInt(1, search);
						ResultSet rs2 = ps2.executeQuery();
						if(rs2.next())
							{
								personID = rs2.getInt(1);
							}
						
						String paymentSqlStament = "UPDATE person SET title = ?, name = ?, address = ?, email = ?, telephone = ? WHERE personId ="+personID;
						PreparedStatement paymentStmt = con.prepareStatement(paymentSqlStament);
						paymentStmt.setString(1, title);
						paymentStmt.setString(2, name);
						paymentStmt.setString(3, address);
						paymentStmt.setString(4, email);
						paymentStmt.setInt(5, tel);
						paymentStmt.executeUpdate();
						
						String SqlStament = "UPDATE patient SET allergies = ?, medicalHistory = ?, prescriptions = ? WHERE patientNo ="+search;
						PreparedStatement Stmt = con.prepareStatement(SqlStament);
						Stmt.setString(1, allergies);
						Stmt.setString(2, medicalHistory);
						Stmt.setString(3, prescriptions);
						Stmt.executeUpdate();
						
						JOptionPane.showMessageDialog(null,"Update Successful");
					}
					catch(SQLException e) 
					{
						System.out.println(e);
					}
				}
				else
				{
					try
					{
						String SqlStament = "INSERT INTO medicalaid (patientNo, medicalAid, medicalNo)" +"VALUES(?,?,?)";
						con.prepareStatement(SqlStament);
						
					}
					catch(SQLException e) 
					{
						System.out.println(e);
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Patient Number does not exist","Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(SQLException e) 
		{
			System.out.println(e);
		}
	}
	
	protected void payment(String sponsorName, int tel, String paymentOption, int amount,int Id )
	{
		Connection con = DBConnector.createConnection();
		try
		{
			boolean recordAdded = true;
			String checkID = "SELECT patientNo FROM patient WHERE patientNo = ?";
			PreparedStatement ps = con.prepareStatement(checkID);
			ps.setInt(1, Id);
			ResultSet rs1 = ps.executeQuery();
			if(rs1.next())
				{
					recordAdded = false;
				}
			if(recordAdded == false)
			{
			
				try
				{
					String paymentSqlStament = "INSERT INTO payment (sponsorName, sponsorTel, paymentOption, amount, patientNo)" + "VALUES(?,?,?,?,?)";
					PreparedStatement paymentStmt = con.prepareStatement(paymentSqlStament);
					paymentStmt.setString(1, sponsorName);
					paymentStmt.setInt(2, tel);
					paymentStmt.setString(3, paymentOption);
					paymentStmt.setInt(4, amount);
					paymentStmt.setInt(5, Id);
					paymentStmt.executeUpdate();
					JOptionPane.showMessageDialog(null,"Payment confirmed");
				}
				catch(SQLException e) 
				{
					System.out.println(e);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Patient Number does not exist","Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(SQLException e) 
		{
			System.out.println(e);
		}
	}
	
	protected void deletePatient(String patientId)
	{
		Connection con = DBConnector.createConnection();
		try
		{
			/*sqlStatement ="DELETE FROM medica WHERE patientNo ="+patientId;
			stmt = con.prepareStatement(sqlStatement);
			stmt.executeUpdate(sqlStatement);*/
			String personID = null;
			String checkID = "SELECT person.personId FROM patient INNER JOIN person ON patient.personId = person.personId WHERE patient.patientNo = ?";
			PreparedStatement ps = con.prepareStatement(checkID);
			ps.setString(1, patientId);
			ResultSet rs1 = ps.executeQuery();
			
			while(rs1.next())
			{
				personID = rs1.getString(1);
			}
			
			sqlStatement ="DELETE FROM patient WHERE patientNo ="+patientId;
			stmt = con.prepareStatement(sqlStatement);
			stmt.executeUpdate(sqlStatement);
			
			sqlStatement ="DELETE FROM person WHERE person.personId ="+personID;
			stmt = con.prepareStatement(sqlStatement);
			stmt.executeUpdate(sqlStatement);
			
		}
		catch(SQLException e) 
		{
			System.out.println(e);
		}
	}
	
	protected void searchPatient(int search, JTextField Title, JTextField Name, JTextField Address, JTextField Tel, JTextField Email, JTextPane medHist
			, JTextPane alleg, JTextPane prescrip, @SuppressWarnings("rawtypes") JComboBox noMedical, JTextField medName, JTextField MedNo) 
	{
		String allergies =null;
		String pres = null;
		String medHistory = null;
		String title = null;
		String name = null;
		String address = null;
		int telephone = 0;
		String email = null;
		int hasMedical = 0;
		String medAidName = null;
		int medAidNo = 0;
		try
		{
			Connection con = DBConnector.createConnection();
		
			boolean recordAdded = true;
			String checkID = "SELECT patientNo FROM patient WHERE patientNo = ?";
			PreparedStatement ps = con.prepareStatement(checkID);
			ps.setInt(1, search);
			ResultSet rs1 = ps.executeQuery();
			if(rs1.next())
				{
					recordAdded = false;
				}
			if(recordAdded == false)
			{
				String checkID1 = "SELECT* FROM patient WHERE patientNo = ?";
				PreparedStatement ps5 = con.prepareStatement(checkID1);
				ps5.setInt(1, search);
				ResultSet rs4 = ps5.executeQuery();
				
				while(rs4.next())
				{
					allergies = rs4.getString(2);
					hasMedical = rs4.getInt(3);
					medHistory = rs4.getString(6);
					pres = rs4.getString(7);
					
				}
				alleg.setText(allergies);
				medHist.setText(medHistory);
				prescrip.setText(pres);
				
				String checkPersonID = "SELECT name, title, address, email, telephone FROM patient INNER JOIN person ON patient.personId = person.personId WHERE patientNo = ?";
				PreparedStatement ps2 = con.prepareStatement(checkPersonID);
				ps2.setInt(1, search);
				ResultSet rs2 = ps2.executeQuery();
				
				while(rs2.next())
				{
					title = rs2.getString("title");
					name = rs2.getString("name");
					address = rs2.getString("address");
					email = rs2.getString("email");
					telephone = rs2.getInt("telephone");
				}
				Title.setText(title);
				Name.setText(name);
				Address.setText(address);
				Tel.setText(telephone+"");
				Email.setText(email);
				
				if(hasMedical == 1)
				{
					noMedical.getEditor().setItem("Yes");
					
					String checkMed = "SELECT patient.patientNo, medicalAid, medicalNo FROM patient INNER JOIN medicalaid ON patient.patientNo = medicalaid.patientNo WHERE patient.patientNo = ?";
					PreparedStatement ps3 = con.prepareStatement(checkMed);
					ps3.setInt(1, search);
					ResultSet rs3 = ps3.executeQuery();
					
					while(rs3.next())
					{
						medAidName = rs3.getString("medicalAid");
						medAidNo = rs3.getInt("medicalNo");
					}
					medName.setText(medAidName);
					MedNo.setText(medAidNo+"");
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Patient Number does not exist","Warning", JOptionPane.WARNING_MESSAGE);
				Title.setText("");
				Name.setText("");
				Address.setText("");
				Tel.setText("");
				Email.setText("");
				medName.setText("");
				MedNo.setText("");
				alleg.setText("");
				medHist.setText("");
				prescrip.setText("");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	protected void findPatient(String patientId, JTable table)
	{
		Connection con = DBConnector.createConnection();
		try
		{
			DefaultTableModel model = new DefaultTableModel(new String[] {"PatientNo", "Title","Name","LastScriptDate", "Tel", "Allergies", "Prescription", "History"}, 0);
			DefaultTableModel modelHistory = new DefaultTableModel(new String[] {"Medical History"},  0);
			sqlStatement ="SELECT patientNo, allergies, title, name, age, lastScriptDate, medicalHistory, prescriptions, telephone FROM patient INNER JOIN person ON patient.personId = person.personId WHERE patientNo LIKE '%"+ patientId+"%'";
			stmt = con.prepareStatement(sqlStatement);
			ResultSet resultset = stmt.executeQuery(sqlStatement);
			
			while(resultset.next())
			{
				String patient = resultset.getString("patientNo");
				String allergies = resultset.getString("allergies");
				String name = resultset.getString("name");
				String title = resultset.getString("title");
				resultset.getInt("age");
				Date lastScriptDate = resultset.getDate("lastScriptDate");
				String medicalHistory = resultset.getString("medicalHistory");
				String prescription = resultset.getString("prescriptions");
				int tel = resultset.getInt("telephone");
				model.addRow(new Object[] {patient, title, name, lastScriptDate, tel, allergies, prescription, medicalHistory});
				modelHistory.addRow(new Object[] {medicalHistory});
			}
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(40);
			table.getColumnModel().getColumn(2).setPreferredWidth(115);
			table.getColumnModel().getColumn(3).setPreferredWidth(115);
			table.getColumnModel().getColumn(4).setPreferredWidth(115);
			table.getColumnModel().getColumn(5).setPreferredWidth(115);
			table.getColumnModel().getColumn(6).setPreferredWidth(115);
			con.close();
		}
		catch(SQLException e) 
		{
			System.out.println(e);
		}
	}
	
	public void addPatient(Patient patient, boolean medOption)
	{
		String Title = patient.getTitle();
		String name = patient.getName();
		String address = patient.getAddress();
		int tel = patient.getTelephone();
		String email = patient.getEmail();
		int age = patient.getAge();
		
		Calendar cal =  Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int calAge = year - age;
		String birth = calAge+"-04-02";
		new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		 java.sql.Date sDate = new java.sql.Date(date.getTime());
		 
		 char gender = patient.getGender();
		 String allergies = patient.getAllergies();
		 String lastScriptDate = patient.getLastScriptDate();
		 String medicalHistory = patient.getMedicalHistory();
		 String prescriptions = patient.getPrescriptions();
		 int noMedical = 0;
		 
		 try
			{
				Connection con = DBConnector.createConnection();
				String personSqlStament = "INSERT INTO person (title, name, address, email, telephone, dateOfBirth, gender)" + "VALUES(?,?,?,?,?,?,?)";
				PreparedStatement personStmt = con.prepareStatement(personSqlStament);
				personStmt.setString(1, Title);
				personStmt.setString(2, name);
				personStmt.setString(3, address);
				personStmt.setString(4, email);
				personStmt.setInt(5, tel);
				personStmt.setDate(6, sDate);
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
				
				String patientSqlStatement = "INSERT INTO patient (allergies, hasMedical, age, lastScriptDate, medicalHistory, prescriptions, personId)" + "VALUES(?,?,?,?,?,?,?)";
				PreparedStatement patientStmt = con.prepareStatement(patientSqlStatement);
				patientStmt.setString(1, allergies);
				patientStmt.setInt(2, noMedical);
				patientStmt.setInt(3, age);
				patientStmt.setString(4, lastScriptDate);
				patientStmt.setString(5, medicalHistory);
				patientStmt.setString(6, prescriptions);
				patientStmt.setInt(7, mid);
				patientStmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, name+" Has successfuly been added to the system");
			}
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
	}
	
	public void addPatientMed(PatientMA patient)
	{
		String Title = patient.getTitle();
		String name = patient.getName();
		String address = patient.getAddress();
		int tel = patient.getTelephone();
		String email = patient.getEmail();
		int age = patient.getAge();
		
		Calendar cal =  Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int calAge = year - age;
		String birth = calAge+"-04-02";
		new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		 java.sql.Date sDate = new java.sql.Date(date.getTime());
		 
		 char gender = patient.getGender();
		 String allergies = patient.getAllergies();
		 String lastScriptDate = patient.getLastScriptDate();
		 String medicalHistory = patient.getMedicalHistory();
		 String prescriptions = patient.getPrescriptions();
		 int noMedical = 1;
		 String medName = patient.getMedicalAid();
		 int medNo = patient.getMedicalNo();
		 
		 try
			{
				Connection con = DBConnector.createConnection();
				String personSqlStament = "INSERT INTO person (title, name, address, email, telephone, dateOfBirth, gender)" + "VALUES(?,?,?,?,?,?,?)";
				PreparedStatement personStmt = con.prepareStatement(personSqlStament);
				personStmt.setString(1, Title);
				personStmt.setString(2, name);
				personStmt.setString(3, address);
				personStmt.setString(4, email);
				personStmt.setInt(5, tel);
				personStmt.setDate(6, sDate);
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
				
				String patientSqlStatement = "INSERT INTO patient (allergies, hasMedical, age, lastScriptDate, medicalHistory, prescriptions, personId)" + "VALUES(?,?,?,?,?,?,?)";
				PreparedStatement patientStmt = con.prepareStatement(patientSqlStatement);
				patientStmt.setString(1, allergies);
				patientStmt.setInt(2, noMedical);
				patientStmt.setInt(3, age);
				patientStmt.setString(4, lastScriptDate);
				patientStmt.setString(5, medicalHistory);
				patientStmt.setString(6, prescriptions);
				patientStmt.setInt(7, mid);
				patientStmt.executeUpdate();
				
				String patientID = "SELECT max(patientNo) FROM patient";
				Statement st1 = con.createStatement();
				ResultSet rs1 = st1.executeQuery(patientID);
				int mid1 =0;
				while(rs1.next())
				{
					mid1 = rs1.getInt(1);
				}
				
				String patientMedSqlStatement = "INSERT INTO medicalaid (patientNo, medicalAid, medicalNo)" + "VALUES(?,?,?)";
				PreparedStatement patientMedStmt = con.prepareStatement(patientMedSqlStatement);
				patientMedStmt.setInt(1, mid1);
				patientMedStmt.setString(2, medName);
				patientMedStmt.setInt(3, medNo);
				patientMedStmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, name+" Has successfuly been added to the system");
			}
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
	
	}
		 
		 protected Patient patientInfoScript(Patient p)
			{
				Connection con = DBConnector.createConnection();
				try
				{
					sqlStatement ="SELECT person.title, person.name FROM patient INNER JOIN person ON patient.personId= person.personId WHERE patientNo=?";
					stmt = con.prepareStatement(sqlStatement);
					stmt.setInt(1, p.getPatientNo());
					ResultSet res = stmt.executeQuery();
					if(res.next()) 
					{
						p.setTitle(res.getString(1));
						p.setName(res.getString(2));
						con.close();
						return p;
					}
					
				}
				catch(SQLException e) 
				{
					System.out.println(e.fillInStackTrace());
				}
				p.setTitle("Incorrect");
				return p;
			}
			
			protected Patient fetchHistory(Patient p)
			{
				Connection con = DBConnector.createConnection();
				try
				{
					sqlStatement ="SELECT person.title, person.name, person.address, person.email, person.telephone, person.email,"
							+ "person.dateOfBirth, person.gender, patient.allergies, patient.hasMedical,"
							+ "patient.age, patient.lastScriptDate, patient.medicalHistory, patient.prescriptions"
							+ " FROM patient INNER JOIN person ON patient.personId= person.personId WHERE patientNo=?";
					stmt = con.prepareStatement(sqlStatement);
					stmt.setInt(1, p.getPatientNo());
					ResultSet res = stmt.executeQuery();
					if(res.next()) 
					{
						Patient  patient = new Patient(res.getString("title"), res.getString("name"), res.getString("address"), res.getString("email"), 
								res.getInt("telephone"), res.getString("dateOfBirth"), 
								res.getString("gender").charAt(0), res.getString("allergies"), res.getBoolean("hasMedical"), res.getInt("age"), res.getString("lastScriptDate"), 
								res.getString("medicalHistory"), res.getString("prescriptions"));
						patient.setPatientNo(p.getPatientNo());
						con.close();
						return patient;
					}
					
				}
				catch(SQLException e) 
				{
					System.out.println(e.fillInStackTrace());
				}
				return null;
			}
		 
		 
	}


