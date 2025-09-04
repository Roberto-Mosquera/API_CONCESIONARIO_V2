package org.example.api_concesionaria.application.service;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase.CreateCategoryCarUseCase;
import org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase.FindCategoryCarUseCase;
import org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase.ListCategoryCarUseCase;
import org.example.api_concesionaria.application.port.output.CategoryCarRepositoryPort;
import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.dto.request.CreateCategoryCarRequest;
import org.example.api_concesionaria.dto.response.CategoryCarResponse;
import org.example.api_concesionaria.mapper.CategoryCarMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryCarService implements CreateCategoryCarUseCase, ListCategoryCarUseCase,
        FindCategoryCarUseCase{

    private final CategoryCarRepositoryPort  categoryCarRepositoryPort;

    @Override
    public void createCategoryCar(CreateCategoryCarRequest categoryCarRequest) {
        CategoryCar categoryCar = CategoryCarMapper.toCategoryCar(categoryCarRequest);
        categoryCarRepositoryPort.saveCategoryCar(categoryCar);
    }

    @Override
    public List<CategoryCarResponse> listCategoryCar(int page) {
        List<CategoryCar> categoryCars = categoryCarRepositoryPort.getListCategoryCar(page);
        return CategoryCarMapper.toListCategoryCarResponse(categoryCars);
    }

    @Override
    public CategoryCarResponse findCategoryCar(UUID id) {
        CategoryCar categoryCar = categoryCarRepositoryPort.getCategoryCarById(id);
        return CategoryCarMapper.toCategoryCarResponse(categoryCar);
    }
}
