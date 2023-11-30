package c6_queue;

import java.util.LinkedList;
import java.util.Queue;

class Message{
	
	String order;	// 명령
	String to;		// 받은이
	
	public Message(String order, String to) {
		super();
		this.order = order;
		this.to = to;
	}

	@Override
	public String toString() {
		return "Message [order=" + order + ", to=" + to + "]";
	}
	
	
}

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<>();
		messageQueue.offer(new Message("sendMail","최기근"));
		messageQueue.offer(new Message("sendSMS","박보영"));
		messageQueue.offer(new Message("sendKaKaoTalk","조정석"));
		System.out.println(messageQueue.size());
		
		Message peekMessage = messageQueue.peek();
		System.out.println(peekMessage);
		System.out.println(messageQueue.size());
		
		while(!messageQueue.isEmpty()) {
			Message m = messageQueue.poll();	// Queue에서 수행할 작업을 꺼내온다.
			System.out.println(m);
			switch(m.order) {
			case "sendMail" :
				System.out.println(m.to+"님에게 메일을 전송합니다");
				break;
			case "sendSMS" :
				System.out.println(m.to+"님에게 문자를 전송합니다");
				break;
			case "sendKaKaoTalk" :
				System.out.println(m.to+"님에게 톡을 보냅니다");
				break;
			} 
		} // end while
		System.out.println(messageQueue.size());
	}

}
