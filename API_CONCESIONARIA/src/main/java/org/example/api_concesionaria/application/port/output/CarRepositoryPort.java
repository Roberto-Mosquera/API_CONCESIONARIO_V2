package org.example.api_concesionaria.application.port.output;

import org.example.api_concesionaria.domain.model.Car;
import java.util.UUID;

public interface CarRepositoryPort {
    boolean saveCar(Car car, UUID categoryId);
}
