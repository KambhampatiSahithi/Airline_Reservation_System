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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;

public class Card {

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
					Card window = new Card();
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
	public Card() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(139, 0, 139));
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 25));
		frame.setBounds(100, 100, 1070, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("Credit Card - Details");
		lblCustomerDetails.setForeground(Color.WHITE);
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblCustomerDetails.setBounds(88, 51, 448, 56);
		frame.getContentPane().add(lblCustomerDetails);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(305, 345, 192, 32);
		frame.getContentPane().add(dateChooser);
		
		JRadioButton rdbtnVisa = new JRadioButton("VISA");
		rdbtnVisa.setBounds(306, 245, 80, 23);
		frame.getContentPane().add(rdbtnVisa);
		
		JRadioButton rdbtnMasterCard = new JRadioButton("MASTER CARD");
		rdbtnMasterCard.setBounds(399, 245, 109, 23);
		frame.getContentPane().add(rdbtnMasterCard);
		
		ButtonGroup b= new ButtonGroup();
		b.add(rdbtnVisa);
		b.add(rdbtnMasterCard);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  

				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
				int tno;	
		String cno,ctype=null,hnm,dob,bn;
		//double gs;		
		tno=Integer.parseInt(textField.getText());
		cno=textField_1.getText();
		//card type should filled
		hnm=textField_2.getText();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		dob=sdf.format(dateChooser.getDate()); 
		bn=textField_3.getText();
	    //gs=Double.parseDouble(textField_8.getText());	    
		String s="insert into card values(?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(s);		
		pst.setInt(1, tno);
		pst.setString(2, cno);
		if(rdbtnVisa.isSelected())
		{
			ctype="VISA";
		}
		if(rdbtnMasterCard.isSelected())
		{
			ctype="MASTERCARD";
		}
		pst.setString(3, ctype);
		pst.setString(4, hnm);
		pst.setString(5, dob);
		pst.setString(6, bn);
		int n=pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "Paid!!!");
					
		}
		catch(Exception e3) {
					JOptionPane.showMessageDialog(null,e3);
				}			
			}
		});		
				
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(322, 480, 153, 40);
		frame.getContentPane().add(btnSave);
		
		JLabel lblCustomerId = new JLabel("Ticket_Number");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCustomerId.setBounds(88, 145, 203, 32);
		frame.getContentPane().add(lblCustomerId);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(305, 145, 192, 32);
		frame.getContentPane().add(textField);
		
		JLabel lblCustomerName = new JLabel("Card_Number");
		lblCustomerName.setForeground(Color.WHITE);
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCustomerName.setBounds(88, 195, 203, 32);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblFatherName = new JLabel("Card_Type");
		lblFatherName.setForeground(Color.WHITE);
		lblFatherName.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFatherName.setBounds(88, 245, 203, 32);
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblPhoneNumber = new JLabel("Holder_Name");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPhoneNumber.setBounds(88, 295, 203, 32);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblFlightClass = new JLabel("Expiry_Date");
		lblFlightClass.setForeground(Color.WHITE);
		lblFlightClass.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFlightClass.setBounds(88, 345, 203, 32);
		frame.getContentPane().add(lblFlightClass);
		
		JLabel lblFlight = new JLabel("Bank_Name");
		lblFlight.setForeground(Color.WHITE);
		lblFlight.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFlight.setBounds(88, 395, 203, 32);
		frame.getContentPane().add(lblFlight);
		
		
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(305, 195, 192, 32);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(305, 295, 192, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(305, 395, 192, 32);
		frame.getContentPane().add(textField_3);
		
		
		
		frame.setVisible(true);
	}
}