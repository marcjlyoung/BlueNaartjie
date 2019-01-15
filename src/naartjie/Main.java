/**
 *  Version: 1.0
 * 	Class: Main
 * 	Description: Starts the system
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */


package naartjie;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		Main naartjie = new Main();
		naartjie.start();
	}
	
	//Methods
	
	//Starts the System
	public void start() {
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
