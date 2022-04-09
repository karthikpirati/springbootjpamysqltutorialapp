package com.springboot.SpringBootProject.globalExceptionHandling;

public class InvalidDataException extends Exception{
	
	public InvalidDataException(String message) {
		super(message);
	}

	public InvalidDataException() {
		super();
	}

}
