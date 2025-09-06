package org.example.api_concesionaria.dto.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public record CreateCarRequest(
        String nameCar,
        MultipartFile FileImgCar,
        Double price,
        Integer stock,
        String brand,
        String model,
        String engine,
        String traction,
        String transmission,
        String torque,
        String speed,
        MultipartFile FileTechnicalSheet,
        UUID id_categoryCar
) {
}
