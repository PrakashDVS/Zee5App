package repository.impl;

import dto.Movie;
import repository.MovieRepo2;

public class MovieRepoimpl implements MovieRepo2 {
private MovieRepoimpl() {
    	
    }
    private static MovieRepo2 repository;
    public static MovieRepo2 getInstance() {
    	if(repository==null) {
    		repository=new MovieRepoimpl();
    	}
    	return repository;

}
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateMovie(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Movie getMovie(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Movie[] getAllMovie() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteMovie(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
