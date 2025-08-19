package org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase;

import org.example.api_concesionaria.dto.response.CategoryCarResponse;

import java.util.UUID;

public interface FindCategoryCarUseCase {
    CategoryCarResponse findCategoryCar(UUID id);
}
