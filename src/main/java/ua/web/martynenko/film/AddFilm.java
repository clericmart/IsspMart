package ua.web.martynenko.film;

import java.util.Map;

public class AddFilm implements Action {

	@Override
	public String run(Map<String, String[]> e) {
		Film f = new Film(	e.get("title")[0],
							e.get("description")[0], 
							Double.parseDouble(e.get("rating")[0]),
							Integer.parseInt(e.get("year")[0]),
							e.get("genres")[0], 
							e.get("country")[0], 
							Integer.parseInt(e.get("duration")[0]));
		if (FilmCollection.map.put(e.get("title")[0], f) != null) return "We have this film in collection";
		else return "Film add " + f;		
	}
}
