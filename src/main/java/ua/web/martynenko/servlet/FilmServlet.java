package ua.web.martynenko.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.web.martynenko.film.Film;

public class FilmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3678156944953369188L;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		try {

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet CheckAttributeServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Films list</h3>");
				

			HttpSession session = req.getSession(false);

			Object attr = session.getAttribute("films");

			if (attr instanceof HashMap){
				HashMap<String, Film> map = (HashMap<String, Film>) attr;
				List entryList = new ArrayList(map.values());
				    
				for (Object object : entryList) {
					out.println("<h3>" + object + "</h3>");
				}
		                
				}else
					out.println("<h1>Operation not found</h1>");
				}catch (Exception e) {
		        }finally {
		        
		            out.println("</body>");
		            out.println("</html>");
		            out.close();
		}
	}
}


