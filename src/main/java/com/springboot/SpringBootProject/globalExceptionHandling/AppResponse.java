package com.springboot.SpringBootProject.globalExceptionHandling;

import org.springframework.http.HttpStatus;

public class AppResponse<T> {

    private T body;
    private HttpStatus httpStatus;

}
