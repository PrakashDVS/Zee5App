package com.zee.zee5app.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.NameNotFoundException;
@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor

@Entity
@Table(name="series", uniqueConstraints = { @UniqueConstraint(columnNames = "seriesName") })
public class Series implements Comparable<Series> {
	@Id
    @Column(name="id")
	@Setter(value = AccessLevel.NONE)
	private String id;
	@NotBlank
	private String seriesName;
	@NotNull
	@Max(value = 70)
	private int ageLimit;
	@NotBlank
	private String genre;
	@NotBlank
	private String language;
	@NotBlank
	private String releaseDate;
	private int length;
	@NotBlank
	private String trailer;
	@NotBlank
	private String cast;
	@NotNull
	@Min(value = 1)
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
	@OneToMany(mappedBy = "series",cascade=CascadeType.ALL)
	private List<Episodes> episodes =new ArrayList<>();
	
}