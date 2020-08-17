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

public class Admin_Home {
	
	int x;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Home window = new Admin_Home();
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
	public Admin_Home() {
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
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 95, 1066, 497);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnFlight = new JRadioButton("Add/Remove Flight");
		rdbtnFlight.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				x=1;
			}
		});
		rdbtnFlight.setBackground(new Color(255, 0, 0));
		rdbtnFlight.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnFlight.setBounds(150, 140, 265, 40);
		panel.add(rdbtnFlight);
		
		JRadioButton rdbtnListofcustomer = new JRadioButton("Check Customer details");
		rdbtnListofcustomer.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				x=2;
			}
		});
		rdbtnListofcustomer.setBackground(new Color(0, 250, 154));
		rdbtnListofcustomer.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnListofcustomer.setBounds(150, 205, 265, 40);
		panel.add(rdbtnListofcustomer);
		
		JRadioButton rdbtnReservation = new JRadioButton("Check Flight details");
		rdbtnReservation.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				x=3;
			}
		});
		rdbtnReservation.setBackground(new Color(218, 165, 32));
		rdbtnReservation.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnReservation.setBounds(150, 270, 265, 40);
		panel.add(rdbtnReservation);
		
		ButtonGroup b=new ButtonGroup();
		b.add(rdbtnFlight);
		b.add(rdbtnListofcustomer);
		b.add(rdbtnReservation);
		
		
		JButton btnProceed = new JButton("PROCEED");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if(x==1)
						new Flight();
					else if(x==2)
						new List();
					else 
						new Flight_details();
				
			}
		});
		btnProceed.setBackground(new Color(0, 128, 0));
		btnProceed.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnProceed.setBounds(426, 374, 210, 35);
		panel.add(btnProceed);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 0, 1066, 95);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAirlineReservationSystem = new JLabel("Administrator Home");
		lblAirlineReservationSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAirlineReservationSystem.setForeground(Color.BLACK);
		lblAirlineReservationSystem.setBackground(Color.GRAY);
		lblAirlineReservationSystem.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAirlineReservationSystem.setBounds(319, 13, 423, 69);
		panel_1.add(lblAirlineReservationSystem);
		frame.setVisible(true);
	}
}
