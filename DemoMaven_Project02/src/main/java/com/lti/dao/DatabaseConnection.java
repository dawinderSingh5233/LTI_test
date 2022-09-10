package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;

public class DatabaseConnection {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String username = "system";
			String password = "orcl";

			conn = DriverManager.getConnection(url, username, password);

			if (conn != null)
				System.out.println("Connected!");
		} catch (Exception e) {

		}
		return conn;
	}

	public static void main(String[] args) {
		getConnection();
	}
}
