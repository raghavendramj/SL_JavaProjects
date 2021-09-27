package servlet_basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetHandler")
public class GetHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetHandler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext servletContext = getServletContext();
		Enumeration initParameterNames = servletContext.getInitParameterNames();

		Map<String, String > contextParamsMap = new HashMap<String, String>();
		while (initParameterNames.hasMoreElements()){

			String contextParamKey = (String) initParameterNames.nextElement();
			String contextParamValue = servletContext.getInitParameter(contextParamKey);
			contextParamsMap.put(contextParamKey, contextParamValue);
		}

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		out.println("Name=" + name + "<br>Address=" + address+ "<br>contextParamsMap=" + contextParamsMap);
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}