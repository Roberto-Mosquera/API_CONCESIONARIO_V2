package org.example.api_concesionaria.domain.service;

import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.exception.DomainException;


public class CarValidator {

    public void validateRequest(Car car) {

        if (car == null) {
            throw new DomainException("El objeto Car es obligatorio.");
        }

        requireNonBlank(car.nameCar(), "nameCar");
        requireNonBlank(car.urlImgCar(), "urlImgCar");

        requireNonNull(car.price(), "price");
        requireNonNull(car.stock(), "stock");

        requireNonBlank(car.brand(), "brand");
        requireNonBlank(car.model(), "model");
        requireNonBlank(car.engine(), "engine");
        requireNonBlank(car.traction(), "traction");
        requireNonBlank(car.transmission(), "transmission");
        requireNonBlank(car.torque(), "torque");
        requireNonBlank(car.speed(), "speed");
        requireNonBlank(car.urlTechnicalSheet(), "urlTechnicalSheet");
    }

    private void requireNonBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("El campo '" + fieldName + "' es obligatorio y no puede estar vacío.");
        }
    }

    private void requireNonNull(Object value, String fieldName) {
        if (value == null) {
            throw new DomainException("El campo '" + fieldName + "' es obligatorio y no puede ser null.");
        }
    }
}
