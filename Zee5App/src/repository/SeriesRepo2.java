package repository;

import dto.Series;

public interface SeriesRepo2 {
	public String addSeries(Series series);
	public String updateSeries(String id);
	public Series getSeries(String id);
	public Series[] getAllSeries();
	public String deleteSeries(String id);
}
