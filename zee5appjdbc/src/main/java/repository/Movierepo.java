package repository;

import dto.Movie;
import dto.Subscription;
import lombok.Data;
@Data
public class Movierepo {
	private Movie[] movies = new Movie[10];
	private static int count = -1;
	
	private static Movierepo movieRepository;
	public static Movierepo getInstance() {
		if(movieRepository==null)
			movieRepository = new Movierepo();
		return movieRepository;
	}
	
	public String addMovie(Movie movie) {
		
		if(count == movies.length-1) {
			Movie temp[] = new Movie[movies.length*4];
			System.arraycopy(movie, 0, temp, 0, movies.length);
			movies = temp;
			movies[++count] = movie;
			return "Success2";	
		}
		movies[++count] = movie;
		return "Success2";			
	}
	
	public String deleteMovie(String id) {
		return null;
	}
	
	public String modifyMovie(String id, Movie movie) {
		return null;
	}
	
	public Movie getMovieById(String id) {
		for (Movie movie : movies) {
			if(movie!=null && movie.getId().equals(id))
				return movie;	
		}
		return null;
	}
	
	public Movie[] getAllMovie() {
		return movies;
	}
	
	
}

