package org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase;

import org.example.api_concesionaria.dto.request.CreateCategoryCarRequest;

public interface CreateCategoryCarUseCase {
    void createCategory(CreateCategoryCarRequest categoryCarRequest);
}
