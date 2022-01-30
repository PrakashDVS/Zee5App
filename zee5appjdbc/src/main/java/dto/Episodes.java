package dto;

import exception.InvalidIdLengthException;
import lombok.AccessLevel;
import lombok.Setter;

public class Episodes {

	@Setter(value = AccessLevel.NONE)
	private String epiId;
	@Setter(value = AccessLevel.NONE)
	private String seriesId;
	private String episodeName;
	private int epiLength;
	private String location;
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
}