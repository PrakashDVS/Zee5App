package com.zee.zee5app.service.impl;

import java.io.IOException;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
//import com.zee.zee5app.repository.MovieRepo2;
import com.zee.zee5app.repository.MovieRepository;
//import com.zee.zee5app.repository.impl.MovieRepoimpl;
import com.zee.zee5app.service.MovieService2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceimpl implements MovieService2 {
	@Autowired
	private  MovieRepository movieRepository;

	@Override
	public Movie addMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie movies = movieRepository.save(movie);
		if (movies != null) {
			return movies;
		} else {
			return null;
		}
	}

	@Override
	public String deleteMovie(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional;
		try {
			optional = this.getMovieById(id);
			if (optional.isEmpty()) {
				throw new IdNotFoundException("id not found!");
			} else {
				movieRepository.deleteById(id);
				return "success";
			}
		} catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<Movie> getMovieById(Long id)
			throws IdNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return movieRepository.findById(id);
	}

	@Override
	public Optional<Movie> getMovieByName(String name)
			throws NameNotFoundException, LocationNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public Optional<List<Movie>> getAllMovie() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
	}

	@Override
	public String updateMovie(Long id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}