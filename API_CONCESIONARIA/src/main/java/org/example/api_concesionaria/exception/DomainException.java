package org.example.api_concesionaria.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DomainException extends RuntimeException {
    private HttpStatus status;
    public DomainException(String message) {
        super(message);
        this.status=HttpStatus.BAD_REQUEST;
    }
}
