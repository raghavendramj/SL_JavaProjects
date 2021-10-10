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

import com.simplilearn.modal.Color;
import com.simplilearn.modal.OS;
import com.simplilearn.modal.Product;

public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListProducts() {
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

		List<String> productNames = productList.stream().map(eachProduct -> eachProduct.getName())
				.collect(Collectors.toList());

		System.out.println(" List of prodcuts are.. " + productNames);

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for (Product eachProduct : productList) {
			out.println("<br>Id :- " + eachProduct.getId() + ", Name :-" + eachProduct.getName() + ", Price:- "
					+ eachProduct.getPrice() + ", Date added:- " + eachProduct.getDate_added());

			out.println("Colors ... ");
			List<Color> colors = eachProduct.getColors();
			out.println(colors.stream().map(eachColor -> eachColor.getName()).collect(Collectors.toList()));

			out.println("Operating Systems ... ");
			Set<OS> operatingSystems = eachProduct.getOS();
			out.println(operatingSystems.stream().map(os -> os.getName()).collect(Collectors.toList()));
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
