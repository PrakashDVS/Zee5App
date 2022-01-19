package service.impl;

import dto.Movie;
import service.MovieService2;

public class MovieServiceimpl implements MovieService2 {

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}
private static  MovieService2 service;
public  static MovieService2 getInstance() {
	if(service==null) {
		service = new MovieServiceimpl();
	}
	return service;
	
}
	@Override
	public String updateMovie(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie getMovieById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] getAllMovie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovieById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
