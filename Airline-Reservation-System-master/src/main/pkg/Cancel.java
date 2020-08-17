package main.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cancel {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancel window = new Cancel();
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
	public Cancel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 25));
		frame.setBounds(100, 100, 1070, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("Ticket Cancellation");
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblCustomerDetails.setBounds(88, 51, 424, 56);
		frame.getContentPane().add(lblCustomerDetails);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
					System.out.println("Database Connected");
					String s="delete from ticket_reservation where ticket_number='"+textField.getText()+"'";
					Statement st=con.createStatement(); 
					int r=st.executeUpdate(s); 
					JOptionPane.showMessageDialog(null, "Ticket Cancelled!!!");
					
				}
				catch(Exception ex) 
				{
					JOptionPane.showMessageDialog(null, ex);
				}	
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(318, 470, 170, 47);
		frame.getContentPane().add(btnDelete);
		
		JButton btnShow = new JButton("SEARCH");
		btnShow.setForeground(Color.WHITE);
		btnShow.setBackground(new Color(85, 107, 47));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String gen=null;
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
					System.out.println("Database Connected");
					String s="select * from flight f, ticket_reservation p where f.flight_id=p.flight_id and p.ticket_number='"+textField.getText()+"'";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(s);
					
					while(rs.next()) {			
						textField_1.setText(rs.getString("flight_id"));
						
						textField_2.setText(rs.getString("customer_id"));
						
						textField_3.setText(rs.getString("seat_number"));
						
						//textField_5.setText(rs.getString("address"));
					}
				
					
				}
				catch(Exception ex) 
				{
					JOptionPane.showMessageDialog(null, ex);
				}	
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnShow.setBounds(563, 168, 154, 36);
		frame.getContentPane().add(btnShow);
		
		JLabel lblCustomerId = new JLabel("Ticket_Number");
		lblCustomerId.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCustomerId.setBounds(88, 170, 203, 32);
		frame.getContentPane().add(lblCustomerId);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(305, 170, 192, 32);
		frame.getContentPane().add(textField);
		
		JLabel lblCustomerName = new JLabel("Flight_ID");
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCustomerName.setBounds(88, 230, 203, 32);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblFatherName = new JLabel("Customer_ID");
		lblFatherName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFatherName.setBounds(88, 290, 203, 32);
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblPhoneNumber = new JLabel("Seat_Number");
		lblPhoneNumber.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPhoneNumber.setBounds(88, 350, 203, 32);
		frame.getContentPane().add(lblPhoneNumber);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(305, 230, 192, 32);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(305, 290, 192, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(305, 350, 192, 32);
		frame.getContentPane().add(textField_3);
		
		frame.setVisible(true);
	}
}