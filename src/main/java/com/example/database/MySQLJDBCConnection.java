package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLJDBCConnection {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "InventoryDb";
		String userName = "root";
		String password = "Yy@102030";
		String dbURL = url + dbName;

		Connection connection = null;

		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Get the connection
			connection = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("Connection established successfully!");
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL JDBC Driver not found. Include it in your library path ");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Connection failed! Check output console");
			e.printStackTrace();
		}

		return connection;
	}
}
