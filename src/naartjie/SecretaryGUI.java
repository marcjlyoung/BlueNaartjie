/**
 *  Version: 1.0
 * 	Class: SecretaryGUI
 * 	Description:  Interface for Secretary Role
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */



package naartjie;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import javafx.scene.control.ComboBox;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class SecretaryGUI extends JFrame {

	private JPanel contentPane;
	private int xOffset = 0;
	private int yOffset = 0;
	private JTextField textFieldSearchPatient;
	private JTable patientList;
	private JTextField textFieldPatientSearch;
	private JTextField textFieldPatientName;
	private JTextField textFieldPatientAddress;
	private JTextField textFieldPatientTelephone;
	private JTextField textFieldPatientMedAid;
	private JTextField textFieldPatientMedAidNo;
	private JTextField textFieldPatientAge;
	private JTextField textFieldSponsorName;
	private JTextField textFieldSponsorTel;
	private JTextField textFieldAmount;
	private JTextField textFieldPaymentPatientID;
	private JTextField textFieldPatientTitle;
	private JTextField textFieldPatientEmail;
	private JTextField textFieldPatientGender;
	private JTextField textFieldPatientMedicalHistory;
	private JTextField textFieldPatientPrescription;
	private JTextField textFieldPatientTitleEdit;
	private JTextField textFieldPatientNameEdit;
	private JTextField textFieldPatientAddressEdit;
	private JTextField textFieldTelephonePatientEdit;
	private JTextField textFieldPatientEmailEdit;
	private JTextField textFieldMedAidPatientEdit;
	private JTextField textFieldPatientEditMedAidNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecretaryGUI frame = new SecretaryGUI();
					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SecretaryGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				SecretaryGUI.this.setLocation(x - xOffset, y - yOffset);
				}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				 xOffset = arg0.getX();
	             yOffset = arg0.getY();
			}
		});
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel side = new JPanel();
		side.setBackground(new Color(0, 206, 209));
		side.setBounds(0, 0, 235, 550);
		contentPane.add(side);
		side.setLayout(null);
		
		JLabel labelBlueNaartjie = new JLabel("Blue Naartjie");
		labelBlueNaartjie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				labelBlueNaartjie.setForeground(new Color(66, 134, 244));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				labelBlueNaartjie.setForeground(new Color(255, 255, 255));
			}
		});
		labelBlueNaartjie.setFont(new Font("Papyrus", Font.BOLD, 20));
		labelBlueNaartjie.setForeground(new Color(255, 255, 255));
		labelBlueNaartjie.setBounds(87, 23, 138, 62);
		side.add(labelBlueNaartjie);
		
		JLabel lP = new JLabel("Logout");
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(SecretaryGUI.class.getResource("/images/BLUE.png")));
		logo.setBounds(10, 12, 85, 73);
		side.add(logo);
		
		JTextPane quote = new JTextPane();
		quote.setEditable(false);
		quote.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		quote.setBackground(new Color(0, 206, 209));
		quote.setForeground(new Color(255, 255, 255));
		quote.setText("\u201CDeclare the past, diagnose the present, foretell the future.\u201D \r\n-  Hippocrates");
		quote.setBounds(27, 414, 174, 73);
		side.add(quote);
		
		JPanel main = new JPanel();
		main.setBackground(Color.DARK_GRAY);
		main.setForeground(new Color(255, 255, 255));
		main.setBounds(235, 0, 750, 443);
		contentPane.add(main);
		main.setLayout(null);
		
		JPanel editP = new JPanel();
		editP.setBackground(Color.DARK_GRAY);
		editP.setBounds(0, 0, 737, 443);
		//main.add(editP);
		editP.setLayout(null);
		
		JLabel editExit = new JLabel("X");
		editExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "WARNING", JOptionPane.YES_NO_OPTION) 
						== JOptionPane.YES_OPTION){
						System.exit(0);
					}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				editExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				editExit.setForeground(Color.WHITE);
			}
		});
		editExit.setToolTipText("Exit");
		editExit.setForeground(Color.WHITE);
		editExit.setFont(new Font("Tahoma", Font.PLAIN, 21));
		editExit.setBounds(697, 11, 20, 20);
		editP.add(editExit);
		
		JLabel lblEditAPatients = new JLabel("Edit a Patients Details Below:");
		lblEditAPatients.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditAPatients.setForeground(new Color(255, 255, 255));
		lblEditAPatients.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEditAPatients.setBounds(238, 13, 223, 20);
		editP.add(lblEditAPatients);
		
		textFieldPatientSearch = new JTextField();
		textFieldPatientSearch.addKeyListener(new KeyAdapter() {
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
		textFieldPatientSearch.setBounds(307, 56, 135, 20);
		editP.add(textFieldPatientSearch);
		textFieldPatientSearch.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(203, 57, 46, 14);
		editP.add(lblId);
		
		JButton deleteButton = new JButton("Delete");
		
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteButton.setFocusable(false);
		deleteButton.setBackground(new Color(0, 206, 209));
		deleteButton.setBounds(145, 409, 110, 23);
		editP.add(deleteButton);
		
		JButton updateButton = new JButton("Update");
		
			updateButton.setForeground(Color.WHITE);
			updateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			updateButton.setFocusable(false);
			updateButton.setBackground(new Color(0, 206, 209));
			updateButton.setBounds(555, 409, 110, 23);
			editP.add(updateButton);
			
			JLabel lblTitlePatientEdit = new JLabel("Title:");
			lblTitlePatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTitlePatientEdit.setForeground(Color.WHITE);
			lblTitlePatientEdit.setBounds(33, 92, 46, 14);
			editP.add(lblTitlePatientEdit);
			
			JLabel lblNamePatientEdit = new JLabel("Name:");
			lblNamePatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNamePatientEdit.setForeground(Color.WHITE);
			lblNamePatientEdit.setBounds(33, 132, 46, 14);
			editP.add(lblNamePatientEdit);
			
			JLabel lblAddressPatientEdit = new JLabel("Address:");
			lblAddressPatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAddressPatientEdit.setForeground(Color.WHITE);
			lblAddressPatientEdit.setBounds(33, 172, 62, 14);
			editP.add(lblAddressPatientEdit);
			
			JLabel lblTelephonePatientEdit = new JLabel("Telephone:");
			lblTelephonePatientEdit.setForeground(Color.WHITE);
			lblTelephonePatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTelephonePatientEdit.setBounds(33, 212, 76, 14);
			editP.add(lblTelephonePatientEdit);
			
			JLabel lblEmailPatientEdit = new JLabel("Email:");
			lblEmailPatientEdit.setForeground(Color.WHITE);
			lblEmailPatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmailPatientEdit.setBounds(33, 252, 46, 14);
			editP.add(lblEmailPatientEdit);
			
			JTextPane textPanePatientAllergiesEdit = new JTextPane();
			textPanePatientAllergiesEdit.setBounds(428, 324, 237, 76);
			editP.add(textPanePatientAllergiesEdit);
			
			JLabel lblAllergiesPatientEdit = new JLabel("Allergies:");
			lblAllergiesPatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAllergiesPatientEdit.setForeground(Color.WHITE);
			lblAllergiesPatientEdit.setBounds(525, 295, 92, 30);
			editP.add(lblAllergiesPatientEdit);
			
			JTextPane textPanePatientPrescription = new JTextPane();
			textPanePatientPrescription.setBounds(428, 218, 237, 76);
			editP.add(textPanePatientPrescription);
			
			JTextPane textPane_1 = new JTextPane();
			textPane_1.setBounds(428, 110, 237, 76);
			editP.add(textPane_1);
			
			JLabel lblPrescriptionPatientEdit = new JLabel("Prescription:");
			lblPrescriptionPatientEdit.setForeground(Color.WHITE);
			lblPrescriptionPatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPrescriptionPatientEdit.setBounds(518, 191, 76, 20);
			editP.add(lblPrescriptionPatientEdit);
			
			JLabel lblMedicalHistoryPatientEdit = new JLabel("Medical History:");
			lblMedicalHistoryPatientEdit.setForeground(Color.WHITE);
			lblMedicalHistoryPatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMedicalHistoryPatientEdit.setBounds(508, 84, 98, 30);
			editP.add(lblMedicalHistoryPatientEdit);
			
			textFieldPatientTitleEdit = new JTextField();
			textFieldPatientTitleEdit.setBounds(145, 92, 152, 20);
			editP.add(textFieldPatientTitleEdit);
			textFieldPatientTitleEdit.setColumns(10);
			
			textFieldPatientNameEdit = new JTextField();
			textFieldPatientNameEdit.setBounds(145, 132, 152, 20);
			editP.add(textFieldPatientNameEdit);
			textFieldPatientNameEdit.setColumns(10);
			
			textFieldPatientAddressEdit = new JTextField();
			textFieldPatientAddressEdit.setBounds(145, 172, 152, 20);
			editP.add(textFieldPatientAddressEdit);
			textFieldPatientAddressEdit.setColumns(10);
			
			textFieldTelephonePatientEdit = new JTextField();
			textFieldTelephonePatientEdit.addKeyListener(new KeyAdapter() {
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
			textFieldTelephonePatientEdit.setBounds(145, 212, 152, 20);
			editP.add(textFieldTelephonePatientEdit);
			textFieldTelephonePatientEdit.setColumns(10);
			
			textFieldPatientEmailEdit = new JTextField();
			textFieldPatientEmailEdit.setBounds(145, 252, 152, 20);
			editP.add(textFieldPatientEmailEdit);
			textFieldPatientEmailEdit.setColumns(10);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setEditable(true);
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
			comboBox_1.setBounds(145, 292, 152, 20);
			editP.add(comboBox_1);
			
			JButton buttonSearchPatientEdit = new JButton("Search");
			buttonSearchPatientEdit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					String search = textFieldPatientSearch.getText();
					if(!(search.equals("")))
					{
						textFieldPatientTitleEdit.setText("");
						textFieldPatientNameEdit.setText("");
						textFieldPatientAddressEdit.setText("");
						textFieldTelephonePatientEdit.setText("");
						textFieldPatientEmailEdit.setText("");
						textFieldPatientEmailEdit.setText("");
						textFieldMedAidPatientEdit.setText("");
						textFieldPatientEditMedAidNo.setText("");
						textPane_1.setText("");
						textPanePatientAllergiesEdit.setText("");
						textPanePatientPrescription.setText("");
						int search1 = Integer.parseInt(search);
						PatientHandler ph = new PatientHandler();
						ph.searchPatient(search1, textFieldPatientTitleEdit, textFieldPatientNameEdit, textFieldPatientAddressEdit, textFieldTelephonePatientEdit, textFieldPatientEmailEdit, textPane_1, textPanePatientAllergiesEdit, textPanePatientPrescription, comboBox_1, textFieldMedAidPatientEdit, textFieldPatientEditMedAidNo);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter a value to searh for","Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			buttonSearchPatientEdit.setForeground(Color.WHITE);
			buttonSearchPatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			buttonSearchPatientEdit.setFocusable(false);
			buttonSearchPatientEdit.setBackground(new Color(0, 206, 209));
			buttonSearchPatientEdit.setBounds(467, 55, 110, 23);
			editP.add(buttonSearchPatientEdit);
			
			JLabel lblMedicalAidPatientEdit = new JLabel("Medical Aid?:");
			lblMedicalAidPatientEdit.setForeground(Color.WHITE);
			lblMedicalAidPatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMedicalAidPatientEdit.setBounds(33, 292, 77, 14);
			editP.add(lblMedicalAidPatientEdit);
			
			
			
			JLabel lblMedAidNamePatientEdit = new JLabel("Medical Aid:");
			lblMedAidNamePatientEdit.setForeground(Color.WHITE);
			lblMedAidNamePatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMedAidNamePatientEdit.setBounds(33, 333, 76, 14);
			editP.add(lblMedAidNamePatientEdit);
			
			textFieldMedAidPatientEdit = new JTextField();
			textFieldMedAidPatientEdit.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) 
				{
					
				}
			});
			textFieldMedAidPatientEdit.setBounds(145, 332, 152, 20);
			editP.add(textFieldMedAidPatientEdit);
			textFieldMedAidPatientEdit.setColumns(10);
			
			JLabel lblMedAidNoPatientEdit = new JLabel("Medical Aid No:");
			lblMedAidNoPatientEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMedAidNoPatientEdit.setForeground(Color.WHITE);
			lblMedAidNoPatientEdit.setBounds(33, 374, 99, 14);
			editP.add(lblMedAidNoPatientEdit);
			
			textFieldPatientEditMedAidNo = new JTextField();
			textFieldPatientEditMedAidNo.addKeyListener(new KeyAdapter() {
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
			textFieldPatientEditMedAidNo.setBounds(145, 374, 152, 20);
			editP.add(textFieldPatientEditMedAidNo);
			textFieldPatientEditMedAidNo.setColumns(10);
			
			deleteButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					String patientId = textFieldPatientSearch.getText();
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int result =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","Warning",dialogButton);
					
					if(result == JOptionPane.YES_OPTION)
					{
						String username = textFieldPatientNameEdit.getText();
						PatientHandler ph = new PatientHandler();
						ph.deletePatient(patientId);
						JOptionPane.showMessageDialog(null, "Patient successfully deleted");
						Log log = new Log(true);
						String action = deleteButton.getText();
						String time = log.dateConverter();
						try {
							log.writeToFile("Secretary", action, username, time);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						textFieldPatientTitleEdit.setText("");
						textFieldPatientAddressEdit.setText("");
						textFieldPatientEditMedAidNo.setText("");
						textPane_1.setText("");
						textPanePatientAllergiesEdit.setText("");
						textPanePatientPrescription.setText("");
						textFieldPatientNameEdit.setText("");
						textFieldPatientEmailEdit.setText("");
						textFieldMedAidPatientEdit.setText("");
						textFieldTelephonePatientEdit.setText("");
						textFieldPatientSearch.setText("");
					}
					else
					{
						
					}
				}
			});
			
			updateButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					String search = textFieldPatientSearch.getText();
					if(!(search.equals("")))
					{
						String title = textFieldPatientTitleEdit.getText();
						String name = textFieldPatientNameEdit.getText();
						String address = textFieldPatientAddressEdit.getText();
						String telS = textFieldTelephonePatientEdit.getText();
						String email = textFieldPatientEmailEdit.getText();
						String optionMed = comboBox_1.getSelectedItem().toString();
						String medHistory = textPane_1.getText();
						String pres = textPanePatientPrescription.getText();
						String allergies = textPanePatientAllergiesEdit.getText();
						String medicalNo = textFieldPatientEditMedAidNo.getText();
						boolean hasMedical = false;
						String dOB = null;
						int searchInt = Integer.parseInt(search);
						
						if(!(title.equals("") | name.equals("") | address.equals("") | telS.equals("") | email.equals("") | medHistory.equals("") | pres.equals("") | allergies.equals("")))
						{
							int telephone = Integer.parseInt(telS);
							char gender = 0;
							int age = 0;
							String lastScriptDate =null;
							if(!(medicalNo.equals("")))
							{
								textFieldMedAidPatientEdit.setEditable(true);
								textFieldPatientEditMedAidNo.setEditable(true);
								hasMedical = true;
								String medName = textFieldMedAidPatientEdit.getText();
								String medNo1 = textFieldPatientEditMedAidNo.getText();
								int medNo = Integer.parseInt(medNo1);
								PatientHandler ph = new PatientHandler();
								PatientMA patient = new PatientMA(title, name, address, email, telephone, dOB, gender, allergies, hasMedical, age, lastScriptDate, medHistory, pres, medName, medNo);
								ph.updatePatientMed(patient, hasMedical, searchInt, optionMed);
								
								Log log = new Log(true);
								String action = updateButton.getText();
								String time = log.dateConverter();
								try {
									log.writeToFile("Secretary", action, name, time);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								textFieldPatientTitleEdit.setText("");
								textFieldPatientNameEdit.setText("");
								textFieldPatientAddressEdit.setText("");
								textFieldTelephonePatientEdit.setText("");
								textFieldPatientEmailEdit.setText("");
								textFieldPatientEmailEdit.setText("");
								textFieldMedAidPatientEdit.setText("");
								textFieldPatientEditMedAidNo.setText("");
								textPane_1.setText("");
								textPanePatientAllergiesEdit.setText("");
								textPanePatientPrescription.setText("");
								textFieldPatientSearch.setText("");
							}
							else
							{
								//textFieldMedAidPatientEdit.setText("");
								//textFieldPatientEditMedAidNo.setText("");
								//textFieldMedAidPatientEdit.setEditable(false);
								//textFieldPatientEditMedAidNo.setEditable(false);
								PatientHandler ph = new PatientHandler();
								Patient patient = new Patient(title, name, address, email, telephone, dOB, gender, allergies, hasMedical, age, lastScriptDate, medHistory, pres);
								ph.updatePatient(patient, hasMedical, searchInt, optionMed);
								textFieldPatientTitleEdit.setText("");
								textFieldPatientNameEdit.setText("");
								textFieldPatientAddressEdit.setText("");
								textFieldTelephonePatientEdit.setText("");
								textFieldPatientEmailEdit.setText("");
								textFieldPatientEmailEdit.setText("");
								textFieldMedAidPatientEdit.setText("");
								textFieldPatientEditMedAidNo.setText("");
								textPane_1.setText("");
								textPanePatientAllergiesEdit.setText("");
								textPanePatientPrescription.setText("");
								textFieldPatientSearch.setText("");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Please enter a value to searh for","Warning", JOptionPane.WARNING_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter a value to searh for","Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
		
		JPanel searchP = new JPanel();
		searchP.setBounds(0, 0, 737, 443);
		main.add(searchP);
		searchP.setBackground(Color.DARK_GRAY);
		searchP.setLayout(null);
		
		JLabel searchExit = new JLabel("X");
		searchExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				searchExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				searchExit.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "WARNING", JOptionPane.YES_NO_OPTION) 
						== JOptionPane.YES_OPTION){
						System.exit(0);
					}
			}
		});
		searchExit.setToolTipText("Exit");
		searchExit.setForeground(Color.WHITE);
		searchExit.setFont(new Font("Tahoma", Font.PLAIN, 21));
		searchExit.setBounds(697, 11, 20, 20);
		searchP.add(searchExit);
		
		JLabel lblEnter = new JLabel("Enter a patient name below:");
		lblEnter.setForeground(new Color(255, 255, 255));
		lblEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnter.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnter.setBounds(256, 31, 225, 14);
		searchP.add(lblEnter);
		
		textFieldSearchPatient = new JTextField();
		textFieldSearchPatient.setBounds(136, 68, 251, 20);
		searchP.add(textFieldSearchPatient);
		textFieldSearchPatient.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				String patientId = textFieldSearchPatient.getText();
				if(!(patientId.equals("")))
				{
					PatientHandler p = new PatientHandler();
					p.findPatient(patientId, patientList);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please enter a value to searh for","Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBackground(new Color(0, 206, 209));
		btnSearch.setBounds(452, 65, 80, 23);
		searchP.add(btnSearch);
		
		patientList = new JTable();
		JScrollPane j = new JScrollPane(patientList);
		patientList.setModel(new DefaultTableModel(new Object[][] {},new String[] {"PatientNo", "Title","Name","LastScriptDate", "Tel", "Allergies", "Prescription", "History"}
		));
		patientList.getColumnModel().getColumn(0).setPreferredWidth(115);
		patientList.getColumnModel().getColumn(1).setPreferredWidth(115);
		patientList.getColumnModel().getColumn(2).setPreferredWidth(115);
		patientList.getColumnModel().getColumn(3).setPreferredWidth(115);
		patientList.getColumnModel().getColumn(4).setPreferredWidth(115);
		patientList.getColumnModel().getColumn(5).setPreferredWidth(115);
		patientList.getColumnModel().getColumn(5).setPreferredWidth(115);
		patientList.setBounds(24, 140, 672, 268);
		j.setBounds(24, 140, 672, 268);
		searchP.add(j);
		
		JLabel lblPatientList = new JLabel("Patient List:");
		lblPatientList.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientList.setForeground(Color.WHITE);
		lblPatientList.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatientList.setBounds(269, 118, 225, 14);
		searchP.add(lblPatientList);
		
		JPanel payP = new JPanel();
		payP.setLayout(null);
		payP.setBackground(Color.DARK_GRAY);
		payP.setBounds(0, 0, 737, 443);
		//main.add(payP);
		
		JLabel payExit = new JLabel("X");
		payExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "WARNING", JOptionPane.YES_NO_OPTION) 
						== JOptionPane.YES_OPTION){
						System.exit(0);
					}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				payExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				payExit.setForeground(Color.WHITE);
			}
		});
		payExit.setToolTipText("Exit");
		payExit.setForeground(Color.WHITE);
		payExit.setFont(new Font("Tahoma", Font.PLAIN, 21));
		payExit.setBounds(697, 11, 20, 20);
		payP.add(payExit);
		
		JLabel lblNewLabel = new JLabel("Enter Payment Details Below: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(249, 16, 207, 14);
		payP.add(lblNewLabel);
		
		textFieldSponsorName = new JTextField();
		textFieldSponsorName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldSponsorName.setBackground(Color.white);
			}
		});
		textFieldSponsorName.setBounds(370, 66, 131, 20);
		payP.add(textFieldSponsorName);
		textFieldSponsorName.setColumns(10);
		
		JLabel lblSponsorName = new JLabel("Sponsor Name:");
		lblSponsorName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSponsorName.setForeground(new Color(255, 255, 255));
		lblSponsorName.setBounds(207, 67, 111, 14);
		payP.add(lblSponsorName);
		
		textFieldSponsorTel = new JTextField();
		textFieldSponsorTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldSponsorTel.setBackground(Color.white);
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
		textFieldSponsorTel.setBounds(370, 106, 131, 20);
		payP.add(textFieldSponsorTel);
		textFieldSponsorTel.setColumns(10);
		
		JLabel lblSponsorTelephone = new JLabel("Sponsor Telephone:");
		lblSponsorTelephone.setForeground(Color.WHITE);
		lblSponsorTelephone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSponsorTelephone.setBounds(207, 107, 131, 14);
		payP.add(lblSponsorTelephone);
		
		JLabel lblPaymentOption = new JLabel("Payment Option:");
		lblPaymentOption.setForeground(Color.WHITE);
		lblPaymentOption.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaymentOption.setBounds(207, 146, 131, 14);
		payP.add(lblPaymentOption);
		
		textFieldAmount = new JTextField();
		textFieldAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldAmount.setBackground(Color.white);
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
		textFieldAmount.setBounds(370, 186, 131, 20);
		payP.add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAmount.setBounds(207, 186, 131, 14);
		payP.add(lblAmount);
		
		JButton btnConfirmPayment = new JButton("Confirm Payment");
		btnConfirmPayment.setForeground(Color.WHITE);
		btnConfirmPayment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmPayment.setFocusable(false);
		btnConfirmPayment.setBackground(new Color(0, 206, 209));
		btnConfirmPayment.setBounds(280, 280, 176, 23);
		payP.add(btnConfirmPayment);
		
		textFieldPaymentPatientID = new JTextField();
		textFieldPaymentPatientID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPaymentPatientID.setBackground(Color.white);
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
		textFieldPaymentPatientID.setColumns(10);
		textFieldPaymentPatientID.setBounds(370, 226, 131, 20);
		payP.add(textFieldPaymentPatientID);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setForeground(Color.WHITE);
		lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientId.setBounds(207, 226, 111, 14);
		payP.add(lblPatientId);
		
		JComboBox comboBoxPaymentOption = new JComboBox();
		comboBoxPaymentOption.setModel(new DefaultComboBoxModel(new String[] {"Cash", "EFT", "Credit", "Cheque"}));
		comboBoxPaymentOption.setBounds(370, 145, 131, 20);
		payP.add(comboBoxPaymentOption);
		
		btnConfirmPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				PatientHandler ah = new PatientHandler();
				String sponsorName = textFieldSponsorName.getText();
				String telS = textFieldSponsorTel.getText();
				String paymentOption = comboBoxPaymentOption.getSelectedItem().toString();
				String amountS = textFieldAmount.getText();
				String idS = textFieldPaymentPatientID.getText();
				
				if(!(sponsorName.equals("") | telS.equals("") | amountS.equals("") | idS.equals("")))
				{
					int tel = Integer.parseInt(telS);
					int amount = Integer.parseInt(amountS);
					int Id = Integer.parseInt(idS);
					
					ah.payment(sponsorName, tel, paymentOption, amount, Id);
					
					Log log = new Log(true);
					String action = btnConfirmPayment.getText();
					String time = log.dateConverter();
					try {
						log.writeToFile("Secretary", action, sponsorName, time);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textFieldSponsorName.setText("");
					textFieldSponsorTel.setText("");
					textFieldAmount.setText("");
					textFieldPaymentPatientID.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please fill in the required fields","Warning", JOptionPane.WARNING_MESSAGE);
					if(sponsorName.equals(""))
					{
						textFieldSponsorName.setBackground(Color.red);
					}
					if(telS.equals(""))
					{
						textFieldSponsorTel.setBackground(Color.red);
					}
					if(amountS.equals(""))
					{
						textFieldAmount.setBackground(Color.red);
					}
					if(idS.equals(""))
					{
						textFieldPaymentPatientID.setBackground(Color.red);
					}
				}
				
			
			}
		});
		
		JPanel addP = new JPanel();
		addP.setLayout(null);
		addP.setBackground(Color.DARK_GRAY);
		addP.setBounds(0, 0, 737, 443);
		//main.add(addP);
		
		JLabel addExit = new JLabel("X");
		addExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				addExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				addExit.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "WARNING", JOptionPane.YES_NO_OPTION) 
						== JOptionPane.YES_OPTION){
						System.exit(0);
					}
			}
		});
		addExit.setToolTipText("Exit");
		addExit.setForeground(Color.WHITE);
		addExit.setFont(new Font("Tahoma", Font.PLAIN, 21));
		addExit.setBounds(697, 11, 20, 20);
		addP.add(addExit);
		
		JLabel lblCreateNewPatient = new JLabel("Create new Patient below:");
		lblCreateNewPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewPatient.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreateNewPatient.setForeground(new Color(255, 255, 255));
		lblCreateNewPatient.setBounds(227, 16, 253, 14);
		addP.add(lblCreateNewPatient);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullName.setBounds(33, 144, 63, 14);
		addP.add(lblFullName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(33, 184, 90, 14);
		addP.add(lblAddress);
		
		JLabel lblCell = new JLabel("Telephone:");
		lblCell.setForeground(Color.WHITE);
		lblCell.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCell.setBounds(33, 224, 90, 14);
		addP.add(lblCell);
		
		JLabel lblMedicalAid = new JLabel("Medical Aid:");
		lblMedicalAid.setForeground(Color.WHITE);
		lblMedicalAid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicalAid.setBounds(33, 340, 90, 14);
		addP.add(lblMedicalAid);
		
		textFieldPatientName = new JTextField();
		textFieldPatientName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPatientName.setBackground(Color.WHITE);
			}
		});
		textFieldPatientName.setColumns(10);
		textFieldPatientName.setBounds(144, 144, 181, 20);
		addP.add(textFieldPatientName);
		
		textFieldPatientAddress = new JTextField();
		textFieldPatientAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPatientAddress.setBackground(Color.WHITE);
			}
		});
		textFieldPatientAddress.setColumns(10);
		textFieldPatientAddress.setBounds(144, 184, 181, 20);
		addP.add(textFieldPatientAddress);
		
		textFieldPatientTelephone = new JTextField();
		textFieldPatientTelephone.addKeyListener(new KeyAdapter() {
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
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPatientTelephone.setBackground(Color.WHITE);
			}
		});
		textFieldPatientTelephone.setColumns(10);
		textFieldPatientTelephone.setBounds(144, 224, 181, 20);
		addP.add(textFieldPatientTelephone);
		
		textFieldPatientMedAid = new JTextField();
		textFieldPatientMedAid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPatientMedAid.setBackground(Color.WHITE);
			}
		});
		textFieldPatientMedAid.setEditable(false);
		textFieldPatientMedAid.setColumns(10);
		textFieldPatientMedAid.setBounds(144, 340, 181, 20);
		addP.add(textFieldPatientMedAid);
		
		JTextPane textPane = new JTextPane();
		textPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textPane.setBackground(Color.WHITE);
			}
		});
		textPane.setBounds(375, 280, 295, 83);
		addP.add(textPane);
		
		JLabel lblAdditionalInfromationallergies = new JLabel("Additional Infromation (Allergies, History etc) :");
		lblAdditionalInfromationallergies.setForeground(new Color(255, 255, 255));
		lblAdditionalInfromationallergies.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdditionalInfromationallergies.setBounds(382, 255, 397, 14);
		addP.add(lblAdditionalInfromationallergies);
		
		JLabel lblMedicalAidNo = new JLabel("Medical Aid No:");
		lblMedicalAidNo.setForeground(Color.WHITE);
		lblMedicalAidNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicalAidNo.setBounds(30, 304, 114, 14);
		addP.add(lblMedicalAidNo);
		
		textFieldPatientMedAidNo = new JTextField();
		textFieldPatientMedAidNo.addKeyListener(new KeyAdapter() {
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
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPatientMedAidNo.setBackground(Color.WHITE);
			}
		});
		textFieldPatientMedAidNo.setEditable(false);
		textFieldPatientMedAidNo.setColumns(10);
		textFieldPatientMedAidNo.setBounds(144, 304, 181, 20);
		addP.add(textFieldPatientMedAidNo);
		
		textFieldPatientAge = new JTextField();
		textFieldPatientAge.addKeyListener(new KeyAdapter() {
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
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPatientAge.setBackground(Color.WHITE);
			}
		});
		textFieldPatientAge.setColumns(10);
		textFieldPatientAge.setBounds(462, 64, 181, 20);
		addP.add(textFieldPatientAge);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAge.setBounds(410, 64, 70, 21);
		addP.add(lblAge);
		
		JButton btnCreatePatient = new JButton("Create Patient");
		
		btnCreatePatient.setForeground(Color.WHITE);
		btnCreatePatient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreatePatient.setFocusable(false);
		btnCreatePatient.setBackground(new Color(0, 206, 209));
		btnCreatePatient.setBounds(538, 409, 132, 23);
		addP.add(btnCreatePatient);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				textFieldPatientAddress.setText("");
				textFieldPatientAge.setText("");
				textFieldPatientEmail.setText("");
				textFieldPatientGender.setText("");
				textFieldPatientMedAid.setText("");
				textFieldPatientMedAidNo.setText("");
				textFieldPatientMedicalHistory.setText("");
				textFieldPatientName.setText("");
				textFieldPatientPrescription.setText("");
				textFieldPatientTelephone.setText("");
				textFieldPatientTitle.setText("");
				textPane.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setFocusable(false);
		btnClear.setBackground(new Color(0, 206, 209));
		btnClear.setBounds(30, 410, 132, 23);
		addP.add(btnClear);
		
		JLabel lblMedYesNo = new JLabel("Medical Aid?");
		lblMedYesNo.setForeground(Color.WHITE);
		lblMedYesNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedYesNo.setBounds(33, 264, 90, 14);
		addP.add(lblMedYesNo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
			
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				if(comboBox.getSelectedItem().toString().equals("Yes"))
				{
					textFieldPatientMedAidNo.setEditable(true);
					textFieldPatientMedAid.setEditable(true);
				}
				else
				{
					textFieldPatientMedAidNo.setEditable(false);
					textFieldPatientMedAid.setEditable(false);
					textFieldPatientMedAidNo.setBackground(Color.white);
					textFieldPatientMedAid.setBackground(Color.white);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		comboBox.setBounds(144, 264, 181, 20);
		addP.add(comboBox);
		
		JLabel lblPatientTitle = new JLabel("Title:");
		lblPatientTitle.setForeground(Color.WHITE);
		lblPatientTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientTitle.setBounds(33, 64, 46, 14);
		addP.add(lblPatientTitle);
		
		JLabel lblPatientEmail = new JLabel("Email:");
		lblPatientEmail.setForeground(Color.WHITE);
		lblPatientEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientEmail.setBounds(410, 104, 46, 14);
		addP.add(lblPatientEmail);
		
		textFieldPatientTitle = new JTextField();
		textFieldPatientTitle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPatientTitle.setBackground(Color.white);
			}
		});
		textFieldPatientTitle.setBounds(144, 64, 181, 20);
		addP.add(textFieldPatientTitle);
		textFieldPatientTitle.setColumns(10);
		
		textFieldPatientEmail = new JTextField();
		textFieldPatientEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPatientEmail.setBackground(Color.WHITE);
			}
		});
		textFieldPatientEmail.setBounds(462, 104, 181, 20);
		addP.add(textFieldPatientEmail);
		textFieldPatientEmail.setColumns(10);
		
		JLabel lblPatientGender = new JLabel("Gender:");
		lblPatientGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientGender.setForeground(Color.WHITE);
		lblPatientGender.setBounds(410, 144, 70, 14);
		addP.add(lblPatientGender);
		
		textFieldPatientGender = new JTextField();
		textFieldPatientGender.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPatientGender.setBackground(Color.WHITE);
			}
		});
		textFieldPatientGender.setBounds(462, 144, 181, 20);
		addP.add(textFieldPatientGender);
		textFieldPatientGender.setColumns(10);
		
		btnCreatePatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				PatientHandler p = new PatientHandler();
				
				String title = textFieldPatientTitle.getText();
				String name = textFieldPatientName.getText();
				String address = textFieldPatientAddress.getText();
				String allergies = textPane.getText();
				String email = textFieldPatientEmail.getText();
				String medicalHistory = textFieldPatientMedicalHistory.getText();
				
				boolean hasMedical = false;
				String optionMed = comboBox.getSelectedItem().toString();
				String ageS = textFieldPatientAge.getText();
				String telephonS = textFieldPatientTelephone.getText();
				String genderS = textFieldPatientGender.getText(); 
				String prescription = textFieldPatientPrescription.getText();
				String lastScriptDate = "2018/10/29";
				String doB = null;
				
				
				
				if(optionMed.equals("Yes"))
				{
					String medAidName = textFieldPatientMedAid.getText();
					if(!((title.equals("") | name.equals("") | address.equals("") | email.equals("") | ageS.equals("") | genderS.equals("") | telephonS.equals("") | allergies.equals("") | medicalHistory.equals("") | prescription.equals("") | textFieldPatientMedAidNo.getText().equals("") | medAidName.equals(""))))
					{
						int tel = Integer.parseInt(telephonS);
						int MedAidNo = Integer.parseInt(textFieldPatientMedAidNo.getText());
						char gender = genderS.charAt(0);
						int age = Integer.parseInt(ageS);
						hasMedical = true;
						PatientMA patientMed = new PatientMA(title, name, address, email, tel, doB, gender, allergies, hasMedical, age, lastScriptDate, medicalHistory, prescription, medAidName, MedAidNo);
						p.addPatientMed(patientMed);
						
						Log log = new Log(true);
						String action = btnCreatePatient.getText();
						String time = log.dateConverter();
						try {
							log.writeToFile("Secretary", action, name, time);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please fill in the required fields","Warning", JOptionPane.WARNING_MESSAGE);
						if(textFieldPatientMedAidNo.getText().equals(""))
						{
							textFieldPatientMedAidNo.setBackground(Color.red);
						}
						
						if(medAidName.equals(""))
						{
							textFieldPatientMedAid.setBackground(Color.red);;
						}
					}
					
				}
				
				
				if(optionMed.equals("No"))
				{
					System.out.println(optionMed);
					if(!((title.equals("") | name.equals("") | address.equals("") | email.equals("") | ageS.equals("") | genderS.equals("") | telephonS.equals("") | allergies.equals("") | medicalHistory.equals("") | prescription.equals(""))))
					{
						int tel = Integer.parseInt(telephonS);
						char gender = genderS.charAt(0);
						int age = Integer.parseInt(ageS);
					
						Patient patient = new Patient(title, name, address, email, tel, doB, gender, allergies, hasMedical, age, lastScriptDate, medicalHistory, prescription);
						p.addPatient(patient, hasMedical);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please fill in the required fields","Warning", JOptionPane.WARNING_MESSAGE);
						
						if(title.equals(""))
						{
							textFieldPatientTitle.setBackground(Color.red);
						}
						
						if(name.equals(""))
						{
							textFieldPatientName.setBackground(Color.red);
						}
						
						if(address.equals(""))
						{
							textFieldPatientAddress.setBackground(Color.red);
						}
						
						if(email.equals(""))
						{
							textFieldPatientEmail.setBackground(Color.red);
						}
						
						if(textFieldPatientTelephone.getText().equals(""))
						{
							textFieldPatientTelephone.setBackground(Color.red);
						}
						
						if(ageS.equals(""))
						{
							textFieldPatientAge.setBackground(Color.red);
						}
						
						if(genderS.equals(""))
						{
							textFieldPatientGender.setBackground(Color.red);
						}
						if(allergies.equals(""))
						{
							textPane.setBackground(Color.red);
						}
						if(medicalHistory.equals(""))
						{
							textFieldPatientMedicalHistory.setBackground(Color.red);
						}
						if(prescription.equals(""))
						{
							textFieldPatientPrescription.setBackground(Color.red);
						}
					}
				}
			}
		});
		
		JLabel lblMedicalHistory = new JLabel("Medical History:");
		lblMedicalHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicalHistory.setForeground(Color.WHITE);
		lblMedicalHistory.setBounds(361, 184, 95, 14);
		addP.add(lblMedicalHistory);
		
		textFieldPatientMedicalHistory = new JTextField();
		textFieldPatientMedicalHistory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPatientMedicalHistory.setBackground(Color.WHITE);
			}
		});
		textFieldPatientMedicalHistory.setBounds(462, 183, 181, 20);
		addP.add(textFieldPatientMedicalHistory);
		textFieldPatientMedicalHistory.setColumns(10);
		
		JLabel lblPatientPrescription = new JLabel("Prescription:");
		lblPatientPrescription.setForeground(Color.WHITE);
		lblPatientPrescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientPrescription.setBounds(33, 104, 83, 14);
		addP.add(lblPatientPrescription);
		
		textFieldPatientPrescription = new JTextField();
		textFieldPatientPrescription.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				textFieldPatientPrescription.setBackground(Color.WHITE);
			}
		});
		textFieldPatientPrescription.setBounds(144, 104, 181, 20);
		addP.add(textFieldPatientPrescription);
		textFieldPatientPrescription.setColumns(10);
		
		JLabel eP = new JLabel("Edit Patient");
		eP.setForeground(new Color(0, 0, 0));
		
		eP.setBackground(new Color(0, 206, 209));
		eP.setHorizontalAlignment(SwingConstants.CENTER);
		eP.setFont(new Font("Tahoma", Font.BOLD, 14));
		eP.setOpaque(true);
		
		JLabel pP = new JLabel("Payment");
		pP.setOpaque(true);
		pP.setForeground(new Color(0, 0, 0));
		
		JLabel aP = new JLabel("Add Patient");
		aP.setOpaque(true);
		aP.setForeground(new Color(0, 0, 0));
		
		JLabel sP = new JLabel("Search Patient");
		sP.setBackground(new Color(0, 139, 139));
		sP.setOpaque(true);
		sP.setHorizontalAlignment(SwingConstants.CENTER);
		sP.setFont(new Font("Tahoma", Font.BOLD, 14));
		sP.setForeground(Color.BLACK);
		sP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sP.setBackground(new Color(0, 139, 139));
				eP.setBackground(new Color(0, 206, 209));
				pP.setBackground(new Color(0, 206, 209));
				aP.setBackground(new Color(0, 206, 209));
				lP.setBackground(new Color(0, 206, 209));
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(searchP);
				main.repaint();
				main.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				sP.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				sP.setForeground(Color.BLACK);
			}
		});
		sP.setBounds(0, 89, 235, 35);
		side.add(sP);
		
		
		
		eP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eP.setBackground(new Color(0, 139, 139));
				sP.setBackground(new Color(0, 206, 209));
				pP.setBackground(new Color(0, 206, 209));
				aP.setBackground(new Color(0, 206, 209));
				lP.setBackground(new Color(0, 206, 209));
				
				textFieldPatientTitleEdit.setText("");
				textFieldPatientAddressEdit.setText("");
				textFieldPatientEditMedAidNo.setText("");
				textPane_1.setText("");
				textPanePatientAllergiesEdit.setText("");
				textPanePatientPrescription.setText("");
				textFieldPatientNameEdit.setText("");
				textFieldPatientEmailEdit.setText("");
				textFieldMedAidPatientEdit.setText("");
				textFieldTelephonePatientEdit.setText("");
				textFieldPatientSearch.setText("");
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(editP);
				main.repaint();
				main.revalidate();
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				eP.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				eP.setForeground(Color.BLACK);
			}
		});
		eP.setBounds(0, 156, 235, 35);
		side.add(eP);
		
		
		aP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aP.setBackground(new Color(0, 139, 139));
				sP.setBackground(new Color(0, 206, 209));
				eP.setBackground(new Color(0, 206, 209));
				pP.setBackground(new Color(0, 206, 209));
				lP.setBackground(new Color(0, 206, 209));
				
				textFieldPatientAddress.setText("");
				textFieldPatientAge.setText("");
				textFieldPatientEmail.setText("");
				textFieldPatientGender.setText("");
				textFieldPatientMedAid.setText("");
				textFieldPatientMedAidNo.setText("");
				textFieldPatientMedicalHistory.setText("");
				textFieldPatientName.setText("");
				textFieldPatientPrescription.setText("");
				textFieldPatientTelephone.setText("");
				textFieldPatientTitle.setText("");
				textPane.setText("");
				
				textFieldPatientAddress.setBackground(Color.white);
				textFieldPatientAge.setBackground(Color.white);
				textFieldPatientEmail.setBackground(Color.white);
				textFieldPatientGender.setBackground(Color.white);
				textFieldPatientMedAid.setBackground(Color.white);
				textFieldPatientMedAidNo.setBackground(Color.white);
				textFieldPatientMedicalHistory.setBackground(Color.white);
				textFieldPatientName.setBackground(Color.white);
				textFieldPatientPrescription.setBackground(Color.white);
				textFieldPatientTelephone.setBackground(Color.white);
				textFieldPatientTitle.setBackground(Color.white);
				textPane.setBackground(Color.white);

				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(addP);
				main.repaint();
				main.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				aP.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				aP.setForeground(Color.BLACK);
			}
		});
		aP.setBackground(new Color(0, 206, 209));
		
		aP.setHorizontalAlignment(SwingConstants.CENTER);
		aP.setFont(new Font("Tahoma", Font.BOLD, 14));
		aP.setBounds(0, 223, 235, 35);
		side.add(aP);
		
		
		pP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pP.setBackground(new Color(0, 139, 139));
				sP.setBackground(new Color(0, 206, 209));
				eP.setBackground(new Color(0, 206, 209));
				aP.setBackground(new Color(0, 206, 209));
				lP.setBackground(new Color(0, 206, 209));
				
				textFieldPaymentPatientID.setText("");
				textFieldAmount.setText("");
				textFieldSponsorName.setText("");
				textFieldSponsorTel.setText("");
				
				textFieldPaymentPatientID.setBackground(Color.white);
				textFieldAmount.setBackground(Color.white);
				textFieldSponsorName.setBackground(Color.WHITE);
				textFieldSponsorTel.setBackground(Color.white);
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(payP);
				main.repaint();
				main.revalidate();
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				pP.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				pP.setForeground(Color.BLACK);
			}
		});
		
		pP.setHorizontalAlignment(SwingConstants.CENTER);
		pP.setFont(new Font("Tahoma", Font.BOLD, 14));
		pP.setBackground(new Color(0, 206, 209));
		pP.setBounds(0, 290, 235, 35);
		side.add(pP);
		
		
		lP.setOpaque(true);
		lP.setHorizontalAlignment(SwingConstants.CENTER);
		lP.setForeground(Color.BLACK);
		lP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lP.setBackground(new Color(0, 206, 209));
		lP.setBounds(0, 357, 235, 35);
		side.add(lP);
		
		lP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sP.setBackground(new Color(0, 206, 209));
				eP.setBackground(new Color(0, 206, 209));
				aP.setBackground(new Color(0, 206, 209));
				lP.setBackground(new Color(0, 139, 139));
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "WARNING", JOptionPane.YES_NO_OPTION) 
						== JOptionPane.YES_OPTION){
					SecretaryGUI.this.dispose();
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
			public void mouseEntered(MouseEvent arg0) {
				lP.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lP.setForeground(Color.BLACK);
			}
		});
		
		JPanel Banner = new JPanel();
		Banner.setBounds(227, 443, 817, 107);
		contentPane.add(Banner);
		Banner.setBackground(Color.DARK_GRAY);
		Banner.setLayout(null);
		
		JLabel banner = new JLabel("");
		banner.setBounds(0, -30, 786, 137);
		Banner.add(banner);
		banner.setVerticalAlignment(SwingConstants.BOTTOM);
		banner.setIcon(new ImageIcon(SecretaryGUI.class.getResource("/images/medBanner.png")));
	}
}
