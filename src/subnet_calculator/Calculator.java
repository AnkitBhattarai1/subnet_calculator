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

	public void calc() {
		ipv4();

	}

	private void findIpClassType(IPv4 address) {
		String addressinBinary = Integer.toBinaryString(Integer.parseInt(address.oct[0]));
		if (addressinBinary.length() < 8) {
			classType = 'A';
			networkBits = 8;
		} else if (addressinBinary.startsWith("10")) {
			classType = 'B';
			networkBits = 16;
		} else if (addressinBinary.startsWith("110")) {
			classType = 'C';
			networkBits = 24;
		} else if (addressinBinary.startsWith("1110")) {
			classType = 'D';
			networkBits = 31;
		} else if (addressinBinary.startsWith("1111")) {
			classType = 'E';
			networkBits = 32;
		}

	}

	private IPv4 findNetworkAddress(IPv4 address) {
		String binaryAddress = "";
		String addressinBinary[] = new String[4];
		String networkAddressinBinary = "";
		String networkAddressinString = "";
		for (int i = 0; i < 4; i++) {
			addressinBinary[i] = Integer.toBinaryString(Integer.parseInt(address.oct[i]));

			while (addressinBinary[i].length() < 8) {
				addressinBinary[i] = "0" + addressinBinary[i];
			}

			binaryAddress = binaryAddress + addressinBinary[i];
		}
		String replacement = "0".repeat(32 - subnetMask);
		networkAddressinBinary = binaryAddress.substring(0, subnetMask) + replacement;
		networkAddressinString = String.valueOf(Integer.parseInt(networkAddressinBinary.substring(0, 8), 2)) + "."
				+ String.valueOf(Integer.parseInt(networkAddressinBinary.substring(8, 16), 2)) + "."
				+ String.valueOf(Integer.parseInt(networkAddressinBinary.substring(16, 24), 2)) + "."
				+ String.valueOf(Integer.parseInt(networkAddressinBinary.substring(24, 32), 2));

		this.networkAddress = new IPv4(networkAddressinString);
		return (IPv4) networkAddress;
	}

	private void ipv4() {
		IPv4 address = new IPv4(inputAddress.toString());
		findIpClassType(address);
		findNetworkAddress(address);
		this.hostsperSubnet = (int) Math.pow(2, 32 - subnetMask);
	}

}
