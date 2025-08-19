package org.example.api_concesionaria.application.port.output;

import org.example.api_concesionaria.domain.model.CategoryCar;

public interface CategoryCarRepositoryPort {
    Boolean saveCategoryCar(CategoryCar categoryCar);
}
