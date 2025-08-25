package org.example.api_concesionaria.application.port.input.simpleUseCase.carUseCase;

import java.util.List;

import org.example.api_concesionaria.dto.response.CarResponseItem;

public interface ListCarUseCase {
    List<CarResponseItem>ListCarResponseFull(int page);
    List<CarResponseItem>ListCarResponseByEngine(int page,String engine);
    List<CarResponseItem>ListCarResponseByTransmission(int page,String etransmissionngine);
    List<CarResponseItem>ListCarResponseByTraction(int page,String traction);
    List<CarResponseItem>ListCarResponseBySpeed(int page,String speed);
}
