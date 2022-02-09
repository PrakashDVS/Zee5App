package com.zee.zee5app.service.impl;

import java.io.IOException;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
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
//	private static MovieService2 movieService;
	@Autowired
	private MovieRepository movieRepository;

//	private MovieServiceimpl() throws IOException {
//		movieRepository = MovieRepoimpl.getInstance();
//	}
//
//	public static MovieService2 getInstance() throws IOException {
//		if (movieService == null)
//			movieService = new MovieServiceimpl();
//		return movieService;
//	}
	@Override
	public Movie addMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie movie2 = movieRepository.save(movie);
		// TODO Auto-generated method stub
		if(movie2 != null) {
			return movie2;
		}
		else {
			return null;
		}
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		try {
			Optional<Movie> optional = this.getMovieById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				movieRepository.deleteById(id);
				return "success";
			}
		}catch(InvalidNameException | IdNotFoundException | InvalidIdLengthException e) {
			e.printStackTrace();
			throw new IdNotFoundException(e.getLocalizedMessage());
		}
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return movieRepository.findById(id);
	}

	@Override
	public Optional<List<Movie>> getAllMovie() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
	}

	@Override
	public Optional<Movie> getMovieByName(String name)
			throws NameNotFoundException, LocationNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return movieRepository.findById(name);
	}
    
    
	
//	@Override
//	public String addMovie(Movie movie) {
//		// TODO Auto-generated method stub
//		return this.repository.addMovie(movie);
//	}
//
//	@Override
//	public Movie getMovieById(String id) {
//		// TODO Auto-generated method stub
//		return this.repository.getMovieById(id);
//	}
//
//	@Override
//	public Movie[] getAllMovies() {
//		// TODO Auto-generated method stub
//		return repository.getAllMovie();
//	}

}