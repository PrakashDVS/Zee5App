package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dto.Movie;
import exception.IdNotFoundException;
import exception.InvalidIdLengthException;
import exception.InvalidNameException;
import exception.LocationNotFoundException;
import exception.NameNotFoundException;

public interface MovieService2 {
	public String addMovie(Movie movie);
	public String deleteMovie(String id) throws IdNotFoundException;
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;
	public Optional<Movie> getMovieByName(String name)
			throws NameNotFoundException, LocationNotFoundException, InvalidNameException, InvalidIdLengthException;
	public Optional<ArrayList<Movie>> getAllMovie() throws InvalidIdLengthException, InvalidNameException;
}
