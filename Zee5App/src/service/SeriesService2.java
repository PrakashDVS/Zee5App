package service;

import java.util.List;
import java.util.Optional;

import dto.Series;
import exception.IdNotFoundException;

public interface SeriesService2 {
	public String addSeries(Series series); 
	public String deleteSeries(String id) throws IdNotFoundException;
	public String modifySeries(String id, Series series) throws IdNotFoundException;
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException;
	public List<Series> getAllSeries();
}
