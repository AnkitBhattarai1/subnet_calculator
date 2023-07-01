package subnet_calculator;

import addresses.Address;
import addresses.IPv4;
import addresses.iptype;

public class Calculator {

	public int subnetMask, noofSubnets, hostsperSubnet, networkBits;
	public Address inputAddress, broadcastAddress, networkAddress;
	public char classType;
	iptype addressType;

	public Calculator(Address inputAddress, int subnetMask) {
		this.inputAddress = inputAddress;
		this.subnetMask = subnetMask;
		this.addressType = inputAddress.iptype;
		calc();
	}

	public Calculator() {

	}

	public void calc() {
		if (addressType == iptype.IPv4)
			ipv4();
	}

	private char findIpClassType(IPv4 address) {

		String addressinBinary = Integer.toBinaryString(Integer.parseInt(address.oct[0]));
		if (addressinBinary.length() < 8) {
			this.classType = 'A';
			this.networkBits = 8;
			this.noofSubnets = (int) Math.pow(2, subnetMask - 8);
		}

		else if (addressinBinary.startsWith("10")) {
			this.classType = 'B';
			this.networkBits = 16;
		} else if (addressinBinary.startsWith("110")) {
			this.classType = 'C';
			this.networkBits = 24;
		} else if (addressinBinary.startsWith("1110")) {
			this.classType = 'D';
			this.networkBits = 31;
		} else if (addressinBinary.startsWith("1111")) {
			this.classType = 'E';
			this.networkBits = 32;
		}

		return this.classType;

	}

	private IPv4 findNetworkAddress(IPv4 address) {
		return (IPv4) this.networkAddress;
	}

	private int findnoofSubnets(IPv4 address) {
		return (this.noofSubnets = (int) Math.pow(2, subnetMask - this.networkBits));
	}

	private void ipv4() {
		IPv4 address = new IPv4(inputAddress.toString());
		findIpClassType(address);
		findnoofSubnets(address);
		this.hostsperSubnet = (int) Math.pow(2, 32 - subnetMask);
	}

}
