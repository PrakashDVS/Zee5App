package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface EpisodeService {
	public String addEpisode(Episodes episode);
	public String deleteEpisode(String epiId) throws IdNotFoundException;
	public String modifyEpisode(String epiId, Episodes episode) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;
	public Optional<Episodes> getEpisodeById(String epiId) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;
	public Optional<Episodes> getEpisodeByName(String episodeName)
			throws NameNotFoundException, LocationNotFoundException, InvalidNameException, InvalidIdLengthException;
	public Optional<List<Episodes>> getAllEpisode() throws InvalidIdLengthException, InvalidNameException;
}
