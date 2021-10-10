package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.util.HibernateUtil;

public class InitializeHibernates extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InitializeHibernates() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");

			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			out.println("Hibernate Session opened.<br>");
			session.close();
			out.println("Hibernate Session closed.<br>");
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
