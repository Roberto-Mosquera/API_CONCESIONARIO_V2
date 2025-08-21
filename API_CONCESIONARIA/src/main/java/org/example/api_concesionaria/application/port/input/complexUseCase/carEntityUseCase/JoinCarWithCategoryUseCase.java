package org.example.api_concesionaria.application.port.input.complexUseCase.carEntityUseCase;

import org.example.api_concesionaria.domain.model.Car;

public interface JoinCarWithCategoryUseCase {
    boolean joinCarWithCategory(Car car);
}
