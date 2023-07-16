package addresses;

import static addresses.iptype.IPv4;

import java.util.Arrays;

import subnet_calculator.Calculator;

public class IPv4 extends Address {

	public String oct[];
	public String address = "";

	public IPv4(String[] oct) {
		this.oct = oct;
		this.iptype = IPv4;
		makeaddress(oct);

	}

	public IPv4(String ipv4) {

		this.oct = ipv4.split("\\.");
		makeaddress(oct);
		this.iptype = iptype.IPv4;
	}

	public IPv4(String oct1, String oct2, String oct3, String oct4) {
		this(new String[] { oct1, oct2, oct3, oct4 });
	}

	public IPv4(int oct1, int oct2, int oct3, int oct4) {
		this(Arrays.stream(new int[] { oct1, oct2, oct3, oct4 }).mapToObj(String::valueOf).toArray(String[]::new));
	}

	public IPv4(int[] oct) {
		this(Arrays.stream(oct).mapToObj(String::valueOf).toArray(String[]::new));
	}

	public IPv4(IPv4 ipv4) {
		this.address = ipv4.address;
		this.oct = ipv4.oct;
	}

	@Override
	public String toString() {
		return address;
	}

	private void makeaddress(String oct[]) {
		for (int i = 0; i < 4; i++) {
			address = address.concat(oct[i].concat("."));
		}
		address = address.substring(0, address.length() - 1);
	}

}
