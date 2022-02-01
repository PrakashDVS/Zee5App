package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Optional;
import java.util.TreeSet;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.SeriesRepo2;
//import com.zee.zee5app.utils.DBUtils;
@Repository
public class SeriesRepoimpl implements SeriesRepo2 {
private TreeSet<Series> set = new TreeSet<>();
@Autowired
DataSource dataSource = null;

//	private static SeriesRepo2 seriesrepository;
//	public static SeriesRepo2 getInstance() throws IOException {
//		if(seriesrepository==null)
//			seriesrepository = new SeriesRepoimpl();
//		return seriesrepository;
//	}
	
	public SeriesRepoimpl() throws IOException {
//		dbUtils = DBUtils.getInstance();
	}

	@Override
	public String addSeries(Series series) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		PreparedStatement preparedStatement = null;

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
		} catch (Exception e) {
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
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		PreparedStatement preparedStatement;
		String deleteStatetment = "delete from series where id=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

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
		} 
//		finally {
//			dbUtils.closeConnection(connection);
//		}
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
			connection=dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String statement="update series set releasedate=? where seriesid=?";
		try {
			preparedStatement=connection.prepareStatement(statement);
			preparedStatement.setString(1, series.getReleaseDate());
			preparedStatement.setString(2, id);
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				connection.commit();
				return "success";
			}
			else
			{
				connection.rollback();
				return "fail";
			}
		} catch (Exception e) {
			// TODO: handle exception
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
				

	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		} 
//		finally {
//			dbUtils.closeConnection(connection);
//		}

		return Optional.empty();
	}

	@Override
	public Optional<ArrayList<Series>> getAllSeries() throws InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		}
//		finally {
//			dbUtils.closeConnection(connection);
//		}

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


