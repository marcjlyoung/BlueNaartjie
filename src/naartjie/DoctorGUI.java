/**
 *  Version: 1.0
 * 	Class: DoctorGUI
 * 	Description: Interface for the Doctor Role
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */

package naartjie;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class DoctorGUI extends JFrame 
{
	
	//Properties
	private String pName;
	private String pNo;
	private JPanel contentPane;
	private int xOffset = 0;
	private int yOffset = 0;
	private JTextField searchPatientNumber;
	private JTextField drugName;
	private JTable drugList;

	//Remove Main method
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorGUI frame = new DoctorGUI("John");
					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//Constructor
	public DoctorGUI(String doctor) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() 
		{
			@Override
			public void mouseDragged(MouseEvent arg0) 
			{
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				DoctorGUI.this.setLocation(x - xOffset, y - yOffset);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
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
		
		JLabel lP = new JLabel("Logout");
		JLabel labelBlueNaartjie = new JLabel("Blue Naartjie");
		labelBlueNaartjie.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				labelBlueNaartjie.setForeground(new Color(66, 134, 244));
			}
			@Override
			public void mouseExited(MouseEvent arg0)
			{
				labelBlueNaartjie.setForeground(new Color(255, 255, 255));
			}
		});
		labelBlueNaartjie.setFont(new Font("Papyrus", Font.BOLD, 20));
		labelBlueNaartjie.setForeground(new Color(255, 255, 255));
		labelBlueNaartjie.setBounds(87, 23, 138, 62);
		side.add(labelBlueNaartjie);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(DoctorGUI.class.getResource("/images/BLUE.png")));
		logo.setBounds(10, 12, 85, 73);
		side.add(logo);
		
		JTextPane quote = new JTextPane();
		quote.setEditable(false);
		quote.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		quote.setBackground(new Color(0, 206, 209));
		quote.setForeground(new Color(255, 255, 255));
		quote.setText("\u201CThe art of medicine consists of amusing the patient while nature cures the disease.\u201D \r\n\u2015 Voltaire");
		quote.setBounds(27, 382, 174, 105);
		side.add(quote);
		
		JPanel main = new JPanel();
		main.setBackground(Color.DARK_GRAY);
		main.setForeground(new Color(255, 255, 255));
		main.setBounds(235, 0, 750, 443);
		contentPane.add(main);
		main.setLayout(null);
		
		
		
		JPanel createScript = new JPanel();
		createScript.setBackground(Color.DARK_GRAY);
		createScript.setBounds(0, 0, 737, 443);
		//main.add(createScript);
		createScript.setLayout(null);
		
		JLabel closeBtn_2 = new JLabel("X");
		closeBtn_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				closeBtn_2.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				closeBtn_2.setForeground(Color.WHITE);
			}
		});
		closeBtn_2.setToolTipText("Exit");
		closeBtn_2.setForeground(Color.WHITE);
		closeBtn_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		closeBtn_2.setBounds(697, 11, 20, 20);
		createScript.add(closeBtn_2);
		
		JLabel lblEditAPatients = new JLabel("Create a Script Below:");
		lblEditAPatients.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditAPatients.setForeground(new Color(255, 255, 255));
		lblEditAPatients.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEditAPatients.setBounds(285, 32, 223, 20);
		createScript.add(lblEditAPatients);
		
			
			
			JButton clearScript = new JButton("Clear Script");
			clearScript.setForeground(Color.WHITE);
			clearScript.setFont(new Font("Tahoma", Font.PLAIN, 14));
			clearScript.setFocusable(false);
			clearScript.setBackground(new Color(0, 206, 209));
			clearScript.setBounds(285, 399, 151, 23);
			createScript.add(clearScript);
			
			
			JScrollPane s3 = new JScrollPane();
			s3.setBounds(285, 90, 372, 62);
			JTextArea patientInfo = new JTextArea();
			patientInfo.setEditable(false);
			patientInfo.setBounds(0, 0, 372, 62);
			s3.setViewportView(patientInfo);
			createScript.add(s3);
			
			JScrollPane s2 = new JScrollPane();
			s2.setBounds(285, 163, 372, 99);
			JTextArea drugInfo = new JTextArea();
			drugInfo.setBounds(0, 0, 372, 99);
			s2.setViewportView(drugInfo);
			createScript.add(s2);
			
			JScrollPane s1 = new JScrollPane();
			s1.setBounds(285, 273, 372, 99);
			JTextArea instructInfo = new JTextArea();
			instructInfo.setEditable(false);
			instructInfo.setBounds(0, 0, 372, 99);
			s1.setViewportView(instructInfo);
			createScript.add(s1);
			
			drugInfo.append(" \n");
			
			JButton addPatient = new JButton("Patient");
			addPatient.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					patientInfo.setText("");
					String s = JOptionPane.showInputDialog( null,"Please enter a patient ID:","Select Patient", JOptionPane.PLAIN_MESSAGE);
					if(s== null)
					{
						
					}
					else 
					{
						if(s == null || s.equals("")) 
						{
							JOptionPane.showMessageDialog(null,"That Patient number does not exist.","Incorrect Patient Number",JOptionPane.ERROR_MESSAGE);
						}
						else 
						{

							PatientHandler p = new PatientHandler();
							Patient person = new Patient("", "", "", "", 0, "", (char) 0, "", false, 0, "", "", "");
							person.setPatientNo(Integer.parseInt(s));
							person = p.patientInfoScript(person);
							if(person.getTitle().equals("Incorrect")) 
							{
								JOptionPane.showMessageDialog(null,"That Patient number does not exist.","Incorrect Patient Number",JOptionPane.ERROR_MESSAGE);
							}
							else 
							{
								pNo = person.getPatientNo() +"";
								pName = person.getName();
								patientInfo.append(" \n");
								patientInfo.append("  " + person.getTitle() + " \n");
								patientInfo.append("  " +person.getName());
							}
						}
					}
				}
			});
			addPatient.setForeground(Color.WHITE);
			addPatient.setFont(new Font("Tahoma", Font.PLAIN, 14));
			addPatient.setFocusable(false);
			addPatient.setBackground(new Color(0, 206, 209));
			addPatient.setBounds(76, 105, 151, 23);
			createScript.add(addPatient);
			
			JButton addDrug = new JButton("Drug(s)");
			addDrug.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					String s = JOptionPane.showInputDialog(null,"Please enter a Drug name or Id:","Select Drug",JOptionPane.PLAIN_MESSAGE);
					if(s==null) 
					{
						
					}
					else
					{
						if(s.equals("") ) 
						{
							JOptionPane.showMessageDialog(null,"That Drug does not exist.","Incorrect Drug",JOptionPane.ERROR_MESSAGE);
						}
						else 
						{
							DrugHandler drug = new DrugHandler();
							Drug d = new Drug();
							d.setDrugId(s);
							d = drug.findExactDrug(d);
							
							if(d.getDrugId() == "Incorrect") 
							{
								JOptionPane.showMessageDialog(null,"That Drug does not exist.","Incorrect Drug",JOptionPane.ERROR_MESSAGE);
							}
							else 
							{
								
								drugInfo.append("  " + d.getDrugId()+ " ");
								drugInfo.append(d.getDrugName() + " ");
								drugInfo.append(d.getDrugDescription() + " ");
								drugInfo.append("\n");
							}
						}
					}
				}
			});
			addDrug.setForeground(Color.WHITE);
			addDrug.setFont(new Font("Tahoma", Font.PLAIN, 14));
			addDrug.setFocusable(false);
			addDrug.setBackground(new Color(0, 206, 209));
			addDrug.setBounds(76, 206, 151, 23);
			createScript.add(addDrug);
			
			instructInfo.append(" \n");
			
			JButton addInstruction = new JButton("Instructions");
			addInstruction.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					String s = JOptionPane.showInputDialog(null,"Please type an Instruction:","Add Instruction",JOptionPane.PLAIN_MESSAGE);
					if(s==null) 
					{
						
					}
					else 
					{
						if(s.equals("")) 
						{
							JOptionPane.showMessageDialog(null,"No Instruction Entered.","No Instruction",JOptionPane.ERROR_MESSAGE);
						}
						else 
						{
							instructInfo.append("  " + s + "\n");
						}
					}
					
				}
			});
			addInstruction.setForeground(Color.WHITE);
			addInstruction.setFont(new Font("Tahoma", Font.PLAIN, 14));
			addInstruction.setFocusable(false);
			addInstruction.setBackground(new Color(0, 206, 209));
			addInstruction.setBounds(76, 305, 151, 23);
			createScript.add(addInstruction);
			
			clearScript.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					patientInfo.setText("");
					drugInfo.setText("");
					instructInfo.setText("");
				}
			});
			
			JButton createScript_1 = new JButton("Complete Script");
			createScript_1.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					String pInfo = patientInfo.getText();
					String dInfo = drugInfo.getText();
					String iInfo = instructInfo.getText();
					
					if(pInfo.equals("") || dInfo.equals("") ||iInfo.equals("")) 
					{
						JOptionPane.showMessageDialog(null,"Please fill out all script fields.","Script field empty",JOptionPane.ERROR_MESSAGE);
					}
					else if(pInfo == null || dInfo == null || iInfo == null)
					{
						JOptionPane.showMessageDialog(null,"Please fill out all script fields.","Script field empty",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						ScriptHandler script = new ScriptHandler();
						script.createScript(pNo,pName, pInfo, dInfo, iInfo, doctor);
						Log log = new Log(true);
						try {
							log.writeToFile(doctor, createScript_1.getText(), pName, log.dateConverter());
						} catch (IOException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"Script has been created successfully!","Script created",JOptionPane.INFORMATION_MESSAGE);

					}
					
				}
			});
			createScript_1.setForeground(Color.WHITE);
			createScript_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			createScript_1.setFocusable(false);
			createScript_1.setBackground(new Color(0, 206, 209));
			createScript_1.setBounds(506, 399, 151, 23);
			createScript.add(createScript_1);
		
		JPanel searchDrug = new JPanel();
		searchDrug.setLayout(null);
		searchDrug.setBackground(Color.DARK_GRAY);
		searchDrug.setBounds(0, 0, 737, 443);
		//main.add(searchDrug);
		
		JLabel closeBtn = new JLabel("X");
		closeBtn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				closeBtn.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				closeBtn.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "WARNING", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
		closeBtn.setToolTipText("Exit");
		closeBtn.setForeground(Color.WHITE);
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 21));
		closeBtn.setBounds(697, 11, 20, 20);
		searchDrug.add(closeBtn);
		
		JLabel lblEnterADrug = new JLabel("Enter a drug name or Id below:");
		lblEnterADrug.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterADrug.setForeground(Color.WHITE);
		lblEnterADrug.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterADrug.setBounds(236, 31, 225, 26);
		searchDrug.add(lblEnterADrug);
		
		drugName = new JTextField();
		drugName.setColumns(10);
		drugName.setBounds(136, 68, 251, 20);
		searchDrug.add(drugName);
		
		JScrollPane j = new JScrollPane();
		j.setBounds(136, 139, 396, 266);
		DefaultTableModel model = new DefaultTableModel(); 
		drugList = new JTable(model);
		drugList.setDefaultEditor(Object.class, null);
		drugList.setBounds(0, 0, 396, 266);
		j.setViewportView(drugList);
		searchDrug.add(j);
		
		
		
		JButton searchDruBtn = new JButton("Search");
		searchDruBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				model.setRowCount(0);
				if(drugName.getText().equals("") ||drugName.getText() == null) 
				{
					JOptionPane.showMessageDialog(null,"Please enter a Drug Id or Name","Incorrect Details",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					DrugHandler drug = new DrugHandler();
					Drug d = new Drug();
					d.setDrugName(drugName.getText());
					d.setDrugId(drugName.getText());
					
					Drug [] list = drug.findDrugs(d);
					if (list == null) 
					{
						JOptionPane.showMessageDialog(null,"Drug Id or DrugName does not exist!","Incorrect Details",JOptionPane.ERROR_MESSAGE);
					}
					else 
					{
						
						
						int count = 0;
						while (count < list.length) 
						{
							d = list[count];
							model.addRow(new Object[]{d.getDrugId(), d.getDrugName(), d.getDrugDescription()});
							count++;
						}
					}
				}
			}
		});
		searchDruBtn.setForeground(Color.WHITE);
		searchDruBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchDruBtn.setFocusable(false);
		searchDruBtn.setBackground(new Color(0, 206, 209));
		searchDruBtn.setBounds(427, 65, 105, 23);
		searchDrug.add(searchDruBtn);
		
		
		JLabel lblDrugList = new JLabel("Drug List:");
		lblDrugList.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrugList.setForeground(Color.WHITE);
		lblDrugList.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDrugList.setBounds(226, 109, 225, 20);
		searchDrug.add(lblDrugList);
		
		JPanel searchP = new JPanel();
		searchP.setBounds(0, 0, 737, 443);
		main.add(searchP);
		searchP.setBackground(Color.DARK_GRAY);
		searchP.setLayout(null);
		
		JLabel closeBtn_1 = new JLabel("X");
		closeBtn_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				closeBtn_1.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				closeBtn_1.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "WARNING", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
		closeBtn_1.setToolTipText("Exit");
		closeBtn_1.setForeground(Color.WHITE);
		closeBtn_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		closeBtn_1.setBounds(697, 11, 20, 20);
		searchP.add(closeBtn_1);
		
		JLabel lblEnter = new JLabel("Enter a patient number below:");
		lblEnter.setForeground(new Color(255, 255, 255));
		lblEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnter.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnter.setBounds(216, 35, 225, 26);
		searchP.add(lblEnter);
		
		searchPatientNumber = new JTextField();
		searchPatientNumber.setText("");
		searchPatientNumber.setBounds(181, 75, 174, 20);
		searchP.add(searchPatientNumber);
		searchPatientNumber.setColumns(10);
		
		JScrollPane s4 = new JScrollPane();
		s4.setBounds(181, 154, 293, 278);
		JTextArea patientHistory = new JTextArea();
		patientHistory.setEditable(false);
		patientHistory.setBounds(0, 0, 293, 278);
		s4.setViewportView(patientHistory);
		searchP.add(s4);
				
		JButton searchPatient = new JButton("Search");
				
		searchPatient.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
				{
					patientHistory.setText("");
					String s = searchPatientNumber.getText();
					if(s.equals("")) 
					{
						JOptionPane.showMessageDialog(null,"Please enter a patient number!","Search field empty",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						PatientHandler p = new PatientHandler();
						Patient pH = new Patient("", "", "", "", 0, "", (char) 0, "", false, 0, "", "", "");
						pH.setPatientNo(Integer.parseInt(s));
						Patient history = p.fetchHistory(pH);
						try 
						{
							patientHistory.append("  \n");
							patientHistory.append("  Title: " + history.getTitle() + "\n");
							patientHistory.append("  Name: " + history.getName() + "\n");
							patientHistory.append("  Address: " +history.getAddress() + "\n");
							patientHistory.append("  Email: " +history.getEmail() + "\n");
							patientHistory.append("  Telephone:" +history.getTelephone() + "\n");
							patientHistory.append("  Patient:" + s + "\n");
							patientHistory.append("  Date of Birth:" + history.getdOB() + "\n");
							patientHistory.append("  Gender:" + history.getGender() + "\n");
							patientHistory.append("  Allergies:" + history.getAllergies() + "\n");
							patientHistory.append("  MedicalHistory: \n" + "  " + history.getMedicalHistory() + "\n");
							patientHistory.append("  Age:" + history.getAge() + "\n");
							patientHistory.append("  lastScriptDate:" + history.getLastScriptDate() + "\n");
							patientHistory.append("  Prescriptions:" + history.getPrescriptions() + "\n");
						}
						catch(NullPointerException e) 
						{
							JOptionPane.showMessageDialog(null,"Patient Number does not exist!","Incorrect entry",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		searchPatient.setForeground(Color.WHITE);
		searchPatient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchPatient.setFocusable(false);
		searchPatient.setBackground(new Color(0, 206, 209));
		searchPatient.setBounds(394, 72, 80, 23);
		searchP.add(searchPatient);
				
				
				
		JLabel lblPatientHistory = new JLabel("Patient History");
		lblPatientHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientHistory.setForeground(Color.WHITE);
		lblPatientHistory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatientHistory.setBounds(216, 119, 225, 14);
		searchP.add(lblPatientHistory);
		
		model.addColumn("Drug ID"); 
		model.addColumn("Drug Name"); 
		model.addColumn("Drug Decription"); 
		
		JLabel sD = new JLabel("Search Drugs");
		sD.setForeground(new Color(0, 0, 0));
		
		sD.setBackground(new Color(0, 206, 209));
		sD.setHorizontalAlignment(SwingConstants.CENTER);
		sD.setFont(new Font("Tahoma", Font.BOLD, 14));
		sD.setOpaque(true);
		
		JLabel cP = new JLabel("Create Script");
		cP.setOpaque(true);
		cP.setForeground(new Color(0, 0, 0));
		
		JLabel sP = new JLabel("Search Patient");
		sP.setBackground(new Color(0, 139, 139));
		sP.setOpaque(true);
		sP.setHorizontalAlignment(SwingConstants.CENTER);
		sP.setFont(new Font("Tahoma", Font.BOLD, 14));
		sP.setForeground(Color.BLACK);
		sP.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				sP.setBackground(new Color(0, 139, 139));
				sD.setBackground(new Color(0, 206, 209));
				cP.setBackground(new Color(0, 206, 209));
				lP.setBackground(new Color(0, 206, 209));
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(searchP);
				main.repaint();
				main.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				sP.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				sP.setForeground(Color.BLACK);
			}
		});
		sP.setBounds(0, 89, 235, 35);
		side.add(sP);
		
		
		
		sD.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				sD.setBackground(new Color(0, 139, 139));
				sP.setBackground(new Color(0, 206, 209));
				cP.setBackground(new Color(0, 206, 209));
				lP.setBackground(new Color(0, 206, 209));
				
				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(searchDrug);
				main.repaint();
				main.revalidate();
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				sD.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				sD.setForeground(Color.BLACK);
			}
		});
		sD.setBounds(0, 156, 235, 35);
		side.add(sD);
		
		
		cP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				cP.setBackground(new Color(0, 139, 139));
				sP.setBackground(new Color(0, 206, 209));
				sD.setBackground(new Color(0, 206, 209));
				lP.setBackground(new Color(0, 206, 209));

				main.removeAll();
				main.repaint();
				main.revalidate();
				
				main.add(createScript);
				main.repaint();
				main.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				cP.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				cP.setForeground(Color.BLACK);
			}
		});
		cP.setBackground(new Color(0, 206, 209));
		
		cP.setHorizontalAlignment(SwingConstants.CENTER);
		cP.setFont(new Font("Tahoma", Font.BOLD, 14));
		cP.setBounds(0, 223, 235, 35);
		side.add(cP);
		
		
		lP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				sP.setBackground(new Color(0, 206, 209));
				sD.setBackground(new Color(0, 206, 209));
				cP.setBackground(new Color(0, 206, 209));
				lP.setBackground(new Color(0, 139, 139));
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "WARNING", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
				{
					DoctorGUI.this.dispose();
					EventQueue.invokeLater(new Runnable() 
					{
						public void run() 
						{
							try 
							{
								LoginGUI frame = new LoginGUI();
								frame.setUndecorated(true);
								frame.setLocationRelativeTo(null);
								frame.setVisible(true);
							} 
							catch (Exception e) 
							{
								e.printStackTrace();
							}
						}
					});
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				lP.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				lP.setForeground(Color.BLACK);
			}
		});
		lP.setOpaque(true);
		lP.setHorizontalAlignment(SwingConstants.CENTER);
		lP.setForeground(Color.BLACK);
		lP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lP.setBackground(new Color(0, 206, 209));
		lP.setBounds(0, 290, 235, 35);
		side.add(lP);
		
		
		
		JPanel Banner = new JPanel();
		Banner.setBounds(227, 443, 817, 107);
		contentPane.add(Banner);
		Banner.setBackground(Color.DARK_GRAY);
		Banner.setLayout(null);
		
		JLabel banner = new JLabel("");
		banner.setBounds(0, -30, 786, 137);
		Banner.add(banner);
		banner.setVerticalAlignment(SwingConstants.BOTTOM);
		banner.setIcon(new ImageIcon(DoctorGUI.class.getResource("/images/medBanner.png")));
	}
}
