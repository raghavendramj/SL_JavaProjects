package servlet_basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyGenericServlet extends GenericServlet {

	public final static String serialVersionUID = "001";

	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {
		String driver = getServletConfig().getInitParameter("DriverInformation");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<b>hello generic servlet... Driver is : </b>" + driver);
		out.print("</body></html>");
	}
}
