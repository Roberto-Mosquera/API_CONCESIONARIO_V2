package org.example.api_concesionaria.infrastructure.persistence.repository.categoryCarRepository;

import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.dto.response.CategoryCarResponse;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.example.api_concesionaria.mapper.CategoryCarMapper;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.UUID;

public class ServiceRepositoryCategoryCar {

    public static Boolean save(SpringDataCategoryCarRepository springDataCategoryCarRepository, CategoryCar categoryCar) {
        CategoryCarEntity categoryCarEntity = CategoryCarMapper.toCategoryCarEntityCreate(categoryCar);
        springDataCategoryCarRepository.save(categoryCarEntity);
        return true;
    }
    public static List<CategoryCarResponse> getList(SpringDataCategoryCarRepository springDataCategoryCarRepository,int page) {
        List<CategoryCarEntity>categoryCarEntities = springDataCategoryCarRepository.findAll(
                PageRequest.of(page, 10)
        ).getContent();
        return CategoryCarMapper.toListCategoryCarResponse(categoryCarEntities);
    }

    public static CategoryCarResponse getById(SpringDataCategoryCarRepository springDataCategoryCarRepository,UUID id) {
        CategoryCarEntity categoryCarEntity = springDataCategoryCarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category Car Not Found!"));
        return CategoryCarMapper.toCategoryCarResponse(categoryCarEntity);
    }

    public static CategoryCarEntity getEntityById(SpringDataCategoryCarRepository springDataCategoryCarRepository,UUID id) {
        CategoryCarEntity categoryCarEntity = springDataCategoryCarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category Car Not Found!"));
        return categoryCarEntity;
    }
}
