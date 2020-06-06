package com.springboot.SpringBootProject.globalExceptionHandling;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<AppGenericResponse> catchExpetion(Exception e) {
		logger.error("checked exception", e);
		AppGenericResponse r=new AppGenericResponse();
		r.setData("exception");
		r.setMessage("");
		r.setE(e);
		return new ResponseEntity<AppGenericResponse>(r,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value=FileNotFoundException.class)
	public ResponseEntity<AppGenericResponse> catchFileNotExpetion(Exception e) {
		logger.error("exceptions related to file", e);
		AppGenericResponse r=new AppGenericResponse();
		r.setData("exception");
		r.setMessage("issue with handlig files");
		r.setE(e);
		return new ResponseEntity<AppGenericResponse>(r,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=RuntimeException.class)
	public ResponseEntity<?> catchRuntimeExpetion(Exception e) {
		logger.error("runtime exception", e);
		return new ResponseEntity<String>("checked exception",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=InvalidDataException.class)
	public ResponseEntity<?> catchInvalidData(InvalidDataException e) {
		logger.error("invalid data", e);
		System.out.println(e.getMessage());
		return new ResponseEntity<String>("invalid data",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

	
	

}
