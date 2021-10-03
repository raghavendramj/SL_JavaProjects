package com.simplilearn.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServletyts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServletyts() {
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

			// Check whether the product exist or not.
			PreparedStatement preparedStatement = databaseConnection.getDbConnection()
					.prepareStatement("select * from products where id=?");
			String prodId = request.getParameter("product_id");
			preparedStatement.setString(1, prodId);
			ResultSet resultSet = preparedStatement.executeQuery();

			PrintWriter out = response.getWriter();

			boolean hasProduct = false;
			while (resultSet.next()) {
				hasProduct = true;
				int produtId = resultSet.getInt(0);
				String product_name = resultSet.getString(1);
				int quantity_in_stock = resultSet.getInt(2);
				int unit_price = resultSet.getInt(3);
				out.println("The product details are...");
				out.println("produtId :- " + produtId);
				out.println("product_name :- " + product_name);
				out.println("quantity_in_stock :- " + quantity_in_stock);
				out.println("unit_price :- " + unit_price);
			}

			if (!hasProduct) {
				out.println("There is no such product with id: -" + prodId);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
