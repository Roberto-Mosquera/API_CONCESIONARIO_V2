package org.example.api_concesionaria.application.service;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.input.complexUseCase.categoryCarEntityUseCase.FindCategoryCarEntityUseCase;
import org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase.CreateCategoryCarUseCase;
import org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase.FindCategoryCarUseCase;
import org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase.ListCategoryCarUseCase;
import org.example.api_concesionaria.application.port.output.CategoryCarRepositoryPort;
import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.dto.request.CreateCategoryCarRequest;
import org.example.api_concesionaria.dto.response.CategoryCarResponse;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.example.api_concesionaria.mapper.CategoryCarMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryCarService implements CreateCategoryCarUseCase, ListCategoryCarUseCase,
        FindCategoryCarUseCase, FindCategoryCarEntityUseCase {

    private final CategoryCarRepositoryPort  categoryCarRepositoryPort;

    @Override
    public void createCategory(CreateCategoryCarRequest categoryCarRequest) {
        CategoryCar categoryCar = CategoryCarMapper.toCategoryCar(categoryCarRequest);
        categoryCarRepositoryPort.saveCategoryCar(categoryCar);
    }

    @Override
    public List<CategoryCarResponse> listCategoryCar(int page) {
        return categoryCarRepositoryPort.getListCategoryCar(page);
    }

    @Override
    public CategoryCarResponse findCategoryCar(UUID id) {
        return categoryCarRepositoryPort.getCategoryCarById(id);
    }

    @Override
    public CategoryCarEntity findCategoryCarEntity(UUID id) {
        return null;
    }
}
