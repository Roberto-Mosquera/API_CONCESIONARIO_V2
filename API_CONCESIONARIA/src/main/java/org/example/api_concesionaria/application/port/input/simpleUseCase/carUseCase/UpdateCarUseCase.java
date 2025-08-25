package org.example.api_concesionaria.application.port.input.simpleUseCase.carUseCase;

import org.example.api_concesionaria.dto.request.CreateCarRequest;

public interface UpdateCarUseCase {
    void UpdateCar(CreateCarRequest carRequest);
}
