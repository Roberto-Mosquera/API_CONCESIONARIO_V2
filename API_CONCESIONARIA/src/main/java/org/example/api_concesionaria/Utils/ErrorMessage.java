package org.example.api_concesionaria.Utils;

import lombok.Getter;

@Getter
public class ErrorMessage<T> {
    private int status = 400;
    private final Boolean isError = Boolean.TRUE;
    private String message = "Error: Ejecucion sin exito";
    public ErrorMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
