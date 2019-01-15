/**
 *  Version: 1.0
 * 	Class: LoginGUI
 * 	Description: Login interface on system start
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class LoginGUI extends JFrame 
{
	//Properties
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	private int xOffset = 0;
	private int yOffset = 0;
	private Staff person;


	//Constructor
	public LoginGUI() 
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
				LoginGUI.this.setLocation(x - xOffset, y - yOffset);
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
		logo.setIcon(new ImageIcon(LoginGUI.class.getResource("/images/BLUE.png")));
		logo.setBounds(10, 12, 85, 73);
		side.add(logo);
		
		JTextPane quote = new JTextPane();
		quote.setEditable(false);
		quote.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		quote.setBackground(new Color(0, 206, 209));
		quote.setForeground(new Color(255, 255, 255));
		quote.setText("\u201CAlways laugh when you can, it is cheap medicine.\u201D - Lord Byron ");
		quote.setBounds(27, 414, 174, 73);
		side.add(quote);
		
		JPanel main = new JPanel();
		main.setBackground(Color.DARK_GRAY);
		main.setForeground(new Color(255, 255, 255));
		main.setBounds(227, 0, 758, 569);
		contentPane.add(main);
		main.setLayout(null);
		
		JLabel exit = new JLabel("X");
		exit.setToolTipText("Exit");
		exit.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "WARNING", JOptionPane.YES_NO_OPTION) 
					== JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				exit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				exit.setForeground(Color.WHITE);
			}
		});
		exit.setFont(new Font("Tahoma", Font.PLAIN, 21));
		exit.setForeground(Color.WHITE);
		exit.setBounds(697, 11, 20, 20);
		main.add(exit);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(252, 199, 100, 20);
		main.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(252, 243, 100, 20);
		main.add(lblPassword);
		
		username = new JTextField();
		username.setCaretColor(Color.WHITE);
		username.setBorder(null);
		username.setBackground(Color.DARK_GRAY);
		username.setFont(new Font("Tahoma", Font.BOLD, 13));
		username.setForeground(Color.WHITE);
		username.setBounds(377, 200, 145, 20);
		username.setText("");
		main.add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBorder(null);
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setBounds(377, 245, 145, 20);
		passwordField.setText("");
		main.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFocusable(false);
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginButton.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
				if(passwordField.getText().equals("") || username.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Please enter a username and password.","Incorrect Details",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					LoginHandler validate = new LoginHandler();
					person = new Staff("", "", "", "", 0, "", (char) 0, "", username.getText(), passwordField.getText(), null, "");
					person = validate.validateLogin(person);
					if(person.getRole().equals("Incorrect")) 
					{
						JOptionPane.showMessageDialog(null,"Incorrect username or password.","Incorrect Details",JOptionPane.ERROR_MESSAGE);
					}
					else if(person.getRole().equals("Admin"))
					{
						LoginGUI.this.dispose();
						EventQueue.invokeLater(new Runnable() 
						{
							public void run() 
							{
								try 
								{
									AdminGUI frame = new AdminGUI();
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
					else if(person.getRole().equals("Secretary")) 
					{
						LoginGUI.this.dispose();
						EventQueue.invokeLater(new Runnable() 
						{
							public void run() 
							{
								try 
								{
									SecretaryGUI frame = new SecretaryGUI();
									frame.setUndecorated(true);
									frame.setLocationRelativeTo(null);
									frame.setVisible(true);
								} catch (Exception e) 
								{
									e.printStackTrace();
								}
							}
						});
						
					}
					else if(person.getRole().equals("Doctor")) 
					{
						LoginGUI.this.dispose();
						EventQueue.invokeLater(new Runnable() 
						{
							public void run() 
							{
								try 
								{
									DoctorGUI frame = new DoctorGUI(person.getName());
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
						
					}else if(person.getRole().equals("Nurse")) 
					{
						LoginGUI.this.dispose();
						EventQueue.invokeLater(new Runnable() 
						{
							public void run() 
							{
								try 
								{
									NurseGUI frame = new NurseGUI();
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
			}
		});
		loginButton.setBackground(new Color(0, 206, 209));
		loginButton.setForeground(new Color(255, 255, 255));
		
		loginButton.setBounds(252, 301, 270, 33);
		main.add(loginButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(377, 220, 145, 13);
		main.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(377, 265, 145, 2);
		main.add(separator_1);
		
		JLabel lblWelcomeToBlue = new JLabel("Welcome to Blue Naartjie Medical Management Suite");
		lblWelcomeToBlue.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				lblWelcomeToBlue.setForeground(new Color(66, 134, 244));
			}
			@Override
			public void mouseExited(MouseEvent arg0) 
			{
				lblWelcomeToBlue.setForeground(new Color(255, 255, 255));
			}
		});
		lblWelcomeToBlue.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToBlue.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblWelcomeToBlue.setForeground(new Color(255, 255, 255));
		lblWelcomeToBlue.setBounds(135, 50, 506, 26);
		main.add(lblWelcomeToBlue);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your details below:");
		lblPleaseEnterYour.setForeground(new Color(255, 255, 255));
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPleaseEnterYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterYour.setBounds(252, 150, 270, 20);
		main.add(lblPleaseEnterYour);
		
		JPanel Banner = new JPanel();
		Banner.setBounds(-49, 433, 817, 136);
		main.add(Banner);
		Banner.setBackground(Color.DARK_GRAY);
		Banner.setLayout(null);
		
		JLabel banner = new JLabel("");
		banner.setBounds(41, -24, 786, 138);
		Banner.add(banner);
		banner.setVerticalAlignment(SwingConstants.BOTTOM);
		banner.setIcon(new ImageIcon(LoginGUI.class.getResource("/images/medBanner.png")));
	}
}
