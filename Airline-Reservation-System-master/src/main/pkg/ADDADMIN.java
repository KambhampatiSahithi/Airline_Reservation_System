package main.pkg;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class ADDADMIN {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_1;
	//protected JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADDADMIN window = new ADDADMIN();
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
	public ADDADMIN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 1046, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 1028, 109);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnrollAdmin = new JLabel("Enroll Admin");
		lblEnrollAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnrollAdmin.setForeground(Color.RED);
		lblEnrollAdmin.setFont(new Font("Calibri", Font.BOLD, 35));
		lblEnrollAdmin.setBounds(0, 0, 1028, 109);
		panel.add(lblEnrollAdmin);
		
		JLabel lblUsername = new JLabel("User_Name");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 25));
		lblUsername.setBounds(100, 150, 140, 30);
		frame.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(277, 151, 169, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(277, 202, 169, 30);
		frame.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPassword.setBounds(100, 200, 140, 30);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPosition.setBounds(97, 300, 101, 30);
		frame.getContentPane().add(lblPosition);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setBounds(277, 305, 169, 30);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Dialog", Font.BOLD, 25));
		lblSalary.setBounds(97, 350, 80, 30);
		frame.getContentPane().add(lblSalary);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setBounds(277, 350, 169, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDoj = new JLabel("DOJ");
		lblDoj.setFont(new Font("Dialog", Font.BOLD, 25));
		lblDoj.setBounds(97, 400, 76, 30);
		frame.getContentPane().add(lblDoj);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(277, 400, 169, 30);
		frame.getContentPane().add(dateChooser);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String un,pw,nm,pos;
					double sal;
					String dt=null;
					un=textField.getText();
					pw=passwordField.getText();
					nm=textField_1.getText();
					pos=textField_2.getText();
					sal=Double.parseDouble(textField_3.getText());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					dt=sdf.format(dateChooser.getDate()); 

					
					Class.forName("com.mysql.jdbc.Driver");
					   
					   Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
					    String s="insert into admin values(?,?,?,?,?,?)";
					    PreparedStatement ps=con.prepareStatement(s);
					    ps.setString(1, un);
					    ps.setString(2, pw);
					    ps.setString(3, nm);
					    ps.setString(4, pos);
					    ps.setDouble(5, sal);
					    ps.setString(6, dt);
					   
					    int r=ps.executeUpdate();
					    	JOptionPane.showMessageDialog(null, " Record Inserted");
					  
					}catch(Exception n) {
						JOptionPane.showMessageDialog(null, n);	
					}
				}
			});

		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 23));
		btnSubmit.setBounds(390, 475, 110, 35);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblName.setBounds(97, 250, 143, 30);
		frame.getContentPane().add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(277, 255, 169, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
	frame.setVisible(true);
}
}