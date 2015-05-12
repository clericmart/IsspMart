package ua.web.martynenko.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3830300220586600643L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String login;
		String password;
		Cookie cookie;
		HttpSession session = req.getSession();
		if (req.getCookies() != null) {
			login = req.getParameter("login");
			password = req.getParameter("password");
			if (login == null || password == null) resp.sendError(500, "Go OUT!!!!!!!!!!");
			try(PrintWriter out = resp.getWriter()) {
				if (!login.equals("") && !password.equals("")) {
					out.print("<h1>" + "Welcome " + req.getParameter("login") + session.getId() + "</h1>");
				}
				else if (!login.equals("") || !password.equals("")) out.print("<h1>Incorrect smth</h1>");
				else out.print("<h1>Enter your login and password</h1>");
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			cookie = new Cookie("issp-cookie", req.getParameter("login"));
			resp.addCookie(cookie);
			resp.sendRedirect("index.html");
		}
//		if (session.isNew()) {
//			session.getAttribute(req.getParameter("login"));
//			session.setMaxInactiveInterval(10);
//			resp.sendRedirect("addfilm.html");
//			resp.getWriter().print(req.getParameter("login"));
			
//		}
//		else resp.sendRedirect("login.html");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().print("Method Get is unavalible");
	}

}
