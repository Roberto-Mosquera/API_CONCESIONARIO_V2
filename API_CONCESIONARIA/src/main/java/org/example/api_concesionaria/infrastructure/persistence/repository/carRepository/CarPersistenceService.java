package org.example.api_concesionaria.infrastructure.persistence.repository.carRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.infrastructure.persistence.entity.CarEntity;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.example.api_concesionaria.mapper.CarMapper;
import org.example.api_concesionaria.validator.CarValidatorPersistence;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CarPersistenceService {

    private final SpringDataCarRepository  springDataCarRepository;
    private final CarValidatorPersistence  carValidatorPersistence;
    @Transactional
    public boolean save(Car car, CategoryCarEntity categoryCarEntity) {

        carValidatorPersistence.validateRequestSave(car);

        CarEntity carEntity = CarMapper.toCarEntity(car);

        carEntity.setCategory(categoryCarEntity);

        springDataCarRepository.save(carEntity);

        return true;
    }

}
