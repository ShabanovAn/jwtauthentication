package com.grokonez.jwtauthentication.advice;

import com.grokonez.jwtauthentication.exception.CarException;
import com.grokonez.jwtauthentication.exception.MotoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NewExceptionControllerAdvice {

    @ExceptionHandler(value = CarException.class)
    public ResponseEntity<?> carException(CarException carException) {
        return new ResponseEntity<>(carException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MotoException.class)
    public ResponseEntity<?> motoException(MotoException motoException) {
        return new ResponseEntity<>(motoException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
