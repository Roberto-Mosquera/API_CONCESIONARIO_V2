package org.example.api_concesionaria.dto.request;

import java.util.UUID;

public record CreateCarRequest(
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
        UUID id_categoryCar
) {
}
