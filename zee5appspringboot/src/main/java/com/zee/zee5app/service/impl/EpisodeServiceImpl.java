package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {

	@Override
	public String addEpisode(Episodes episode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEpisode(String epiId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyEpisode(String epiId, Episodes episode)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Episodes> getEpisodeById(String epiId)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Episodes> getEpisodeByName(String episodeName)
			throws NameNotFoundException, LocationNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Episodes>> getAllEpisode() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return null;
	}

}
