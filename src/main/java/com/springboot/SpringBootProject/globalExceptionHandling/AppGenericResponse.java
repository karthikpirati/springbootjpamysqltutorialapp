package com.springboot.SpringBootProject.globalExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AppGenericResponse<T> extends ResponseEntity<T> {
	
	private T data;
	private HttpStatus httpStatus;
	private int status;
	private String message;
	private Exception e;

	public AppGenericResponse(HttpStatus status) {
		super(status);
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Exception getE() {
		return e;
	}
	public void setE(Exception e) {
		this.e = e;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
