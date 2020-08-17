package main.pkg;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.SwingConstants;

public class Customer_login {

	private JFrame frmExistingUser;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Customer_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExistingUser = new JFrame();
		frmExistingUser.getContentPane().setBackground(new Color(176, 224, 230));
		frmExistingUser.setTitle("Customer");
		frmExistingUser.setBounds(100, 100, 741, 407);
		frmExistingUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExistingUser.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(153, 50, 204));
		panel.setBounds(47, 30, 625, 58);
		frmExistingUser.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblExistingUserLog = new JLabel("CUSTOMER LOGIN");
		lblExistingUserLog.setForeground(new Color(255, 255, 255));
		lblExistingUserLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblExistingUserLog.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblExistingUserLog.setBounds(0, 0, 625, 58);
		panel.add(lblExistingUserLog);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 0));
		panel_1.setBounds(47, 101, 625, 224);
		frmExistingUser.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					
Class.forName("com.mysql.jdbc.Driver");
					
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
Statement st=con.createStatement();
		String s="select Customer_Name,Password from Customer";
		ResultSet rs=st.executeQuery(s);
		String un,pw;
		boolean found=false;
		un=textField.getText();
		pw=passwordField.getText();
		while(rs.next()) {
		 if(un.equals(rs.getString(1))  && pw.equals(rs.getString(2))) {
			 found=true;
			 break;
		 }
		 
		}
		if(found)
			new Customer_Home();
		else
			JOptionPane.showMessageDialog(null, "Invalid Credentials");
		
				}
				catch(Exception e) { 
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(224, 144, 116, 37);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(49, 36, 122, 30);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(204, 33, 178, 30);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(49, 82, 122, 30);
		panel_1.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(204, 79, 178, 30);
		panel_1.add(passwordField);
		frmExistingUser.setVisible(true);
	}
}