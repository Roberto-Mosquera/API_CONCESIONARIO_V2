package org.example.api_concesionaria.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends RuntimeException{
    private HttpStatus status;
    public NotFoundException(String message) {
        super(message);
        this.status=HttpStatus.NOT_FOUND;
    }
}
