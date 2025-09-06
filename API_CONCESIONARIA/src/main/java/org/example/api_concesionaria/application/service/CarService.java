package org.example.api_concesionaria.application.service;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.input.simpleUseCase.carUseCase.CreateCarUseCase;
import org.example.api_concesionaria.application.port.input.simpleUseCase.carUseCase.FindCarUseCase;
import org.example.api_concesionaria.application.port.input.simpleUseCase.carUseCase.ListCarUseCase;
import org.example.api_concesionaria.application.port.output.CarRepositoryPort;
import org.example.api_concesionaria.application.port.output.CategoryCarRepositoryPort;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.dto.request.CreateCarFiles;
import org.example.api_concesionaria.dto.request.CreateCarRequest;
import org.example.api_concesionaria.dto.response.CarResponseItem;
import org.example.api_concesionaria.mapper.CarMapper;
import org.example.api_concesionaria.utils.FileMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService implements CreateCarUseCase, ListCarUseCase, FindCarUseCase {

    private final CarRepositoryPort  carRepositoryPort;
    private final CategoryCarRepositoryPort categoryCarRepositoryPort;
    private final FileMapper fileMapper;

    @Override
    public void createCar(CreateCarRequest carRequest) throws Exception {
        CreateCarFiles files = fileMapper.saveFileCategoryCar(carRequest);
        CategoryCar categoryCar = categoryCarRepositoryPort.getCategoryCarById(carRequest.id_categoryCar());
        Car car = CarMapper.toCarCreate(carRequest,categoryCar,files);
        carRepositoryPort.saveCar(car);
    }

    @Override
    public CarResponseItem findCarById(UUID id) {
        Car car = carRepositoryPort.findCarById(id);
        return CarMapper.toCarResponseItem(car);
    }

    @Override
    public CarResponseItem findCarByName(String name_car) {
        Car car = carRepositoryPort.findCarByName(name_car);
        return CarMapper.toCarResponseItem(car);
    }

    @Override
    public List<CarResponseItem> ListCarResponseFull(int page) {
        List<Car>cars=carRepositoryPort.ListCarResponseFull(page);
        return CarMapper.toListCarResponseItem(cars);
    }

    @Override
    public List<CarResponseItem> ListCarResponseByEngine(int page, String engine) {
        List<Car>cars=carRepositoryPort.ListCarResponseByEngine(page,engine);
        return CarMapper.toListCarResponseItem(cars);
    }

    @Override
    public List<CarResponseItem> ListCarResponseByTransmission(int page, String transmission) {
        List<Car>cars=carRepositoryPort.ListCarResponseByTransmission(page,transmission);
        return CarMapper.toListCarResponseItem(cars);
    }

    @Override
    public List<CarResponseItem> ListCarResponseByTraction(int page, String traction) {
        List<Car>cars=carRepositoryPort.ListCarResponseByTraction(page,traction);
        return CarMapper.toListCarResponseItem(cars);
    }

    @Override
    public List<CarResponseItem> ListCarResponseBySpeed(int page, String speed) {
        List<Car>cars=carRepositoryPort.ListCarResponseBySpeed(page,speed);
        return CarMapper.toListCarResponseItem(cars);
    }

    @Override
    public List<CarResponseItem> ListCarResponseByCategory(int page, UUID CategoryId) {
        List<Car>cars=carRepositoryPort.ListCarResponseByCategory(page,CategoryId);
        return CarMapper.toListCarResponseItem(cars);
    }

}
