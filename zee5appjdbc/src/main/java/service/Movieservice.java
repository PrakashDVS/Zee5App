package service;

import dto.Movie;
import lombok.Data;
import repository.Movierepo;

@Data

public class Movieservice {
	private Movierepo repository = Movierepo.getInstance();
	private static Movieservice service = null;		
	
	public static Movieservice getInstance() {
		if(service == null)
			service = new Movieservice();
		return service;
	}
	
	public String addMovie(Movie movie) {
		return this.repository.addMovie(movie);
	}
	
	public Movie getMovieById(String id) {
		return this.repository.getMovieById(id);
	}
	
	public Movie[] getAllMovies() {
		return repository.getAllMovie();
	}

}