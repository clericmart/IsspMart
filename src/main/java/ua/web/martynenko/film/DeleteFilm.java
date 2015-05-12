package ua.web.martynenko.film;

import java.util.Map;

public class DeleteFilm implements Action {

	@Override
	public String run(Map<String, String[]> e) {
		Film f = FilmCollection.map.remove(e.get("title")[0]);
		if (f == null) return "There is no such film in collection";
		else return "Film delete " + f;
	}

}
