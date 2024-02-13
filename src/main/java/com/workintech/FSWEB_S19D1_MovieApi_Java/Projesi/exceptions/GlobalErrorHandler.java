package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler
    public ResponseEntity<ActorErrorResponse> actorErrorResponseResponseEntity (ActorException actorException){

        ActorErrorResponse actorErrorResponse = new ActorErrorResponse(actorException.getMessage(), actorException.getHttpStatus().value(), LocalDateTime.now());
        log.error("ActorException occured!",actorErrorResponse.toString());
        return new ResponseEntity<>(actorErrorResponse, actorException.getHttpStatus());

    }

    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> exceptionHandler (Exception exception){

        GlobalErrorResponse globalErrorResponse = new GlobalErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),LocalDateTime.now() );
        log.error("Exception occured",exception.toString());
        return new ResponseEntity<>(globalErrorResponse, HttpStatusCode.valueOf(globalErrorResponse.getStatus()));
    }


}
