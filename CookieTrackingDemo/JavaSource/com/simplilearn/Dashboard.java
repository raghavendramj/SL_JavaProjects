package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Dashboard() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = null;
		boolean foundUserId = false;

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");

		cookies = request.getCookies();
		for (Cookie eachCookie : cookies) {
			if (eachCookie.getName().contentEquals("userId") && eachCookie.getValue() != null) {
				out.println("UserId read from cookie:- " + eachCookie.getValue() + "<br>");
				foundUserId = true;
			}
		}

		if (!foundUserId) {
			out.println("No UserId cookie was present!...<br>");
			response.sendRedirect("sessionError");
		}
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
