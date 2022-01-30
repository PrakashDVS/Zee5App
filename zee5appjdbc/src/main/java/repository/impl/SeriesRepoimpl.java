package repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import dto.Series;
import exception.IdNotFoundException;
import exception.InvalidIdLengthException;
import exception.NameNotFoundException;
import repository.SeriesRepo2;
import utils.DBUtils;

public class SeriesRepoimpl implements SeriesRepo2 {
private TreeSet<Series> set = new TreeSet<>();
DBUtils dbUtils = null;

	private static SeriesRepo2 seriesrepository;
	public static SeriesRepo2 getInstance() throws IOException {
		if(seriesrepository==null)
			seriesrepository = new SeriesRepoimpl();
		return seriesrepository;
	}
	
	private SeriesRepoimpl() throws IOException {
		dbUtils = DBUtils.getInstance();
	}

	@Override
	public String addSeries(Series series) {
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;

		String insertStatetment = "insert into series"
				+ "(id,seriesName,ageLimit,cast,genre,length,releaseDate,language,noOfEpisodes)" + "values(?,?,?,?,?,?,?,?)";

// "(id,ageLimit,cast,genre,length,trailer,releaseDate,language,noOfEpisodes)" 
		try {
			preparedStatement = connection.prepareStatement(insertStatetment);

			preparedStatement.setString(1, series.getId());
			preparedStatement.setString(2, series.getSeriesName());
			preparedStatement.setInt(3, series.getAgeLimit());
			preparedStatement.setString(4, series.getCast());
			preparedStatement.setString(5, series.getGenre());
			preparedStatement.setInt(6, series.getLength());
//			preparedStatement.setString(6, series.getTrailer());
			preparedStatement.setString(7, series.getReleaseDate());
			preparedStatement.setString(8, series.getLanguage());
			preparedStatement.setInt(9, series.getNoOfEpisodes());

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
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;
		String deleteStatetment = "delete from series where id=?";
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
	public String modifySeries(String id, Series series) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Series> optional = this.getSeriesById(id);
		if(optional.isPresent()) {
			boolean result = set.remove(optional.get());
			set.add(series);
			if(result) {
				return null;
			}
			
		}
		return null;
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from series where id=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Series Series = new Series();
				Series.setId(resultSet.getString("id"));
				Series.setSeriesName(resultSet.getString("seriesName"));
				Series.setAgeLimit(resultSet.getInt("ageLimit"));
				Series.setCast(resultSet.getString("cast"));
				Series.setGenre(resultSet.getString("genre"));
				Series.setLength(resultSet.getInt("length"));
				Series.setReleaseDate(resultSet.getString("releaseDate"));
				Series.setLanguage(resultSet.getString("language"));
				Series.setNoOfEpisodes(resultSet.getInt("noOfEpisodes"));
				return Optional.of(Series);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public Optional<ArrayList<Series>> getAllSeries() throws InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Series> arrayList = new ArrayList<>();

		String selectStatement = "select * from series";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Series Series = new Series();
				Series.setId(resultSet.getString("id"));
				Series.setSeriesName(resultSet.getString("seriesName"));
				Series.setAgeLimit(resultSet.getInt("ageLimit"));
				Series.setCast(resultSet.getString("cast"));
				Series.setGenre(resultSet.getString("genre"));
				Series.setLength(resultSet.getInt("length"));
				Series.setReleaseDate(resultSet.getString("releaseDate"));
				Series.setLanguage(resultSet.getString("language"));
				Series.setNoOfEpisodes(resultSet.getInt("noOfEpisodes"));
				arrayList.add(Series);
			}
			return Optional.ofNullable(arrayList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}
	}
	
	
	
	
//	@Override
//	public String addSeries(Series series) {
//		// TODO Auto-generated method stub
//		if(count == seriess.length-1) {
//			Series temp[] = new Series[seriess.length*4];
//			System.arraycopy(series, 0, temp, 0, seriess.length);
//			seriess = temp;
//			seriess[++count] = series;
//			
//			return "Success4";
//		}
//		seriess[++count] = series;
//		return "Success4";
//	}
//
//	@Override
//	public String deleteSeries(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String modifySeries(String id, Series series) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Series getSeriesById(String id) {
//		// TODO Auto-generated method stub
//		for (Series series : seriess) {
//			if(series!=null && series.getId().equals(id))
//				return series;
//		}
//		return null;
//	}
//
//	@Override
//	public Series[] getAllSeries() {
//		// TODO Auto-generated method stub
//		return seriess;
//	}


