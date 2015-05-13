package ua.web.martynenko.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
		
		String names = "";
		
		File inputFile = new File("D://user.xml");
	       
        try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
			NodeList n = doc.getElementsByTagName("login");
			for (int i = 0; i < n.getLength(); i++) {
				names += n.item(i).getTextContent() + " ";
			}
		} catch (SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		String adminlogin = getInitParameter("login");
		String adminPass = getInitParameter("password");
		if (login.equals(adminlogin) && pass.equals(adminPass)) resp.getWriter().print(names);
		else resp.sendRedirect("login.html");
		
		 
	}
}
