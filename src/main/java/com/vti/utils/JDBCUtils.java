package com.vti.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

	private static Connection connection;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null || connection.isClosed()) {
			String url = "jdbc:mysql://localhost:3306/exam_testing_database?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			String username = "root";
			String password = "Superkyl2509";

			// Step 1* register the driver class with DriverManager
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: get a Database Connection

			connection = DriverManager.getConnection(url, username, password);
		}

		return connection;
	}

	public static void disconnect() throws SQLException {
		if (connection != null && connection.isClosed()) {
			connection.close();
		}
	}
}
