package org.example.api_concesionaria.mapper;

import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.dto.request.CreateCarRequest;
import org.example.api_concesionaria.infrastructure.persistence.entity.CarEntity;

public class CarMapper {
    public static Car toCarCreate(CreateCarRequest createCarRequest) {
        return new Car(
                null,
                createCarRequest.nameCar(),
                createCarRequest.urlImgCar(),
                createCarRequest.price(),
                createCarRequest.stock(),
                createCarRequest.brand(),
                createCarRequest.engine(),
                createCarRequest.engine(),
                createCarRequest.traction(),
                createCarRequest.transmission(),
                createCarRequest.torque(),
                createCarRequest.speed(),
                createCarRequest.urlTechnicalSheet(),
                createCarRequest.enabled(),
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

}
