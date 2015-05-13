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

public class LoginXMLServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7555055307101758835L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("password");
		String temp = "";
		String loginxml = "";
		String passxml = "";
		
		File inputFile = new File("/user.xml");
	       
        try {
        	Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
			NodeList n = doc.getElementsByTagName("user");
			for (int i = 0; i < n.getLength(); i++) {
				loginxml = n.item(i).getChildNodes().item(1).getTextContent();
				passxml = n.item(i).getChildNodes().item(3).getTextContent();
				if (login.equals(loginxml) && pass.equals(passxml)) temp = login;
			}	
		} catch (SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		}
        
		if (!temp.equals("")) resp.getWriter().print("Welcome " + login);
		else resp.sendRedirect("login.html");
		
		
	}
}
