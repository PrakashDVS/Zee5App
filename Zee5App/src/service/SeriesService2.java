package service;

import dto.Series;

public interface SeriesService2 {
	public String addSeries(Series series);
	public String updateSeries(String id);
	public Series getSeriesById(String id);
	public Series[] getAllSeries();
	public String deleteSeriesById(String id);
}
