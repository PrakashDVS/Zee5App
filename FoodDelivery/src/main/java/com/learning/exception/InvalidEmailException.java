package com.learning.exception;
import lombok.ToString;

@ToString(callSuper = true)
public class InvalidEmailException extends Exception {
	public InvalidEmailException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
