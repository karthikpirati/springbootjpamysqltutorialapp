package com.springboot.SpringBootProject.globalExceptionHandling;

public class DuplicateEntryException extends Exception{

    public DuplicateEntryException(String message){
        super(message);
    }
}
