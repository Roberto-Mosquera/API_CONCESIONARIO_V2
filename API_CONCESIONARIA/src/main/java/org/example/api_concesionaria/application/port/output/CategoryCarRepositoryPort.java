package org.example.api_concesionaria.application.port.output;

import org.example.api_concesionaria.domain.model.CategoryCar;

import java.util.List;
import java.util.UUID;

public interface CategoryCarRepositoryPort {
    UUID saveCategoryCar(CategoryCar categoryCar);
    List<CategoryCar> getListCategoryCar(int page);
    CategoryCar getCategoryCarById(UUID id);
}
