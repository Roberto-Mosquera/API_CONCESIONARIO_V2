package org.example.api_concesionaria.application.port.input.simpleUseCase;

import org.example.api_concesionaria.domain.model.CategoryCar;

public interface CreateCategoryCarUseCase {
    void createCategory(CategoryCar categoryCar);
}
