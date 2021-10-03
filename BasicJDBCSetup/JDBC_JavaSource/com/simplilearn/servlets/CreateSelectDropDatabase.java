package com.simplilearn.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateSelectDropDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateSelectDropDatabase() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			InputStream inStream = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties properties = new Properties();
			properties.load(inStream);

			String dbURL = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String driverClass = properties.getProperty("driver");

			DatabaseConnection databaseConnection = new DatabaseConnection(dbURL, username, password, driverClass);

			String databaseName = request.getParameter("databaseName");
			String operation = request.getParameter("operation");

			Statement statement = databaseConnection.getDbConnection().createStatement();
			String query = "";
			PrintWriter out = response.getWriter();
			if ("create".equalsIgnoreCase(operation)) {
				query = "create database " + databaseName; // query
				int status = statement.executeUpdate(query); // db execution
				out.print("<br>Database " + databaseName + " created successfully! -- Status :- " + status); // browser
																												// output
			} else if ("drop".equalsIgnoreCase(operation)) {
				query = "drop database " + databaseName;
				int status = statement.executeUpdate(query);
				out.print("<br>Database " + databaseName + " dropped successfully! -- Status :- " + status);
			} else if ("use".equalsIgnoreCase(operation)) {
				query = "use " + databaseName;
				int status = statement.executeUpdate(query);
				out.print("<br>Using database " + databaseName + "-- Status :- " + status);
			} else if ("all".equalsIgnoreCase(operation)) {
				query = "create database " + databaseName;
				int status = statement.executeUpdate(query);
				out.print("<br>Database " + databaseName + " created successfully! -- Status :- " + status);

				query = "use " + databaseName;
				status = statement.executeUpdate(query);
				out.print("<br>Using database " + databaseName + "-- Status :- " + status);

				query = "drop database " + databaseName;
				status = statement.executeUpdate(query);
				out.print("<br>Database " + databaseName + " dropped successfully! -- Status :- " + status);
			}

			databaseConnection.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
