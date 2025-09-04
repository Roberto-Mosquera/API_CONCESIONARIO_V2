package org.example.api_concesionaria.infrastructure.persistence.repository.carRepository;

import org.example.api_concesionaria.infrastructure.persistence.entity.CarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpringDataCarRepository extends JpaRepository<CarEntity, UUID> {

    Optional<CarEntity> findByIdAndEnabledFalse(UUID id);

    Optional<CarEntity> findByNameCarAndEnabledFalse(String nameCar);

    @Query("SELECT c FROM CarEntity c WHERE c.engine=:engine AND c.enabled=false")
    Page<CarEntity> findListByEngine(@Param("engine")String engine, Pageable pageable);

    @Query("SELECT c FROM CarEntity c WHERE c.transmission=:transmission AND c.enabled=false")
    Page<CarEntity> findListByTransmission(@Param("transmission")String transmission, Pageable pageable);

    @Query("SELECT c FROM CarEntity c WHERE c.traction=:traction AND c.enabled=false")
    Page<CarEntity> findListByTraction(@Param("traction")String traction, Pageable pageable);

    @Query("SELECT c FROM CarEntity c WHERE c.speed=:speed AND c.enabled=false")
    Page<CarEntity> findListBySpeed(@Param("speed")String speed, Pageable pageable);

    @Query("SELECT c FROM CarEntity c WHERE c.category.id=:id_category AND c.enabled=false")
    Page<CarEntity> findListByCategory(@Param("id_category")UUID id_category, Pageable pageable);

    @Query("SELECT (count(c) > 0) FROM CarEntity c WHERE c.category.id = :id_category AND c.enabled = false")
    boolean existsByCategoryId(@Param("id_category") UUID idCategory);

}
