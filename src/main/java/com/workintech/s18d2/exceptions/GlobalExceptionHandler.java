package com.workintech.s18d2.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(PlantException exception){
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(exception.getHttpStatus().value(),exception.getMessage(), LocalDateTime.now());
        log.error("Plant exception occured:", plantErrorResponse.toString());
        return new ResponseEntity<>(plantErrorResponse,exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception){
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage(), LocalDateTime.now());
        log.error("Plant exception occured:", plantErrorResponse.toString());
        return new ResponseEntity<>(plantErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
