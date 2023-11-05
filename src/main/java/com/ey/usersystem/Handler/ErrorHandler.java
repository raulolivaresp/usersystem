package com.ey.usersystem.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ey.usersystem.Api.ErrorResponse;
import com.ey.usersystem.Utils.ValidException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({ ValidException.class })
    public ResponseEntity<ErrorResponse> handleInvalidArgument(ValidException exception){

       ErrorResponse errorResponse = new ErrorResponse();
       errorResponse.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
