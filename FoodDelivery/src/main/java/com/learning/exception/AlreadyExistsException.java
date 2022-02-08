package com.learning.exception;
import java.lang.Exception;

import lombok.ToString;
@ToString(callSuper = true)
public class AlreadyExistsException extends Exception {
	public AlreadyExistsException(String message) {
		super(message);
	}


}
