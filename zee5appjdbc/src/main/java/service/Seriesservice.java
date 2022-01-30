package service;

import dto.Series;
import lombok.Data;
import repository.Seriesrepo;

@Data

public class Seriesservice {
	private Seriesrepo repository = Seriesrepo.getInstance();
	private static Seriesservice service = null;		
	
	public static Seriesservice getInstance() {
		if(service == null)
			service = new Seriesservice();
		return service;
	}
	
	public String addSeries(Series series) {
		return this.repository.addSeries(series);
	}
	
	public Series getSeriesById(String id) {
		return this.repository.getSeriesById(id);
	}
	
	public Series[] getAllSeries() {
		return repository.getAllSeries();
	}


}