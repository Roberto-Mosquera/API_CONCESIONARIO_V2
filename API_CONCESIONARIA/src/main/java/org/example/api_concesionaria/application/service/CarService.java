package org.example.api_concesionaria.application.service;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.input.simpleUseCase.carUseCase.CreateCarUseCase;
import org.example.api_concesionaria.application.port.output.CarRepositoryPort;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.domain.service.CarValidator;
import org.example.api_concesionaria.dto.request.CreateCarRequest;
import org.example.api_concesionaria.mapper.CarMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarService implements CreateCarUseCase {

    private final CarRepositoryPort  carRepositoryPort;

    private final CarValidator carValidator;

    @Override
    @Transactional
    public void createCar(CreateCarRequest carRequest) {
        Car car = CarMapper.toCarCreate(carRequest);
        carValidator.validateRequest(car);
        carRepositoryPort.saveCar(car, car.id_categoryCar());
    }

}
