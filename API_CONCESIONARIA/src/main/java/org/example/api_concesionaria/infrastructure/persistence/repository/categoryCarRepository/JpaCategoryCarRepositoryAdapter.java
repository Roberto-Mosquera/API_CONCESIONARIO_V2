package org.example.api_concesionaria.infrastructure.persistence.repository.categoryCarRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.output.CategoryCarRepositoryPort;
import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.dto.response.CategoryCarResponse;
import org.example.api_concesionaria.exception.NotFoundException;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.example.api_concesionaria.mapper.CategoryCarMapper;
import org.example.api_concesionaria.utils.messegeException.CategoryCarMessageException;
import org.example.api_concesionaria.validator.CategoryCarValidatorPersistence;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Transactional
public class JpaCategoryCarRepositoryAdapter implements CategoryCarRepositoryPort, CategoryCarMessageException {

    private final SpringDataCategoryCarRepository springDataCategoryCarRepository;
    private final CategoryCarValidatorPersistence categoryCarValidatorPersistence;

    @Override
    public UUID saveCategoryCar(CategoryCar categoryCar) {
        categoryCarValidatorPersistence.validateDuplicateName(categoryCar);
        CategoryCarEntity categoryCarEntity = CategoryCarMapper.toCategoryCarEntityCreate(categoryCar);
        categoryCarEntity = springDataCategoryCarRepository.save(categoryCarEntity);
        return categoryCarEntity.getId();
    }

    @Override
    public List<CategoryCarResponse> getListCategoryCar(int page) {
        categoryCarValidatorPersistence.validatePageNegativeInList(page);
        List<CategoryCarEntity> categoryCarEntities = springDataCategoryCarRepository.findAll(
                PageRequest.of(page, 10)
        ).getContent();
        return CategoryCarMapper.toListCategoryCarResponse(categoryCarEntities);
    }

    @Override
    public CategoryCarResponse getCategoryCarById(UUID id) {
        CategoryCarEntity categoryCarEntity = springDataCategoryCarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        NOT_FOUNT_CATEGORY_CAR_BY_ID
                ));
        return CategoryCarMapper.toCategoryCarResponse(categoryCarEntity);
    }

    @Override
    public CategoryCarEntity getCategoryCarEntityById(UUID id) {
        return springDataCategoryCarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        NOT_FOUNT_CATEGORY_CAR_BY_ID
                ));
    }

}
