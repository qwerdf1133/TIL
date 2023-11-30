package c3_map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("key", "value");
		prop.put("score", 10);
		System.out.println(prop);
		prop.clear();
		
		prop.setProperty("key", "key value");
		String value = prop.getProperty("key");
		System.out.println("value : " + value);
		value = prop.getProperty("최기근", "키 없음");
		System.out.println("value : " + value);
		
		System.out.println("===========================");
		
		// 경고 warning
		String path = 
		PropertiesExample.class.getResource("db.properties").getPath();
		System.out.println(path);
		
		Properties prop2 = new Properties();
		
		try {
			prop2.load(new FileReader(path));
			
			String userName = prop2.getProperty("username");
			String password = prop2.getProperty("password");
			
			System.out.println("userName : " + userName);
			System.out.println("password : " + password);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
