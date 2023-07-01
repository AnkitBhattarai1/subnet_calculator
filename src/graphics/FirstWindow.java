package graphics;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FirstWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel IpAddress;
	private JLabel SubnetMask;
	private JLabel NetworkAddress;
	private JLabel BroadcastAddress;
	private JLabel NumberofSubnets;
	private JLabel HostsPerSubnet;
	
	
	private JTextField ipAddress;
	private JTextField subnetMask;
	private JTextField networkAddress;
	private JTextField broadcastAddress;
	private JTextField numberofSubnets;
	private JTextField hostsperSubnet;
	
	
	private JButton calcButton;
	
	
	//Strings to hold the octect of the address.
	String oct1;
	String oct2;
	String oct3;
	String oct4;
	String oct5;
	String oct6;
	String oct7;
	String oct8;
	
	public FirstWindow(){
		
	    setTitle("Subnet Calculator");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(800, 700);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    setLayout(new GridLayout());
		
		
		IpAddress=new JLabel("IP Address");
		SubnetMask=new JLabel("Subnet Mask");
		NetworkAddress=new JLabel("Network Address");
		BroadcastAddress = new JLabel("Broadcast Address");
		NumberofSubnets=new JLabel("Number of Subnets");
		HostsPerSubnet = new JLabel("HostsPerSubnet");
		
		
		
		
		
		
	}
	
	
}
