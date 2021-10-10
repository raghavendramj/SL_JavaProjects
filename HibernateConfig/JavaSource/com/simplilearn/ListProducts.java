package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.modal.Product;
import com.simplilearn.util.HibernateUtil;

public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListProducts() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			// using HQL
			List<Product> productList = session.createQuery("select _product from Product _product").getResultList();
			session.close();

			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>Product Listing</b><br>");

			for (Product eachProduct : productList) {
				out.println("ID: " + String.valueOf(eachProduct.getId()) + ", Name: " + eachProduct.getName()
						+ ", Price: " + String.valueOf(eachProduct.getPrice()) + ", Date Added: "
						+ String.valueOf(eachProduct.getDate_added()) + "<br>");
			}

			out.println("</body></html>");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
