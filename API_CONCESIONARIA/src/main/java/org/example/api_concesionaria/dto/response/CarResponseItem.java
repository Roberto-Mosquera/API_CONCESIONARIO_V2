package org.example.api_concesionaria.dto.response;

import java.util.UUID;

public record CarResponseItem(
    UUID id,
    String nameCar,
    String urlImgCar,
    Double price,
    String category_name
) {
}
