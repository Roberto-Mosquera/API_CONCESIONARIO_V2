package org.example.api_concesionaria.infrastructure.persistence.repository.categoryCarRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.output.CategoryCarRepositoryPort;
import org.example.api_concesionaria.domain.model.CategoryCar;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class JpaCategoryCarRepositoryAdapter implements CategoryCarRepositoryPort {

    private final SpringDataCategoryCarRepository springDataCategoryCarRepository;

    @Override
    @Transactional
    public Boolean saveCategoryCar(CategoryCar categoryCar) {
        return null;
    }

}
