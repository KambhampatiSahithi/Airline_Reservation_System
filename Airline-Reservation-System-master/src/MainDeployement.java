


import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainDeployement {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDeployement window = new MainDeployement();
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
	public MainDeployement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 990, 623);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 972, 138);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAirlineReservationSystem = new JLabel("MAIN DEPLOYEMENT");
		lblAirlineReservationSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAirlineReservationSystem.setForeground(Color.RED);
		lblAirlineReservationSystem.setBackground(Color.RED);
		lblAirlineReservationSystem.setFont(new Font("Calibri", Font.BOLD, 40));
		lblAirlineReservationSystem.setBounds(0, 0, 972, 138);
		panel.add(lblAirlineReservationSystem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(123, 104, 238));
		panel_1.setForeground(new Color(72, 61, 139));
		panel_1.setBounds(0, 138, 972, 438);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCreateSchema = new JButton("Create Schema");
		btnCreateSchema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					   System.out.println("Driver Loaded");
					   Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/","harsha","konduri@26");
					    
					   
					Statement st=conn.createStatement();
					
				    st.executeUpdate("create database airline");
				    st.executeUpdate("use airline");
				    String s0="create table admin(Username varchar(20),Password varchar(20),Name varchar(20),Position varchar(10),Salary double,DOJ date)";
				    st.executeUpdate(s0);
					JOptionPane.showMessageDialog(null, " admin Table created");
				    String s="create table customer(Customer_ID int primary key,Customer_Name varchar(20),Password varchar(20),Father_Name varchar(20), DOB date,Phone_Number varchar(20),Address varchar(30),Gender varchar(20))";
				    st.executeUpdate(s);
				    JOptionPane.showMessageDialog(null, "customer Table created");
				    String s1="create table flight(Flight_ID int primary key,Flight_Name varchar(20), Source varchar(20), Departure varchar(10),Destination varchar(20), Arrival_Time varchar(10), Flight_Class varchar(20), Flight_Charges varchar(10), Seats int)";
				    st.executeUpdate(s1);
				    JOptionPane.showMessageDialog(null, "Flight Table created");
				    String s2="create table Ticket_reservation(Ticket_Number int primary key,Customer_ID int,Customer_Name varchar(20),Father_Name varchar(20),Gender varchar(10),DOB date,Phone_Number varchar(20),Address varchar(20), Date_Of_Journey date,Flight_ID int,Seat_Number int,foreign key(Customer_ID)references customer(Customer_ID)on delete cascade,foreign key(Flight_ID)references flight(Flight_ID)on delete cascade)";
				    st.executeUpdate(s2);
				    JOptionPane.showMessageDialog(null, " Ticket_reservation Table created");
				    //String s3="create table Customer_login(Ticket_Number int,Customer_ID int, Flight_ID int,Departure varchar(10),Amount double,foreign key(Ticket_Number)references Ticket_reservation(Ticket_Number)on delete cascade,foreign key(Customer_ID)references customer(Customer_Id)on delete cascade,foreign key(Flight_ID)references flight(Flight_Id)on delete cascade)";
				    //st.executeUpdate(s3);
				    //JOptionPane.showMessageDialog(null, " payment_details Table created");
				    //String s4="create table Enquiry(Customer_ID int,Ticket_Number int ,Flight_ID int,Flight_Name varchar(20),Seat_Number int,Fare double,date_Of_Journey date,foreign key(Ticket_Number)references Ticket_reservation(Ticket_Number)on delete cascade,foreign key(Customer_ID)references customer(Customer_Id)on delete cascade,foreign key(Flight_ID)references flight(Flight_Id)on delete cascade)";
				    //st.executeUpdate(s4);
				    JOptionPane.showMessageDialog(null, " Enquiry Table created");
				    String s5="create table Ticket_cancellation(Ticket_Number int,Flight_ID int,Customer_ID int,Seat_Number int,foreign key(Ticket_Number)references Ticket_reservation(Ticket_Number)on delete cascade,foreign key(Customer_ID)references customer(Customer_Id)on delete cascade,foreign key(Flight_ID)references flight(Flight_Id)on delete cascade)";
				    st.executeUpdate(s5);
				    JOptionPane.showMessageDialog(null, " Ticket_cancellation Table created");
				    String s6="create table list_of_customers(Flight_ID int, Customer_Name varchar(20),Father_Name varchar(10),DOB date,Phone_Number varchar(20),Address varchar(20),Flight_Name varchar(20),Source varchar(20),Destination varchar(20),Flight_Charges double,Ticket_Number int,Seat_Number int,foreign key(Ticket_Number)references Ticket_reservation(Ticket_Number)on delete cascade)";
				    st.executeUpdate(s6);
				    JOptionPane.showMessageDialog(null, " list_of_customers Table created");
				    String s7="create table payment(Ticket_Number int, Customer_ID int,Flight_ID int,Departure varchar(20),Amount double, Payment_mode varchar(20),foreign key(Ticket_Number)references Ticket_reservation(Ticket_Number)on delete cascade,foreign key(Customer_ID)references customer(Customer_Id)on delete cascade,foreign key(Flight_ID)references flight(Flight_Id)on delete cascade)";
				    st.executeUpdate(s7);
				    JOptionPane.showMessageDialog(null, " payment Table created");
				    String s8="create table card(Ticket_Number int,Card_Number varchar(20),Card_Type varchar(20),Holder_Name varchar(20),Expiry_Date date,Bank_Name varchar(20),foreign key(Ticket_Number)references Ticket_reservation(Ticket_Number)on delete cascade)";
				    st.executeUpdate(s8);
				    JOptionPane.showMessageDialog(null, " card Table created");
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					System.out.println(e1);}
				
				
			}
		});
		btnCreateSchema.setFont(new Font("Calibri", Font.BOLD, 30));
		btnCreateSchema.setBounds(147, 166, 270, 83);
		panel_1.add(btnCreateSchema);
		
		JButton btnDropSchema = new JButton("Drop Schema");
		btnDropSchema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					   System.out.println("Driver Loaded");
					    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/","harsha","konduri@26");
					    Statement st=con.createStatement();
					    
					     st.executeUpdate("drop database airline");
					     JOptionPane.showMessageDialog(null, "Database Truncated");
					     JOptionPane.showMessageDialog(null,"Table Created");
				}
				catch(Exception e1) 
				{
					JOptionPane.showMessageDialog(null,e1);}
			}
				
				
				
			}
		);
		
			
		btnDropSchema.setFont(new Font("Calibri", Font.BOLD, 30));
		btnDropSchema.setBounds(572, 166, 270, 83);
		panel_1.add(btnDropSchema);
		
		
		
		
		
	}
}
	