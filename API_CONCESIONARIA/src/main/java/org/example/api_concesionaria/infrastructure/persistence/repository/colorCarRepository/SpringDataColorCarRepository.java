package org.example.api_concesionaria.infrastructure.persistence.repository.colorCarRepository;

import org.example.api_concesionaria.infrastructure.persistence.entity.ColorCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataColorCarRepository extends JpaRepository<ColorCarEntity, UUID> {
}
