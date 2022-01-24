package repository;

import java.util.List;
import java.util.Optional;

import dto.Movie;
import exception.IdNotFoundException;

public interface MovieRepo2 {
	public String addMovie(Movie movie);
	public String deleteMovie(String id) throws IdNotFoundException;
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException;
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException;
	public List<Movie> getAllMovie();
}
