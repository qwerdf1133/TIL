package f07_data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamExample {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fos = new FileOutputStream("primitive.txt");
			// 기본 타입 8가지 + String
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeUTF("최기근"); // 문자열 출력
			dos.writeDouble(99.9); 
			dos.writeInt(100);
			dos.writeChar('A');
			dos.writeBoolean(true);
			
			dos.writeUTF("홍길동");
			dos.writeDouble(69.9);
			dos.writeInt(67);
			dos.writeChar('B');
			dos.writeBoolean(false);
			
			dos.flush();
			dos.close();
			
			
			DataInputStream dis 
				= new DataInputStream(new FileInputStream("primitive.txt"));
			String name = dis.readUTF();	
			double score = dis.readDouble();
			int order = dis.readInt();
			char grade = dis.readChar();
			boolean checked = dis.readBoolean();
			System.out.println("name : " + name);
			System.out.println("score : " + score);
			System.out.println("order : " + order);
			System.out.println("grade : " + grade);
			System.out.println("checked : " + checked);
			
			System.out.println("-------------------------------");
			
			name = dis.readUTF();	
			score = dis.readDouble();
			order = dis.readInt();
			grade = dis.readChar();
			checked = dis.readBoolean();
			System.out.println("name : " + name);
			System.out.println("score : " + score);
			System.out.println("order : " + order);
			System.out.println("grade : " + grade);
			System.out.println("checked : " + checked);
			
			
			dis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}














