package org.example.api_concesionaria.infrastructure.persistence.repository.carRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.infrastructure.persistence.entity.CarEntity;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.example.api_concesionaria.mapper.CarMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarPersistenceService {

    private final SpringDataCarRepository  springDataCarRepository;

    public boolean save(Car car, CategoryCarEntity categoryCarEntity) {

        CarEntity carEntity = CarMapper.toCarEntity(car);

        carEntity.setCategory(categoryCarEntity);

        springDataCarRepository.save(carEntity);

        return true;
    }

}
