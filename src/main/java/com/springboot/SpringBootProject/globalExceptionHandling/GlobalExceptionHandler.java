package com.springboot.SpringBootProject.globalExceptionHandling;

import java.io.FileNotFoundException;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
//	Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<AppGenericResponse> catchExpetion(Exception e) {
		log.error("checked exception", e);
		AppGenericResponse r=new AppGenericResponse(HttpStatus.INTERNAL_SERVER_ERROR);
		r.setData("exception");
		r.setMessage(e.getMessage());
		r.setE(e);
		return new ResponseEntity<AppGenericResponse>(r,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value=DuplicateEntryException.class)
	public ResponseEntity<?> catchDuplicateEntry(DuplicateEntryException e) {
		log.error("checked exception", e);
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}


//	@ExceptionHandler(value=ArithmeticException.class)
//	public ResponseEntity<?> catchArithmeticExpetion(Exception e) {
//		logger.error("catchArithmeticExpetion exception", e);
////		AppGenericResponse r=new AppGenericResponse();
////		r.setData("exception");
////		r.setMessage("");
////		r.setE(e);
//		return new ResponseEntity<String>("got arithemtic exception",HttpStatus.INTERNAL_SERVER_ERROR);



	@ExceptionHandler(value=ArithmeticException.class)
	public ResponseEntity<?> catchArithmeticExpetion(Exception e) {
		log.error("catchArithmeticExpetion exception", e);
//		AppGenericResponse r=new AppGenericResponse(HttpStatus.INTERNAL_SERVER_ERROR);
//		r.setData("got arithmetic exception");
//		r.setMessage("do not divide 1 with zero");
//		r.setE(e);
//		r.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@ExceptionHandler(value=MyCustomException4.class)
	public ResponseEntity<?> catchCustomException(Exception e) {
		log.error("catchArithmeticExpetion exception", e);
		return new ResponseEntity<>("cusyom exception",HttpStatus.INTERNAL_SERVER_ERROR);
	}



	@ExceptionHandler(value=FileNotFoundException.class)
	public ResponseEntity<AppGenericResponse> catchFileNotExpetion(Exception e) {
		log.error("exceptions related to file", e);
		AppGenericResponse r=new AppGenericResponse(HttpStatus.INTERNAL_SERVER_ERROR);
		r.setData("exception");
		r.setMessage("issue with handlig files");
		r.setE(e);
		return new ResponseEntity<AppGenericResponse>(r,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=RuntimeException.class)
	public ResponseEntity<?> catchRuntimeExpetion(Exception e) {
		log.error("runtime exception", e);
		return new ResponseEntity<String>("Runtime exception"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=InvalidDataException.class)
	public ResponseEntity<?> catchInvalidData(InvalidDataException e) {
		log.error("invalid data", e);
		System.out.println(e.getMessage());
		return new ResponseEntity<String>("Password and Invalid ",HttpStatus.BAD_REQUEST);
	}
	
	

	
	

}
