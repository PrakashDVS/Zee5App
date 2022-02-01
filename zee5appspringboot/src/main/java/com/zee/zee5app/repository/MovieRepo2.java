package com.zee.zee5app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface MovieRepo2 {
	public String addMovie(Movie movie);
	public String deleteMovie(String id) throws IdNotFoundException;
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;

	public Optional<Movie> getMovieByName(String name) throws NameNotFoundException, InvalidIdLengthException, InvalidNameException;
	
	public String watchMovie(String moviename) throws NameNotFoundException, LocationNotFoundException;
	public Optional<ArrayList<Movie>> getAllMovie() throws InvalidIdLengthException, InvalidNameException;
}