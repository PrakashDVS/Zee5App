package com.zee.zee5app.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.User;
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
	private  SeriesRepository seriesRepository;

	@Override
	public String addSeries(Series series) {
		Series series2 = seriesRepository.save(series);
		if(series2 != null) {
			return "success";
		}else {
			return "fail";
		}
	}

	
	@Override
	public String deleteSeries(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Series> optional;
		try {
			optional = this.getSeriesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("id not found!");
			}else {
				seriesRepository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
		 
	}

	@Override
	public Optional<Series> getSeriesById(Long id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return seriesRepository.findById(id);
	}

	@Override
	public Optional<List<Series>> getAllSeries()  {
		// TODO Auto-generated method stub
		return Optional.ofNullable(seriesRepository.findAll());
	}
	
	@Override
	public String updateSeries(Long id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}