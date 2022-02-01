package com.zee.zee5app.service.impl;

import java.io.IOException;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.MovieRepo2;
import com.zee.zee5app.repository.impl.MovieRepoimpl;
import com.zee.zee5app.service.MovieService2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceimpl implements MovieService2 {
//	private static MovieService2 movieService;
	private static MovieRepo2 movieRepository;

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
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return this.movieRepository.addMovie(movie);
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.movieRepository.deleteMovie(id);
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return this.movieRepository.modifyMovie(id, movie);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return this.movieRepository.getMovieById(id);
	}

	@Override
	public Optional<ArrayList<Movie>> getAllMovie() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return this.movieRepository.getAllMovie();
	}

	@Override
	public Optional<Movie> getMovieByName(String name)
			throws NameNotFoundException, LocationNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return movieRepository.getMovieByName(name);
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