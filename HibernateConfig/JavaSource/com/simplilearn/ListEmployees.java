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

import com.simplilearn.modal.Employee;
import com.simplilearn.util.HibernateUtil;

public class ListEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListEmployees() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			// using HQL
			List<Employee> employeesList = session.createQuery("select _employee from Employee _employee").getResultList();
			session.close();

			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>Product Listing</b><br>");

			for (Employee employee : employeesList) {
				out.println("ID: " + String.valueOf(employee.getId()) + ", Name: " + employee.getUsername()
						+ ", Email: " + employee.getEmail() + ", Country: " + employee.getCountry() + "<br>");
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
