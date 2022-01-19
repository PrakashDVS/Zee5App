package repository.impl;

import dto.Series;
import repository.SeriesRepo2;

public class SeriesRepoimpl implements SeriesRepo2 {
private SeriesRepoimpl() {
    	
    }
    private static SeriesRepo2 repository;
    public static SeriesRepo2 getInstance() {
    	if(repository==null) {
    		repository=new SeriesRepoimpl();
    	}
    	return repository;
    }
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateSeries(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Series getSeries(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSeries(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
