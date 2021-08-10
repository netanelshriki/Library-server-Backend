package com.net.demoTokenLib.advice;

import com.net.demoTokenLib.exceptions.ErrorMsg;
import com.net.demoTokenLib.exceptions.LibraryException;
import com.net.demoTokenLib.exceptions.LibraryLoginException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class LibraryAdvice {

    @ExceptionHandler(value = {LibraryLoginException.class})
    public ResponseEntity<?> handler1(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {LibraryException.class})
    public ResponseEntity<?> handler2(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }


}
