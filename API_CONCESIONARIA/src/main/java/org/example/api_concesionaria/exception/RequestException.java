package org.example.api_concesionaria.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RequestException extends RuntimeException{
    private HttpStatus status;
    public RequestException(String message,HttpStatus status) {
        super(message);
        this.status=status;
    }
}
