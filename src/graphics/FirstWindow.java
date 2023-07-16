package graphics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import addresses.IPv4;
import subnet_calculator.Calculator;

public class FirstWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	// Strings to hold the octect of the address.
	String oct1;
	String oct2;
	String oct3;
	String oct4;
	String oct5;
	String oct6;
	String oct7;
	String oct8;

	private JLabel ipAddressLabel;
	private JLabel subnetMaskLabel;
	private JLabel networkAddressLabel;
	private JLabel broadcastAddressLabel;
	private JLabel numberOfSubnetsLabel;
	private JLabel hostsPerSubnetLabel;

	private JTextField ipAddressTextField;
	private JTextField subnetMaskTextField;
	private JTextField networkAddressTextField;
	private JTextField broadcastAddressTextField;
	private JTextField numberOfSubnetsTextField;
	private JTextField hostsPerSubnetTextField;

	private JButton calculateButton;

	public FirstWindow() {
		super("Subnet Calculator");

		// Create labels
		ipAddressLabel = new JLabel("IP Address:");
		subnetMaskLabel = new JLabel("Subnet Mask:");
		networkAddressLabel = new JLabel("Network Address:");
		broadcastAddressLabel = new JLabel("Broadcast Address:");
		numberOfSubnetsLabel = new JLabel("Number of Subnets:");
		hostsPerSubnetLabel = new JLabel("Hosts per Subnet:");

		// Create text fields
		ipAddressTextField = new JTextField(20);
		subnetMaskTextField = new JTextField(20);
		networkAddressTextField = new JTextField(20);
		broadcastAddressTextField = new JTextField(20);
		numberOfSubnetsTextField = new JTextField(20);
		hostsPerSubnetTextField = new JTextField(20);

		// Create calculate button
		calculateButton = new JButton("Calculate");

		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculate();
			}
		});

		// Set layout
		setLayout(new GridLayout(7, 2));

		// Add components to the frame
		add(ipAddressLabel);
		add(ipAddressTextField);
		add(subnetMaskLabel);
		add(subnetMaskTextField);
		add(networkAddressLabel);
		add(networkAddressTextField);
		add(broadcastAddressLabel);
		add(broadcastAddressTextField);
		add(numberOfSubnetsLabel);
		add(numberOfSubnetsTextField);
		add(hostsPerSubnetLabel);
		add(hostsPerSubnetTextField);
		add(calculateButton);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Center the frame
		setVisible(true);
	}

	private void calculate() {
		// long intial = System.currentTimeMillis();
		IPv4 address = new IPv4(ipAddressTextField.getText());
		Calculator calculator = new Calculator(address, Integer.parseInt(subnetMaskTextField.getText()));
		networkAddressTextField.setText(calculator.networkAddress.toString());
		hostsPerSubnetTextField.setText(String.valueOf(calculator.hostsperSubnet));
		numberOfSubnetsTextField.setText(String.valueOf(calculator.noofSubnets));
		broadcastAddressTextField.setText(calculator.broadcastAddress.toString());

		// long fina = System.currentTimeMillis();
		// System.out.println(fina-intial);
	}

}
