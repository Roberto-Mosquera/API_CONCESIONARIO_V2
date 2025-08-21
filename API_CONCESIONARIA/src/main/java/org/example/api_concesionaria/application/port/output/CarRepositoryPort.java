package org.example.api_concesionaria.application.port.output;

import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;

public interface CarRepositoryPort {
    boolean saveCar(Car car, CategoryCarEntity  categoryCarEntity);
}
