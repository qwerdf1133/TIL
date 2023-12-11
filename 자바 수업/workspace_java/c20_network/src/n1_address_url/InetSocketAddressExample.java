package n1_address_url;

import java.net.InetSocketAddress;

public class InetSocketAddressExample {

	public static void main(String[] args) {
		InetSocketAddress isa = new InetSocketAddress("10.100.205.231", 5001);
		System.out.println(isa.getHostString());
		System.out.println(isa.getHostName());
		System.out.println(isa.getAddress());
		System.out.println(isa.getPort());
		

	}

}
