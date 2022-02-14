package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface MovieService2 {
	public Movie addMovie(Movie movie);

	public String updateMovie(Long id, Movie movie) throws IdNotFoundException;

	public String deleteMovie(Long id) throws IdNotFoundException;

	public Optional<Movie> getMovieById(Long id)
			throws IdNotFoundException, InvalidNameException, InvalidIdLengthException;

	public Optional<Movie> getMovieByName(String name)
			throws NameNotFoundException, LocationNotFoundException, InvalidNameException, InvalidIdLengthException;

	public Optional<List<Movie>> getAllMovie() ;
}
