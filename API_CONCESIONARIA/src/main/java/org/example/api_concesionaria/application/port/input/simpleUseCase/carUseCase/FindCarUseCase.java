package org.example.api_concesionaria.application.port.input.simpleUseCase.carUseCase;

import org.example.api_concesionaria.dto.response.CarResponseItem;

import java.util.UUID;

public interface FindCarUseCase {
    CarResponseItem findCarById(UUID id);
    CarResponseItem findCarByName(String name_car);
}
