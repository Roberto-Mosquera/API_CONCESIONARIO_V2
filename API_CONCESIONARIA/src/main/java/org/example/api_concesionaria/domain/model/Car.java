package org.example.api_concesionaria.domain.model;

import java.util.UUID;

public record Car(
        UUID id,
        String nameCar,
        String urlImgCar,
        Double price,
        Integer stock,
        String brand,
        String model,
        String engine,
        String traction,
        String transmission,
        String torque,
        String speed,
        String urlTechnicalSheet,
        Boolean enabled,
        UUID id_categoryCar
) {
}
