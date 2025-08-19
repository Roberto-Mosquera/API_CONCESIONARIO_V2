package org.example.api_concesionaria.application.port.output;

import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.dto.response.CategoryCarResponse;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;

import java.util.List;
import java.util.UUID;

public interface CategoryCarRepositoryPort {
    Boolean saveCategoryCar(CategoryCar categoryCar);
    List<CategoryCarResponse> getListCategoryCar(int page);
    CategoryCarResponse getCategoryCarById(UUID id);
    CategoryCarEntity getCategoryCarEntityById(UUID id);
}
