package ua.web.martynenko.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.web.martynenko.film.Film;

public class AddFilmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3678156944953369188L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try (PrintWriter out = resp.getWriter()){
			out.print("Get method is unavailible");
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		double rating = Double.parseDouble(req.getParameter("rating"));
		int year = Integer.parseInt(req.getParameter("year"));
		String country = req.getParameter("country");
		int duration = Integer.parseInt(req.getParameter("duration"));
		String genres = req.getParameter("genres");
		
		HttpSession session = req.getSession(true);
		
		PrintWriter out = resp.getWriter();
		
		
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet CalcServlet</title>");
			out.println("</head>");
			out.println("<body>");
		
			HashMap<String,Film> map;
			if (session.isNew()) {
				map = new HashMap<String, Film>();
			} else {
				map = (HashMap<String, Film>) session.getAttribute("films");
			}
			
			map.put(title, new Film(title, description, rating, year, genres, country, duration));
			
			session.setAttribute("films", map);
			

            out.println("<h2>ID equels: " + session.getId() + "</h2>");
            out.println("<h3>Operation list (sum:" + map.size() + ") </h3>");
            
            for (Map.Entry<String, Film> film : map.entrySet()) {
				out.println("<h3>" + film.getValue() + "</h3>");
			}
         
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.println("</body>");
            out.println("</html>");
            out.close();
		}
		
		
	}
}
