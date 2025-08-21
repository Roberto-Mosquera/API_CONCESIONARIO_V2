package org.example.api_concesionaria.infrastructure.persistence.repository.categoryCarRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.output.CategoryCarRepositoryPort;
import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.dto.response.CategoryCarResponse;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaCategoryCarRepositoryAdapter implements CategoryCarRepositoryPort {

    private final CategoryCarPersistenceService categoryCarPersistenceService;

    @Override
    public Boolean saveCategoryCar(CategoryCar categoryCar) {
        return categoryCarPersistenceService.save(categoryCar);
    }

    @Override
    public List<CategoryCarResponse> getListCategoryCar(int page) {
        return categoryCarPersistenceService.getList(page);
    }

    @Override
    public CategoryCarResponse getCategoryCarById(UUID id) {
        return categoryCarPersistenceService.getById(id);
    }

    @Override
    public CategoryCarEntity getCategoryCarEntityById(UUID id) {
        return categoryCarPersistenceService.getEntityById(id);
    }

}
