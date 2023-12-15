package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionExample {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class 존재");
			
			// java.sql.Connection
			// 1번 방법
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306?user=root&password=1234"
			);
			System.out.println(conn);
			conn.close();
			
			// 2번 방법 
			conn =  DriverManager.getConnection(
				"jdbc:mysql://localhost:3306",
				"root",
				"1234"
			);
			System.out.println(conn);
			conn.close();
			
			// 3번 방법 - Properties 객체 사용
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "1234");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",prop);
			System.out.println(conn);
			conn.close();
			
			// 4. properties file 활용
			File file = new File("prop/mysql.properties");
			FileReader reader = new FileReader(file);
			prop = new Properties();
			prop.load(reader);
			
			System.out.println(prop);
			
			String url = prop.getProperty("url");
			System.out.println(url);
			
			conn = DriverManager.getConnection(url,prop);
			System.out.println(conn);
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}















