package org.example.api_concesionaria.mapper;

import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.dto.request.CreateCategoryCarRequest;
import org.example.api_concesionaria.dto.response.CategoryCarResponse;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;

import java.util.List;


public class CategoryCarMapper {

    public static CategoryCar toCategoryCar(CreateCategoryCarRequest categoryCarRequest) {
        return new CategoryCar(
                null,
                categoryCarRequest .nameCategory(),
                null
        );
    }

    public static CategoryCarEntity toCategoryCarEntityCreate(CategoryCar categoryCar) {
        return new CategoryCarEntity(
                categoryCar.getId(),
                categoryCar.getNameCategory(),
                categoryCar.getEnabled()
        );
    }

    public static CategoryCar toCategoryCar(CategoryCarEntity categoryCarEntity) {
        return new CategoryCar(
                categoryCarEntity.getId(),
                categoryCarEntity.getNameCategory(),
                categoryCarEntity.getEnabled()
        );
    }

    public static List<CategoryCar> toListCategoryCar(List<CategoryCarEntity> categoryCarEntities) {
        return categoryCarEntities.stream()
                .map(CategoryCarMapper::toCategoryCar)
                .toList();
    }

    public static CategoryCarResponse toCategoryCarResponse(CategoryCar categoryCar) {
        return new CategoryCarResponse(
                categoryCar.getId(),
                categoryCar.getNameCategory()
        );
    }

    public static List<CategoryCarResponse> toListCategoryCarResponse(List<CategoryCar> categoryCars) {
        return categoryCars.stream()
                .map(CategoryCarMapper::toCategoryCarResponse)
                .toList();
    }
}
