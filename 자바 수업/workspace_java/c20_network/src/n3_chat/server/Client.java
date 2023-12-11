package n3_chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Socket으로 연결된 client의 정보를 저장하고
 * 개별 송/수신을 담당할 class
 */
public class Client {
	
	/**
	 * 연결된 client socket 정보를 저장할 field
	 * OutputStream
	 * InputStream
	 */
	Socket socket;
	
	public Client(Socket socket) {
		this.socket = socket;
		receive(); // 수신 대기 및 처리
	}
	
	/**
	 * socket으로 연결된 client에게
	 * server에서 필요한 정보를 매개변수로 넘겨받아 출력
	 * @param message
	 */
	public void send(String message) {
		OutputStream os = null;
		byte[] bytes = message.getBytes();
		try {
			os = socket.getOutputStream();
			os.write(bytes);
			os.flush();
		} catch (IOException e) {
			System.out.println("Client 통신 안됨");
			
			try {
				// 오류가 발생한 스트림 자원 해제
				if(os != null) os.close();
			} catch (IOException e1) {}
			
			try {
				// 통신이 불가능한 소켓 자원 해제
				if(socket != null && !socket.isClosed()) socket.close();
			} catch (IOException e1) {}
			
			// 연결 수락한 통신 가능한 client 목록에서 제거
			ServerExample.clients.remove(this);
			
		} // end catch
	} // end send
	
	/**
	 * client에서 출력된 데이터를 수신
	 * 연결된 모든 client에게 메세지 출력
	 */
	public void receive() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// 반복 하면서 client 에서 출력된 데이터를 수신받아 모든 클라이언트에 출력
				while(true) {
					InputStream is = null;
					byte[] bytes = new byte[100];
					try {
						is = socket.getInputStream();
						int readCount = is.read(bytes);
						String message = new String(bytes,0,readCount);
						// 발신자 정보 ip:port
						String sender = socket.getInetAddress().getHostAddress()+":"+socket.getPort();
						message = sender +" : "+message;
						
						// server에 연결된 모든 client에 메세지 출력
						for(Client c : ServerExample.clients) {
							c.send(message);
						}
					} catch (IOException e) {
						System.out.println("Client - 통신 안됨");
						
						try {
							if(is != null) is.close();
						} catch (IOException e1) {}
						
						try {
							if(socket.isClosed()) socket.close();
						} catch (IOException e1) {}
						
						// 연결된 클라이언트 목록에서 제거
						ServerExample.clients.remove(Client.this);
						
						break; // while 종료
					} // end catch
				} // end while
			}
		});
		t.start();
		
	} // end receive
	
}












