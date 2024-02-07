package com.bitc.db_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MySQLConnectorTest {
	
	@Test
	public void testConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/develop_jsp",
				"developer",
				"12345"
			);
			System.out.println("DB ���� �Ϸ� : "+conn);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class ã�� �� ����.");
		} catch (SQLException e) {
			System.out.println("DB ���� ���� ���� : " + e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
	
}






