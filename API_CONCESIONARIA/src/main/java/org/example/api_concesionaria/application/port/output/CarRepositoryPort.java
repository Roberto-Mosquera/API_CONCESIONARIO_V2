package org.example.api_concesionaria.application.port.output;

import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.infrastructure.persistence.entity.CarEntity;

import java.util.List;
import java.util.UUID;

public interface CarRepositoryPort {
    UUID saveCar(Car car);
    Car findCarById(UUID id);
    Car findCarByName(String name_car);
    CarEntity findCarEntityById(UUID id);
    List<Car> ListCarResponseFull(int page);
    List<Car> ListCarResponseByEngine(int page,String engine);
    List<Car> ListCarResponseByTransmission(int page,String transmission);
    List<Car> ListCarResponseByTraction(int page,String traction);
    List<Car> ListCarResponseBySpeed(int page,String speed);
    List<Car> ListCarResponseByCategory(int page,UUID CategoryId);
}
