package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.NameNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "movieName")},name="movie")
public class Movie implements Comparable<Movie>{
	
	@Id
    @Column(name="id")
	@Setter(value = AccessLevel.NONE)
	private String id;
	@NotNull
	@Setter(value = AccessLevel.NONE)
	private String movieName;
	@NotNull
	@Max(value = 70)
	private int ageLimit;
	@NotNull
	private String genre;
	@NotNull
	private String language;
@NotNull
private String trailer;
	@NotBlank
	private String cast;
	@NotNull
	private BigDecimal length;
	@NotNull
	private Date releaseDate;

	public Movie(String id, String movieName, String genre, String language, @NotBlank Date releaseDate, @NotNull BigDecimal length,
			@NotNull String trailer, String cast, int ageLimit) throws InvalidNameException, InvalidIdLengthException {

		super();
		this.setId(id);
		this.setMovieName(movieName);
		this.ageLimit = ageLimit;
		this.genre = genre;
		this.language = language;
		this.trailer = trailer;
		this.cast = cast;
		this.length = length;
		this.releaseDate = releaseDate;

	}

	public void setId(String id) throws InvalidIdLengthException {
		if (id.length() < 6) {
			throw new InvalidIdLengthException("id length is less than or equal to 6"); // throws exception
		}
		this.id = id;
	}

	public void setMovieName(String movieName) throws InvalidNameException {
		if (movieName == null || movieName == "" || movieName.length() < 2) {
			throw new InvalidNameException("Movie name not valid");
		}
		this.movieName = movieName;
	}

	@Override
	public int compareTo(Movie o) {
		return o.id.compareTo(this.getId());
	}



}