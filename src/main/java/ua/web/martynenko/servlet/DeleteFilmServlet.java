package ua.web.martynenko.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.web.martynenko.film.Film;

public class DeleteFilmServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2015409985088946445L;
	@SuppressWarnings({ "unchecked" })
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		PrintWriter out = resp.getWriter();
		try {

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet CheckAttributeServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Delete film by title</h3>");
				

			HttpSession session = req.getSession(false);

			Object attr = session.getAttribute("films");

			if (attr instanceof HashMap){
				Film a;
				HashMap<String, Film> map = (HashMap<String, Film>) attr;
				a = map.remove(title);
				if (a.getTitle().equals(title)) out.print("Succes");
			}
			}catch (Exception e) {
		    }finally {
		    	out.println("</body>");
		        out.println("</html>");
		        out.close();
		}
	}
}
