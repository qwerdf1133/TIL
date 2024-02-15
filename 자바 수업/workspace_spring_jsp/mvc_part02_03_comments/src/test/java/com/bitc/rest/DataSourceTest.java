package com.bitc.rest;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations= {"classpath:/spring/root-context.xml"}
)
public class DataSourceTest {
	
	@Autowired
	DataSource ds;
	
	@Test
	public void dataSourceTest() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if( conn != null) conn.close();
			} catch (SQLException e) {}
		}
	}
	
}













