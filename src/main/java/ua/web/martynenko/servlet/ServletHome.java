package ua.web.martynenko.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class ServletHome extends HttpServlet {
	private int count;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		if (login == null || password == null) response.sendError(500, "Go OUT!!!!!!!!!!");
		try(PrintWriter out = response.getWriter()) {
			if (!login.equals("") && !password.equals("")) out.print("<h1>Welcome</h1>");
			else if (!login.equals("") || !password.equals("")) out.print("<h1>Uncorrect smth</h1>");
			else out.print("<h1>Enter your login and password</h1>");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}