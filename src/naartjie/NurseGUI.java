/**
 *  Version: 1.0
 * 	Class: NurseGUI
 * 	Description: Interface for the Nurse Role
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */

package naartjie;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class NurseGUI extends JFrame {

	//Properties
	private JPanel contentPane;
	private JTextField searchDrug;
	private JTable drugList;
	private JTextField drugIdField;
	private JTextField drugNameField;
	private JTextField drugDescriptionField;
	private JTextField addId;
	private JTextField addName;
	private JTextField addDescription;
	private int xOffset=0;
	private int yOffset=0;
	private JTextField searchField;
	
	//Remove
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseGUI frame = new NurseGUI();
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
	public NurseGUI() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 960, 540);
	contentPane = new JPanel();
	contentPane.addMouseMotionListener(new MouseMotionAdapter() {
		@Override
		public void mouseDragged(MouseEvent arg0) 
		{
			int x = arg0.getXOnScreen();
			int y = arg0.getYOnScreen();
			
			NurseGUI.this.setLocation(x - xOffset, y - yOffset);
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
	
	JPanel mainDrug = new JPanel();
	mainDrug.setBounds(236, 0, 749, 443);
	contentPane.add(mainDrug);
	
	JTextPane txtpnmedicineIsA = new JTextPane();
	txtpnmedicineIsA.setForeground(Color.WHITE);
	txtpnmedicineIsA.setEditable(false);
	txtpnmedicineIsA.setBackground(new Color(0, 206, 209));
	txtpnmedicineIsA.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
	txtpnmedicineIsA.setText("\"The art of medicine was to be properly learned only from its practice and its exercise\" - Thomas Sydenham");
	txtpnmedicineIsA.setBounds(35, 403, 167, 88);
	side.add(txtpnmedicineIsA);
	mainDrug.setLayout(null);
	
	JPanel viewdrugPanel = new JPanel();
	viewdrugPanel.setBackground(Color.DARK_GRAY);
	viewdrugPanel.setBounds(0, 0, 749, 443);
	//mainDrug.add(viewdrugPanel);
	viewdrugPanel.setLayout(null);
	
	
	
	JLabel lblNewLabel = new JLabel("Generated Documents Below:");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel.setBounds(252, 45, 221, 14);
	viewdrugPanel.add(lblNewLabel);
	
	JLabel viewdrugXLabel = new JLabel("X");
	viewdrugXLabel.addMouseListener(new MouseAdapter() {
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
			viewdrugXLabel.setForeground(Color.RED);
		}
		@Override
		public void mouseExited(MouseEvent e) 
		{
			viewdrugXLabel.setForeground(Color.WHITE);
		}
	});
	viewdrugXLabel.setToolTipText("Exit");
	viewdrugXLabel.setForeground(Color.WHITE);
	viewdrugXLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	viewdrugXLabel.setBounds(697, 11, 20, 20);
	viewdrugPanel.add(viewdrugXLabel);
	
	JTextArea drugReport = new JTextArea();
	drugReport.setEditable(false);
	JScrollPane l = new JScrollPane();
	l.setBounds(148, 84, 415, 277);
	l.setViewportView(drugReport);
	drugReport.setBounds(0, 0, 415, 277);
	viewdrugPanel.add(l);
	
	JPanel editdrugPanel = new JPanel();
	editdrugPanel.setBackground(Color.DARK_GRAY);
	editdrugPanel.setBounds(0, 0, 749, 443);
	//mainDrug.add(editdrugPanel);
	editdrugPanel.setLayout(null);
	
	
	JButton drugReportButton = new JButton("Generate Report");
	drugReportButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			drugReport.setText("");
			DrugHandler d = new DrugHandler();
			Drug drug = new Drug();
			drug = d.countDrugs(drug);
			drugReport.append("  \n");
			drugReport.append("  Number of drugs: "+drug.getNumberOfDrugs());
			Log log = new Log(true);
			try {
				log.writeToFile("Nurse", "Generated Drug Report", "Drug Count", log.dateConverter());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	});
	drugReportButton.setBounds(280, 388, 154, 23);
	viewdrugPanel.add(drugReportButton);
	drugReportButton.setForeground(Color.WHITE);
	drugReportButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	drugReportButton.setFocusable(false);
	drugReportButton.setBackground(new Color(0, 206, 209));
	
	JLabel lbldrugDetails = new JLabel("Edit Drug Details Below:");
	lbldrugDetails.setForeground(Color.WHITE);
	lbldrugDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
	lbldrugDetails.setBounds(242, 134, 241, 17);
	editdrugPanel.add(lbldrugDetails);
	
	JLabel lbldrugID = new JLabel("ID:");
	lbldrugID.setForeground(Color.WHITE);
	lbldrugID.setFont(new Font("Tahoma", Font.BOLD, 14));
	lbldrugID.setBounds(167, 175, 46, 17);
	editdrugPanel.add(lbldrugID);
	
	drugIdField = new JTextField();
	drugIdField.setEditable(false);
	drugIdField.setBounds(394, 175, 153, 20);
	editdrugPanel.add(drugIdField);
	drugIdField.setColumns(10);
	
	JLabel lblDrugName = new JLabel("Drug Name:");
	lblDrugName.setForeground(Color.WHITE);
	lblDrugName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDrugName.setBounds(167, 224, 98, 17);
	editdrugPanel.add(lblDrugName);
	
	drugNameField = new JTextField();
	drugNameField.setBounds(394, 224, 153, 20);
	editdrugPanel.add(drugNameField);
	drugNameField.setColumns(10);
	
	drugDescriptionField = new JTextField();
	drugDescriptionField.setBounds(394, 278, 153, 20);
	editdrugPanel.add(drugDescriptionField);
	drugDescriptionField.setColumns(10);
	
	JButton deleteButton = new JButton("Delete");
	deleteButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			if(searchField.getText().equals("") || searchField.getText() == null)
			{
				JOptionPane.showMessageDialog(null,"Please search for a drug!","Incorrect Details",JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this drug?","WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					DrugHandler d = new DrugHandler();
					Drug drug = new Drug();
					drug.setDrugId(drugIdField.getText());
					Boolean result = d.deleteDrug(drug);
					if(result) 
					{
						searchField.setText("");
						drugIdField.setText("");
						drugNameField.setText("");
						drugDescriptionField.setText("");
						Log log = new Log(true);
						try {
							log.writeToFile("Nurse", "Drug Deleted",drugIdField.getText(), log.dateConverter());
						} catch (IOException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"Drug has been Deleted!","Drug Deleted",JOptionPane.INFORMATION_MESSAGE);
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"Drug could not be deleted!","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	});
	deleteButton.setForeground(Color.WHITE);
	deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	deleteButton.setFocusable(false);
	deleteButton.setBackground(new Color(0, 206, 209));
	deleteButton.setBounds(148, 351, 145, 23);
	editdrugPanel.add(deleteButton);
	
	JLabel editdrugXlabel = new JLabel("X");
	editdrugXlabel.addMouseListener(new MouseAdapter() 
	{
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
			editdrugXlabel.setForeground(Color.RED);
		}
		@Override
		public void mouseExited(MouseEvent e) 
		{
			editdrugXlabel.setForeground(Color.WHITE);
		}
	});
	editdrugXlabel.setToolTipText("Exit");
	editdrugXlabel.setForeground(Color.WHITE);
	editdrugXlabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	editdrugXlabel.setBounds(697, 11, 20, 20);
	editdrugPanel.add(editdrugXlabel);
	
	JLabel lblDrugDescription = new JLabel("Drug Description:");
	lblDrugDescription.setForeground(Color.WHITE);
	lblDrugDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDrugDescription.setBounds(168, 278, 133, 17);
	editdrugPanel.add(lblDrugDescription);
	
	JButton updateButton = new JButton("Update");
	updateButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
		
			String id = drugIdField.getText();
			String name = drugNameField.getText();
			String info = drugDescriptionField.getText();	
			
			if(searchField.getText().equals("") || searchField.getText() == null)
			{
				JOptionPane.showMessageDialog(null,"Please search for a drug!","Incorrect Details",JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				if(name.equals("") || name == null || info.equals("") || info == null ) 
				{
					JOptionPane.showMessageDialog(null,"Please fill out all fields!","Incorrect Details",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					DrugHandler d = new DrugHandler();
					Drug drug = new Drug();
					drug.setDrugId(id);
					drug.setDrugName(name);
					drug.setDrugDescription(info);
					boolean result = d.updateDrug(drug);
					if(result) 
					{
						
						Log log = new Log(true);
						try {
							log.writeToFile("Nurse", "Drug Updated",drugIdField.getText(), log.dateConverter());
						} catch (IOException e) {
							e.printStackTrace();
						}
						drugIdField.setText("");
						drugNameField.setText("");
						drugDescriptionField.setText("");
						JOptionPane.showMessageDialog(null,"Drug has been Updated!","Drug Updated",JOptionPane.INFORMATION_MESSAGE);
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"Drug could not be Updated!","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	});
	updateButton.setForeground(Color.WHITE);
	updateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	updateButton.setFocusable(false);
	updateButton.setBackground(new Color(0, 206, 209));
	updateButton.setBounds(402, 351, 145, 23);
	editdrugPanel.add(updateButton);
	
	searchField = new JTextField();
	searchField.setColumns(10);
	searchField.setBounds(148, 80, 186, 20);
	editdrugPanel.add(searchField);
	
	JButton searchButton = new JButton("Search");
	searchButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			if(searchField.getText().equals("") ||searchField.getText() == null) 
			{
				JOptionPane.showMessageDialog(null,"Please enter a Drug Id or Name","Incorrect Details",JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				DrugHandler drug = new DrugHandler();
				Drug s = new Drug();
				s.setDrugId(searchField.getText());
				s = drug.findExactDrug(s);
				if (s == null) 
				{
					JOptionPane.showMessageDialog(null,"Drug Id or DrugName does not exist!","Incorrect Details",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					drugIdField.setText(s.getDrugId());
					drugNameField.setText(s.getDrugName());
					drugDescriptionField.setText(s.getDrugDescription());
				}
			}
		}
	});
	searchButton.setForeground(Color.WHITE);
	searchButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	searchButton.setFocusable(false);
	searchButton.setBackground(new Color(0, 206, 209));
	searchButton.setBounds(402, 77, 145, 23);
	editdrugPanel.add(searchButton);
	
	JLabel lblSearchADrug = new JLabel("Search a Drug to Edit:");
	lblSearchADrug.setForeground(Color.WHITE);
	lblSearchADrug.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblSearchADrug.setBounds(242, 40, 241, 17);
	editdrugPanel.add(lblSearchADrug);
	
	JPanel adddrugPanel = new JPanel();
	adddrugPanel.setBackground(Color.DARK_GRAY);
	adddrugPanel.setBounds(0, 0, 749, 443);
	//mainDrug.add(adddrugPanel);
	adddrugPanel.setLayout(null);
	
	JLabel lblInsertDetails = new JLabel("Insert New Drug Details:\r\n");
	lblInsertDetails.setBounds(239, 90, 241, 17);
	lblInsertDetails.setForeground(Color.WHITE);
	lblInsertDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
	adddrugPanel.add(lblInsertDetails);
	
	JLabel lbladddrugID = new JLabel("ID:");
	lbladddrugID.setForeground(Color.WHITE);
	lbladddrugID.setFont(new Font("Tahoma", Font.BOLD, 14));
	lbladddrugID.setBounds(156, 144, 46, 17);
	adddrugPanel.add(lbladddrugID);
	
	addId = new JTextField();
	addId.setBounds(350, 144, 153, 20);
	adddrugPanel.add(addId);
	addId.setColumns(10);
	
	JLabel lbladddrugName = new JLabel("Drug Name:");
	lbladddrugName.setForeground(Color.WHITE);
	lbladddrugName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lbladddrugName.setBounds(156, 185, 95, 17);
	adddrugPanel.add(lbladddrugName);
	
	addName = new JTextField();
	addName.setBounds(350, 185, 153, 20);
	adddrugPanel.add(addName);
	addName.setColumns(10);
	
	JLabel lbladddrugDescription = new JLabel("Drug Description:");
	lbladddrugDescription.setForeground(Color.WHITE);
	lbladddrugDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
	lbladddrugDescription.setBounds(156, 228, 120, 17);
	adddrugPanel.add(lbladddrugDescription);
	
	addDescription = new JTextField();
	addDescription.setBounds(350, 228, 153, 20);
	adddrugPanel.add(addDescription);
	addDescription.setColumns(10);
	
	JButton addDrugBtn = new JButton("Add");
	addDrugBtn.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			String drugId = addId.getText();
			String drugName = addName.getText();
			String drugDescription = addDescription.getText();
			
			if(drugId.equals("") || drugId == null  || drugName.equals("") || drugName == null || drugDescription.equals("") || drugDescription == null) 
			{
				JOptionPane.showMessageDialog(null,"Please fill out all drug fields","Incorrect Details",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				DrugHandler d = new DrugHandler();
				Drug drug = new Drug();
				drug.setDrugId(drugId);
				drug.setDrugName(drugName);
				drug.setDrugDescription(drugDescription);
				String result = d.addDrug(drug);
				if(result.equals("Inserted")) 
				{
					Log log = new Log(true);
					try {
						log.writeToFile("Nurse", "Drug Added",addId.getText(), log.dateConverter());
					} catch (IOException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Drug has been added to the System!","Drug Inserted",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(result.equals("Failed")) 
				{
					JOptionPane.showMessageDialog(null,"DrugId or DrugName already exist","Incorrect Details",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
	});
	addDrugBtn.setForeground(Color.WHITE);
	addDrugBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
	addDrugBtn.setFocusable(false);
	addDrugBtn.setBackground(new Color(0, 206, 209));
	addDrugBtn.setBounds(399, 294, 104, 23);
	adddrugPanel.add(addDrugBtn);
	
	JLabel adddrugXlabel = new JLabel("X");
	adddrugXlabel.addMouseListener(new MouseAdapter() {
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
			adddrugXlabel.setForeground(Color.RED);
		}
		@Override
		public void mouseExited(MouseEvent e) 
		{
			adddrugXlabel.setForeground(Color.WHITE);
		}
	});
	adddrugXlabel.setToolTipText("Exit");
	adddrugXlabel.setForeground(Color.WHITE);
	adddrugXlabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	adddrugXlabel.setBounds(697, 11, 20, 20);
	adddrugPanel.add(adddrugXlabel);
	
	JButton clearBtn = new JButton("Clear");
	clearBtn.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			addId.setText("");
			addName.setText("");
			addDescription.setText("");
		}
	});
	clearBtn.setForeground(Color.WHITE);
	clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
	clearBtn.setFocusable(false);
	clearBtn.setBackground(new Color(0, 206, 209));
	clearBtn.setBounds(156, 294, 104, 23);
	adddrugPanel.add(clearBtn);
	
	JPanel searchPanel = new JPanel();
	searchPanel.setBackground(Color.DARK_GRAY);
	searchPanel.setBounds(0, 0, 749, 443);
	mainDrug.add(searchPanel);
	searchPanel.setLayout(null);
	
	JScrollPane j = new JScrollPane();
	j.setBounds(136, 139, 396, 266);
	DefaultTableModel model = new DefaultTableModel(); 
	drugList = new JTable(model);
	drugList.setDefaultEditor(Object.class, null);
	model.addColumn("Drug ID"); 
	model.addColumn("Drug Name"); 
	model.addColumn("Drug Decription"); 
	drugList.setBounds(0, 0, 396, 266);
	j.setViewportView(drugList);
	searchPanel.add(j);
	
	searchDrug = new JTextField();
	searchDrug.setBounds(136, 75, 205, 20);
	searchPanel.add(searchDrug);
	searchDrug.setColumns(10);
	
	JButton searchDrugBtn = new JButton("Search");
	searchDrugBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			model.setRowCount(0);
			if(searchDrug.getText().equals("") ||searchDrug.getText() == null) 
			{
				JOptionPane.showMessageDialog(null,"Please enter a Drug Id or Name","Incorrect Details",JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				DrugHandler drug = new DrugHandler();
				Drug d = new Drug();
				d.setDrugId(searchDrug.getText());
				d.setDrugName(searchDrug.getText());
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
	searchDrugBtn.setBounds(405, 72, 127, 23);
	searchPanel.add(searchDrugBtn);
	searchDrugBtn.setForeground(Color.WHITE);
	searchDrugBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
	searchDrugBtn.setFocusable(false);
	searchDrugBtn.setBackground(new Color(0, 206, 209));
	
	JLabel labeldrugX = new JLabel("X");
	labeldrugX.addMouseListener(new MouseAdapter() 
	{
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
			labeldrugX.setForeground(Color.RED);
		}
		@Override
		public void mouseExited(MouseEvent e) 
		{
			labeldrugX.setForeground(Color.WHITE);
		}
	});
	labeldrugX.setToolTipText("Exit");
	labeldrugX.setForeground(Color.WHITE);
	labeldrugX.setFont(new Font("Tahoma", Font.PLAIN, 21));
	labeldrugX.setBounds(697, 11, 20, 20);
	searchPanel.add(labeldrugX);
	
	JLabel lblDrugsListedBelow = new JLabel("Drugs listed below:");
	lblDrugsListedBelow.setForeground(Color.WHITE);
	lblDrugsListedBelow.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDrugsListedBelow.setBounds(266, 111, 158, 17);
	searchPanel.add(lblDrugsListedBelow);
	
	JLabel lblEnterADrug = new JLabel("Enter a drug name or Id below:");
	lblEnterADrug.setHorizontalAlignment(SwingConstants.CENTER);
	lblEnterADrug.setForeground(Color.WHITE);
	lblEnterADrug.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblEnterADrug.setBounds(222, 32, 225, 26);
	searchPanel.add(lblEnterADrug);
	
	JLabel searchdrugLbl = new JLabel("Search Drug", SwingConstants.CENTER);
	JLabel managedrugLbl = new JLabel("Edit Drug", SwingConstants.CENTER);
	JLabel logoutdrugLbl = new JLabel("Logout", SwingConstants.CENTER);
	JLabel adddrugLbl = new JLabel("Add Drug", SwingConstants.CENTER);
	JLabel viewdrugdetailsLbl = new JLabel("View Drug Details");
	viewdrugdetailsLbl.setBackground(new Color(0, 206, 209));
	viewdrugdetailsLbl.setOpaque(true);
	adddrugLbl.setBackground(new Color(0, 206, 209));
	adddrugLbl.setOpaque(true);
	adddrugLbl.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			adddrugLbl.setBackground(new Color(0, 134, 134));
			searchdrugLbl.setBackground(new Color(0, 206, 209));
			logoutdrugLbl.setBackground(new Color(0, 206, 209));
			managedrugLbl.setBackground(new Color(0, 206, 209));
			viewdrugdetailsLbl.setBackground(new Color(0, 206, 209));
			
			
			mainDrug.removeAll();
			mainDrug.repaint();
			mainDrug.revalidate();
			
			mainDrug.add(adddrugPanel);
			mainDrug.repaint();
			mainDrug.revalidate();
			
		}
		@Override
		public void mouseEntered(MouseEvent e) 
		{
			adddrugLbl.setForeground(Color.WHITE);
		}
		@Override
		public void mouseExited(MouseEvent e) 
		{
			adddrugLbl.setForeground(Color.BLACK);
		}
	});
	searchdrugLbl.setBackground(new Color(0, 139, 139));
	searchdrugLbl.setOpaque(true);
	searchdrugLbl.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			searchdrugLbl.setBackground(new Color(0, 134, 134));
			logoutdrugLbl.setBackground(new Color(0, 206, 209));
			managedrugLbl.setBackground(new Color(0, 206, 209));
			adddrugLbl.setBackground(new Color(0, 206, 209));
			viewdrugdetailsLbl.setBackground(new Color(0, 206, 209));
			
			mainDrug.removeAll();
			mainDrug.repaint();
			mainDrug.revalidate();
			
			mainDrug.add(searchPanel);
			mainDrug.repaint();
			mainDrug.revalidate();
		}
		@Override
		public void mouseEntered(MouseEvent e) 
		{
			searchdrugLbl.setForeground(Color.WHITE);
		}
		@Override
		public void mouseExited(MouseEvent e) 
		{
			searchdrugLbl.setForeground(Color.BLACK);
		}
	});
	searchdrugLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
	searchdrugLbl.setBounds(0, 90, 235, 35);
	side.add(searchdrugLbl);
	
	
	managedrugLbl.setBackground(new Color(0, 206, 209));
	managedrugLbl.setOpaque(true);
	managedrugLbl.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			managedrugLbl.setBackground(new Color(0, 134, 134));
			logoutdrugLbl.setBackground(new Color(0, 206, 209));
			searchdrugLbl.setBackground(new Color(0, 206, 209));
			adddrugLbl.setBackground(new Color(0, 206, 209));
			viewdrugdetailsLbl.setBackground(new Color(0, 206, 209));
			
			mainDrug.removeAll();
			mainDrug.repaint();
			mainDrug.revalidate();
			
			mainDrug.add(editdrugPanel);
			mainDrug.repaint();
			mainDrug.revalidate();
		}
		@Override
		public void mouseEntered(MouseEvent e) 
		{
			managedrugLbl.setForeground(Color.WHITE);
		}
		@Override
		public void mouseExited(MouseEvent e) 
		{
			managedrugLbl.setForeground(Color.BLACK);
		}
	});
	managedrugLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
	managedrugLbl.setBounds(0, 156, 235, 35);
	side.add(managedrugLbl);
	
	
	logoutdrugLbl.setBackground(new Color(0, 206, 209));
	logoutdrugLbl.setOpaque(true);
	logoutdrugLbl.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) 
		{
			logoutdrugLbl.setForeground(Color.WHITE);
		}
		@Override
		public void mouseExited(MouseEvent e) 
		{
			logoutdrugLbl.setForeground(Color.BLACK);
		}
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			logoutdrugLbl.setBackground(new Color(0, 134, 134));
			searchdrugLbl.setBackground(new Color(0, 206, 209));
			managedrugLbl.setBackground(new Color(0, 206, 209));
			adddrugLbl.setBackground(new Color(0, 206, 209));
			viewdrugdetailsLbl.setBackground(new Color(0, 206, 209));
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				NurseGUI.this.dispose();
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
	});
	logoutdrugLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
	logoutdrugLbl.setBounds(0, 357, 235, 35);
	side.add(logoutdrugLbl);
	
	adddrugLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
	adddrugLbl.setBounds(0, 223, 235, 35);
	side.add(adddrugLbl);
	
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
	

	viewdrugdetailsLbl.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			viewdrugdetailsLbl.setBackground(new Color(0, 134, 134));
			searchdrugLbl.setBackground(new Color(0, 206, 209));
			managedrugLbl.setBackground(new Color(0, 206, 209));
			adddrugLbl.setBackground(new Color(0, 206, 209));
			logoutdrugLbl.setBackground(new Color(0, 206, 209));
			
			mainDrug.removeAll();
			mainDrug.repaint();
			mainDrug.revalidate();
			
			mainDrug.add(viewdrugPanel);
			mainDrug.repaint();
			mainDrug.revalidate();
			
		}
		@Override
		public void mouseEntered(MouseEvent e) 
		{
			viewdrugdetailsLbl.setForeground(Color.WHITE);
		}
		@Override
		public void mouseExited(MouseEvent e) 
		{
			viewdrugdetailsLbl.setForeground(Color.BLACK);
		}
	});
	viewdrugdetailsLbl.setHorizontalAlignment(SwingConstants.CENTER);
	viewdrugdetailsLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
	viewdrugdetailsLbl.setBounds(0, 290, 235, 35);
	side.add(viewdrugdetailsLbl);
	
	JPanel Banner = new JPanel();
	Banner.setBounds(227, 442, 817, 122);
	contentPane.add(Banner);
	Banner.setBackground(Color.DARK_GRAY);
	Banner.setLayout(null);
	
	JLabel bannerLbl = new JLabel("");
	bannerLbl.setBounds(0, -41, 816, 139);
	Banner.add(bannerLbl);
	bannerLbl.setIcon(new ImageIcon(AdminGUI.class.getResource("/Images/medBanner.png")));
	
	
	
	

	
}
}
