package servlet_basics;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/PostHandler")
public class PostHandler extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public PostHandler() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletConfig servletConfig = getServletConfig();
        String driver = servletConfig.getInitParameter("DriverInformation");

        Enumeration initParameterNames = servletConfig.getInitParameterNames();
        Map<String, String> initParamsMap = new HashMap<String, String>();
        while (initParameterNames.hasMoreElements()) { // will iterate through only keys..
            String initParamKey = (String) initParameterNames.nextElement();
            String initParamValue = servletConfig.getInitParameter(initParamKey);
            initParamsMap.put(initParamKey, initParamValue);
        }
        System.out.println("Current Init Param Key and Values are... " + initParamsMap);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        String name = request.getParameter("name");
        String address = request.getParameter("address");


        Enumeration parameterNames = request.getParameterNames();
        Map<String, String> requestParamsMap = new HashMap<String, String>();

        while (parameterNames.hasMoreElements()) {

            String requestKey = (String) parameterNames.nextElement();
            String parameterValue = request.getParameter(requestKey);
            requestParamsMap.put(requestKey, parameterValue);
        }

        out.println("Name=" + name + "<br>Address=" + address
                + "<br> initParamsMap is =" + initParamsMap
                + "<br> requestParamsMap is =" + requestParamsMap);
        out.println("</body></html>");
    }
}