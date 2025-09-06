package org.example.api_concesionaria.validator;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.exception.BadRequestException;
import org.example.api_concesionaria.exception.BusinessException;

import org.example.api_concesionaria.infrastructure.persistence.repository.categoryCarRepository.SpringDataCategoryCarRepository;
import org.example.api_concesionaria.utils.messegeException.CategoryCarMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryCarValidatorPersistence implements CategoryCarMessageException {

    private final SpringDataCategoryCarRepository springDataCategoryCarRepository;

    public void validateDuplicateName(CategoryCar categoryCar) {
        if (springDataCategoryCarRepository.existsByNameCategory(categoryCar.getNameCategory())) {
            throw new BusinessException(THAT_NAME_ALREADY_EXISTS, HttpStatus.CONFLICT);
        }
    }

    public void validatePageNegativeInList(int page) {
        if (page < 0) {
            throw new BadRequestException(PAGE_NEGATIVE, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
