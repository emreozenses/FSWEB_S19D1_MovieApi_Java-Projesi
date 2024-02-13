package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Getter
public class ActorException extends RuntimeException{

    private HttpStatus httpStatus;

    public ActorException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
