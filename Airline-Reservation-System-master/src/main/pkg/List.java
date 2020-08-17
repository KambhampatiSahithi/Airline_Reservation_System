package main.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class List {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List window = new List();
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
	public List() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 224, 208));
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 25));
		frame.setBounds(100, 100, 1070, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(25, 192, 998, 380);
		frame.getContentPane().add(table);
		
		JButton btnBook = new JButton("SEARCH");
		btnBook.setBackground(Color.BLACK);
		btnBook.setForeground(Color.WHITE);
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","harsha","konduri@26");
					System.out.println("Database Connected");
					String s="select customer_id, customer_name ,father_name ,dob ,phone_number ,address ,gender from ticket_reservation where flight_id='"+textField.getText()+"'";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(s);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception ex) 
				{
					JOptionPane.showMessageDialog(null, ex);
				}	
			}
		});
		btnBook.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnBook.setBounds(565, 115, 142, 32);
		frame.getContentPane().add(btnBook);
		
		JLabel lblListOfCustomers = new JLabel("List of Customers");
		lblListOfCustomers.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblListOfCustomers.setBounds(57, 27, 377, 56);
		frame.getContentPane().add(lblListOfCustomers);
		
		JLabel lblFlightid = new JLabel("Flight_ID");
		lblFlightid.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFlightid.setBounds(102, 115, 175, 32);
		frame.getContentPane().add(lblFlightid);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(289, 115, 192, 32);
		frame.getContentPane().add(textField);
		
		frame.setVisible(true);
	}
}