package ua.web.martynenko.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3821426662685460851L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		try (PrintWriter out = resp.getWriter()){
		out.print("Session ID is: " + session.getId());
		out.print("Session time is: " + session.getMaxInactiveInterval());
		session.setMaxInactiveInterval(5);
//		out.print("Session ID is: " + session.getId());
		} catch (Exception e) {
		}
	}
}
