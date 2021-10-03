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

public class InitialzeDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InitialzeDatabase() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			InputStream inStream = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties properties = new Properties();
			properties.load(inStream);

			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String driver = properties.getProperty("driver");

			// Step 1: Register your JDBC Driver.
			Class.forName(driver);

			// Step 2: Getting the connection
			Connection connection = DriverManager.getConnection(url, username, password);

			String completeString = "jdbc:mysql://localhost:3306/employeedb?user=root&password=admin@123";
			Connection connection2 = DriverManager.getConnection(completeString);

			// Step 3: Get the Statement Object
			Statement statement = connection.createStatement();

			// Step 4: Create the query and execute it and Extract the results..
			String sqlQuery = "select * from employees";
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			PrintWriter out = response.getWriter();
			out.print(
					"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
			out.print("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
			out.print("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");

			out.print("<div class='container'>");
			out.print("<h1> List of Employees:<h1>");
			out.print("<table class='table'>");
			out.print("<thead>");
			out.print("<tr>");
			out.print("<th>Username </th>");
			out.print("<th>Email </th>");
			out.print("<th>Country </th>");
			out.print("</tr>");
			out.print("</thead>");
			out.print("<tbody>");
			while (resultSet.next()) {
				String employeeUsername = resultSet.getString(2);
				String email = resultSet.getString(4);
				String country = resultSet.getString(5);
				// out.println("<br><br>Username:- " + employeeUsername + " Email :-" + email +
				// " Country :-" + country);

				out.print("<tr>");
				out.print("<td>" + employeeUsername + " </td>");
				out.print("<td>" + email + " </td>");
				out.print("<td>" + country + " </td>");
				out.print("</tr>");
			}
			out.print("</tbody>");
			out.print("</table>");
			out.print("<div>");

			// Step 5: Close the connection.
			connection.close();
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
