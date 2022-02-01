package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Series;

import lombok.Data;
@Data
public class Seriesrepo {
	private Series[] seriess = new Series[10];
	private static int count = -1;
	
	private static Seriesrepo seriesrepository;
	public static Seriesrepo getInstance() {
		if(seriesrepository==null)
			seriesrepository = new Seriesrepo();
		return seriesrepository;
	}
	
	public String addSeries(Series series) {
		if(count == seriess.length-1) {
			Series temp[] = new Series[seriess.length*4];
			System.arraycopy(series, 0, temp, 0, seriess.length);
			seriess = temp;
			seriess[++count] = series;
			
			return "Success4";
		}
		seriess[++count] = series;
		return "Success4";
	}
	

	public String deleteSeries(String id) {
		return null;
	}
	
	public String modifySeries(String id, Series series) {
		return null;
	}
	
	public Series getSeriesById(String id) {
		for (Series series : seriess) {
			if(series!=null && series.getId().equals(id))
				return series;
		}
		return null;
	}
	
	public Series[] getAllSeries() {
		return seriess;
	}
}
