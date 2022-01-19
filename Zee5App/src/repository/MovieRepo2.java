package repository;

import dto.Movie;

public interface MovieRepo2 {
	public String addMovie(Movie movie);
	public String updateMovie(String id);
	public Movie getMovie(String id);
	public Movie[] getAllMovie();
	public String deleteMovie(String id);
}
