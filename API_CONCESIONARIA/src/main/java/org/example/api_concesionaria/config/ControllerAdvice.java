package org.example.api_concesionaria.config;

import org.example.api_concesionaria.exception.*;
import org.example.api_concesionaria.utils.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorMessage>  RequestExceptionHandler(RequestException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(ex.getStatus().value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, ex.getStatus());
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorMessage>  BusinessExceptionHandler(BusinessException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(ex.getStatus().value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, ex.getStatus());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorMessage>  NotFoundExceptionHandler(NotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(ex.getStatus().value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, ex.getStatus());
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorMessage>  BadRequestExceptionHandler(BadRequestException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(ex.getStatus().value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, ex.getStatus());
    }

    @ExceptionHandler(value = DomainException.class)
    public ResponseEntity<ErrorMessage>  ExceptionHandler(DomainException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(ex.getStatus().value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, ex.getStatus());
    }

}
