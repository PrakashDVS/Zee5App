package repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import dto.Movie;
import exception.IdNotFoundException;
import exception.InvalidIdLengthException;
import exception.InvalidNameException;
import exception.LocationNotFoundException;
import exception.NameNotFoundException;
import repository.MovieRepo2;
import utils.DBUtils;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepoimpl implements MovieRepo2 {
private Set<Movie> set = new LinkedHashSet<>();
	DBUtils dbUtils = null;
	private MovieRepoimpl() throws IOException {
//		dbUtils = DBUtils.getInstance();
	}
	
//	private static MovieRepo2 movieRepository;
//	public static MovieRepo2 getInstance() throws IOException{
//		if(movieRepository==null)
//			movieRepository = new MovieRepoimpl();
//		return movieRepository;
//	}
	
	@Override
	public String addMovie(Movie movie) {
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;

		String insertStatetment = "insert into movie"
				+ "(id,name,ageLimit,genre,language,trailer,cast,length,releaseDate)" + "values(?,?,?,?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(insertStatetment);

			preparedStatement.setString(1, movie.getId());
			preparedStatement.setString(2, movie.getMovieName());
			preparedStatement.setInt(3, movie.getAgeLimit());
			preparedStatement.setString(4, movie.getGenre());
			preparedStatement.setString(5, movie.getLanguage());
			preparedStatement.setString(6, movie.getTrailer());
			preparedStatement.setString(7, movie.getCast());
			preparedStatement.setInt(8, movie.getLength());
			preparedStatement.setString(9, movie.getReleaseDate());

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}

	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;
		String deleteStatetment = "delete from movie where id=?";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(deleteStatetment);
			preparedStatement.setString(1, id);

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {

			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Optional<Movie> optional = this.getMovieById(id);
		if(optional.isPresent()) {
			boolean result = set.remove(optional.get());
			set.add(movie);
			if(result) {
				return null;
			}
			
		}
		return null;
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from movies where id=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Movie Movie = new Movie();
				Movie.setId(resultSet.getString("id"));
				Movie.setMovieName(resultSet.getString("name"));
				Movie.setAgeLimit(resultSet.getInt("ageLimit"));
				Movie.setGenre(resultSet.getString("genre"));
				Movie.setLanguage(resultSet.getString("language"));
				Movie.setTrailer(resultSet.getString("trailer"));
				Movie.setCast(resultSet.getString("cast"));
				Movie.setLength(resultSet.getInt("length"));
				Movie.setReleaseDate(resultSet.getString("releaseDate"));
				return Optional.of(Movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public Optional<ArrayList<Movie>> getAllMovie() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Movie> arrayList = new ArrayList<>();
		String selectStatement = "select * from movies";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Movie Movie = new Movie();
				Movie.setId(resultSet.getString("id"));
				Movie.setMovieName(resultSet.getString("name"));
				Movie.setAgeLimit(resultSet.getInt("ageLimit"));
				Movie.setGenre(resultSet.getString("genre"));
				Movie.setLanguage(resultSet.getString("language"));
				Movie.setTrailer(resultSet.getString("trailer"));
				Movie.setCast(resultSet.getString("cast"));
				Movie.setLength(resultSet.getInt("length"));
				Movie.setReleaseDate(resultSet.getString("releaseDate"));
				arrayList.add(Movie);
			}
			return Optional.ofNullable(arrayList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	

	@Override
	public Optional<Movie> getMovieByName(String name)
			throws NameNotFoundException, InvalidIdLengthException, InvalidNameException {
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from movies where id=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, name);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Movie Movie = new Movie();
				Movie.setId(resultSet.getString("id"));
				Movie.setMovieName(resultSet.getString("name"));
				Movie.setAgeLimit(resultSet.getInt("ageLimit"));
				Movie.setGenre(resultSet.getString("genre"));
				Movie.setLanguage(resultSet.getString("language"));
				Movie.setTrailer(resultSet.getString("trailer"));
				Movie.setCast(resultSet.getString("cast"));
				Movie.setLength(resultSet.getInt("length"));
				Movie.setReleaseDate(resultSet.getString("releaseDate"));
				return Optional.of(Movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public String watchMovie(String moviename) throws NameNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}	
	
//	private Movie[] movies = new Movie[10];
//	private static int count = -1;
//	
//	private static MovieRepository movieRepository;
//	public static MovieRepository getInstance() {
//		if(movieRepository==null)
//			movieRepository = new MovieRepositoryImpl();
//		return movieRepository;
//	}
//	
//	private MovieRepositoryImpl() {
//		
//	}
//	
//	@Override
//	public String addMovie(Movie movie) {
//		// TODO Auto-generated method stub
//		if(count == movies.length-1) {
//			Movie temp[] = new Movie[movies.length*4];
//			System.arraycopy(movie, 0, temp, 0, movies.length);
//			movies = temp;
//			movies[++count] = movie;
//			return "Success2";	
//		}
//		movies[++count] = movie;
//		return "Success2";
//	}
//
//	@Override
//	public String deleteMovie(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String modifyMovie(String id, Movie movie) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Movie getMovieById(String id) {
//		// TODO Auto-generated method stub
//		for (Movie movie : movies) {
//			if(movie!=null && movie.getId().equals(id))
//				return movie;	
//		}
//		return null;
//	}
//
//	@Override
//	public Movie[] getAllMovie() {
//		// TODO Auto-generated method stub
//		return movies;
//	}
//
//}
