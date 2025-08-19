package org.example.api_concesionaria.Utils;


import lombok.Getter;

@Getter
public class SuccessMessage<T> {
    private int status = 200;
    private final Boolean isError = Boolean.FALSE;
    private String message = "Mensaje Exitoso";
    private T Body = null;
    public SuccessMessage(int status, String message, T Body) {
        this.status = status;
        this.message = message;
        this.Body = Body;
    }
}
