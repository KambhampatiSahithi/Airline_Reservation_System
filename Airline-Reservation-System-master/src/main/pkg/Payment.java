package main.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment {
	
	int x;

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
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
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205, 133, 63));
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 25));
		frame.setBounds(100, 100, 1070, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("Payment Details");
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblCustomerDetails.setBounds(88, 51, 377, 56);
		frame.getContentPane().add(lblCustomerDetails);
		
		JRadioButton rdbtnCreditCard = new JRadioButton("CREDIT CARD");
		rdbtnCreditCard.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				x=1;
			}
		});
		rdbtnCreditCard.setBackground(new Color(218, 165, 32));
		rdbtnCreditCard.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnCreditCard.setBounds(305, 363, 203, 32);
		frame.getContentPane().add(rdbtnCreditCard);
		
		JRadioButton rdbtnCash = new JRadioButton("CASH");
		rdbtnCash.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				x=2;
			}
		});
		rdbtnCash.setBackground(new Color(218, 165, 32));
		rdbtnCash.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnCash.setBounds(305, 414, 203, 32);
		frame.getContentPane().add(rdbtnCash);
		
		
		ButtonGroup b=new ButtonGroup();
		b.add(rdbtnCreditCard);
		b.add(rdbtnCash);
		
		JButton btnAddFlights = new JButton("SAVE");
		btnAddFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
				int tno,cid,fid;	
		String dp,amt,pmt;
		
		tno=Integer.parseInt(textField.getText());
		cid=Integer.parseInt(textField_1.getText());
		fid=Integer.parseInt(textField_2.getText());
		
		dp=textField_3.getText();
		amt=textField_4.getText();
		pmt=textField_4.getText();
	    //gs=Double.parseDouble(textField_8.getText());	    
		String s="insert into payment values(?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(s);		
		pst.setInt(1, tno);
		pst.setInt(2, cid);
		pst.setInt(3, fid);
		pst.setString(4, dp);
		pst.setString(5, amt);
		if(rdbtnCreditCard.isSelected())
		{
			pmt="Credit Card";
			JOptionPane.showMessageDialog(null, " Proceed to Payment!!!");
		}
		if(rdbtnCash.isSelected())
		{
			pmt="Cash";
			JOptionPane.showMessageDialog(null, " Pay at Airport!!!");
		}
		pst.setString(6, pmt);
		
		int n=pst.executeUpdate();
					
		}
		catch(Exception e3) {
					JOptionPane.showMessageDialog(null,e3);
				}			
			
				if(x==1)
					new Card();
				else
				{
					JOptionPane.showMessageDialog(null, " Ticket Booked!!!");	
				}
			}
		});
		btnAddFlights.setBackground(Color.BLACK);
		btnAddFlights.setForeground(Color.WHITE);
		btnAddFlights.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddFlights.setBounds(326, 496, 151, 40);
		frame.getContentPane().add(btnAddFlights);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setBackground(new Color(0, 128, 0));
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
						textField_1.setText(rs.getString("customer_id"));
						
						textField_2.setText(rs.getString("flight_id"));
						
						textField_3.setText(rs.getString("departure"));
						
						textField_4.setText(rs.getString("flight_charges"));
						
					}
				
					
				}
				catch(Exception ex) 
				{
					JOptionPane.showMessageDialog(null, ex);
				}	
			}
			
		});
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnShow.setBounds(556, 147, 151, 32);
		frame.getContentPane().add(btnShow);
		
		JLabel lblCustomerId = new JLabel("Ticket_Number");
		lblCustomerId.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCustomerId.setBounds(88, 145, 203, 32);
		frame.getContentPane().add(lblCustomerId);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(305, 145, 192, 32);
		frame.getContentPane().add(textField);
		
		JLabel lblCustomerName = new JLabel("Customer_ID");
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCustomerName.setBounds(88, 185, 203, 32);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblFatherName = new JLabel("Flight_ID");
		lblFatherName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFatherName.setBounds(88, 225, 203, 32);
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblPhoneNumber = new JLabel("Departure");
		lblPhoneNumber.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPhoneNumber.setBounds(88, 265, 203, 32);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblFlightClass = new JLabel("Amount");
		lblFlightClass.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFlightClass.setBounds(88, 305, 203, 32);
		frame.getContentPane().add(lblFlightClass);
		
		JLabel lblFlight = new JLabel("Payment Mode:");
		lblFlight.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFlight.setBounds(88, 361, 203, 32);
		frame.getContentPane().add(lblFlight);
		
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
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(305, 265, 192, 32);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(305, 305, 192, 32);
		frame.getContentPane().add(textField_4);
		
		frame.setVisible(true);
	}
}