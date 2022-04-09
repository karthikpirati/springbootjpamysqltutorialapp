package com.springboot.SpringBootProject.dto;

import org.springframework.http.HttpStatus;

public class AppResponseObj<T> {

    private T body; // List<Subs>/ User/ Channee/
    private HttpStatus httpStatus;

    public AppResponseObj(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public AppResponseObj(T body, HttpStatus httpStatus) {
        this.body = body;
        this.httpStatus = httpStatus;
    }
}
