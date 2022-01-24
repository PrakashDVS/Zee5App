package service.impl;

import java.util.List;
import java.util.Optional;

import dto.Movie;
import exception.IdNotFoundException;
import repository.MovieRepo2;
import repository.impl.MovieRepoimpl;
import service.MovieService2;

public class MovieServiceimpl implements MovieService2 {
	private MovieRepo2 repository = MovieRepoimpl.getInstance();
	private static MovieService2 service;	
	
	public static MovieService2 getInstance() {
		if(service == null)
			service = new MovieServiceimpl();
		return service;
	}
	
    private MovieServiceimpl() {
		
	}

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return this.repository.addMovie(movie);
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.deleteMovie(id);
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.modifyMovie(id, movie);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.getMovieById(id);
	}

	@Override
	public List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		return this.repository.getAllMovie();
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