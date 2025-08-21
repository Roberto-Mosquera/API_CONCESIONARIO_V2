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

    public static CategoryCarEntity toCategoryCarEntityCreate(CategoryCar car) {
        return new CategoryCarEntity(
                car.nameCategory()
        );
    }

    public static CategoryCarResponse toCategoryCarResponse(CategoryCarEntity categoryCarEntity) {
        return new CategoryCarResponse(
                categoryCarEntity.getId(),
                categoryCarEntity.getNameCategory()
        );
    }

    public static List<CategoryCarResponse> toListCategoryCarResponse(List<CategoryCarEntity> categoryCarEntities) {
        return categoryCarEntities.stream()
                .map(CategoryCarMapper::toCategoryCarResponse)
                .toList();
    }
}
