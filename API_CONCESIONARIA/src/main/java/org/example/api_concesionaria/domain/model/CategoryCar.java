package org.example.api_concesionaria.domain.model;

import org.example.api_concesionaria.exception.DomainException;
import org.example.api_concesionaria.utils.messegeException.CategoryCarMessageException;

import java.util.UUID;

public class CategoryCar implements CategoryCarMessageException {

    private UUID id;
    private String nameCategory;
    private Boolean enabled;

    public CategoryCar(UUID id, String nameCategory, Boolean enabled) {
        this.id = id;
        if (nameCategory == null || nameCategory.isBlank()) {
            throw new DomainException(MISSING_NAME_CATEGORY_CAR);
        }
        this.nameCategory = nameCategory;
        this.enabled = enabled;
    }

    public UUID getId() {
        return id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public Boolean getEnabled() {
        return enabled;
    }

}
