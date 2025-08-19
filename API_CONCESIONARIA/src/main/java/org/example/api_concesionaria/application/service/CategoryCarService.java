package org.example.api_concesionaria.application.service;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.input.simpleUseCase.CreateCategoryCarUseCase;
import org.example.api_concesionaria.application.port.output.CategoryCarRepositoryPort;
import org.example.api_concesionaria.domain.model.CategoryCar;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryCarService implements CreateCategoryCarUseCase {

    private final CategoryCarRepositoryPort  categoryCarRepositoryPort;

    @Override
    public void createCategory(CategoryCar categoryCar) {

    }

}
