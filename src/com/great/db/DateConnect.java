package com.great.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateConnect {
	
	public static Connection getConnect(){
		Connection conn=null;
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL",
					"AF1509", "oracle");
			System.out.println("connect success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}

}
