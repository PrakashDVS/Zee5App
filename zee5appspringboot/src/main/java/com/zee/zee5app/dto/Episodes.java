package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name="episodes")
@AllArgsConstructor
public class Episodes {
	@Id
    @Column(name="epiId")
	@NotBlank
	@Setter(value = AccessLevel.NONE)
	private String epiId;
	@NotBlank
	@Setter(value = AccessLevel.NONE)
	private String seriesId;
	@NotBlank
	private String episodeName;
	@NotNull
	private int epiLength;
	@NotBlank
	private String location;
	@NotBlank
	private String trailer;

	public void setEpiId(String id) throws InvalidIdLengthException {
		if (id.length() < 6) {
			throw new InvalidIdLengthException("id length is less than or equal to 6");
		}
		this.epiId = id;
	}

	public void setSeriesId(String id) throws InvalidIdLengthException {
		if (id.length() < 6) {
			throw new InvalidIdLengthException("id length is less than or equal to 6");
		}
		this.seriesId = id;
	}
	@ManyToOne
	@JoinColumn(name="id")
	
	private Series series;
	
	
}