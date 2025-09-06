package org.example.api_concesionaria.application.port.input.simpleUseCase.colorCarUseCase;

import org.example.api_concesionaria.dto.request.CreateColorCarRequest;

public interface CreateColorCarUseCase {
    void createColorCar(CreateColorCarRequest createColorCarRequest);
}
