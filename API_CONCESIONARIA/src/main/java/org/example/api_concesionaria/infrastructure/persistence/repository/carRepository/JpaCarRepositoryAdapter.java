package org.example.api_concesionaria.infrastructure.persistence.repository.carRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.output.CarRepositoryPort;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.exception.NotFoundException;
import org.example.api_concesionaria.infrastructure.persistence.entity.CarEntity;
import org.example.api_concesionaria.infrastructure.persistence.repository.categoryCarRepository.JpaCategoryCarRepositoryAdapter;
import org.example.api_concesionaria.mapper.CarMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Transactional
public class JpaCarRepositoryAdapter implements CarRepositoryPort {

    private final SpringDataCarRepository  springDataCarRepository;

    private final JpaCategoryCarRepositoryAdapter jpaCategoryCarRepositoryAdapter;

    @Override
    public UUID saveCar(Car car) {
        CarEntity carEntity = CarMapper.toCarEntity(car);
        carEntity = springDataCarRepository.save(carEntity);
        return carEntity.getId();
    }

    @Override
    public Car findCarById(UUID id) {
        CarEntity carEntity = springDataCarRepository.findByIdAndEnabledFalse(id)
                .orElseThrow( () -> new NotFoundException("No se encontro el carro con el id: " + id) );
        return CarMapper.toCarDetail(carEntity);
    }

    @Override
    public Car findCarByName(String name_car) {
        CarEntity carEntity = springDataCarRepository.findByNameCarAndEnabledFalse(name_car)
                .orElseThrow( () -> new NotFoundException("No se encontro el carro con el nombre de : " + name_car) );
        return CarMapper.toCarDetail(carEntity);
    }

    @Override
    public List<Car> ListCarResponseFull(int page) {
        List<CarEntity> carEntities = springDataCarRepository.findAll(
                PageRequest.of(page, 10)
        ).getContent();
        return CarMapper.toListCarDetail(carEntities);
    }

    @Override
    public List<Car> ListCarResponseByEngine(int page, String engine) {
        Pageable pageable = PageRequest.of(page, 10);
        List<CarEntity> carEntities = springDataCarRepository
                .findListByEngine(engine, pageable)
                .getContent();
        return CarMapper.toListCarDetail(carEntities);
    }

    @Override
    public List<Car> ListCarResponseByTransmission(int page, String transmission) {
        Pageable pageable = PageRequest.of(page, 10);
        List<CarEntity> carEntities = springDataCarRepository
                .findListByTransmission(transmission,pageable)
                .getContent();
        return CarMapper.toListCarDetail(carEntities);
    }

    @Override
    public List<Car> ListCarResponseByTraction(int page, String traction) {
        Pageable pageable = PageRequest.of(page, 10);
        List<CarEntity> carEntities = springDataCarRepository
                .findListByTraction(traction,pageable)
                .getContent();
        return CarMapper.toListCarDetail(carEntities);
    }

    @Override
    public List<Car> ListCarResponseBySpeed(int page, String speed) {
        Pageable pageable = PageRequest.of(page, 10);
        List<CarEntity> carEntities = springDataCarRepository
                .findListBySpeed(speed,pageable)
                .getContent();
        return CarMapper.toListCarDetail(carEntities);
    }

    @Override
    public List<Car> ListCarResponseByCategory(int page, UUID CategoryId) {
        Pageable pageable = PageRequest.of(page, 10);
        List<CarEntity> carEntities = springDataCarRepository
                .findListByCategory(CategoryId,pageable)
                .getContent();
        return CarMapper.toListCarDetail(carEntities);
    }


}
