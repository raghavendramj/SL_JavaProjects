package com.simplilearn.servlets;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opencsv.CSVReader;

public class StoredProceduresExamples extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StoredProceduresExamples() {
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

			String storedProcedureQuery = "{call add_product(?,?,?)}";
			CallableStatement callableStatement = databaseConnection.getDbConnection()
					.prepareCall(storedProcedureQuery);

			callableStatement.setString(1, "Foam Dinner Plate");
			callableStatement.setFloat(2, 70f);
			callableStatement.setFloat(3, 1.21f);
			//callableStatement.executeUpdate();

			callableStatement.close();

			response.getWriter().println("Stored procedure has been executed.<Br>");

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
