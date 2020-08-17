package main.pkg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

//import org.omg.CORBA.portable.InputStream;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class Customer {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	protected String path;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 222, 173));
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 25));
		frame.setBounds(100, 100, 1070, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("Customer Signup");
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblCustomerDetails.setBounds(88, 51, 391, 56);
		frame.getContentPane().add(lblCustomerDetails);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(360, 305, 192, 32);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Dialog", Font.BOLD, 25));
		lblGender.setBounds(636, 122, 97, 32);
		frame.getContentPane().add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("MALE");
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnMale.setBounds(636, 165, 127, 25);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnFemale.setBounds(785, 165, 127, 25);
		frame.getContentPane().add(rdbtnFemale);
		
		ButtonGroup b= new ButtonGroup();
		b.add(rdbtnMale);
		b.add(rdbtnFemale);
		
		JButton button = new JButton("SAVE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
				int cid;	
		String cnm,pw,fnm,add,dob,pn,gen=null;
		
		//double gs;		
		cid=Integer.parseInt(textField.getText());
		pw=passwordField.getText();
		cnm=textField_1.getText();
		fnm=textField_2.getText();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		dob=sdf.format(dateChooser.getDate()); 
		pn=textField_3.getText();
		add=textField_4.getText();	   
		// String filename=path;
		//	File f=new File(filename);
		//	FileInputStream fis=new FileInputStream(f);
        String s="insert into customer values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(s);
				
		pst.setInt(1, cid);
		pst.setString(2, cnm);
		pst.setString(3, pw);
		pst.setString(4,fnm);
		pst.setString(5, dob);
		pst.setString(6, pn);
		pst.setString(7, add);
		if(rdbtnMale.isSelected())
		{
			gen="Male";
		}
		if(rdbtnFemale.isSelected())
		{
			gen="Female";
		}
		pst.setString(8, gen);
		//pst.setBinaryStream(8,(InputStream)fis,(int)(f.length()));
		int n=pst.executeUpdate();
		int c=0;
		c=c+n;
		JOptionPane.showMessageDialog(null, c+" Customers added");	
		
		}
		catch(Exception e3) {
					JOptionPane.showMessageDialog(null,e3);
				}			
			}
		});		
		

				
				
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(120, 509, 119, 32);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("UPDATE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
				int cid;	
		String cnm,pw,fnm,add,dob,pn,gen=null;
		int n,c=0;
		//double gs;		
		cid=Integer.parseInt(textField.getText());
		pw=passwordField.getText();
		cnm=textField_1.getText();
		fnm=textField_2.getText();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		dob=sdf.format(dateChooser.getDate()); 
		pn=textField_3.getText();
		add=textField_4.getText();
		if(rdbtnMale.isSelected())
		{
			gen="Male";
		}
		if(rdbtnFemale.isSelected())
		{
			gen="Female";
		}
		String s="update customer set customer_name=?,password?,father_name=? ,dob=?,phone_number=?,address=?,gender=? where customer_id=?";
		PreparedStatement pst=con.prepareStatement(s);	
		pst.setInt(7, cid);
		pst.setString(1, cnm);
		pst.setString(2, pw);
		pst.setString(3,fnm);
		pst.setString(4, dob);
		pst.setString(5, pn);
		pst.setString(6, add);
		pst.setString(7, gen);
		n=pst.executeUpdate();
		c=c+n;
		JOptionPane.showMessageDialog(null, c+" customers updated");
					
		}
		catch(Exception e3) {
					JOptionPane.showMessageDialog(null,e3);
				}			
			}
		});		
		
		button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_1.setBounds(300, 509, 119, 32);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("RESET");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField.setText("");
				passwordField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				dateChooser.setDate(null);
				textField_3.setText("");
				textField_4.setText("");
				ButtonGroup b= new ButtonGroup();
				b.remove(rdbtnMale);
				b.remove(rdbtnFemale);
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
				ButtonGroup b1= new ButtonGroup();
				b.add(rdbtnMale);
				b.add(rdbtnFemale);
			}
		});
				
		button_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_2.setBounds(480, 509, 104, 32);
		frame.getContentPane().add(button_2);
		
		JLabel lblCustomerId = new JLabel("Customer_ID");
		lblCustomerId.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCustomerId.setBounds(88, 145, 203, 32);
		frame.getContentPane().add(lblCustomerId);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(360, 145, 192, 32);
		frame.getContentPane().add(textField);
		
		JLabel lblCustomerName = new JLabel("Customer_Name");
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCustomerName.setBounds(88, 186, 203, 32);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblFatherName = new JLabel("Father_Name");
		lblFatherName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFatherName.setBounds(88, 265, 203, 32);
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblPhoneNumber = new JLabel("Phone_Number");
		lblPhoneNumber.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPhoneNumber.setBounds(88, 345, 203, 32);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Dialog", Font.BOLD, 25));
		lblDob.setBounds(88, 305, 203, 32);
		frame.getContentPane().add(lblDob);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 25));
		lblAddress.setBounds(88, 385, 203, 32);
		frame.getContentPane().add(lblAddress);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(360, 190, 192, 32);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(360, 265, 192, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(360, 345, 192, 32);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(360, 397, 192, 65);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPassword.setBounds(88, 225, 203, 32);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(360, 228, 192, 30);
		frame.getContentPane().add(passwordField);
		
		JButton btnExistingCustomerClick = new JButton("<html>EXISTING CUSTOMER? CLICK HERE</html>");
		btnExistingCustomerClick.setForeground(Color.WHITE);
		btnExistingCustomerClick.setBackground(new Color(255, 0, 0));
		btnExistingCustomerClick.setVerticalAlignment(SwingConstants.TOP);
		btnExistingCustomerClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Customer_login();
			}
		});
		btnExistingCustomerClick.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExistingCustomerClick.setBounds(656, 362, 345, 86);
		frame.getContentPane().add(btnExistingCustomerClick);
		
		
		
		frame.setVisible(true);
	}
}
