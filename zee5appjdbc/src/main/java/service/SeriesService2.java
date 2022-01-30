package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dto.Series;
import exception.IdNotFoundException;
import exception.InvalidIdLengthException;
import exception.NameNotFoundException;

public interface SeriesService2 {
	public String addSeries(Series series); 
	public String deleteSeries(String id) throws IdNotFoundException;
	public String modifySeries(String id, Series series) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException;
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException;
	public Optional<ArrayList<Series>> getAllSeries() throws InvalidIdLengthException, NameNotFoundException;
}
