package org.example.api_concesionaria.application.service;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.input.complexUseCase.carEntityUseCase.JoinCarWithCategoryUseCase;
import org.example.api_concesionaria.application.port.input.complexUseCase.categoryCarEntityUseCase.FindCategoryCarEntityUseCase;
import org.example.api_concesionaria.application.port.output.CarRepositoryPort;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceAux implements JoinCarWithCategoryUseCase {

    private final FindCategoryCarEntityUseCase findCategoryCarEntityUseCase;
    private final CarRepositoryPort carRepositoryPort;

    @Override
    public boolean joinCarWithCategory(Car car) {
        CategoryCarEntity categoryCarEntity = findCategoryCarEntityUseCase.findCategoryCarEntity(car.id_categoryCar());
        return carRepositoryPort.saveCar(car, categoryCarEntity);
    }

}
