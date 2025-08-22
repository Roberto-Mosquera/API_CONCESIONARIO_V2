package org.example.api_concesionaria.infrastructure.persistence.repository.carRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.output.CarRepositoryPort;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.example.api_concesionaria.infrastructure.persistence.repository.categoryCarRepository.JpaCategoryCarRepositoryAdapter;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaCarRepositoryAdapter implements CarRepositoryPort {

    private final CarPersistenceService carPersistenceService;

    private final JpaCategoryCarRepositoryAdapter jpaCategoryCarRepositoryAdapter;

    @Override
    public boolean saveCar(Car car, UUID categoryId) {
        CategoryCarEntity category = jpaCategoryCarRepositoryAdapter.getCategoryCarEntityById(categoryId);
        return carPersistenceService.save(car, category);
    }

}
