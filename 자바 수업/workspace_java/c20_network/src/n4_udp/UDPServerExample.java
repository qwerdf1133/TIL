package n4_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerExample {

	public static void main(String[] args) {
		
		try {
			DatagramSocket datagramSocket = new DatagramSocket(5002);
			while(true) {
				System.out.println("datagrame packet 생성");
				DatagramPacket packet = new DatagramPacket(new byte[100], 100);
				datagramSocket.receive(packet);
				String data = new String(packet.getData(), 0 , packet.getLength());
				System.out.println("[받은 내용 : "+data+"]");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}













