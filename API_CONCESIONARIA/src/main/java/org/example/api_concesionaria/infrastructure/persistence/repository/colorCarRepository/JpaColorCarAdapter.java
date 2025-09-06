package org.example.api_concesionaria.infrastructure.persistence.repository.colorCarRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.output.ColorCarRepositoryPort;
import org.example.api_concesionaria.domain.model.ColorCar;
import org.example.api_concesionaria.infrastructure.persistence.entity.ColorCarEntity;
import org.example.api_concesionaria.mapper.ColorCarMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaColorCarAdapter implements ColorCarRepositoryPort {

    private final SpringDataColorCarRepository springDataColorCarRepository;

    @Override
    public void saveColorCar(ColorCar colorCar) {
        ColorCarEntity colorCarEntity = ColorCarMapper.toColorCarEntity(colorCar);
        springDataColorCarRepository.save(colorCarEntity);
    }

}
