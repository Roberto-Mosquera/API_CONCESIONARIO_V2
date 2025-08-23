package org.example.api_concesionaria.config;

import org.example.api_concesionaria.exception.*;
import org.example.api_concesionaria.utils.ErrorMessage;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

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
    public ResponseEntity<ErrorMessage>  DomainHandler(DomainException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(ex.getStatus().value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, ex.getStatus());
    }

    @ExceptionHandler(value = FileException.class)
    public ResponseEntity<ErrorMessage>  FileHandler(FileException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(ex.getStatus().value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, ex.getStatus());
    }

    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorMessage>  MaxUploadHandler(MaxUploadSizeExceededException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(HttpStatus.PAYLOAD_TOO_LARGE.value())
                .message("El archivo o los archivos sobrepasan los 6 MB permitidos")
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.PAYLOAD_TOO_LARGE);
    }
}
