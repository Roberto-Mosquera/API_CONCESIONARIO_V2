package org.example.api_concesionaria.application.service;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.input.simpleUseCase.carUseCase.CreateCarUseCase;
import org.example.api_concesionaria.application.port.input.simpleUseCase.carUseCase.FindCarUseCase;
import org.example.api_concesionaria.application.port.input.simpleUseCase.carUseCase.ListCarUseCase;
import org.example.api_concesionaria.application.port.output.CarRepositoryPort;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.domain.service.CarValidator;
import org.example.api_concesionaria.dto.request.CreateCarRequest;
import org.example.api_concesionaria.dto.response.CarResponseItem;
import org.example.api_concesionaria.mapper.CarMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService implements CreateCarUseCase, ListCarUseCase, FindCarUseCase {
    private final CarRepositoryPort  carRepositoryPort;

    private final CarValidator carValidator;

    @Override
    public void createCar(CreateCarRequest carRequest) {
        Car car = CarMapper.toCarCreate(carRequest);
        carValidator.validateRequest(car);
        carRepositoryPort.saveCar(car, car.id_categoryCar());
    }

    @Override
    public CarResponseItem findCarById(UUID id) {
        return null;
    }

    @Override
    public CarResponseItem findCarByName(String name_car) {
        return null;
    }

    @Override
    public List<CarResponseItem> ListCarResponseFull(int page) {
        return List.of();
    }

    @Override
    public List<CarResponseItem> ListCarResponseByEngine(int page, String engine) {
        return List.of();
    }

    @Override
    public List<CarResponseItem> ListCarResponseByTransmission(int page, String transmission) {
        return List.of();
    }

    @Override
    public List<CarResponseItem> ListCarResponseByTraction(int page, String traction) {
        return List.of();
    }

    @Override
    public List<CarResponseItem> ListCarResponseBySpeed(int page, String speed) {
        return List.of();
    }

    @Override
    public List<CarResponseItem> ListCarResponseByCategory(int page, UUID CategoryId) {
        return List.of();
    }


}
