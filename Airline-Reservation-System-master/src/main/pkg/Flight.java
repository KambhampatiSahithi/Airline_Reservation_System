package main.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Flight {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_3;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flight window = new Flight();
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
	public Flight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(220, 20, 60));
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 25));
		frame.setBounds(100, 100, 1070, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("Flight Details");
		lblCustomerDetails.setForeground(Color.WHITE);
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblCustomerDetails.setBounds(88, 51, 377, 56);
		frame.getContentPane().add(lblCustomerDetails);
		
		JButton btnAddFlights = new JButton("ADD FLIGHTS");
		btnAddFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
				int fid,sts;
		String fnm,sr,dst,dp,at,fcls,fchgs;
		double gs;		
	    fid=Integer.parseInt(textField.getText());
	    fnm=textField_1.getText();
		sr=textField_2.getText();
		dp=textField_4.getText();
		dst=textField_3.getText();
		at=textField_5.getText();
		fcls=textField_6.getText();
		fchgs=textField_7.getText();
		sts=Integer.parseInt(textField_8.getText());    
		String s="insert into flight values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(s);		
		pst.setInt(1, fid);
		pst.setString(2, fnm);
		pst.setString(3, sr);
		pst.setString(5, dst);
		pst.setString(4, dp);
		pst.setString(6, at);
		pst.setString(7, fcls);
		pst.setString(8, fchgs);
		pst.setInt(9, sts);
		int n=pst.executeUpdate();
		JOptionPane.showMessageDialog(null, n+" flights added");
					
		}
		catch(Exception e3) {
					JOptionPane.showMessageDialog(null,e3);
				}			
			}
		});		
		
				
		btnAddFlights.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddFlights.setBounds(88, 470, 178, 40);
		frame.getContentPane().add(btnAddFlights);
		
		JButton button_1 = new JButton("UPDATE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
				int fid,sts;
				String fnm,sr,dst,dp,at,fcls,fchgs;
				double gs;		
			    fid=Integer.parseInt(textField.getText());
			    fnm=textField_1.getText();
				sr=textField_2.getText();
				dp=textField_4.getText();
				dst=textField_3.getText();
				at=textField_5.getText();
				fcls=textField_6.getText();
				fchgs=textField_7.getText();
				sts=Integer.parseInt(textField_8.getText());
			    //gs=Double.parseDouble(textField_8.getText());	    
				String s="update flight set Flight_Name=?,Source=?,Departure=?,Destination=?,Arrival_Time=?,Flight_Class=?,Flight_Charges=?,Seats=? where flight_ID=?";
				PreparedStatement pst=con.prepareStatement(s);		
				pst.setInt(9, fid);
				pst.setString(1, fnm);
				pst.setString(2,sr);
				pst.setString(3, dp);
				pst.setString(4, dst);
				pst.setString(5, at);
				pst.setString(6, fcls);
				pst.setString(7, fchgs);
				pst.setInt(8, sts);
				int n=pst.executeUpdate();
				JOptionPane.showMessageDialog(null, n+" flights updated");
							
				}
				catch(Exception e3) {
							JOptionPane.showMessageDialog(null,e3);
						}			
					}
				});		
				
			
		button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_1.setBounds(278, 470, 145, 40);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("RESET");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_4.setText("");
				textField_3.setText("");
				textField_6.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_2.setBounds(435, 470, 145, 40);
		frame.getContentPane().add(button_2);
		
		
		JLabel lblCustomerId = new JLabel("Flight_ID");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCustomerId.setBounds(88, 145, 203, 32);
		frame.getContentPane().add(lblCustomerId);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(305, 145, 192, 32);
		frame.getContentPane().add(textField);
		
		JLabel lblCustomerName = new JLabel("Flight_Name");
		lblCustomerName.setForeground(Color.WHITE);
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCustomerName.setBounds(88, 185, 203, 32);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblFatherName = new JLabel("Source");
		lblFatherName.setForeground(Color.WHITE);
		lblFatherName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFatherName.setBounds(88, 225, 203, 32);
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblPhoneNumber = new JLabel("Departure");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPhoneNumber.setBounds(88, 265, 203, 32);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setForeground(Color.WHITE);
		lblDestination.setFont(new Font("Dialog", Font.BOLD, 25));
		lblDestination.setBounds(576, 225, 161, 32);
		frame.getContentPane().add(lblDestination);
		
		JLabel lblArraivalTime = new JLabel("Arrival_Time");
		lblArraivalTime.setForeground(Color.WHITE);
		lblArraivalTime.setFont(new Font("Dialog", Font.BOLD, 25));
		lblArraivalTime.setBounds(576, 265, 161, 32);
		frame.getContentPane().add(lblArraivalTime);
		
		JLabel lblFlightClass = new JLabel("Flight_Class");
		lblFlightClass.setForeground(Color.WHITE);
		lblFlightClass.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFlightClass.setBounds(88, 305, 203, 32);
		frame.getContentPane().add(lblFlightClass);
		
		JLabel lblFlight = new JLabel("Flight_Charges");
		lblFlight.setForeground(Color.WHITE);
		lblFlight.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFlight.setBounds(88, 345, 203, 32);
		frame.getContentPane().add(lblFlight);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setForeground(Color.WHITE);
		lblSeats.setFont(new Font("Dialog", Font.BOLD, 25));
		lblSeats.setBounds(88, 385, 203, 32);
		frame.getContentPane().add(lblSeats);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(305, 185, 192, 32);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(305, 225, 192, 32);
		frame.getContentPane().add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(305, 265, 192, 32);
		frame.getContentPane().add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(305, 305, 192, 32);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(305, 345, 192, 32);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(305, 385, 192, 32);
		frame.getContentPane().add(textField_8);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(767, 225, 192, 32);
		frame.getContentPane().add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(767, 265, 192, 32);
		frame.getContentPane().add(textField_5);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
					System.out.println("Database Connected");
					String s="delete from flight where flight_id='"+textField.getText()+"'";
					Statement st=con.createStatement(); 
					int r=st.executeUpdate(s); 
					JOptionPane.showMessageDialog(null, "Flight Removed!!!");
					
				}
				catch(Exception ex) 
				{
					JOptionPane.showMessageDialog(null, ex);
				}	
				
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(592, 470, 145, 40);
		frame.getContentPane().add(btnDelete);
		
		
		frame.setVisible(true);
	}
}