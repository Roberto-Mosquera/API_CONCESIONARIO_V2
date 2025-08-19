package org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase;

import org.example.api_concesionaria.dto.response.CategoryCarResponse;

import java.util.List;

public interface ListCategoryCarUseCase {
    List<CategoryCarResponse> listCategoryCar(int page);
}
