package com.springboot.SpringBootProject.globalExceptionHandling;

import org.springframework.http.HttpStatus;

public class AppGenericResponse<T> {
	
	private T data;
	private HttpStatus status;
	private String message;
	private Exception e;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
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
	
	
	

}
