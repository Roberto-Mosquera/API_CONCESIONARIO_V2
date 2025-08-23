package org.example.api_concesionaria.infrastructure.persistence.repository.carRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.output.CarRepositoryPort;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.infrastructure.persistence.entity.CarEntity;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.example.api_concesionaria.infrastructure.persistence.repository.categoryCarRepository.JpaCategoryCarRepositoryAdapter;
import org.example.api_concesionaria.mapper.CarMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class JpaCarRepositoryAdapter implements CarRepositoryPort {

    private final SpringDataCarRepository  springDataCarRepository;

    private final JpaCategoryCarRepositoryAdapter jpaCategoryCarRepositoryAdapter;

    @Override
    public UUID saveCar(Car car, UUID categoryId) {
        CategoryCarEntity category = jpaCategoryCarRepositoryAdapter.getCategoryCarEntityById(categoryId); //Aqui ya valida una excepcion
        CarEntity carEntity = CarMapper.toCarEntity(car);
        carEntity.setCategory(category);
        carEntity = springDataCarRepository.save(carEntity);
        return carEntity.getId();
    }

}
