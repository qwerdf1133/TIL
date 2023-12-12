package n4_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClientExample {

	public static void main(String[] args) {
		// 수신 발신 역할을 담당하는 객체 - 실제 전송할 데이터의 정보는 DatagramPacket 객체가 담당
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			for(int i = 1; i < 4; i++){
				String message = "message - " + i;
				byte[] bytes = message.getBytes();
				DatagramPacket packet = new DatagramPacket(
					bytes,			// 전송할 데이터
					bytes.length,	// 전송할 데이터 크기 - byte 단위
					new InetSocketAddress("192.168.111.1",5002)	// 전송할 위치
				);
				datagramSocket.send(packet);
				System.out.println("보낸 바이트 수 : " + bytes.length);
			}
			System.out.println("[발신 완료]");
			datagramSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}














