package org.example.api_concesionaria.utils;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SuccessMessage<T> {
    private int status = 200;
    private final Boolean isError = Boolean.FALSE;
    private String message = "Mensaje Exitoso";
    private T Body = null;
}
