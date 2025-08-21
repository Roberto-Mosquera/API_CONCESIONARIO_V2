package org.example.api_concesionaria.utils;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorMessage {
    private int status = 400;
    private final Boolean isError = Boolean.TRUE;
    private String message = "Error: Ejecucion sin exito";
}
