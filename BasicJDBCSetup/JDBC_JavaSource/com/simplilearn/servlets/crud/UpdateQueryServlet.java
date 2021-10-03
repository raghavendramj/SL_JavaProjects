package com.simplilearn.servlets.crud;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.servlets.DatabaseConnection;

public class UpdateQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateQueryServlet() {
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
			String updateQuery = "update employees set username=? where id=?;";

			Connection connection = databaseConnection.getDbConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			preparedStatement.setString(1, request.getParameter("username"));
			preparedStatement.setString(2, request.getParameter("id"));

			int result = preparedStatement.executeUpdate();

			PrintWriter out = response.getWriter();
			out.println("<br><br>Query Status :- " + result);
			databaseConnection.closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
