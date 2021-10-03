package com.simplilearn.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private Connection dbConnection;

	public Connection getDbConnection() {
		return dbConnection;
	}

	public DatabaseConnection(String dbURL, String username, String password, String driverClass) {
		initialzeConnection(dbURL, username, password, driverClass);
	}

	private void initialzeConnection(String dbURL, String username, String password, String driverClass) {

		try {
			// Step 1: Register your JDBC Driver.
			Class.forName(driverClass);

			// Step 2: Getting the connection
			Connection connection = DriverManager.getConnection(dbURL, username, password);

			this.dbConnection = connection;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public void closeConnection() {
		if (this.dbConnection != null) {
			try {
				this.dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
