package org.example.api_concesionaria.infrastructure.persistence.repository.carRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.output.CarRepositoryPort;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaCarRepositoryAdapter implements CarRepositoryPort {

    private final CarPersistenceService carPersistenceService;

    @Override
    public boolean saveCar(Car car, CategoryCarEntity categoryCarEntity) {
        return carPersistenceService.save(car,categoryCarEntity);
    }

}
