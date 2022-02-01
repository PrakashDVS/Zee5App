package com.zee.zee5app.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.net.URL;
import java.util.Objects;

import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.NameNotFoundException;
//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor

public class Series implements Comparable<Series> {
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	private String seriesName;
	private int ageLimit;
	private String genre;
	private String language;
	private String releaseDate;
	private int length;
	private String trailer;
	private String cast;
	private int noOfEpisodes;

	public Series(String id,String seriesName, int ageLimit, String genre, String language, String releaseDate, int length,
			String trailer, String cast, int noOfEpisodes) throws InvalidNameException, InvalidIdLengthException {

		super();
		this.setId(id);
		this.seriesName = seriesName;
		this.ageLimit = (ageLimit);
		this.cast = cast;
		this.genre = genre;
		this.length = length;
		this.trailer = trailer;
		this.releaseDate = releaseDate;
		this.language = language;
		this.noOfEpisodes = noOfEpisodes;

	}

	


	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	public void setSeriesName(String seriesName) throws NameNotFoundException {

		if(seriesName == null)
			throw new NameNotFoundException("series name not found");
		this.seriesName = seriesName;
	}

	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6)
			throw new InvalidIdLengthException("id length less than 6");
		this.id = id;
	}
	
}