package org.example.api_concesionaria.mapper;

import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.dto.request.CreateCarRequest;
import org.example.api_concesionaria.infrastructure.persistence.entity.CarEntity;

import java.util.List;

public class CarMapper {
    public static Car toCarCreate(CreateCarRequest createCarRequest) {
        return new Car(
                null,
                createCarRequest.nameCar(),
                createCarRequest.urlImgCar(),
                createCarRequest.price(),
                createCarRequest.stock(),
                createCarRequest.brand(),
                createCarRequest.model(),
                createCarRequest.engine(),
                createCarRequest.traction(),
                createCarRequest.transmission(),
                createCarRequest.torque(),
                createCarRequest.speed(),
                createCarRequest.urlTechnicalSheet(),
                null,
                createCarRequest.id_categoryCar()
        );
    }

    public static CarEntity toCarEntity(Car car){
        return new CarEntity(
                car.nameCar(),
                car.urlImgCar(),
                car.price(),
                car.stock(),
                car.brand(),
                car.model(),
                car.engine(),
                car.traction(),
                car.transmission(),
                car.torque(),
                car.speed(),
                car.urlTechnicalSheet()
        );
    }

    public static Car toCar(CarEntity carEntity){
        return new Car(
                carEntity.getId(),
                carEntity.getNameCar(),
                carEntity.getUrlImgCar(),
                carEntity.getPrice(),
                carEntity.getStock(),
                carEntity.getBrand(),
                carEntity.getModel(),
                carEntity.getEngine(),
                carEntity.getTraction(),
                carEntity.getTransmission(),
                carEntity.getTorque(),
                carEntity.getSpeed(),
                carEntity.getUrlTechnicalSheet(),
                carEntity.getEnabled(),
                carEntity.getCategory().getId()
        );
    }

    public static List<Car> toListCar(List<CarEntity> carEntities){
        return carEntities.stream()
                .map(CarMapper::toCar)
                .toList();
    }

}
