package main.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

public class Customer_Home {
	
	int x;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Home window = new Customer_Home();
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
	public Customer_Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1084, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 128, 114));
		panel.setBounds(0, 123, 1066, 469);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnReservation = new JRadioButton("Book ticket");
		rdbtnReservation.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				x=1;
			}
		});
		rdbtnReservation.setBackground(new Color(218, 165, 32));
		rdbtnReservation.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnReservation.setBounds(150, 99, 245, 40);
		panel.add(rdbtnReservation);
		
		JRadioButton rdbtnCancel = new JRadioButton("Cancel");
		rdbtnCancel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				x=2;
			}
		});
		rdbtnCancel.setBackground(new Color(192, 192, 192));
		rdbtnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnCancel.setBounds(150, 224, 245, 40);
		panel.add(rdbtnCancel);
		
		ButtonGroup b=new ButtonGroup();
		b.add(rdbtnReservation);
		b.add(rdbtnCancel);
		
		
		JButton btnProceed = new JButton("PROCEED");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if(x==1)
						new Reservation();
					else 
						new Cancel();
				
			}
		});
		btnProceed.setBackground(new Color(0, 128, 0));
		btnProceed.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnProceed.setBounds(403, 346, 210, 35);
		panel.add(btnProceed);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(0, 0, 1066, 125);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAirlineReservationSystem = new JLabel("Customer Home");
		lblAirlineReservationSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAirlineReservationSystem.setForeground(Color.BLACK);
		lblAirlineReservationSystem.setBackground(Color.GRAY);
		lblAirlineReservationSystem.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblAirlineReservationSystem.setBounds(0, 0, 1066, 123);
		panel_1.add(lblAirlineReservationSystem);
		
		frame.setVisible(true);
	}
}