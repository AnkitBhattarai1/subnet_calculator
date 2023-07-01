package addresses;

import static addresses.iptype.IPv6;

public class IPv6 extends Address {

	String oct[];
	String address = "";

	public IPv6(String[] oct) {   // constructor accepting the array of String
		this.oct = oct;
		this.iptype = IPv6;
		makeAddress(oct);
	}

	public IPv6(String address) {
		this.oct=address.split(":");
		this.iptype=IPv6;
		makeAddress(oct);
		
	}

	public IPv6(String oct1, String oct2, String oct3, String oct4, String oct5, String oct6, String oct7,
			String oct8) {
		this(new String[] { oct1, oct2, oct3, oct4, oct5, oct6, oct7, oct8 });
	}

	public String toString() {
		return address;
	}

	private void makeAddress(String[] oct) {

		for (int i = 0; i < 8; i++) {
			address = address.concat(oct[i].concat(":"));
		}
		address = address.substring(0, address.length() - 1);
	}

}
