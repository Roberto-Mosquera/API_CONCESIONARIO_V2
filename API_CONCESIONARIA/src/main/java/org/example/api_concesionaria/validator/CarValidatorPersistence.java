package org.example.api_concesionaria.validator;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.exception.RequestException;
import org.example.api_concesionaria.infrastructure.persistence.repository.carRepository.SpringDataCarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CarValidatorPersistence {

    public final SpringDataCarRepository springDataCarRepository;

    public void validateRequestSave(Car car) {

        if (car == null) {
            throw new RequestException("El objeto Car es obligatorio.",HttpStatus.BAD_REQUEST);
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
            throw new RequestException("El campo '" + fieldName + "' es obligatorio y no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
    }

    private void requireNonNull(Object value, String fieldName) {
        if (value == null) {
            throw new RequestException("El campo '" + fieldName + "' es obligatorio y no puede ser null.",HttpStatus.BAD_REQUEST);
        }
    }
}
