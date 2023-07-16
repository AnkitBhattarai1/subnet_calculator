package subnet_calculator;

import addresses.Address;
import addresses.IPv4;
import addresses.IPv6;
import addresses.iptype;

public class Calculator {

	public int subnetMask, noofSubnets, hostsperSubnet;
	public Address inputAddress, broadcastAddress, networkAddress;
	iptype addressType;

	public Calculator(Address inputAddress, int subnetMask) {
		this.inputAddress = inputAddress;
		this.subnetMask = subnetMask;
		this.addressType = inputAddress.iptype;
		calc();
	}

	public void calc() {
		if (inputAddress.iptype == iptype.IPv4) {
			ipv4();
		} else {
			ipv6();
		}

	}

	/*
	 * private void findIpClassType(IPv4 address) { String addressinBinary =
	 * Integer.toBinaryString(Integer.parseInt(address.oct[0])); if
	 * (addressinBinary.length() < 8) { classType = 'A'; networkBits = 8; } else if
	 * (addressinBinary.startsWith("10")) { classType = 'B'; networkBits = 16; }
	 * else if (addressinBinary.startsWith("110")) { classType = 'C'; networkBits =
	 * 24; } else if (addressinBinary.startsWith("1110")) { classType = 'D';
	 * networkBits = 31; } else if (addressinBinary.startsWith("1111")) { classType
	 * = 'E'; networkBits = 32; }
	 * 
	 * }
	 */

	private void findNetworkAddresses(IPv4 address) {
		String binaryAddress = findBinaryAddress(address);
		String networkAddressinBinary = "";
		String networkAddressinString = "";
		String broadcastAddressinBinary;
		String broadcastAddressinString;

		networkAddressinBinary = binaryAddress.substring(0, subnetMask) + "0".repeat(32 - subnetMask);
		broadcastAddressinBinary = binaryAddress.substring(0, subnetMask) + "1".repeat(32 - subnetMask);

		networkAddressinString = String.valueOf(Integer.parseInt(networkAddressinBinary.substring(0, 8), 2)) + "."
				+ String.valueOf(Integer.parseInt(networkAddressinBinary.substring(8, 16), 2)) + "."
				+ String.valueOf(Integer.parseInt(networkAddressinBinary.substring(16, 24), 2)) + "."
				+ String.valueOf(Integer.parseInt(networkAddressinBinary.substring(24, 32), 2));

		broadcastAddressinString = String.valueOf(Integer.parseInt(broadcastAddressinBinary.substring(0, 8), 2)) + "."
				+ String.valueOf(Integer.parseInt(broadcastAddressinBinary.substring(8, 16), 2)) + "."
				+ String.valueOf(Integer.parseInt(broadcastAddressinBinary.substring(16, 24), 2)) + "."
				+ String.valueOf(Integer.parseInt(broadcastAddressinBinary.substring(24, 32), 2));

		this.networkAddress = new IPv4(networkAddressinString);
		this.broadcastAddress = new IPv4(broadcastAddressinString);

	}

	private String findBinaryAddress(IPv4 address) {
		String binaryAddress = "";
		String addressinBinary[] = new String[4];
		for (int i = 0; i < 4; i++) {
			addressinBinary[i] = Integer.toBinaryString(Integer.parseInt(address.oct[i]));

			while (addressinBinary[i].length() < 8) {
				addressinBinary[i] = "0" + addressinBinary[i];
			}

			binaryAddress = binaryAddress + addressinBinary[i];
		}
		return binaryAddress;
	}

	private void findNetworkAddresses(IPv6 address) {

	}

	private void ipv4() {
		IPv4 address = new IPv4(inputAddress.toString());
		findNetworkAddresses(address);
		this.hostsperSubnet = (int) Math.pow(2, 32 - subnetMask);
		this.noofSubnets = (int) Math.pow(2, subnetMask - (subnetMask / 8) * 8);
	}

	private void ipv6() {
		System.out.println("This for ipv6");
	}

}
