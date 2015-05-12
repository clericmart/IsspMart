package ua.web.martynenko.film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SortFilm implements Action{

	@Override
	public String run(Map<String, String[]> e) {
		List<Film> entryList = new ArrayList<Film>(FilmCollection.map.values());
		Collections.sort(entryList);
		String films = "";
		for (Object object : entryList) {
			films += object + "\n";
		}
		return "Sorted films: \n" + films;
	}
	
}
