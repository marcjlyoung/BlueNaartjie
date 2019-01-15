/**
 *  Version: 1.0
 * 	Class: AdminGUI
 * 	Description: Interface for the Admin Role
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */




package naartjie;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminGUI extends JFrame {

	//Constants
	
	private static final long serialVersionUID = 1L;
	
	//Properties
	
	private JPanel contentPane;
	private JTextField searchtextField;
	private JTable table;
	private int xOffset = 0;
	private int yOffset = 0;
	private JTextField idtextField;
	private JTextField nametextField;
	private JTextField passwordtextField;
	private JTextField addresstextField;
	private JTextField telephonetextField;
	private JTextField specialitytextField;
	private JTextField pharmacytextField;
	private JTextField usernametextField;
	private JTextField idcreatetextField;
	private JTextField namecreatetextField;
	private JTextField passwordcreatetextField;
	private JTextField confrimpasswordcreatetextField;
	private JTextField addresscreatetextField;
	private JTextField telephonecreatetextField;
	private JTextField specialitycreatetextField;
	private JTextField pharmacycreatetextField;
	private JTextField textFieldTitle;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldTelephone;
	private JTextField textFieldGender;
	private JTextField textFieldNurseStaffNo;
	private JTextField textFieldNursePharmacy;
	private JTextField textFieldDoctorstaffno;
	private JTextField textFieldDoctorSpeciality;
	private JTextField textFieldDoctorOfficeNo;
	private JTextField textFieldDoctorUsername;
	private JTextField textFieldDoctorDateJoined;
	private JTextField textFieldNurseUsername;
	private JTextField textFieldNurseDateJoined;
	private JTextField textFieldSecretaryStaffNo;
	private JTextField textFieldSecretaryUsername;
	private JTextField textFieldSecretaryDateJoined;
	private JTextField textFieldSecretaryDeskNo;
	private JTextField textFieldAdminStaffNo;
	private JTextField textFieldAdminUsername;
	private JTextField textFieldAdminDateJoined;
	private JTextField textFieldAdminLastLogin;
	private JPasswordField passwordFieldNurse;
	private JPasswordField confirmpasswordFieldNurse;
	private String roleClicked = "cheese";
	private JPasswordField passwordFieldDoctor;
	private JPasswordField confirmpasswordFieldDoctor;
	private JPasswordField passwordFieldSecretary;
	private JPasswordField confirmpasswordFieldSecretary;
	private JPasswordField passwordFieldAdmin;
	private JPasswordField confirmpasswordFieldAdmin;
	String roleEditable = null;
	
	//Constructor
	public AdminGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) 
			{
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				
				AdminGUI.this.setLocation(x - xOffset, y - yOffset);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				xOffset = arg0.getX();
				yOffset = arg0.getY();
			}
		});
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel side = new JPanel();
		side.setBackground(new Color(0, 206, 209));
		side.setBounds(0, 0, 235, 550);
		contentPane.add(side);
		side.setLayout(null);
		
		JPanel main = new JPanel();
		main.setBackground(Color.DARK_GRAY);
		main.setBounds(236, 0, 749, 443);
		contentPane.add(main);
		
		JTextPane txtpnmedicineIsA = new JTextPane();
		txtpnmedicineIsA.setForeground(Color.WHITE);
		txtpnmedicineIsA.setEditable(false);
		txtpnmedicineIsA.setBackground(new Color(0, 206, 209));
		txtpnmedicineIsA.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtpnmedicineIsA.setText("\"Medicine is a science of uncertainty and an art of probability\" - William Osler");
		txtpnmedicineIsA.setBounds(27, 414, 160, 81);
		side.add(txtpnmedicineIsA);
		main.setLayout(null);
		
		JPanel maintenancePanel = new JPanel();
		maintenancePanel.setBackground(Color.DARK_GRAY);
		maintenancePanel.setBounds(0, 0, 749, 443);
		//main.add(maintenancePanel);
		maintenancePanel.setLayout(null);
		
		JPanel documenttablePanel = new JPanel();
		documenttablePanel.setBounds(133, 70, 457, 308);
		maintenancePanel.add(documenttablePanel);
		documenttablePanel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		JScrollPane jp = new JScrollPane(textArea);
		textArea.setEditable(false);
		jp.setBounds(0, 0, 457, 308);
		textArea.setBounds(0, 0, 457, 308);
		documenttablePanel.add(jp);
		
		JPanel panelPerson = new JPanel();
		panelPerson.setLayout(null);
		panelPerson.setBackground(Color.DARK_GRAY);
		panelPerson.setBounds(131, 0, 340, 402);
		//main.add(panelPerson);
		
		
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(141, 280, 153, 20);
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		panelPerson.add(dateChooser_1);
		
		JButton generatereportButton = new JButton("Statistics");
		generatereportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		generatereportButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				textArea.setText("");
				ReportGenerator r = new ReportGenerator();
				r.admin(textArea);
				r.doctor(textArea);
				r.nurse(textArea);
				r.secretary(textArea);
			}
		});
		generatereportButton.setForeground(Color.WHITE);
		generatereportButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		generatereportButton.setFocusable(false);
		generatereportButton.setBackground(new Color(0, 206, 209));
		generatereportButton.setBounds(133, 409, 105, 23);
		maintenancePanel.add(generatereportButton);
		
		JButton generatelogButton = new JButton("Log");
		generatelogButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				Log r = new Log(true);
				r.readfile(textArea);
			}
		});
		generatelogButton.setForeground(Color.WHITE);
		generatelogButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		generatelogButton.setFocusable(false);
		generatelogButton.setBackground(new Color(0, 206, 209));
		generatelogButton.setBounds(485, 409, 105, 23);
		maintenancePanel.add(generatelogButton);
		
		JLabel lblGeneratedDocumentsBelow = new JLabel("Generated Documents below:");
		lblGeneratedDocumentsBelow.setForeground(Color.WHITE);
		lblGeneratedDocumentsBelow.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGeneratedDocumentsBelow.setBounds(269, 35, 221, 14);
		maintenancePanel.add(lblGeneratedDocumentsBelow);
		
		JLabel XLblmaintenance = new JLabel("X");
		XLblmaintenance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				XLblmaintenance.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				XLblmaintenance.setForeground(Color.WHITE);
			}
		});
		XLblmaintenance.setToolTipText("Exit");
		XLblmaintenance.setForeground(Color.WHITE);
		XLblmaintenance.setFont(new Font("Tahoma", Font.PLAIN, 21));
		XLblmaintenance.setBounds(697, 11, 20, 20);
		maintenancePanel.add(XLblmaintenance);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				textArea.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setFocusable(false);
		btnClear.setBackground(new Color(0, 206, 209));
		btnClear.setBounds(311, 409, 105, 23);
		maintenancePanel.add(btnClear);
		
		JPanel editPanel = new JPanel();
		editPanel.setBackground(Color.DARK_GRAY);
		editPanel.setBounds(0, 0, 749,443 );
		//main.add(editPanel);
		editPanel.setLayout(null);
		
		JLabel idLbl = new JLabel("ID:");
		idLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		idLbl.setForeground(Color.WHITE);
		idLbl.setBounds(156, 89, 80, 14);
		editPanel.add(idLbl);
		
		idtextField = new JTextField();
		idtextField.setBounds(336, 88, 153, 20);
		editPanel.add(idtextField);
		idtextField.setColumns(10);
		
		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameLbl.setForeground(Color.WHITE);
		nameLbl.setBounds(156, 135, 80, 14);
		editPanel.add(nameLbl);
		
		JLabel passwordLbl = new JLabel("Password:");
		passwordLbl.setForeground(Color.WHITE);
		passwordLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordLbl.setBounds(156, 181, 80, 14);
		editPanel.add(passwordLbl);
		
		JLabel addressLbl = new JLabel("Address:");
		addressLbl.setForeground(Color.WHITE);
		addressLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		addressLbl.setBounds(156, 227, 80, 14);
		editPanel.add(addressLbl);
		
		JLabel telLbl = new JLabel("Telephone:");
		telLbl.setForeground(Color.WHITE);
		telLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		telLbl.setBounds(156, 273, 80, 14);
		editPanel.add(telLbl);
		
		JLabel docLbl = new JLabel("Speciality:");
		docLbl.setForeground(Color.WHITE);
		docLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		docLbl.setBounds(156, 319, 80, 14);
		editPanel.add(docLbl);
		
		JLabel pharmacyLbl = new JLabel("Pharmacy:");
		pharmacyLbl.setForeground(Color.WHITE);
		pharmacyLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		pharmacyLbl.setBounds(156, 365, 80, 14);
		editPanel.add(pharmacyLbl);
		
		nametextField = new JTextField();
		nametextField.setBounds(337, 134, 152, 20);
		editPanel.add(nametextField);
		nametextField.setColumns(10);
		
		passwordtextField = new JTextField();
		passwordtextField.setBounds(336, 180, 153, 20);
		editPanel.add(passwordtextField);
		passwordtextField.setColumns(10);
		
		addresstextField = new JTextField();
		addresstextField.setBounds(336, 226, 153, 20);
		editPanel.add(addresstextField);
		addresstextField.setColumns(10);
		
		telephonetextField = new JTextField();
		telephonetextField.setBounds(336, 272, 153, 20);
		editPanel.add(telephonetextField);
		telephonetextField.setColumns(10);
		
		specialitytextField = new JTextField();
		specialitytextField.setBounds(336, 318, 153, 20);
		editPanel.add(specialitytextField);
		specialitytextField.setColumns(10);
		
		pharmacytextField = new JTextField();
		pharmacytextField.setBounds(336, 364, 153, 20);
		editPanel.add(pharmacytextField);
		pharmacytextField.setColumns(10);
		
		JButton updateButton = new JButton("Update");
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				AdminHandler ah = new AdminHandler(); //creates a new instance of adminHandler
				String Special = specialitytextField.getText(); // gets the text value in the textbox
				String search = idtextField.getText();
				String u = usernametextField.getText();
				String pass = passwordtextField.getText();
				String Address = addresstextField.getText();
				String Pharm = pharmacytextField.getText();
				String Name = nametextField.getText();
				String tele = telephonetextField.getText();
				
				if(!(search.equals("")))
				{
						ah.updateDoctor(search, u, pass, Name, Address, tele, Special, Pharm, roleEditable); //
						telephonetextField.setText(""); //sets the textbox value to null
						nametextField.setText("");
						pharmacytextField.setText("");
						addresstextField.setText("");
						passwordtextField.setText("");
						usernametextField.setText("");
						specialitytextField.setText("");
						Log log = new Log(true);
						String action = updateButton.getText();
						String time = log.dateConverter();
						try {
							log.writeToFile("Admin", action, Name, time);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please enter a value in the search field","Warning", JOptionPane.WARNING_MESSAGE);//displays and error if the search field is empty
				}
			}
		});
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateButton.setForeground(Color.WHITE);
		updateButton.setFocusable(false);
		updateButton.setBackground(new Color(0, 206, 209));
		updateButton.setBounds(394, 409, 95, 23);
		editPanel.add(updateButton);
		
		JLabel XlblEditUsers = new JLabel("X");
		XlblEditUsers.setToolTipText("Exit");
		XlblEditUsers.setForeground(Color.WHITE);
		XlblEditUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				XlblEditUsers.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				XlblEditUsers.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
		XlblEditUsers.setFont(new Font("Tahoma", Font.PLAIN, 21));
		XlblEditUsers.setBounds(697, 11, 20, 20);
		editPanel.add(XlblEditUsers);
		
		JLabel usernameLbl = new JLabel("Username:");
		usernameLbl.setForeground(Color.WHITE);
		usernameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameLbl.setBounds(156, 43, 80, 14);
		editPanel.add(usernameLbl);
		
		usernametextField = new JTextField();
		usernametextField.setEnabled(false);
		usernametextField.setBounds(336, 42, 153, 20);
		editPanel.add(usernametextField);
		usernametextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Edit User's Details Below:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(218, 16, 241, 14);
		editPanel.add(lblNewLabel_2);
		
		JButton edituserdeleteButton = new JButton("Delete");
		edituserdeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				String staffNo = idtextField.getText();
				String name = nametextField.getText();
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int result =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","Warning",dialogButton);
				
				if(result == JOptionPane.YES_OPTION)
				{
					AdminHandler a = new AdminHandler();
					a.deleteStaff(staffNo);
					
					idtextField.setText("");
					addresstextField.setText("");
					telephonetextField.setText("");
					specialitytextField.setText("");
					pharmacytextField.setText("");
					usernametextField.setText("");
					nametextField.setText("");
					passwordtextField.setText("");
				
					Log log = new Log(true);
					String action = updateButton.getText();
					String time = log.dateConverter();
					try {
						log.writeToFile("Admin", action, name, time);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else
				{
					
				}
			}
		});
		edituserdeleteButton.setForeground(Color.WHITE);
		edituserdeleteButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		edituserdeleteButton.setFocusable(false);
		edituserdeleteButton.setBackground(new Color(0, 206, 209));
		edituserdeleteButton.setBounds(156, 409, 95, 23);
		editPanel.add(edituserdeleteButton);
		
		JButton editUserSearchButton = new JButton("Search");
		
			editUserSearchButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					String id = idtextField.getText();
					if(!(id.equals("")))
					{
						AdminHandler newr = new AdminHandler();
						newr.editSearch(id, usernametextField, passwordtextField, nametextField,addresstextField, telephonetextField, specialitytextField, pharmacytextField);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter a value to searh for","Warning", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				@Override
				public void mouseReleased(MouseEvent arg0) 
				{
					
				}
				@Override
				public void mouseExited(MouseEvent arg0) 
				{
					String emptyPharm = pharmacytextField.getText();
					String emptySpecial = specialitytextField.getText();
					
					if(emptyPharm.equals(""))
					{
						pharmacytextField.setEditable(false);
					}
					else
					{
						pharmacytextField.setEditable(true);
						roleEditable = "Nurse";
					}
					
					if(emptySpecial.equals(""))
					{
						specialitytextField.setEditable(false);
					}
					else
					{
						specialitytextField.setEditable(true);
						roleEditable = "Doctor";
					}
					
					if(emptySpecial.equals("")&&emptyPharm.equals(""))
					{
						roleEditable ="Person";
					}
				}
			});
			editUserSearchButton.setForeground(Color.WHITE);
			editUserSearchButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			editUserSearchButton.setFocusable(false);
			editUserSearchButton.setBackground(new Color(0, 206, 209));
			editUserSearchButton.setBounds(512, 87, 95, 23);
			editPanel.add(editUserSearchButton);
			
			JPanel panel = new JPanel();
			panel.setBounds(132, 400, 596, 43);
			//editPanel.add(panel);
			panel.setLayout(null);
			panel.setBackground(Color.DARK_GRAY);
			
			JButton button_1 = new JButton("Add");
			button_1.addMouseListener(new MouseAdapter() {
				@SuppressWarnings("deprecation")
				@Override
				public void mouseClicked(MouseEvent e) 
				{
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						String Title = textFieldTitle.getText();
						String name = textFieldName.getText();
						String address = textFieldAddress.getText();
						String email = textFieldEmail.getText();
						String tel1 = textFieldTelephone.getText();
						String gender1 = textFieldGender.getText();
					if(roleClicked.equals("Nurse"))
					{
						AdminHandler fg = new AdminHandler();
						String staffno = textFieldNurseStaffNo.getText();
						String username = textFieldNurseUsername.getText();
						String password = passwordFieldNurse.getText();
						String confirmPass = confirmpasswordFieldNurse.getText();
						//String role = "Nurse";
						Date Joined =fg.lastLogin();
					
						String pharm = textFieldNursePharmacy.getText();
						if(!(Title.equals("") | name.equals("") | address.equals("") | email.equals("") | staffno.equals("") | username.equals("") | password.equals("") | confirmPass.equals("") | pharm.equals("") | tel1.equals("") | gender1.equals("")))
						{
							String DOB = df.format(dateChooser_1.getDate());
							int tel = Integer.parseInt(textFieldTelephone.getText());
							char gender = textFieldGender.getText().charAt(0);
							try {
								Joined = new SimpleDateFormat("yyyy-MM-dd").parse(textFieldNurseDateJoined.getText());
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if(password.equals(confirmPass))
							{
								Log log = new Log(true);
								//Nurse r = new Nurse(Title, name, address, email, tel, DOB, gender, staffno, username, password, Joined, role, pharm);
								AdminHandler insertNurse = new AdminHandler();
								insertNurse.insertNurse(Title, name, address, email, tel, DOB, gender, staffno, username, password, Joined, pharm);
								String action = button_1.getText();
								String time = log.dateConverter();
								try {
									log.writeToFile("Admin", action, username, time);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Passwords do not match","Warning", JOptionPane.WARNING_MESSAGE);
								passwordFieldNurse.setText("");
								confirmpasswordFieldNurse.setText("");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Please fill in the required fields","Warning", JOptionPane.WARNING_MESSAGE);
							if(Title.equals(""))
							{
								textFieldTitle.setBackground(Color.red);
							}
							if(name.equals(""))
							{
								textFieldName.setBackground(Color.red);
							}
							if(email.equals(""))
							{
								textFieldEmail.setBackground(Color.red);
							}
							if(staffno.equals(""))
							{
								textFieldNurseStaffNo.setBackground(Color.red);
							}
							if(username.equals(""))
							{
								textFieldNurseUsername.setBackground(Color.red);
							}
							if(password.equals(""))
							{
								passwordFieldNurse.setBackground(Color.red);
							}
							if(confirmPass.equals(""))
							{
								confirmpasswordFieldNurse.setBackground(Color.red);
							}
							if(textFieldTelephone.getText().equals(""))
							{
								textFieldTelephone.setBackground(Color.red);
							}
							if(textFieldGender.getText().equals(""))
							{
								textFieldGender.setBackground(Color.red);
							}
							if(address.equals(""))
							{
								textFieldAddress.setBackground(Color.red);
							}
							if(pharm.equals(""))
							{
								textFieldNursePharmacy.setBackground(Color.red);
							}
						
						}
					}
					else if(roleClicked.equals("Admin"))
					{
						AdminHandler p = new AdminHandler();
						String staffno = textFieldAdminStaffNo.getText();
						String username = textFieldAdminUsername.getText();
						String password = passwordFieldAdmin.getText();
						String confirmPass = confirmpasswordFieldAdmin.getText();
						Date Joined = p.lastLogin();
						String role ="Admin";
						Date lastLogin = p.lastLogin();
						
						if(!(Title.equals("") | name.equals("") | address.equals("") | email.equals("") |tel1.equals("") | gender1.equals("") | staffno.equals("") | username.equals("") | password.equals("") |confirmPass.equals("")))
						{
							int tel = Integer.parseInt(textFieldTelephone.getText());
							char gender = textFieldGender.getText().charAt(0);
							String DOB = df.format(dateChooser_1.getDate());
							if(password.equals(confirmPass))
							{
								Admin admin = new Admin(Title, name, address, email, tel, DOB, gender, staffno, username, password, Joined, role, lastLogin);
								AdminHandler r = new AdminHandler();
								r.insertAdmin(admin);
								Log log = new Log(true);
								String action = button_1.getText();
								String time = log.dateConverter();
								try {
									log.writeToFile("Admin", action, username, time);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Passwords do not match","Warning", JOptionPane.WARNING_MESSAGE);
								passwordFieldAdmin.setText("");
								confirmpasswordFieldAdmin.setText("");
							}
						}
						
						else
						{
							JOptionPane.showMessageDialog(null,"Please fill in the required fields","Warning", JOptionPane.WARNING_MESSAGE);
							if(Title.equals(""))
							{
								textFieldTitle.setBackground(Color.red);
							}
							if(name.equals(""))
							{
								textFieldName.setBackground(Color.red);
							}
							if(email.equals(""))
							{
								textFieldEmail.setBackground(Color.red);
							}
							if(textFieldTelephone.getText().equals(""))
							{
								textFieldTelephone.setBackground(Color.red);
							}
							if(textFieldGender.getText().equals(""))
							{
								textFieldGender.setBackground(Color.red);
							}
							if(address.equals(""))
							{
								textFieldAddress.setBackground(Color.red);
							}
							if(staffno.equals(""))
							{
								textFieldAdminStaffNo.setBackground(Color.red);
							}
							if(password.equals(""))
							{
								passwordFieldAdmin.setBackground(Color.RED);
							}
							if(confirmPass.equals(""))
							{
								confirmpasswordFieldAdmin.setBackground(Color.red);
							}
							if(username.equals(""))
							{
								textFieldAdminUsername.setBackground(Color.red);
							}
						
						}
					}
					else if(roleClicked.equals("Secretary"))
					{
						String staffno = textFieldSecretaryStaffNo.getText();
						String username = textFieldSecretaryUsername.getText();
						String password = passwordFieldSecretary.getText();
						String confirmPass = confirmpasswordFieldSecretary.getText();
						Date Joined = dateChooser_1.getDate();
						String role ="Secretary";
						String deskNo = textFieldSecretaryDeskNo.getText();
						
						if(!(Title.equals("") | name.equals("") | address.equals("") | email.equals("") | tel1.equals("") | gender1.equals("") | staffno.equals("") | username.equals("") | password.equals("") |confirmPass.equals("")| deskNo.equals("")))
						{
							int tel = Integer.parseInt(textFieldTelephone.getText());
							char gender = textFieldGender.getText().charAt(0); 
							String DOB = df.format(dateChooser_1.getDate());
							if(password.equals(confirmPass))
							{
								Secretary secretary = new Secretary(Title, name, address, email, tel, DOB, gender, staffno, username, password, Joined, role, deskNo);
								AdminHandler r = new AdminHandler();
								r.insertSecretary(secretary);
								Log log = new Log(true);
								String action = button_1.getText();
								String time = log.dateConverter();
								try {
									log.writeToFile("Admin", action, username, time);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Passwords do not match","Warning", JOptionPane.WARNING_MESSAGE);
								passwordFieldSecretary.setText("");
								confirmpasswordFieldSecretary.setText("");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Please fill in the required fields","Warning", JOptionPane.WARNING_MESSAGE);
							if(Title.equals(""))
							{
								textFieldTitle.setBackground(Color.red);
							}
							if(name.equals(""))
							{
								textFieldName.setBackground(Color.red);
							}
							if(email.equals(""))
							{
								textFieldEmail.setBackground(Color.red);
							}
							if(textFieldTelephone.getText().equals(""))
							{
								textFieldTelephone.setBackground(Color.red);
							}
							if(textFieldGender.getText().equals(""))
							{
								textFieldGender.setBackground(Color.red);
							}
							if(address.equals(""))
							{
								textFieldAddress.setBackground(Color.red);
							}
							if(staffno.equals(""))
							{
								textFieldSecretaryStaffNo.setBackground(Color.red);
							}
							if(password.equals(""))
							{
								passwordFieldSecretary.setBackground(Color.RED);
							}
							if(confirmPass.equals(""))
							{
								confirmpasswordFieldSecretary.setBackground(Color.red);
							}
							if(username.equals(""))
							{
								textFieldSecretaryUsername.setBackground(Color.red);
							}
							if(deskNo.equals(""))
							{
								textFieldSecretaryDeskNo.setBackground(Color.red);
							}
						}
						
					}
					else if(roleClicked.equals("Doctor"))
					{
						String staffno = textFieldDoctorstaffno.getText();
						String username = textFieldDoctorUsername.getText();
						String password = passwordFieldDoctor.getText();
						Date Joined = dateChooser_1.getDate();
						String role ="Doctor";
						String speciality = textFieldDoctorSpeciality.getText();
						String officeNo = textFieldDoctorOfficeNo.getText();
						
						if(!(Title.equals("") | name.equals("") | address.equals("") | email.equals("") | tel1.equals("") | gender1.equals("") | staffno.equals("") | username.equals("") | password.equals("") | speciality.equals("") | officeNo.equals("")))		
						{
							int tel = Integer.parseInt(textFieldTelephone.getText());
							char gender = textFieldGender.getText().charAt(0);
							String DOB = df.format(dateChooser_1.getDate());
							if(password.equals(confirmpasswordFieldDoctor.getText()))
							{
								Doctor doctor = new Doctor(Title, name, address, email, tel, DOB, gender, staffno, username, password, Joined, role, speciality, officeNo);
								AdminHandler r = new AdminHandler();
								r.insertDoctor(doctor);
								Log log = new Log(true);
								String action = button_1.getText();
								String time = log.dateConverter();
								try {
									log.writeToFile("Admin", action, username, time);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Passwords do not match","Warning", JOptionPane.WARNING_MESSAGE);
								passwordFieldDoctor.setText("");
								confirmpasswordFieldDoctor.setText("");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Please fill in the required fields","Warning", JOptionPane.WARNING_MESSAGE);
							if(Title.equals(""))
							{
								textFieldTitle.setBackground(Color.red);
							}
							if(name.equals(""))
							{
								textFieldName.setBackground(Color.red);
							}
							if(email.equals(""))
							{
								textFieldEmail.setBackground(Color.red);
							}
							if(textFieldTelephone.getText().equals(""))
							{
								textFieldTelephone.setBackground(Color.red);
							}
							if(textFieldGender.getText().equals(""))
							{
								textFieldGender.setBackground(Color.red);
							}
							if(address.equals(""))
							{
								textFieldAddress.setBackground(Color.red);
							}
							if(staffno.equals(""))
							{
								textFieldDoctorstaffno.setBackground(Color.red);
							}
							if(officeNo.equals(""))
							{
								textFieldDoctorOfficeNo.setBackground(Color.red);
							}
							if(speciality.equals(""))
							{
								textFieldDoctorSpeciality.setBackground(Color.red);
							}
							if(username.equals(""))
							{
								textFieldDoctorUsername.setBackground(Color.red);
							}
							if(password.equals(""))
							{
								passwordFieldDoctor.setBackground(Color.red);
							}
							if(confirmpasswordFieldDoctor.getText().equals(""))
							{
								confirmpasswordFieldDoctor.setBackground(Color.red);
							}
						}
					}
					else if(roleClicked.equals(null))
					{
						JOptionPane.showMessageDialog(null,"Please select a user role you would like to add","Warning", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please select a user role you would like to add","Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			button_1.setForeground(Color.WHITE);
			button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			button_1.setFocusable(false);
			button_1.setBackground(new Color(0, 206, 209));
			button_1.setBounds(138, 0, 153, 27);
			panel.add(button_1);
		
		JPanel addPanel = new JPanel();
		addPanel.setToolTipText("Please select a role you would like to add");
		addPanel.setBackground(new Color(0, 206, 209));
		addPanel.setBounds(0, 0, 132, 443);
		//main.add(addPanel);
		addPanel.setLayout(null);
		
		JLabel labelAddDoctor = new JLabel("Add Doctor", SwingConstants.CENTER);
		labelAddDoctor.setOpaque(true);
		labelAddDoctor.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelAddDoctor.setBackground(new Color(0, 206, 209));
		labelAddDoctor.setBounds(0, 223, 132, 35);
		addPanel.add(labelAddDoctor);
		
		JLabel labelAddNurse = new JLabel("Add Nurse", SwingConstants.CENTER);
		
		labelAddNurse.setBounds(0, 156, 132, 35);
		labelAddNurse.setOpaque(true);
		labelAddNurse.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelAddNurse.setBackground(new Color(0, 206, 209));
		addPanel.add(labelAddNurse);
		
		JLabel labelSecretary = new JLabel("Add Secretary", SwingConstants.CENTER);
		labelSecretary.setOpaque(true);
		labelSecretary.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelSecretary.setBackground(new Color(0, 206, 209));
		labelSecretary.setBounds(0, 290, 132, 35);
		addPanel.add(labelSecretary);
		
		JLabel labelAddAdmin = new JLabel("Add Admin", SwingConstants.CENTER);
		
		labelAddAdmin.setOpaque(true);
		labelAddAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelAddAdmin.setBackground(new Color(0, 206, 209));
		labelAddAdmin.setBounds(0, 90, 132, 35);
		addPanel.add(labelAddAdmin);
		
		JPanel createPanel = new JPanel();
		createPanel.setBackground(Color.DARK_GRAY);
		createPanel.setBounds(0, 0, 749, 443);
		//main.add(createPanel);
		createPanel.setLayout(null);
		
		JLabel idCreateUserLbl = new JLabel("Username:");
		idCreateUserLbl.setBounds(156, 43, 80, 14);
		idCreateUserLbl.setForeground(Color.WHITE);
		idCreateUserLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		createPanel.add(idCreateUserLbl);
		
		idcreatetextField = new JTextField();
		idcreatetextField.setEditable(false);
		idcreatetextField.setBounds(336, 42, 153, 20);
		createPanel.add(idcreatetextField);
		idcreatetextField.setColumns(10);
		
		JLabel nameCreateLbl = new JLabel("Name:");
		nameCreateLbl.setForeground(Color.WHITE);
		nameCreateLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameCreateLbl.setBounds(156, 89, 80, 14);
		createPanel.add(nameCreateLbl);
		
		JLabel passwordCreateLbl = new JLabel("Password:");
		passwordCreateLbl.setForeground(Color.WHITE);
		passwordCreateLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordCreateLbl.setBounds(156, 135, 80, 14);
		createPanel.add(passwordCreateLbl);
		
		JLabel confirmpasswordCreateLbl = new JLabel("Confirm Password:");
		confirmpasswordCreateLbl.setForeground(Color.WHITE);
		confirmpasswordCreateLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		confirmpasswordCreateLbl.setBounds(156, 181, 131, 14);
		createPanel.add(confirmpasswordCreateLbl);
		
		JLabel addressCreateLbl = new JLabel("Address:");
		addressCreateLbl.setForeground(Color.WHITE);
		addressCreateLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		addressCreateLbl.setBounds(156, 227, 80, 14);
		createPanel.add(addressCreateLbl);
		
		JLabel telephoneCreateLbl = new JLabel("Telephone:");
		telephoneCreateLbl.setForeground(Color.WHITE);
		telephoneCreateLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		telephoneCreateLbl.setBounds(156, 273, 80, 14);
		createPanel.add(telephoneCreateLbl);
		
		JLabel specialityCreateLbl = new JLabel("Speciality:");
		specialityCreateLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		specialityCreateLbl.setForeground(Color.WHITE);
		specialityCreateLbl.setBounds(156, 319, 80, 14);
		createPanel.add(specialityCreateLbl);
		
		JLabel pharmacyCreateLbl = new JLabel("Pharmacy:");
		pharmacyCreateLbl.setForeground(Color.WHITE);
		pharmacyCreateLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		pharmacyCreateLbl.setBounds(156, 365, 80, 14);
		createPanel.add(pharmacyCreateLbl);
		
		namecreatetextField = new JTextField();
		namecreatetextField.setBounds(336, 88, 153, 20);
		createPanel.add(namecreatetextField);
		namecreatetextField.setColumns(10);
		
		passwordcreatetextField = new JTextField();
		passwordcreatetextField.setBounds(336, 134, 153, 20);
		createPanel.add(passwordcreatetextField);
		passwordcreatetextField.setColumns(10);
		
		confrimpasswordcreatetextField = new JTextField();
		confrimpasswordcreatetextField.setBounds(336, 180, 153, 20);
		createPanel.add(confrimpasswordcreatetextField);
		confrimpasswordcreatetextField.setColumns(10);
		
		addresscreatetextField = new JTextField();
		addresscreatetextField.setBounds(336, 226, 153, 20);
		createPanel.add(addresscreatetextField);
		addresscreatetextField.setColumns(10);
		
		telephonecreatetextField = new JTextField();
		telephonecreatetextField.setBounds(336, 272, 153, 20);
		createPanel.add(telephonecreatetextField);
		telephonecreatetextField.setColumns(10);
		
		specialitycreatetextField = new JTextField();
		specialitycreatetextField.setBounds(336, 318, 153, 20);
		createPanel.add(specialitycreatetextField);
		specialitycreatetextField.setColumns(10);
		
		pharmacycreatetextField = new JTextField();
		pharmacycreatetextField.setBounds(336, 364, 153, 20);
		createPanel.add(pharmacycreatetextField);
		pharmacycreatetextField.setColumns(10);
		
		JButton addcreateButton = new JButton("Add");
		addcreateButton.setForeground(Color.WHITE);
		addcreateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addcreateButton.setFocusable(false);
		addcreateButton.setBackground(new Color(0, 206, 209));
		addcreateButton.setBounds(218, 395, 200, 23);
		createPanel.add(addcreateButton);
		
		JLabel XcreateLbl = new JLabel("X");
		XcreateLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				XcreateLbl.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				XcreateLbl.setForeground(Color.WHITE);
			}
		});
		XcreateLbl.setToolTipText("Exit");
		XcreateLbl.setForeground(Color.WHITE);
		XcreateLbl.setFont(new Font("Tahoma", Font.PLAIN, 21));
		XcreateLbl.setBounds(697, 11, 20, 20);
		createPanel.add(XcreateLbl);
		
		JLabel lblInsertNewUsers = new JLabel("Insert New User's Details Below:");
		lblInsertNewUsers.setForeground(Color.WHITE);
		lblInsertNewUsers.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInsertNewUsers.setBounds(218, 16, 241, 14);
		createPanel.add(lblInsertNewUsers);
		
		JButton button = new JButton("Search");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setFocusable(false);
		button.setBackground(new Color(0, 206, 209));
		button.setBounds(536, 39, 80, 23);
		createPanel.add(button);
		
				textFieldTitle = new JTextField();
				textFieldTitle.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) 
					{
						textFieldTitle.setBackground(Color.WHITE);
					}
				});
				textFieldTitle.setColumns(10);
				textFieldTitle.setBounds(141, 50, 153, 20);
				panelPerson.add(textFieldTitle);
				
				textFieldName = new JTextField();
				textFieldName.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0)
					{
						textFieldName.setBackground(Color.WHITE);
					}
				});
				textFieldName.setColumns(10);
				textFieldName.setBounds(141, 96, 153, 20);
				panelPerson.add(textFieldName);
				
				textFieldAddress = new JTextField();
				textFieldAddress.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) 
					{
						textFieldAddress.setBackground(Color.WHITE);
					}
				});
				textFieldAddress.setColumns(10);
				textFieldAddress.setBounds(141, 142, 153, 20);
				panelPerson.add(textFieldAddress);
				
				textFieldEmail = new JTextField();
				textFieldEmail.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) 
					{
						textFieldEmail.setBackground(Color.WHITE);
					}
				});
				textFieldEmail.setColumns(10);
				textFieldEmail.setBounds(141, 188, 153, 20);
				panelPerson.add(textFieldEmail);
				
				textFieldTelephone = new JTextField();
				textFieldTelephone.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) 
					{
						textFieldTelephone.setBackground(Color.WHITE);
					}
					@Override
					public void keyTyped(KeyEvent e) 
					{
						char c = e.getKeyChar();
						if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)
						{
							getToolkit().beep();
							e.consume();
						}
					}
				});
				textFieldTelephone.setColumns(10);
				textFieldTelephone.setBounds(141, 234, 153, 20);
				panelPerson.add(textFieldTelephone);
				
				textFieldGender = new JTextField();
				textFieldGender.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) 
					{
						textFieldGender.setBackground(Color.WHITE);
					}
				});
				textFieldGender.setColumns(10);
				textFieldGender.setBounds(141, 326, 153, 20);
				panelPerson.add(textFieldGender);
				
				JLabel labelTitle = new JLabel("Title:");
				labelTitle.setForeground(Color.WHITE);
				labelTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelTitle.setBounds(44, 56, 46, 14);
				panelPerson.add(labelTitle);
				
				JLabel labelName = new JLabel("Name:");
				labelName.setForeground(Color.WHITE);
				labelName.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelName.setBounds(44, 96, 46, 14);
				panelPerson.add(labelName);
				
				JLabel labelAddress = new JLabel("Address:");
				labelAddress.setForeground(Color.WHITE);
				labelAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelAddress.setBounds(44, 142, 73, 14);
				panelPerson.add(labelAddress);
				
				JLabel labelEmail = new JLabel("Email:");
				labelEmail.setForeground(Color.WHITE);
				labelEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelEmail.setBounds(44, 188, 46, 14);
				panelPerson.add(labelEmail);
				
				JLabel labelTelephone = new JLabel("Telephone:");
				labelTelephone.setForeground(Color.WHITE);
				labelTelephone.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelTelephone.setBounds(44, 234, 86, 14);
				panelPerson.add(labelTelephone);
				
				JLabel labelDOB = new JLabel("Date Of Birth:");
				labelDOB.setForeground(Color.WHITE);
				labelDOB.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelDOB.setBounds(44, 280, 99, 14);
				panelPerson.add(labelDOB);
				
				JLabel labelGender = new JLabel("Gender:");
				labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelGender.setForeground(Color.WHITE);
				labelGender.setBounds(44, 326, 73, 14);
				panelPerson.add(labelGender);
				panelPerson.add(dateChooser_1);
		
		
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(new Rectangle(0, 0, 749, 443));
		searchPanel.setBounds(0, 0, 749, 443);
		main.add(searchPanel);
		searchPanel.setBackground(Color.DARK_GRAY);
		searchPanel.setLayout(null);
		
		searchtextField = new JTextField();
		searchtextField.setBounds(239, 73, 185, 20);
		searchPanel.add(searchtextField);
		searchtextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter a Username:");
		lblNewLabel.setBounds(101, 73, 114, 17);
		searchPanel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(!(searchtextField.getText().equals("")))
				{
					String search = searchtextField.getText();
					AdminHandler r = new AdminHandler();
					r.fAdmin(search, table);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please enter a value to searh for","Warning", JOptionPane.WARNING_MESSAGE);
					//JOptionPane.showMessageDialog(panel, "A deprecated call", "Warning",
			        //JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBackground(new Color(0, 206, 209));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBounds(447, 72, 80, 23);
		searchPanel.add(btnSearch);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblX.setToolTipText("Exit");
		lblX.setBounds(697, 11, 20, 20);
		searchPanel.add(lblX);
		
		JLabel lblCurrentUsersListed = new JLabel("Current users listed below:");
		lblCurrentUsersListed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrentUsersListed.setForeground(Color.WHITE);
		lblCurrentUsersListed.setBounds(239, 122, 208, 14);
		searchPanel.add(lblCurrentUsersListed);
		
		JLabel searchuserLbl = new JLabel("Search For User Below:");
		searchuserLbl.setForeground(Color.WHITE);
		searchuserLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchuserLbl.setBounds(252, 31, 185, 14);
		searchPanel.add(searchuserLbl);
		
		table = new JTable();
		JScrollPane j = new JScrollPane(table);
		table.setBounds(153, 147, 374, 238);
		j.setBounds(153, 147, 374, 238);
		searchPanel.add(j);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"StaffNo", "Username", "Name"
			}
		));
		
		JPanel panelDoctor = new JPanel();
		panelDoctor.setBounds(471, 0, 256, 402);
		//main.add(panelDoctor);
		panelDoctor.setBackground(Color.DARK_GRAY);
		panelDoctor.setLayout(null);
		
		
		
		JLabel lblOfficeNo = new JLabel("Office No:");
		lblOfficeNo.setForeground(Color.WHITE);
		lblOfficeNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOfficeNo.setBounds(7, 326, 77, 14);
		panelDoctor.add(lblOfficeNo);
		
		JLabel lblSpeciality = new JLabel("Speciality:");
		lblSpeciality.setForeground(Color.WHITE);
		lblSpeciality.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSpeciality.setBounds(7, 280, 77, 14);
		panelDoctor.add(lblSpeciality);
		
		JLabel lblDoctorStaffNo = new JLabel("StaffNo:");
		lblDoctorStaffNo.setForeground(Color.WHITE);
		lblDoctorStaffNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDoctorStaffNo.setBounds(7, 50, 77, 14);
		panelDoctor.add(lblDoctorStaffNo);
		
		textFieldDoctorstaffno = new JTextField();
		textFieldDoctorstaffno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				textFieldDoctorstaffno.setBackground(Color.white);
			}
		});
		textFieldDoctorstaffno.setBounds(89, 50, 153, 20);
		panelDoctor.add(textFieldDoctorstaffno);
		textFieldDoctorstaffno.setColumns(10);
		
		textFieldDoctorSpeciality = new JTextField();
		textFieldDoctorSpeciality.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				textFieldDoctorSpeciality.setBackground(Color.white);
			}
		});
		textFieldDoctorSpeciality.setBounds(89, 279, 153, 20);
		panelDoctor.add(textFieldDoctorSpeciality);
		textFieldDoctorSpeciality.setColumns(10);
		
		textFieldDoctorOfficeNo = new JTextField();
		textFieldDoctorOfficeNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				textFieldDoctorOfficeNo.setBackground(Color.white);
			}
		});
		textFieldDoctorOfficeNo.setBounds(89, 326, 153, 20);
		panelDoctor.add(textFieldDoctorOfficeNo);
		textFieldDoctorOfficeNo.setColumns(10);
		
		JLabel lblDoctorUsername = new JLabel("Username:");
		lblDoctorUsername.setForeground(Color.WHITE);
		lblDoctorUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDoctorUsername.setBounds(7, 96, 74, 14);
		panelDoctor.add(lblDoctorUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(7, 142, 77, 14);
		panelDoctor.add(lblPassword);
		
		JLabel lblConfirmPass = new JLabel("Confirm:");
		lblConfirmPass.setForeground(Color.WHITE);
		lblConfirmPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmPass.setBounds(7, 188, 77, 14);
		panelDoctor.add(lblConfirmPass);
		
		JLabel lblDateJoined = new JLabel("Joined On:");
		lblDateJoined.setForeground(Color.WHITE);
		lblDateJoined.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateJoined.setBounds(7, 234, 74, 14);
		panelDoctor.add(lblDateJoined);
		
		textFieldDoctorUsername = new JTextField();
		textFieldDoctorUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				textFieldDoctorUsername.setBackground(Color.white);
			}
		});
		textFieldDoctorUsername.setBounds(89, 96, 153, 20);
		panelDoctor.add(textFieldDoctorUsername);
		textFieldDoctorUsername.setColumns(10);
		
		textFieldDoctorDateJoined = new JTextField();
		textFieldDoctorDateJoined.setEditable(false);
		textFieldDoctorDateJoined.setBounds(89, 234, 153, 20);
		panelDoctor.add(textFieldDoctorDateJoined);
		textFieldDoctorDateJoined.setColumns(10);
		
		passwordFieldDoctor = new JPasswordField();
		passwordFieldDoctor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				passwordFieldDoctor.setBackground(Color.white);
			}
		});
		passwordFieldDoctor.setBounds(89, 142, 153, 20);
		panelDoctor.add(passwordFieldDoctor);
		
		confirmpasswordFieldDoctor = new JPasswordField();
		confirmpasswordFieldDoctor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				confirmpasswordFieldDoctor.setBackground(Color.white);
			}
		});
		confirmpasswordFieldDoctor.setBounds(89, 188, 153, 20);
		panelDoctor.add(confirmpasswordFieldDoctor);
		
		JLabel label_1 = new JLabel("X");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			
			}
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				label_1.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				label_1.setForeground(Color.WHITE);
			}
		});
		label_1.setToolTipText("Exit");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_1.setBounds(235, 11, 20, 20);
		panelDoctor.add(label_1);
		
		JPanel panelSecretary = new JPanel();
		panelSecretary.setBackground(Color.DARK_GRAY);
		panelSecretary.setBounds(471, 0, 256, 402);
		//main.add(panelSecretary);
		panelSecretary.setLayout(null);
		
	
		
		JLabel lblSecretaryStaffno = new JLabel("StaffNo:");
		lblSecretaryStaffno.setForeground(Color.WHITE);
		lblSecretaryStaffno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecretaryStaffno.setBounds(7, 50, 64, 14);
		panelSecretary.add(lblSecretaryStaffno);
		
		JLabel lblSecretaryUsername = new JLabel("Username:");
		lblSecretaryUsername.setForeground(Color.WHITE);
		lblSecretaryUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecretaryUsername.setBounds(7, 96, 74, 14);
		panelSecretary.add(lblSecretaryUsername);
		
		JLabel lblSecretaryPassword = new JLabel("Password:");
		lblSecretaryPassword.setForeground(Color.WHITE);
		lblSecretaryPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecretaryPassword.setBounds(7, 142, 85, 14);
		panelSecretary.add(lblSecretaryPassword);
		
		JLabel lblSecretaryConfirm = new JLabel("Confirm:");
		lblSecretaryConfirm.setForeground(Color.WHITE);
		lblSecretaryConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecretaryConfirm.setBounds(7, 188, 71, 14);
		panelSecretary.add(lblSecretaryConfirm);
		
		JLabel lblSecretaryJoinedOn = new JLabel("Joined On:");
		lblSecretaryJoinedOn.setForeground(Color.WHITE);
		lblSecretaryJoinedOn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecretaryJoinedOn.setBounds(7, 234, 82, 14);
		panelSecretary.add(lblSecretaryJoinedOn);
		
		JLabel lblDeskNo = new JLabel("Desk No:");
		lblDeskNo.setForeground(Color.WHITE);
		lblDeskNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeskNo.setBounds(7, 280, 64, 14);
		panelSecretary.add(lblDeskNo);
		
		textFieldSecretaryStaffNo = new JTextField();
		textFieldSecretaryStaffNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				 textFieldSecretaryStaffNo.setBackground(Color.white);
			}
		});
		textFieldSecretaryStaffNo.setBounds(89, 50, 153, 20);
		panelSecretary.add(textFieldSecretaryStaffNo);
		textFieldSecretaryStaffNo.setColumns(10);
		
		textFieldSecretaryUsername = new JTextField();
		textFieldSecretaryUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				textFieldSecretaryUsername.setBackground(Color.WHITE);
			}
		});
		textFieldSecretaryUsername.setBounds(89, 96, 153, 20);
		panelSecretary.add(textFieldSecretaryUsername);
		textFieldSecretaryUsername.setColumns(10);
		
		textFieldSecretaryDateJoined = new JTextField();
		textFieldSecretaryDateJoined.setBounds(89, 234, 153, 20);
		panelSecretary.add(textFieldSecretaryDateJoined);
		textFieldSecretaryDateJoined.setColumns(10);
		
		textFieldSecretaryDeskNo = new JTextField();
		textFieldSecretaryDeskNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				textFieldSecretaryDeskNo.setBackground(Color.white);
			}
		});
		textFieldSecretaryDeskNo.setBounds(89, 280, 153, 20);
		panelSecretary.add(textFieldSecretaryDeskNo);
		textFieldSecretaryDeskNo.setColumns(10);
		
		passwordFieldSecretary = new JPasswordField();
		passwordFieldSecretary.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				passwordFieldSecretary.setBackground(Color.white);
			}
		});
		passwordFieldSecretary.setBounds(89, 142, 153, 20);
		panelSecretary.add(passwordFieldSecretary);
		
		confirmpasswordFieldSecretary = new JPasswordField();
		confirmpasswordFieldSecretary.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				confirmpasswordFieldSecretary.setBackground(Color.white);
			}
		});
		confirmpasswordFieldSecretary.setBounds(89, 188, 153, 20);
		panelSecretary.add(confirmpasswordFieldSecretary);
		
		JLabel label_2 = new JLabel("X");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					AdminGUI.this.dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								LoginGUI frame = new LoginGUI();
								frame.setUndecorated(true);
								frame.setLocationRelativeTo(null);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				label_2.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				label_2.setForeground(Color.WHITE);
			}
		});
		label_2.setToolTipText("Exit");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label_2.setBounds(235, 11, 20, 20);
		panelSecretary.add(label_2);
		
		
		JPanel panelAdmin = new JPanel();
		panelAdmin.setBackground(Color.DARK_GRAY);
		panelAdmin.setBounds(471, 0, 256, 402);
		//main.add(panelAdmin);
		panelAdmin.setLayout(null);
		
		
		
		JLabel lblAdminStaffNo = new JLabel("StaffNo:");
		lblAdminStaffNo.setForeground(Color.WHITE);
		lblAdminStaffNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdminStaffNo.setBounds(7, 50, 69, 14);
		panelAdmin.add(lblAdminStaffNo);
		
		JLabel lblAdminUsername = new JLabel("Username:");
		lblAdminUsername.setForeground(Color.WHITE);
		lblAdminUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdminUsername.setBounds(7, 96, 74, 14);
		panelAdmin.add(lblAdminUsername);
		
		JLabel lblAdminPassword = new JLabel("Password:");
		lblAdminPassword.setForeground(Color.WHITE);
		lblAdminPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdminPassword.setBounds(7, 142, 72, 14);
		panelAdmin.add(lblAdminPassword);
		
		JLabel lblAdminConfirm = new JLabel("Confirm:");
		lblAdminConfirm.setForeground(Color.WHITE);
		lblAdminConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdminConfirm.setBounds(7, 188, 71, 14);
		panelAdmin.add(lblAdminConfirm);
		
		JLabel lblAdminDateJoined = new JLabel("Joined On:");
		lblAdminDateJoined.setForeground(Color.WHITE);
		lblAdminDateJoined.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdminDateJoined.setBounds(7, 234, 74, 14);
		panelAdmin.add(lblAdminDateJoined);
		
		JLabel lblAdminLastLogin = new JLabel("Last Login:");
		lblAdminLastLogin.setForeground(Color.WHITE);
		lblAdminLastLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdminLastLogin.setBounds(7, 280, 76, 14);
		panelAdmin.add(lblAdminLastLogin);
		
		textFieldAdminStaffNo = new JTextField();
		textFieldAdminStaffNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldAdminStaffNo.setBackground(Color.white);
			}
		});
		textFieldAdminStaffNo.setBounds(89, 50, 153, 20);
		panelAdmin.add(textFieldAdminStaffNo);
		textFieldAdminStaffNo.setColumns(10);
		
		textFieldAdminUsername = new JTextField();
		textFieldAdminUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				textFieldAdminUsername.setBackground(Color.white);
			}
		});
		textFieldAdminUsername.setBounds(89, 96, 153, 20);
		panelAdmin.add(textFieldAdminUsername);
		textFieldAdminUsername.setColumns(10);
		
		textFieldAdminDateJoined = new JTextField();
		textFieldAdminDateJoined.setEditable(false);
		textFieldAdminDateJoined.setBounds(89, 234, 153, 20);
		panelAdmin.add(textFieldAdminDateJoined);
		textFieldAdminDateJoined.setColumns(10);
		
		textFieldAdminLastLogin = new JTextField();
		textFieldAdminLastLogin.setEditable(false);
		textFieldAdminLastLogin.setBounds(89, 280, 153, 20);
		panelAdmin.add(textFieldAdminLastLogin);
		textFieldAdminLastLogin.setColumns(10);
		
		passwordFieldAdmin = new JPasswordField();
		passwordFieldAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				passwordFieldAdmin.setBackground(Color.white);
			}
		});
		passwordFieldAdmin.setBounds(89, 142, 153, 20);
		panelAdmin.add(passwordFieldAdmin);
		
		confirmpasswordFieldAdmin = new JPasswordField();
		confirmpasswordFieldAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				confirmpasswordFieldAdmin.setBackground(Color.white);
			}
		});
		confirmpasswordFieldAdmin.setBounds(89, 188, 153, 20);
		panelAdmin.add(confirmpasswordFieldAdmin);
		
		JLabel label = new JLabel("X");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?","WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					AdminGUI.this.dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								LoginGUI frame = new LoginGUI();
								frame.setUndecorated(true);
								frame.setLocationRelativeTo(null);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				label.setForeground(Color.WHITE);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				label.setForeground(Color.RED);
			}
		});
		label.setToolTipText("Exit");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBounds(235, 11, 20, 20);
		panelAdmin.add(label);
		
		JPanel panelNurse = new JPanel();
		panelNurse.setBackground(Color.DARK_GRAY);
		panelNurse.setBounds(471, 0, 256, 402);
		//main.add(panelNurse);
		panelNurse.setLayout(null);
		
		JLabel lblStaffNo = new JLabel("StaffNo:");
		lblStaffNo.setForeground(Color.WHITE);
		lblStaffNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStaffNo.setBounds(7, 50, 63, 14);
		panelNurse.add(lblStaffNo);
		
		JLabel lblNewLabel_4 = new JLabel("Pharmacy:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(7, 280, 63, 17);
		panelNurse.add(lblNewLabel_4);
		
		textFieldNurseStaffNo = new JTextField();
		textFieldNurseStaffNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				textFieldNurseStaffNo.setBackground(Color.WHITE);
			}
		});
		textFieldNurseStaffNo.setBounds(89, 50, 153, 20);
		panelNurse.add(textFieldNurseStaffNo);
		textFieldNurseStaffNo.setColumns(10);
		
		textFieldNursePharmacy = new JTextField();
		textFieldNursePharmacy.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				textFieldNursePharmacy.setBackground(Color.WHITE);
			}
		});
		textFieldNursePharmacy.setBounds(89, 280, 153, 20);
		panelNurse.add(textFieldNursePharmacy);
		textFieldNursePharmacy.setColumns(10);
		
		JLabel lblNurseUsername = new JLabel("Username:");
		lblNurseUsername.setForeground(Color.WHITE);
		lblNurseUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNurseUsername.setBounds(7, 96, 80, 14);
		panelNurse.add(lblNurseUsername);
		
		JLabel lblNursePassword = new JLabel("Password:");
		lblNursePassword.setForeground(Color.WHITE);
		lblNursePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNursePassword.setBounds(7, 142, 85, 14);
		panelNurse.add(lblNursePassword);
		
		JLabel lblNurseConfirm = new JLabel("Confirm:");
		lblNurseConfirm.setForeground(Color.WHITE);
		lblNurseConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNurseConfirm.setBounds(7, 188, 73, 14);
		panelNurse.add(lblNurseConfirm);
		
		JLabel lblNurseJoinedOn = new JLabel("Joined On:");
		lblNurseJoinedOn.setForeground(Color.WHITE);
		lblNurseJoinedOn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNurseJoinedOn.setBounds(7, 234, 85, 14);
		panelNurse.add(lblNurseJoinedOn);
		
		textFieldNurseUsername = new JTextField();
		textFieldNurseUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				textFieldNurseUsername.setBackground(Color.WHITE);
			}
		});
		textFieldNurseUsername.setBounds(89, 96, 153, 20);
		panelNurse.add(textFieldNurseUsername);
		textFieldNurseUsername.setColumns(10);
		
		textFieldNurseDateJoined = new JTextField();
		textFieldNurseDateJoined.setEditable(false);
		textFieldNurseDateJoined.setBounds(89, 234, 153, 20);
		panelNurse.add(textFieldNurseDateJoined);
		textFieldNurseDateJoined.setColumns(10);
		
		passwordFieldNurse = new JPasswordField();
		passwordFieldNurse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				passwordFieldNurse.setBackground(Color.WHITE);
			}
		});
		passwordFieldNurse.setBounds(89, 142, 153, 20);
		panelNurse.add(passwordFieldNurse);
		
		confirmpasswordFieldNurse = new JPasswordField();
		confirmpasswordFieldNurse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				confirmpasswordFieldNurse.setBackground(Color.WHITE);
			}
		});
		confirmpasswordFieldNurse.setBounds(89, 188, 153, 20);
		panelNurse.add(confirmpasswordFieldNurse);
		
		JLabel labelX = new JLabel("X");
		labelX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				labelX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				labelX.setForeground(Color.WHITE);
			}
		});
		labelX.setToolTipText("Exit");
		labelX.setForeground(Color.WHITE);
		labelX.setFont(new Font("Tahoma", Font.PLAIN, 21));
		labelX.setBounds(235, 11, 20, 20);
		panelNurse.add(labelX);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(141, 280, 153, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		
		JLabel searchLbl = new JLabel("Search", SwingConstants.CENTER);
		JLabel manageLbl = new JLabel("Edit Users", SwingConstants.CENTER);
		JLabel logoutLbl = new JLabel("Logout", SwingConstants.CENTER);
		JLabel createLbl = new JLabel("Create User", SwingConstants.CENTER);
		JLabel maintenanceLbl = new JLabel("Maintenance");
		maintenanceLbl.setBackground(new Color(0, 206, 209));
		maintenanceLbl.setOpaque(true);
		createLbl.setBackground(new Color(0, 206, 209));
		createLbl.setOpaque(true);
		createLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				roleClicked = "cheese";
				createLbl.setBackground(new Color(0, 134, 134));
				searchLbl.setBackground(new Color(0, 206, 209));
				logoutLbl.setBackground(new Color(0, 206, 209));
				manageLbl.setBackground(new Color(0, 206, 209));
				maintenanceLbl.setBackground(new Color(0, 206, 209));
				labelAddDoctor.setBackground(new Color(0, 206, 209));
				labelAddNurse.setBackground(new Color(0, 206, 209));
				labelSecretary.setBackground(new Color(0, 206, 209));
				labelAddAdmin.setBackground(new Color(0, 206, 209));
				
				textFieldTitle.setBackground(Color.white);
				textFieldName.setBackground(Color.white);
				textFieldAddress.setBackground(Color.white);
				textFieldEmail.setBackground(Color.white);
				textFieldTelephone.setBackground(Color.white);
				dateChooser.setBackground(Color.white);
				textFieldGender.setBackground(Color.white);
				
				textFieldTitle.setText("");
				textFieldName.setText("");
				textFieldAddress.setText("");
				textFieldEmail.setText("");
				textFieldTelephone.setText("");
				textFieldGender.setText("");
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				//main.add(createPanel);
				main.add(addPanel);
				main.add(panel);
				main.add(panelPerson);
				main.repaint();
				main.revalidate();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				createLbl.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				createLbl.setForeground(Color.BLACK);
			}
		});
		searchLbl.setBackground(new Color(0, 139, 139));
		searchLbl.setOpaque(true);
		searchLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				searchLbl.setBackground(new Color(0, 134, 134));
				logoutLbl.setBackground(new Color(0, 206, 209));
				manageLbl.setBackground(new Color(0, 206, 209));
				createLbl.setBackground(new Color(0, 206, 209));
				maintenanceLbl.setBackground(new Color(0, 206, 209));
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(searchPanel);
				main.repaint();
				main.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				searchLbl.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				searchLbl.setForeground(Color.BLACK);
			}
		});
		searchLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchLbl.setBounds(0, 90, 235, 35);
		side.add(searchLbl);
		
		
		manageLbl.setBackground(new Color(0, 206, 209));
		manageLbl.setOpaque(true);
		manageLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				manageLbl.setBackground(new Color(0, 134, 134));
				logoutLbl.setBackground(new Color(0, 206, 209));
				searchLbl.setBackground(new Color(0, 206, 209));
				createLbl.setBackground(new Color(0, 206, 209));
				maintenanceLbl.setBackground(new Color(0, 206, 209));
				
				idtextField.setText("");
				nametextField.setText("");
				passwordtextField.setText("");
				addresstextField.setText("");
				telephonetextField.setText("");
				specialitytextField.setText("");
				pharmacytextField.setText("");
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(editPanel);
				main.repaint();
				main.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				manageLbl.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				manageLbl.setForeground(Color.BLACK);
			}
		});
		manageLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		manageLbl.setBounds(0, 156, 235, 35);
		side.add(manageLbl);
		
		
		logoutLbl.setBackground(new Color(0, 206, 209));
		logoutLbl.setOpaque(true);
		logoutLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				logoutLbl.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				logoutLbl.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				logoutLbl.setBackground(new Color(0, 134, 134));
				searchLbl.setBackground(new Color(0, 206, 209));
				manageLbl.setBackground(new Color(0, 206, 209));
				createLbl.setBackground(new Color(0, 206, 209));
				maintenanceLbl.setBackground(new Color(0, 206, 209));
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?","WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					AdminGUI.this.dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								LoginGUI frame = new LoginGUI();
								frame.setUndecorated(true);
								frame.setLocationRelativeTo(null);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		logoutLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoutLbl.setBounds(0, 357, 235, 35);
		side.add(logoutLbl);
		
		createLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		createLbl.setBounds(0, 223, 235, 35);
		side.add(createLbl);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminGUI.class.getResource("/Images/BLUE.png")));
		lblNewLabel_1.setBounds(10, 12, 85, 73);
		side.add(lblNewLabel_1);
		
		JLabel lblBlueNaartjie = new JLabel("Blue Naartjie");
		lblBlueNaartjie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{	
				lblBlueNaartjie.setForeground(new Color(66,134,244));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				lblBlueNaartjie.setForeground(new Color(255, 255, 255));
			}
		});
		lblBlueNaartjie.setFont(new Font("Papyrus", Font.BOLD, 20));
		lblBlueNaartjie.setForeground(Color.WHITE);
		lblBlueNaartjie.setBounds(87, 23, 138, 62);
		side.add(lblBlueNaartjie);
		
	
		maintenanceLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				maintenanceLbl.setBackground(new Color(0, 134, 134));
				searchLbl.setBackground(new Color(0, 206, 209));
				manageLbl.setBackground(new Color(0, 206, 209));
				createLbl.setBackground(new Color(0, 206, 209));
				logoutLbl.setBackground(new Color(0, 206, 209));
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(maintenancePanel);
				main.repaint();
				main.revalidate();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				maintenanceLbl.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				maintenanceLbl.setForeground(Color.BLACK);
			}
		});
		maintenanceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		maintenanceLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		maintenanceLbl.setBounds(0, 290, 235, 35);
		side.add(maintenanceLbl);
		
		JPanel Banner = new JPanel();
		Banner.setBounds(227, 442, 817, 122);
		contentPane.add(Banner);
		Banner.setBackground(Color.DARK_GRAY);
		Banner.setLayout(null);
		
		JLabel bannerLbl = new JLabel("");
		bannerLbl.setBounds(0, -41, 816, 139);
		Banner.add(bannerLbl);
		bannerLbl.setIcon(new ImageIcon(AdminGUI.class.getResource("/Images/medBanner.png")));
		
		labelAddNurse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				roleClicked = "Nurse";
				labelAddNurse.setBackground(new Color(0, 134, 134));
				labelAddDoctor.setBackground(new Color(0, 206, 209));
				labelSecretary.setBackground(new Color(0, 206, 209));
				labelAddAdmin.setBackground(new Color(0, 206, 209));
				
				textFieldNursePharmacy.setBackground(Color.WHITE);
				textFieldNurseStaffNo.setBackground(Color.WHITE);
				textFieldNurseUsername.setBackground(Color.WHITE);
				passwordFieldNurse.setBackground(Color.WHITE);
				confirmpasswordFieldNurse.setBackground(Color.WHITE);
				
				textFieldNursePharmacy.setText("");
				textFieldNurseStaffNo.setText("");
				textFieldNurseUsername.setText("");
				passwordFieldNurse.setText("");
				confirmpasswordFieldNurse.setText("");
				
				/*textFieldTitle.setBackground(Color.white);
				textFieldName.setBackground(Color.white);
				textFieldAddress.setBackground(Color.white);
				textFieldEmail.setBackground(Color.white);
				textFieldTelephone.setBackground(Color.white);
				dateChooser.setBackground(Color.white);
				textFieldGender.setBackground(Color.white);*/
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(addPanel);
				main.add(panel);
				main.add(panelPerson);
				main.add(panelNurse);
				main.repaint();
				main.revalidate();
				
				AdminHandler r = new AdminHandler();
				textFieldNurseDateJoined.setText(r.dateJoined());
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelAddNurse.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				labelAddNurse.setForeground(Color.BLACK);
			}
		});
		
		labelAddDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				roleClicked = "Doctor";
				labelAddDoctor.setBackground(new Color(0, 134, 134));
				labelAddNurse.setBackground(new Color(0, 206, 209));
				labelSecretary.setBackground(new Color(0, 206, 209));
				labelAddAdmin.setBackground(new Color(0, 206, 209));
				
				textFieldDoctorOfficeNo.setBackground(Color.white);
				textFieldDoctorSpeciality.setBackground(Color.white);
				textFieldDoctorstaffno.setBackground(Color.white);
				textFieldDoctorUsername.setBackground(Color.white);
				passwordFieldDoctor.setBackground(Color.white);
				confirmpasswordFieldDoctor.setBackground(Color.white);
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(addPanel);
				main.add(panel);
				main.add(panelPerson);
				main.add(panelDoctor);
				main.repaint();
				main.revalidate();
				
				AdminHandler r = new AdminHandler();
				textFieldDoctorDateJoined.setText(r.dateJoined());
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelAddDoctor.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				labelAddDoctor.setForeground(Color.BLACK);
			}
		});
		
		
		labelSecretary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				roleClicked = "Secretary";
				labelSecretary.setBackground(new Color(0, 134, 134));
				labelAddNurse.setBackground(new Color(0, 206, 209));
				labelAddDoctor.setBackground(new Color(0, 206, 209));
				labelAddAdmin.setBackground(new Color(0, 206, 209));
				
				textFieldSecretaryDeskNo.setBackground(Color.white);
				textFieldSecretaryStaffNo.setBackground(Color.white);
				textFieldSecretaryUsername.setBackground(Color.white);
				passwordFieldSecretary.setBackground(Color.white);
				confirmpasswordFieldSecretary.setBackground(Color.white);
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(addPanel);
				main.add(panel);
				main.add(panelPerson);
				main.add(panelSecretary);
				main.repaint();
				main.revalidate();
				
				AdminHandler r = new AdminHandler();
				textFieldSecretaryDateJoined.setText(r.dateJoined());
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelSecretary.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				labelSecretary.setForeground(Color.BLACK);
			}
		});
		

		labelAddAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				roleClicked = "Admin";
				labelAddAdmin.setBackground(new Color(0, 134, 134));
				labelAddNurse.setBackground(new Color(0, 206, 209));
				labelSecretary.setBackground(new Color(0, 206, 209));
				labelAddDoctor.setBackground(new Color(0, 206, 209));
				textFieldAdminUsername.setBackground(Color.WHITE);
				textFieldAdminStaffNo.setBackground(Color.white);
				passwordFieldAdmin.setBackground(Color.white);
				confirmpasswordFieldAdmin.setBackground(Color.white);
				
				textFieldAdminUsername.setText("");
				textFieldAdminStaffNo.setText("");
				passwordFieldAdmin.setText("");
				confirmpasswordFieldAdmin.setText("");
				AdminHandler r2 = new AdminHandler();
				textFieldAdminLastLogin.setText(r2.dateJoined());
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(addPanel);
				main.add(panel);
				main.add(panelPerson);
				main.add(panelAdmin);
				main.repaint();
				main.revalidate();
				
				AdminHandler r = new AdminHandler();
				textFieldAdminDateJoined.setText(r.dateJoined());
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelAddAdmin.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				labelAddAdmin.setForeground(Color.BLACK);
			}
		});
	}
}
