package ua.web.martynenko.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class LifeCycleServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig conf) throws ServletException {
		System.out.println("Init LifeCycleServlet");
		Enumeration<String> paramInit = conf.getInitParameterNames();
		String name;
		System.out.println("Parametrs:");
		while (paramInit.hasMoreElements()) {
			name = paramInit.nextElement();
			System.out.println("Parametr name is " + name);
			System.out.println("Parametr value is " + conf.getInitParameter(name));
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy LifeCycleServlet");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("Run Service");
	}
}
