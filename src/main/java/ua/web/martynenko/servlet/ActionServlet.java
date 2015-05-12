package ua.web.martynenko.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.web.martynenko.film.*;


public class ActionServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7215842240185017797L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String, String[]> params = req.getParameterMap();
		String action = req.getParameter("action");
		Map<String, Action> map = new HashMap<String, Action>();
		map.put("addfilm", new AddFilm());
		map.put("deletefilm", new DeleteFilm());
		map.put("sortfilm", new SortFilm());
		map.put("collectionfilm", new FilmCollection());
		for (Map.Entry<String, Action> a : map.entrySet()) {
			if (a.getKey().equals(action)) resp.getWriter().print(a.getValue().run(params));
		}
	}
}
