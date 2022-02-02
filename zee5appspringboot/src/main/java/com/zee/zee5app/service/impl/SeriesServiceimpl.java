package com.zee.zee5app.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.NameNotFoundException;
//import com.zee.zee5app.repository.SeriesRepo2;
import com.zee.zee5app.repository.SeriesRepository;
//import com.zee.zee5app.repository.impl.SeriesRepoimpl;
import com.zee.zee5app.service.SeriesService2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class SeriesServiceimpl implements SeriesService2 {
	@Autowired
	public SeriesRepository repository;
//	private static SeriesService2 service;	
//	
//	public static SeriesService2 getInstance() throws IOException {
//		if(service == null)
//			service = new SeriesServiceimpl();
//		return service;
//	}
//	
    public SeriesServiceimpl() throws IOException {
//		repository = SeriesRepoimpl.getInstance();
	}

	@Override
	public String addSeries(Series series) {
		Series series2 = repository.save(series);
		// TODO Auto-generated method stub
		if(series2 != null) {
			return "success";
		}
		else {
			return "fail";
		}
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException, NameNotFoundException {
		try {
			Optional<Series> optional = this.getSeriesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				repository.deleteById(id);
				return "success";
			}
		}catch( IdNotFoundException | InvalidIdLengthException e) {
			e.printStackTrace();
			throw new IdNotFoundException(e.getLocalizedMessage());
		}
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Optional<List<Series>> getAllSeries() throws InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());

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