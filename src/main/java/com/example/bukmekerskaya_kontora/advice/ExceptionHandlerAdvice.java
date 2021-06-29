package com.example.bukmekerskaya_kontora.advice;

import com.example.bukmekerskaya_kontora.exception.AlreadyExistsException;
import com.example.bukmekerskaya_kontora.exception.BadRequestException;
import com.example.bukmekerskaya_kontora.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {AlreadyExistsException.class})
    public ResponseEntity<ErrorResponse> handlerAlreadyExistsException(AlreadyExistsException ex, WebRequest webRequest){
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.CONFLICT,
                webRequest.getDescription(false),
                ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorResponse> handlerBadRequestException(BadRequestException ex, WebRequest webRequest){
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST,
                webRequest.getDescription(false),
                ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerResourceNotFound(ResourceNotFoundException ex, WebRequest webRequest){
        ErrorResponse errorResponse = ErrorResponse.of(
                HttpStatus.NOT_FOUND,
                webRequest.getDescription(false),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ErrorResponse> handlerInternalServerException(Exception ex, WebRequest webRequest){
        ErrorResponse errorResponse = ErrorResponse.of(
                HttpStatus.INTERNAL_SERVER_ERROR,
                webRequest.getDescription(false),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
