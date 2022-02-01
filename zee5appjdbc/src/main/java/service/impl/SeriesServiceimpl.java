package service.impl;

import java.io.IOException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dto.Series;
import exception.IdNotFoundException;
import exception.InvalidIdLengthException;
import exception.NameNotFoundException;
import repository.SeriesRepo2;
import repository.impl.SeriesRepoimpl;
import service.SeriesService2;
@Service
public class SeriesServiceimpl implements SeriesService2 {
	private SeriesRepo2 repository;
//	private static SeriesService2 service;	
//	
//	public static SeriesService2 getInstance() throws IOException {
//		if(service == null)
//			service = new SeriesServiceimpl();
//		return service;
//	}
//	
//    private SeriesServiceimpl() throws IOException {
//		repository = SeriesRepoimpl.getInstance();
//	}

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return this.repository.addSeries(series);
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.deleteSeries(id);
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.modifySeries(id, series);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.getSeriesById(id);
	}

	@Override
	public Optional<ArrayList<Series>> getAllSeries() throws InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.getAllSeries();
	}
	
//	@Override
//	public String addSeries(Series series) {
//		// TODO Auto-generated method stub
//		return this.repository.addSeries(series);
//	}
//
//	@Override
//	public Series getSeriesById(String id) {
//		// TODO Auto-generated method stub
//		return this.repository.getSeriesById(id);
//	}
//
//	@Override
//	public Series[] getAllSeries() {
//		// TODO Auto-generated method stub
//		return repository.getAllSeries();
//	}

}