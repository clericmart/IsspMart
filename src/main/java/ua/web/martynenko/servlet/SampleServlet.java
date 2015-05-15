package ua.web.martynenko.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet(name = "Sample", 
			asyncSupported = true, 
			urlPatterns = { "/SampleServlet" },
			loadOnStartup = 0,
			initParams = {
						@WebInitParam(name = "n", value="a"),
						@WebInitParam(name = "n2", value="a2")
						})
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		Enumeration<String> parametrNames = getInitParameterNames();
		String name;
		String value;
		Configuration config = Configuration.getInstance();
		while (parametrNames.hasMoreElements()) {
			name = (String) parametrNames.nextElement();
			value = getInitParameter(name);
			config.setParameter(name, value);
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Sample");
		
	}

}
