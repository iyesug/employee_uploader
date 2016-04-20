package com.great.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection
{
	private Connection connection;
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	public DBConnection()
	{
		try
		{
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public Connection getConnection()
	{
		connection = null;

		try
		{
			connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "AF1509", "oracle");
			System.out.println("connect success");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return connection;
	}

	public void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs)
	{
		try
		{

			if (rs != null)
			{
				rs.close();
			}
			if (ps != null)
			{
				ps.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
