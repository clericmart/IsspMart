package ua.web.martynenko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("password");
		String adminlogin = getInitParameter("login");
		String adminPass = getInitParameter("password");
		if (login.equals(adminlogin) && pass.equals(adminPass)) resp.getWriter().print("OK");
		else resp.sendRedirect("login.html");
		
	}
}
