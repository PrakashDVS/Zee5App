package service;

import dto.Movie;

public interface MovieService2 {
	public String addMovie(Movie movie);
	public String updateMovie(String id);
	public Movie getMovieById(String id);
	public Movie[] getAllMovie();
	public String deleteMovieById(String id);
}
