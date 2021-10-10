package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.modal.Product;
import com.simplilearn.modal.ProductParts;

public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductDetails() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernates.cfg.xml").build();
		Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		System.out.println("Hibernate Session opened!");

		String hibernateQuery = "select _p from Product _p";
		// from Object{name, price, etc..} -> Product{name, price}
		List<Product> productList = session.createQuery(hibernateQuery, Product.class).getResultList();

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for (Product eachProduct : productList) {
			out.println("<br>Id :- " + eachProduct.getId() + ", Name :-" + eachProduct.getName() + ", Price:- "
					+ eachProduct.getPrice() + ", Date added:- " + eachProduct.getDateAdded());

			out.println("<br><b>Component Mapping</b><br>");
			ProductParts parts = eachProduct.getParts();
			out.println("Parts:- " + parts.getCpu() + ", " + parts.getHdd() + ", " + parts.getRam());
			out.println("<hr>");
		}
		out.println("</body></html>");
		session.close();
		System.out.println("Hibernate Session closed!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
