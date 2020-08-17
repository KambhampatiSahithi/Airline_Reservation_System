package main.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;

public class Reservation {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_5;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation window = new Reservation();
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
	public Reservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 25));
		frame.setBounds(100, 100, 1070, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Source");
		label.setBounds(25, 299, 74, 32);
		label.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(label);
		
		
		JLabel label_1 = new JLabel("Destination");
		label_1.setBounds(247, 299, 115, 32);
		label_1.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(label_1);
		
		
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setBounds(191, 354, 115, 41);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");	
		//String src,dst;
		
		//src=textField_8.getText();
		//dst=textField_9.getText();
	    
		String s="select * from flight where source='"+textField_8.getText()+"'"+"and "+"destination='"+textField_9.getText()+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(s);

		table.setModel(DbUtils.resultSetToTableModel(rs));
					
		}
		catch(Exception e3) {
					JOptionPane.showMessageDialog(null,e3);
				}			
		}
	});
		btnShow.setForeground(Color.WHITE);
		btnShow.setBackground(Color.RED);
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(btnShow);
		
		table = new JTable();
		table.setBounds(25, 416, 477, 168);
		frame.getContentPane().add(table);
		
		
		JLabel lblTicketNumber = new JLabel("Ticket_Number");
		lblTicketNumber.setBounds(525, 30, 192, 30);
		lblTicketNumber.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(lblTicketNumber);
		
		textField = new JTextField();
		textField.setBounds(740, 30, 184, 30);
		textField.setFont(new Font("Dialog", Font.BOLD, 15));
		textField.setColumns(10);
		frame.getContentPane().add(textField);
		
		JLabel lblCustomerId = new JLabel("Customer_ID");
		lblCustomerId.setBounds(525, 65, 192, 30);
		lblCustomerId.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(lblCustomerId);
		
		JLabel lblCustomerNumber = new JLabel("Customer_Name");
		lblCustomerNumber.setBounds(525, 100, 192, 30);
		lblCustomerNumber.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(lblCustomerNumber);
		
		JLabel lblFatherName = new JLabel("Father_Name");
		lblFatherName.setBounds(525, 135, 192, 30);
		lblFatherName.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(525, 170, 192, 30);
		lblDob.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(lblDob);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(740, 170, 184, 30);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblPhoneNumber = new JLabel("Phone_Number");
		lblPhoneNumber.setBounds(525, 217, 192, 30);
		lblPhoneNumber.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(525, 299, 192, 30);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(lblAddress);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(740, 413, 184, 30);
		frame.getContentPane().add(dateChooser_1);
		
		JLabel lblDateofjourney = new JLabel("Date_Of_Journey");
		lblDateofjourney.setBounds(525, 413, 192, 30);
		lblDateofjourney.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(lblDateofjourney);
		
		JLabel lblFlightid = new JLabel("Flight_ID");
		lblFlightid.setBounds(525, 456, 192, 30);
		lblFlightid.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(lblFlightid);
		
		JLabel lblSeatno = new JLabel("Seat_Number");
		lblSeatno.setBounds(525, 499, 192, 30);
		lblSeatno.setFont(new Font("Dialog", Font.BOLD, 22));
		frame.getContentPane().add(lblSeatno);
		
		textField_1 = new JTextField();
		textField_1.setBounds(740, 65, 184, 30);
		textField_1.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(740, 100, 184, 30);
		textField_2.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(740, 135, 184, 30);
		textField_3.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(740, 213, 184, 30);
		textField_4.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_4.setColumns(10);
		frame.getContentPane().add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(740, 459, 184, 30);
		textField_6.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_6.setColumns(10);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(740, 499, 184, 30);
		textField_7.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_7.setColumns(10);
		frame.getContentPane().add(textField_7);
		
		JLabel label_2 = new JLabel("Gender");
		label_2.setFont(new Font("Dialog", Font.BOLD, 22));
		label_2.setBounds(525, 363, 97, 32);
		frame.getContentPane().add(label_2);
		
		JRadioButton rdbtnMale = new JRadioButton("MALE");
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnMale.setBounds(740, 369, 97, 25);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnFemale.setBounds(861, 369, 115, 25);
		frame.getContentPane().add(rdbtnFemale);
		
		ButtonGroup b= new ButtonGroup();
		b.add(rdbtnMale);
		b.add(rdbtnFemale);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String gen=null;
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
					System.out.println("Database Connected");
					String s="select * from customer where customer_id='"+textField_1.getText()+"'";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(s);
					
					while(rs.next()) {
						textField_2.setText(rs.getString("customer_name"));
						
						textField_3.setText(rs.getString("father_name"));
						
						dateChooser.setDate(rs.getDate("DOB"));
						
						textField_4.setText(rs.getString("Phone_number"));
						
						textField_5.setText(rs.getString("address"));
					}
				
					
				}
				catch(Exception ex) 
				{
					JOptionPane.showMessageDialog(null, ex);
				}	
			}
		});
		btnSearch.setBounds(943, 65, 97, 30);
		btnSearch.setBackground(Color.GREEN);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(btnSearch);
		
		JLabel lblTicketReservation = new JLabel("Ticket Booking");
		lblTicketReservation.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketReservation.setBounds(56, 13, 416, 56);
		lblTicketReservation.setFont(new Font("Tahoma", Font.BOLD, 42));
		frame.getContentPane().add(lblTicketReservation);
		

		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(740, 256, 184, 93);
		frame.getContentPane().add(textField_5);
		
			
			
		
		JButton btnBook = new JButton("BOOK");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
				String cnm,fnm,add,dob,pn,gen=null,dob1;
				int tid,cid,fid,sno;
				tid=Integer.parseInt(textField.getText());
				cid=Integer.parseInt(textField_1.getText());
				cnm=textField_2.getText();
				fnm=textField_3.getText();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				dob=sdf.format(dateChooser.getDate()); 
				pn=textField_4.getText();
				add=textField_5.getText();	
				SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
				dob1=sdf1.format(dateChooser_1.getDate()); 
				
				fid=Integer.parseInt(textField_6.getText());
				sno=Integer.parseInt(textField_7.getText());
				
		        String s="insert into ticket_reservation values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(s);
						
				pst.setInt(1, tid);
				pst.setInt(2,cid);
				pst.setString(3,cnm);
				pst.setString(4,fnm);
				if(rdbtnMale.isSelected())
				{
					gen="Male";
				}
				if(rdbtnFemale.isSelected())
				{
					gen="Female";
				}
				pst.setString(5, gen);
				pst.setString(6, dob);
				pst.setString(7, pn);
				pst.setString(8, add);
				pst.setString(9, dob1);
				pst.setInt(10, fid);
				pst.setInt(11, sno);
				
				
				int n=pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, n+"Ticket Booked!!!");			
				}
				catch(Exception e3) {
							JOptionPane.showMessageDialog(null,e3);
						}
				new Payment();
			}
		});
		btnBook.setForeground(Color.WHITE);
		btnBook.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBook.setBackground(Color.BLACK);
		btnBook.setBounds(773, 542, 115, 41);
		frame.getContentPane().add(btnBook);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(111, 299, 128, 30);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_9.setColumns(10);
		textField_9.setBounds(374, 301, 128, 30);
		frame.getContentPane().add(textField_9);
		
		table_1 = new JTable();
		table_1.setBounds(214, 147, 288, 116);
		frame.getContentPane().add(table_1);
		
		JLabel lblShowAvailableFlights = new JLabel("Show available flights:");
		lblShowAvailableFlights.setFont(new Font("Dialog", Font.BOLD, 22));
		lblShowAvailableFlights.setBounds(25, 91, 253, 49);
		frame.getContentPane().add(lblShowAvailableFlights);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");	
	    
		String s="select source,destination from flight";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(s);

		table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
		}
		catch(Exception e3) {
					JOptionPane.showMessageDialog(null,e3);
				}	
			}
		});
		btnSearch_1.setForeground(Color.WHITE);
		btnSearch_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch_1.setBackground(new Color(0, 153, 255));
		btnSearch_1.setBounds(25, 185, 144, 30);
		frame.getContentPane().add(btnSearch_1);
		
		
		frame.setVisible(true);
	}
}