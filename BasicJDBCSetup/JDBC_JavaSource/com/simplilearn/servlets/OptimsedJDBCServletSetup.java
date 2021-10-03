package com.simplilearn.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OptimsedJDBCServletSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OptimsedJDBCServletSetup() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			InputStream inStream = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties properties = new Properties();
			properties.load(inStream);

			String dbURL = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String driverClass = properties.getProperty("driver");

			DatabaseConnection databaseConnection = new DatabaseConnection(dbURL, username, password, driverClass);

			Statement statement = databaseConnection.getDbConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employees");

			PrintWriter out = response.getWriter();
			while (resultSet.next()) {
				String employeeUsername = resultSet.getString(2);
				String email = resultSet.getString(4);
				String country = resultSet.getString(5);
				out.println("<br><br>Username:- " + employeeUsername + " Email :-" + email + " Country :-" + country);
			}
			databaseConnection.closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
