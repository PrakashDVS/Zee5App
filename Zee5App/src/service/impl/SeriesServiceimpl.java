package service.impl;

import dto.Series;
import service.SeriesService2;

public class SeriesServiceimpl implements SeriesService2 {

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return null;
	}
	private static SeriesService2 service;
	
	public static SeriesService2 getInstance() {
		if (service==null) {
			service = new SeriesServiceimpl();
		}
		return service;
	}

	@Override
	public String updateSeries(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Series getSeriesById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSeriesById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
