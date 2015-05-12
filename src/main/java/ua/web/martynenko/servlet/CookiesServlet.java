package ua.web.martynenko.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 287705174579194749L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		resp.getWriter().println("Cookies count is " + cookies.length);
		for (int i = 0; i < cookies.length; i++) {
			resp.getWriter().println(cookies[i].getName());
			resp.getWriter().println(cookies[i].getValue());
			resp.getWriter().println(cookies[i].getDomain());
			resp.getWriter().println(cookies[i].getPath());
			resp.getWriter().println(cookies[i].getComment());
			resp.getWriter().println(cookies[i].getMaxAge());
			resp.getWriter().println(cookies[i].getSecure());
			resp.getWriter().println(cookies[i].getVersion());
			resp.getWriter().println(cookies[i].isHttpOnly());	
		}
		Cookie cookie = new Cookie("issp-cookie", new Date().toString());
		cookie.setComment("Bla-bla");
//		cookie.setHttpOnly(true);
		resp.getWriter().print(cookie.getComment());
		resp.addCookie(cookie);
	}
}
