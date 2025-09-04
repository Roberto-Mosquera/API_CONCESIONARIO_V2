package org.example.api_concesionaria.mapper;

import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.dto.request.CreateCarRequest;
import org.example.api_concesionaria.dto.response.CarResponseItem;
import org.example.api_concesionaria.infrastructure.persistence.entity.CarEntity;

import java.util.List;

public class CarMapper {
    public static Car toCarCreate(CreateCarRequest createCarRequest, CategoryCar categoryCar) { //El request lo pasa a car
        return new Car(
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
                categoryCar
        );
    }

    public static CarEntity toCarEntity(Car car){ //El car lo pasa a car entity para guardarlo
        return new CarEntity(
                null,
                car.getNameCar(),
                car.getUrlImgCar(),
                car.getPrice(),
                car.getStock(),
                car.getBrand(),
                car.getModel(),
                car.getEngine(),
                car.getTraction(),
                car.getTransmission(),
                car.getTorque(),
                car.getSpeed(),
                car.getUrlTechnicalSheet(),
                car.getEnabled(),
                CategoryCarMapper.toCategoryCarEntityCreate(car.getCategoryCar())
        );
    }

    public static CarResponseItem toCarResponseItem(Car car){
        return new CarResponseItem(
                car.getId(),
                car.getNameCar(),
                car.getUrlImgCar(),
                car.getPrice(),
                car.getCategoryCar().getNameCategory()
        );
    }

    public static List<CarResponseItem> toListCarResponseItem(List<Car> cars){
        return cars.stream()
                .map(CarMapper::toCarResponseItem)
                .toList();
    }

    public static Car toCarDetail(CarEntity carEntity){
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
                CategoryCarMapper.toCategoryCar(carEntity.getCategory())
        );
    }

    public static Car toCarBasic(CarEntity carEntity){
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
                carEntity.getEnabled()
        );
    }

    public static List<Car> toListCarDetail(List<CarEntity> carEntities){
        return carEntities.stream()
                .map(CarMapper::toCarDetail)
                .toList();
    }

    public static List<Car> toListCarBasic(List<CarEntity> carEntities){
        return carEntities.stream()
                .map(CarMapper::toCarBasic)
                .toList();
    }

}
