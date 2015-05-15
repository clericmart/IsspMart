package ua.web.martynenko.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@WebServlet("name1")
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
		String templogin = "";
		String temppass = "";
		String loginxml = "";
		String passxml = "";
		String defaultPath = "/user.xml";
		
		File inputFile;
		
		String s = getInitParameter("user1");
		
		if (s == null) inputFile = new File(defaultPath);
		else inputFile = new File(s);
		
        try {
        	Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
			NodeList n = doc.getElementsByTagName("user");
			for (int i = 0; i < n.getLength(); i++) {
				loginxml = n.item(i).getChildNodes().item(1).getTextContent();
				passxml = n.item(i).getChildNodes().item(3).getTextContent();
				if (login.equals(loginxml) && pass.equals(passxml)) {templogin = login; temppass = pass;}
				else if (login.equals(loginxml) && !pass.equals(passxml)) templogin = login; 		
			}	
		} catch (SAXException | ParserConfigurationException | NullPointerException e) {
			e.printStackTrace();
		} finally {
			
		}
        
		if (!templogin.equals("") && !temppass.equals("")) resp.getWriter().print("Welcome " + login);
		else if (!templogin.equals("") && temppass.equals("")) resp.getWriter().print("Please enter correct password");
		else resp.sendRedirect("login.html");
		
		
	}
}
