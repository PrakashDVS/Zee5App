package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface SeriesService2 {
	public String addSeries(Series series); 
	public String deleteSeries(String id) throws IdNotFoundException, NameNotFoundException;
	public String modifySeries(String id, Series series) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException;
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException;
	public Optional<List<Series>> getAllSeries() throws InvalidIdLengthException, NameNotFoundException;
}
