package main.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(30, 144, 255));
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 25));
		frame.setBounds(100, 100, 1070, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSearch = new JButton("Administrator");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new main.pkg.ADMINLOGIN();			
				
			}
		});
		btnSearch.setBounds(137, 330, 299, 93);
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1052, 152);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("AIRLINE RESERVATION SYSTEM");
		lblCustomerDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerDetails.setForeground(new Color(255, 255, 255));
		lblCustomerDetails.setBounds(0, 0, 1052, 152);
		panel.add(lblCustomerDetails);
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 42));
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Customer();
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCustomer.setBackground(new Color(255, 255, 255));
		btnCustomer.setBounds(584, 330, 299, 93);
		frame.getContentPane().add(btnCustomer);
	}
}