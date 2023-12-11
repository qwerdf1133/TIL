package n3_chat.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientExample {

	// console에서 서버에 전송할 메세지를 입력
	Scanner sc = new Scanner(System.in);
	
	/**
	 * server와 연결된 정보를 저장
	 */
	Socket socket;
	
	public ClientExample() {
		startClient();
	}
	
	/**
	 * 서버와 연결
	 */
	public void startClient() {
		try {
			socket = new Socket();
			// 연결이 수락 될때 까지 blocking
			socket.connect(new InetSocketAddress("10.100.205.231",5002));
			System.out.println("연결 정보 : " + socket.getRemoteSocketAddress());
			
			// 서버에서 전달 되는 메세지 수신 대기 및 수신 처리 - receive();
			receive();
			
			while(true) {
				System.out.print("메세지 입력 : ");
				// console을 통해서 서버에 출력할 메세지를 입력받음
				String message = sc.nextLine();
				send(message);	// server에 메세지 출력
			}
			
		} catch (IOException e) {
			System.out.println("서버와 통신 안됨 : " + e.getMessage());
			stopClient();
			return;
		}
	}
	
	/**
	 * 안전하게 자원 해제
	 */
	public void stopClient() {
		System.out.println("자원 해제");
		if(socket != null && !socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {}
		}
	}
	
	/**
	 * console에서 입력 받은 message를 서버에 출력
	 */
	public void send(String message) {
		OutputStream os = null;
		byte[] bytes = message.getBytes();
		
		try {
			os = socket.getOutputStream();
			os.write(bytes);
			os.flush();
		} catch (IOException e) {
			System.out.println("서버와 연결 끊김");
			
			try {
				if(os != null) os.close();
			} catch (IOException e1) {}
			
			stopClient();
		}
		
	}

	/**
	 * server에서 발신된 메세지 수신
	 */
	public void receive() {
		Thread t = new Thread(()->{
			while(true) {
				InputStream is = null;
				byte[] bytes = new byte[300];
				try {
					is = socket.getInputStream();
					int readBytes = is.read(bytes);
					String message = new String(bytes,0, readBytes);
					System.out.println(message);
				}catch(IOException e) {
					System.out.println("서버와 연결 종료");
					stopClient();
					break;
				}
			}
		});
		t.start();
	}
	
	public static void main(String[] args) {
		new ClientExample();
	}

}

















