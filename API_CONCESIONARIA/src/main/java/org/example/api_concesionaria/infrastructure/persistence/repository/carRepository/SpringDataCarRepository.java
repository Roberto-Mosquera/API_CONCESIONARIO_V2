package org.example.api_concesionaria.infrastructure.persistence.repository.carRepository;

import org.example.api_concesionaria.infrastructure.persistence.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataCarRepository extends JpaRepository<CarEntity, UUID> {
}
