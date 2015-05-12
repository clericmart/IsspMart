package ua.web.martynenko.film;

import java.util.HashMap;
import java.util.Map;

public class FilmCollection implements Action{
	public static Map<String, Film> map = new HashMap<String,Film>();

	@Override
	public String run(Map<String, String[]> m) {
		String films = "";
		for (Map.Entry<String, Film> film : map.entrySet()) {
			 films += film.getValue() + "\n";
		}
		return films;
	}
}
