package org.example.gateway;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Throwable.class)
    public void handleException(Exception e) {
        System.out.println(e.getMessage());
    }
}