package com.zee.zee5app.controlleradvice;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyRecordExistsExceptionHandler(AlreadyExistsException e){
		HashMap<String,String> map = new HashMap<>();
		map.put("message", "Record alredy eists"+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> ExceptionHandler(Exception e){
		HashMap<String,String> map = new HashMap<>();
		map.put("message", "unknown Exception"+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> idNotFoundExceptionHandler(IdNotFoundException e){
		HashMap<String, String> map = new HashMap<>();
		map.put("message", e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
}
