package org.example.api_concesionaria.domain.service;

import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.exception.DomainException;
import org.example.api_concesionaria.utils.messegeException.CategoryCarMessageException;

public class CategoryCarValidator implements CategoryCarMessageException {
    public void validateRequestSave(CategoryCar categoryCar) {
        if (categoryCar.nameCategory() == null || categoryCar.nameCategory().isBlank()) {
            throw new DomainException(MISSING_NAME_CATEGORY_CAR);
        }
    }
}
