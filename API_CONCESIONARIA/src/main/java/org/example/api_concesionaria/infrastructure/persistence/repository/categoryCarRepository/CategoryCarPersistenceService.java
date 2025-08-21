package org.example.api_concesionaria.infrastructure.persistence.repository.categoryCarRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.dto.response.CategoryCarResponse;
import org.example.api_concesionaria.exception.NotFoundException;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.example.api_concesionaria.mapper.CategoryCarMapper;
import org.example.api_concesionaria.utils.messegeException.CategoryCarMessageException;
import org.example.api_concesionaria.validator.CategoryCarValidatorPersistence;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryCarPersistenceService implements CategoryCarMessageException{

    private final SpringDataCategoryCarRepository springDataCategoryCarRepository;

    private final CategoryCarValidatorPersistence  categoryCarValidatorPersistence;

    @Transactional
    public Boolean save(CategoryCar categoryCar) {
        categoryCarValidatorPersistence.validateRequestSave(categoryCar);
        CategoryCarEntity categoryCarEntity = CategoryCarMapper.toCategoryCarEntityCreate(categoryCar);
        springDataCategoryCarRepository.save(categoryCarEntity);
        return true;
    }

    @Transactional
    public List<CategoryCarResponse> getList(int page) {
        categoryCarValidatorPersistence.validatePageNegativeInList(page);
        List<CategoryCarEntity> categoryCarEntities = springDataCategoryCarRepository.findAll(
                PageRequest.of(page, 10)
        ).getContent();
        return CategoryCarMapper.toListCategoryCarResponse(categoryCarEntities);
    }

    @Transactional
    public CategoryCarResponse getById(UUID id) {
        CategoryCarEntity categoryCarEntity = springDataCategoryCarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        NOT_FOUNT_CATEGORY_CAR_BY_ID,
                        HttpStatus.NOT_FOUND
                ));
        return CategoryCarMapper.toCategoryCarResponse(categoryCarEntity);
    }

    @Transactional
    public CategoryCarEntity getEntityById(UUID id) {
        return springDataCategoryCarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        NOT_FOUNT_CATEGORY_CAR_BY_ID,
                        HttpStatus.NOT_FOUND
                ));
    }
}
