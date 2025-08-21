package org.example.api_concesionaria.infrastructure.persistence.repository.categoryCarRepository;

import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataCategoryCarRepository extends JpaRepository<CategoryCarEntity, UUID> {
    boolean existsByNameCategory(String nameCategory);
}
